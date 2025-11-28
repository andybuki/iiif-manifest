package org.crossasia.manifest.canvas;

import info.freelibrary.iiif.presentation.v3.ImageContent;
import info.freelibrary.iiif.presentation.v3.Manifest;
import org.crossasia.manifest.canvas.builder.CanvasBuilder;
import org.crossasia.manifest.canvas.extractor.PageDataExtractor;
import org.crossasia.manifest.canvas.model.PageData;
import org.crossasia.manifest.canvas.service.ImageInfoFetcher;
import org.crossasia.manifest.statics.collection.CollectionConfig;
import org.crossasia.manifest.statics.manifest.ManifestConfig;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Unified canvas creator that works with any collection type.
 * Collection-specific behavior is driven by CollectionConfig.
 */
public class CanvasCreator {

    private final CollectionConfig config;
    private final CanvasBuilder canvasBuilder;

    public CanvasCreator(CollectionConfig config) {
        this.config = config;
        this.canvasBuilder = new CanvasBuilder(
                ManifestConfig.SERVER,
                config.getManifestCollection(),
                ManifestConfig.THUMBNAIL_PATH
        );
    }

    /**
     * Create canvases for a manifest from JSON data
     */
    public void createCanvases(File file, JSONObject jsonObj, Manifest manifest) {
        if (!jsonObj.has("pages")) {
            return;
        }

        JSONArray pages = jsonObj.getJSONArray("pages");
        List<info.freelibrary.iiif.presentation.v3.Canvas> canvases = new ArrayList<>();

        String id = extractId(jsonObj);
        String firstPosition = "1";

        for (int j = 0; j < pages.length(); j++) {
            JSONObject pageObj = pages.getJSONObject(j);

            try {
                PageData pageData = PageDataExtractor.extract(pageObj);

                // Track first position for thumbnail
                if (j == 0 && pageData.getPosition() != null) {
                    firstPosition = pageData.getPosition();
                }

                // Determine which position to use for image dimensions
                String positionForDimensions = getPositionForDimensions(pageData, j);

                ImageInfoFetcher.ImageDimensions dimensions = ImageInfoFetcher.fetchDimensions(
                        config.getBaseUrl(),
                        config.getCollectionName(),
                        id,
                        positionForDimensions
                );

                info.freelibrary.iiif.presentation.v3.Canvas canvas =
                        canvasBuilder.buildCanvas(id, pageData, dimensions);

                canvases.add(canvas);

            } catch (Exception e) {
                handlePageError(file, j, e);
            }
        }

        manifest.setCanvases(canvases);
        setManifestThumbnail(manifest, id, firstPosition);
    }

    /**
     * Extract ID from JSON based on collection's ID type
     */
    private String extractId(JSONObject jsonObj) {
        switch (config.getIdType()) {
            case INTEGER:
                return String.valueOf(jsonObj.getInt("id"));
            case STRING:
            default:
                return jsonObj.getString("id");
        }
    }

    /**
     * Determine which position to use for fetching image dimensions.
     * Override this method in subclasses for collection-specific behavior.
     */
    protected String getPositionForDimensions(PageData pageData, int pageIndex) {
        // Default: use the page's actual position
        return pageData.getPosition() != null ? pageData.getPosition() : "1";
    }

    /**
     * Set the thumbnail for the manifest
     */
    private void setManifestThumbnail(Manifest manifest, String id, String firstPosition) {
        String thumbnailUri = ManifestConfig.buildThumbnailUrl(
                config.getManifestCollection(),
                id,
                firstPosition
        );
        manifest.setThumbnails(new ImageContent(thumbnailUri));
    }

    /**
     * Handle errors during page processing
     */
    private void handlePageError(File file, int pageIndex, Exception e) {
        System.err.println("Error processing page " + pageIndex +
                " in file " + file.getName() + ": " + e.getMessage());
        e.printStackTrace();
    }

    // ========== Factory Methods ==========

    public static CanvasCreator forDtab() {
        return new CanvasCreator(CollectionConfig.DTAB);
    }

    public static CanvasCreator forKahlen() {
        return new KahlenCanvasCreator();
    }

    public static CanvasCreator forTap() {
        return new CanvasCreator(CollectionConfig.TAP);
    }
}