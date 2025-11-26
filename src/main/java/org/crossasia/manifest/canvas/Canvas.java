package org.crossasia.manifest.canvas;

import info.freelibrary.iiif.presentation.v3.AnnotationPage;
import info.freelibrary.iiif.presentation.v3.ImageContent;
import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.PaintingAnnotation;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import info.freelibrary.iiif.presentation.v3.services.ImageService3;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.canvas.builder.CanvasBuilder;
import org.crossasia.manifest.canvas.extractor.PageDataExtractor;
import org.crossasia.manifest.canvas.model.PageData;
import org.crossasia.manifest.canvas.service.ImageInfoFetcher;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;
import static org.crossasia.manifest.statics.manifest.ManifestData.*;

class Canvas {

    private final CanvasBuilder canvasBuilder;
    private final String baseUrl = "https://iiif-content.crossasia.org/xasia/";
    private final String collectionName = "dtab";

    public Canvas() {
        this.canvasBuilder = new CanvasBuilder(SERVER, MANIFEST_COLLECTION, THUMBNAIL_PATH);
    }

    public void createCanvas(File file, DtabAttributes attributes, JSONObject jsonObj, Manifest manifest) {
        if (!jsonObj.has("pages")) {
            return;
        }

        JSONArray pages = jsonObj.getJSONArray("pages");
        List<info.freelibrary.iiif.presentation.v3.Canvas> canvases = new ArrayList<>();

        String id = String.valueOf(jsonObj.getInt("id"));
        String firstPosition = "1";

        // Process each page
        for (int j = 0; j < pages.length(); j++) {
            JSONObject pageObj = pages.getJSONObject(j);

            try {
                // Extract page data
                PageData pageData = PageDataExtractor.extract(pageObj);

                // Get first position for thumbnail
                if (j == 0 && pageData.getPosition() != null) {
                    firstPosition = pageData.getPosition();
                }

                // Fetch image dimensions
                ImageInfoFetcher.ImageDimensions dimensions = ImageInfoFetcher.fetchDimensions(
                        baseUrl,
                        collectionName,
                        id,
                        pageData.getPosition()
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
        String thumbnailUri = SERVER + MANIFEST_COLLECTION + id + "+" + firstPosition + THUMBNAIL_PATH;
        manifest.setThumbnails(new ImageContent(thumbnailUri));
    }
}