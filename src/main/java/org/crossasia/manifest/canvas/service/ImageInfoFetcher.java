package org.crossasia.manifest.canvas.service;

import org.crossasia.manifest.statics.manifest.ManifestConfig;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Fetches image information from IIIF Image API endpoints.
 */
public class ImageInfoFetcher {

    private static final int CONNECTION_TIMEOUT = 10000; // 10 seconds
    private static final int READ_TIMEOUT = 10000; // 10 seconds

    /**
     * Holds image dimension data
     */
    public static class ImageDimensions {
        private final int width;
        private final int height;

        public ImageDimensions(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() { return width; }
        public int getHeight() { return height; }

        @Override
        public String toString() {
            return "ImageDimensions{width=" + width + ", height=" + height + "}";
        }
    }

    /**
     * Fetches image dimensions from IIIF info.json endpoint
     *
     * @param baseUrl       Base URL of the IIIF server
     * @param collection    Collection name
     * @param id            Image/document ID
     * @param position      Page position
     * @return ImageDimensions containing width and height
     * @throws IOException if the request fails
     */
    public static ImageDimensions fetchDimensions(String baseUrl, String collection, String id, String position)
            throws IOException {

        String infoUrl = ManifestConfig.buildInfoUrl(baseUrl, collection, id, position);

        return fetchDimensionsFromUrl(infoUrl);
    }

    /**
     * Fetches dimensions directly from a URL
     */
    public static ImageDimensions fetchDimensionsFromUrl(String infoUrl) throws IOException {
        URL url = new URL(infoUrl);
        URLConnection connection = url.openConnection();
        connection.setConnectTimeout(CONNECTION_TIMEOUT);
        connection.setReadTimeout(READ_TIMEOUT);

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {

            // Use org.json library consistently
            JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

            int width = jsonObject.getInt("width");
            int height = jsonObject.getInt("height");

            return new ImageDimensions(width, height);
        }
    }
}