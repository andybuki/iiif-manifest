package org.crossasia.manifest.canvas;

import info.freelibrary.iiif.presentation.v3.ImageContent;
import info.freelibrary.iiif.presentation.v3.Manifest;

import org.crossasia.manifest.attributes.KahlenAttributes;
import org.crossasia.manifest.canvas.builder.CanvasBuilder;
import org.crossasia.manifest.canvas.extractor.PageDataExtractor;
import org.crossasia.manifest.canvas.model.PageData;
import org.crossasia.manifest.canvas.service.ImageInfoFetcher;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.crossasia.manifest.statics.manifest.ManifestData.*;

public class CanvasKahlen {

    private final CanvasBuilder canvasBuilder;
    private final String baseUrl = "https://iiif-content.crossasia.org/xasia/";
    private final String collectionName = "kahlen";

    public CanvasKahlen() {
        this.canvasBuilder = new CanvasBuilder(SERVER, MANIFEST_COLLECTION, THUMBNAIL_PATH);
    }

    public void createCanvas(File file, KahlenAttributes attributes, JSONObject jsonObj, Manifest manifest) {
        if (!jsonObj.has("pages")) {
            return;
        }

        JSONArray pages = jsonObj.getJSONArray("pages");
        List<info.freelibrary.iiif.presentation.v3.Canvas> canvases = new ArrayList<>();

        String id = String.valueOf(jsonObj.getInt("id"));

        // Process each page
        for (int j = 0; j < pages.length(); j++) {
            JSONObject pageObj = pages.getJSONObject(j);

            try {
                // Extract page data
                PageData pageData = PageDataExtractor.extract(pageObj);

                // Fetch image dimensions (Kahlen uses position "1" for first page)
                ImageInfoFetcher.ImageDimensions dimensions = ImageInfoFetcher.fetchDimensions(
                        baseUrl,
                        collectionName,
                        id,
                        "1"
                );

                // Build canvas
                info.freelibrary.iiif.presentation.v3.Canvas canvas =
                        canvasBuilder.buildCanvas(id, pageData, dimensions);

                canvases.add(canvas);

            } catch (Exception e) {
                System.err.println("Error processing page " + j + " in file " + file.getName() + ": " + e.getMessage());
                e.printStackTrace();
            }
        }

        // Set canvases to manifest
        manifest.setCanvases(canvases);

        // Set manifest thumbnail (first page)
        String thumbnailUri = SERVER + MANIFEST_COLLECTION + id + "+1" + THUMBNAIL_PATH;
        manifest.setThumbnails(new ImageContent(thumbnailUri));
    }
}