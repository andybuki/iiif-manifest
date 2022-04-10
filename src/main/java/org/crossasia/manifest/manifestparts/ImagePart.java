package org.crossasia.manifest.manifestparts;

import info.freelibrary.iiif.presentation.v3.*;
import info.freelibrary.iiif.presentation.v3.services.image.ImageService3;
import org.crossasia.manifest.constants.CollectionNames;
import org.crossasia.manifest.presentations.AnnotatedPage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import static org.crossasia.manifest.constants.PublicConstants.*;
import static org.crossasia.manifest.presentations.IIIFPresentationDlllm.COLLECTION_ADDITION;
import static org.crossasia.manifest.presentations.IIIFPresentationDlllm.COLLECTION_NAME;

public class ImagePart {

    public static void addImagePart(File file, JSONObject jsonObj, Manifest manifest, String book_ID) {
        ImageService3 manifestThumbService;
        String MANIFEST_THUMBNAIL_URI;
        JSONArray pages = null;
        if (jsonObj.has("pages")) {
            pages = (jsonObj.getJSONArray("pages"));
        }
        String canvasID ="";
        String annoID ="";
        String annoPageID ="";

        Canvas canvas = new Canvas("");
        ArrayList<Canvas> canvases = new ArrayList<>();
        AnnotationPage<PaintingAnnotation> annoPage;
        PaintingAnnotation anno;
        ImageContent imageContent = new ImageContent("");

        for (int j = 0; j < (pages != null ? pages.length() : 0); j++) {
            JSONObject pagesObj = (JSONObject) pages.get(j);
            JSONObject pagesObj_first = (JSONObject) pages.get(0);

            int pages_position = 0;
            String pages_id = "";
            String first_page = "";
            String pages_document_id = "";

            if (pagesObj_first.has("pages_id")) first_page = (String) pagesObj_first.get("pages_id");

            if (pagesObj.has("pages_position"))
                pages_position = Integer.parseInt(String.valueOf(pagesObj.get("pages_position")))+1;

            if (pagesObj.has("pages_id")) pages_id = (String) pagesObj.get("pages_id");

            if (pagesObj.has("pages_document_id"))
                pages_document_id = (String) pagesObj.get("pages_document_id");

            try {
                URL url = new URL(IIIF_COLLECTION_START_URL+COLLECTION_NAME+COLLECTION_ADDITION + pages_document_id + "+" + pages_id + "/info.json");
                JSONParser jsonParser = new JSONParser();
                URLConnection urlConnection = url.openConnection();
                BufferedReader in  = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                long weight = 0;
                long height =0;
                String inputLine;
                while ((inputLine = in.readLine())!=null) {
                    org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) jsonParser.parse(inputLine);
                    weight = (Long) jsonObject.get("width");
                    height = (Long) jsonObject.get("height");
                }
                in.close();

                String manifestID = SERVER + COLLECTION_NAME + COLLECTION_ADDITION+ pages_document_id + "+" + pages_id;
                canvasID = manifestID + "/canvas";
                String imageID = manifestID + "/full/full/0/default.jpg";
                annoID = manifestID + "/annotation";
                annoPageID = manifestID+"/annotation_page";
                MANIFEST_THUMBNAIL_URI = SERVER + CollectionNames.DLLM.getName() + ""+ book_ID +"+"+ pages_id+   THUMBNAIL_PATH;
                manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + COLLECTION_NAME+ book_ID +"+"+ pages_id);
                canvas = new Canvas(canvasID).setWidthHeight((int) weight, (int) height);
                canvas.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));
                imageContent = new ImageContent(imageID).setWidthHeight((int) weight, (int) height);
                imageContent.setServices(manifestThumbService);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e +" - "+ file.getName()+ ", " + pages_id +" - " + pages_document_id) ;
            }

            AnnotatedPage.addAnnotatedPage(manifest, canvasID, annoID, annoPageID, canvas, canvases, imageContent, pages_position);

            MANIFEST_THUMBNAIL_URI = SERVER + COLLECTION_NAME + book_ID +"+"+ first_page+ THUMBNAIL_PATH;
            manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + COLLECTION_NAME + book_ID +"+"+first_page);
            manifest.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));
        }
    }
}
