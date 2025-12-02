package org.crossasia.manifest.canvas.service;

import org.crossasia.manifest.statics.manifest.ManifestConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Fetches image information from IIIF Image API endpoints.
 *
 * <p>This service validates URLs, handles HTTP responses, and extracts
 * image dimensions from IIIF info.json endpoints. It includes proper error
 * handling for network issues, invalid responses, and missing data.</p>
 *
 * <h3>Features</h3>
 * <ul>
 *   <li>URL validation before making requests</li>
 *   <li>HTTP status code checking</li>
 *   <li>JSON response validation</li>
 *   <li>Configurable timeouts</li>
 *   <li>Comprehensive error logging</li>
 * </ul>
 */
public class ImageInfoFetcher {

    private static final Logger logger = LoggerFactory.getLogger(ImageInfoFetcher.class);
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
     * Fetches dimensions directly from a URL with validation and error handling.
     *
     * @param infoUrl the IIIF info.json URL
     * @return ImageDimensions containing width and height
     * @throws IOException if the URL is invalid, network fails, or response is invalid
     */
    public static ImageDimensions fetchDimensionsFromUrl(String infoUrl) throws IOException {
        // Validate URL
        if (infoUrl == null || infoUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("Info URL cannot be null or empty");
        }

        URL url;
        try {
            url = new URL(infoUrl);
        } catch (MalformedURLException e) {
            logger.error("Invalid IIIF info URL: {}", infoUrl, e);
            throw new IOException("Malformed URL: " + infoUrl, e);
        }

        // Validate URL protocol
        String protocol = url.getProtocol().toLowerCase();
        if (!protocol.equals("http") && !protocol.equals("https")) {
            throw new IOException("Unsupported protocol: " + protocol + ". Only HTTP and HTTPS are supported.");
        }

        logger.debug("Fetching image dimensions from: {}", infoUrl);

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(CONNECTION_TIMEOUT);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Check HTTP response code
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                String errorMsg = String.format(
                    "Failed to fetch image info. HTTP %d from %s", responseCode, infoUrl
                );
                logger.warn(errorMsg);
                throw new IOException(errorMsg);
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                // Parse JSON response
                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(new JSONTokener(reader));
                } catch (JSONException e) {
                    logger.error("Invalid JSON response from: {}", infoUrl, e);
                    throw new IOException("Invalid JSON in IIIF info response", e);
                }

                // Validate required fields
                if (!jsonObject.has("width") || !jsonObject.has("height")) {
                    throw new IOException(
                        "IIIF info.json missing required fields (width/height): " + infoUrl
                    );
                }

                // Extract dimensions
                int width;
                int height;
                try {
                    width = jsonObject.getInt("width");
                    height = jsonObject.getInt("height");
                } catch (JSONException e) {
                    logger.error("Failed to parse dimensions from: {}", infoUrl, e);
                    throw new IOException("Invalid width/height values in IIIF info", e);
                }

                // Validate dimension values
                if (width <= 0 || height <= 0) {
                    throw new IOException(
                        String.format("Invalid dimensions: width=%d, height=%d from %s",
                                     width, height, infoUrl)
                    );
                }

                logger.debug("Successfully fetched dimensions: {}x{} from {}", width, height, infoUrl);
                return new ImageDimensions(width, height);
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}