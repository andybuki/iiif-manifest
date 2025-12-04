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
 *
 * Replaces the old collection-specific classes:
 * - Canvas.java (for DTAB)
 * - CanvasKahlen.java (for Kahlen/TAP)
 *
 * Collection-specific behavior is driven by CollectionConfig.
 *
 * Usage:
 *   CanvasCreator creator = new CanvasCreator(CollectionConfig.DTAB);
 *   creator.createCanvas(file, jsonObj, manifest);
 *
 * Or use factory methods:
 *   CanvasCreator.forDtab().createCanvas(file, jsonObj, manifest);
 */
public class CanvasCreator {

    protected final CollectionConfig config;
    private final CanvasBuilder canvasBuilder;

    public CanvasCreator(CollectionConfig config) {
        this.config = config;
        this.canvasBuilder = new CanvasBuilder(
                config.getIiifBaseUrl(),
                config.getManifestCollection(),
                ManifestConfig.THUMBNAIL_PATH
        );
    }

    /**
     * Create canvases for a manifest from JSON data.
     * This is the main entry point - replaces both Canvas.createCanvas()
     * and CanvasKahlen.createCanvas().
     *
     * @param file      The input file (for error reporting)
     * @param jsonObj   The JSON object containing page data
     * @param manifest  The manifest to add canvases to
     */
    public void createCanvas(File file, JSONObject jsonObj, Manifest manifest) {
        if (!jsonObj.has("pages")) {
            return;
        }

        JSONArray pages = jsonObj.getJSONArray("pages");
        List<info.freelibrary.iiif.presentation.v3.Canvas> canvases = new ArrayList<>();

        String id = extractId(jsonObj);
        String firstPosition = "1";

        // Extract canvas label from JSON (schema:caption or fallback)
        String canvasLabel = extractCanvasLabel(jsonObj, id);

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
                        config.getIiifBaseUrl(),
                        config.getCollectionName(),
                        id,
                        positionForDimensions
                );

                info.freelibrary.iiif.presentation.v3.Canvas canvas =
                        canvasBuilder.buildCanvas(id, pageData, dimensions, canvasLabel);

                canvases.add(canvas);

            } catch (Exception e) {
                handlePageError(file, j, e);
            }
        }

        manifest.setCanvases(canvases);
        setManifestThumbnail(manifest, id, firstPosition);
    }

    /**
     * Extract canvas label from JSON.
     * Priority: schema:caption → schema:label → schema:alternative → id
     */
    protected String extractCanvasLabel(JSONObject jsonObj, String id) {
        // Try schema:caption first
        if (jsonObj.has("schema:caption")) {
            Object caption = jsonObj.get("schema:caption");
            if (caption instanceof String && !((String) caption).isEmpty()) {
                return (String) caption;
            }
        }
        // Fallback to schema:label
        if (jsonObj.has("schema:label")) {
            Object label = jsonObj.get("schema:label");
            if (label instanceof String && !((String) label).isEmpty()) {
                return (String) label;
            }
        }
        // Fallback to schema:alternative
        if (jsonObj.has("schema:alternative")) {
            Object alt = jsonObj.get("schema:alternative");
            if (alt instanceof String && !((String) alt).isEmpty()) {
                return (String) alt;
            }
        }
        // Final fallback to id
        return id;
    }

    /**
     * Extract ID from JSON based on collection's ID type.
     * - DTAB uses integer IDs: jsonObj.getInt("id")
     * - Kahlen/TAP use string IDs: jsonObj.getString("id")
     */
    protected String extractId(JSONObject jsonObj) {
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
     *
     * Default behavior (DTAB, TAP, etc.): use the page's actual position
     * Kahlen behavior: always use "1" (overridden in KahlenCanvasCreator)
     */
    protected String getPositionForDimensions(PageData pageData, int pageIndex) {
        return pageData.getPosition() != null ? pageData.getPosition() : "1";
    }

    /**
     * Get the position to use for the thumbnail.
     * Override for collection-specific behavior.
     */
    protected String getThumbnailPosition(String firstPosition) {
        return firstPosition;
    }

    /**
     * Set the thumbnail for the manifest
     */
    private void setManifestThumbnail(Manifest manifest, String id, String firstPosition) {
        String thumbnailPosition = getThumbnailPosition(firstPosition);
        String thumbnailUri = config.getIiifBaseUrl() +
                config.getManifestCollection() + id + "+" + thumbnailPosition +
                ManifestConfig.THUMBNAIL_PATH;
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

    /** Create creator for DTAB collection (replaces Canvas.java) */
    public static CanvasCreator forDtab() {
        return new CanvasCreator(CollectionConfig.DTAB);
    }

    /** Create creator for Kahlen collection (replaces CanvasKahlen.java) */
    public static CanvasCreator forKahlen() {
        return new KahlenCanvasCreator();
    }

    /** Create creator for TAP collection */
    public static CanvasCreator forTap() {
        return new CanvasCreator(CollectionConfig.TAP);
    }

    /** Create creator for Turfan collection */
    public static CanvasCreator forTurfan() {
        return new CanvasCreator(CollectionConfig.TURFAN);
    }

    /** Create creator for Sugawara collection */
    public static CanvasCreator forSugawara() {
        return new CanvasCreator(CollectionConfig.SUGAWARA);
    }
}