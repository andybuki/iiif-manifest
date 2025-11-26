package org.crossasia.manifest.canvas.service;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ImageInfoFetcher {

    public static class ImageDimensions {
        private final int width;
        private final int height;

        public ImageDimensions(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() { return width; }
        public int getHeight() { return height; }
    }

    /**
     * Fetches image dimensions from IIIF info.json endpoint
     */
    public static ImageDimensions fetchDimensions(String baseUrl, String collection, String id, String position)
            throws IOException, ParseException {

        String infoUrl = baseUrl + collection + "+" + id + "+" + position + "/info.json";
        URL url = new URL(infoUrl);

        JSONParser jsonParser = new JSONParser();
        URLConnection urlConnection = url.openConnection();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            String inputLine = in.readLine();
            if (inputLine != null) {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(inputLine);
                long width = (Long) jsonObject.get("width");
                long height = (Long) jsonObject.get("height");
                return new ImageDimensions((int) width, (int) height);
            }
        }

        throw new IOException("Could not read image dimensions from " + infoUrl);
    }
}
