package org.crossasia.manifest.presentations;

import info.freelibrary.iiif.presentation.v3.*;
import info.freelibrary.iiif.presentation.v3.properties.*;
import info.freelibrary.iiif.presentation.v3.services.image.ImageService3;
import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.crossasia.manifest.constants.CollectionNames;
import org.crossasia.manifest.json.StaticJsonCaller;
import org.crossasia.manifest.metadata.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

import static org.crossasia.manifest.constants.PublicConstants.*;
import static org.crossasia.manifest.metadata.MetadataMembers.metadataMembers;
import static org.crossasia.manifest.presentations.ProviderToManifest.addProviderToManifest;

@SpringBootApplication
public class IIIFPresentationDlllm  {
    public static void main(String[] args) throws IOException {
        File rawData = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/final/raw_TEST/");
        PrintStream out = new PrintStream(new FileOutputStream("src/main/resources/output.txt"));
        File dir = new File(String.valueOf(rawData));
        File[] filesInDir = dir.listFiles();
        Manifestor manifestor = new Manifestor();
        fileGeneration(out, filesInDir != null ? filesInDir : new File[0], manifestor);
    }

    private static void fileGeneration(PrintStream out, File[] filesInDir, Manifestor manifestor) throws IOException {
        int counter;
        for (File file : filesInDir) {
            Manifest manifest;
            DllmAttributes dllmAttributes = new DllmAttributes();
            File manifestsResultFolder = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/final/result_TEST/");

            JSONObject jsonMetadata = new JSONObject(new JSONTokener(new FileInputStream(file)));
            StaticJsonCaller.staticJsonCaller(dllmAttributes, jsonMetadata);

            manifest = getLabelDataForManifest(file, dllmAttributes);

            String plmp_id = dllmAttributes.getDocuments_code_number();
            counter = Integer.parseInt(dllmAttributes.getDocuments_id().replace("dllm_",""));
            String collection = dllmAttributes.getIn_collection();
            StaticFieldsDllmCollection.staticFields(counter, manifest, plmp_id, collection); //all static fields

            metadataMembers(dllmAttributes, manifest);
            String book_ID = COLLECTION_PATH_PLUS_ZERO + counter;

            addImagePart(file, jsonMetadata, manifest, book_ID);
            addProviderToManifest(manifest, collection);

            File newFile = new File(manifestsResultFolder + "/" + dllmAttributes.getDocuments_id() + ".json");
            manifestor.write(manifest, newFile);
            System.setOut(out);
        }
    }

    @NotNull
    private static Manifest getLabelDataForManifest(File file, DllmAttributes dllmAttributes) {
        Manifest manifest;
        I18n i18n_title_Roman = LabelMetadata.getStringsLabel(dllmAttributes);
        I18n i18n_title = LabelMetadata.getStringsLabelBoth(dllmAttributes);
        I18n i18n_title_no_title_both = LabelMetadata.getStringsLabelNoTitleBoth(dllmAttributes);
        if (i18n_title_Roman!=null) {
            manifest = new Manifest(String.valueOf(file), new Label(i18n_title));
        } else {
            manifest = new Manifest(String.valueOf(file), new Label(i18n_title_no_title_both));
        }
        return manifest;
    }

    private static void addImagePart(File file, JSONObject jsonObj, Manifest manifest, String book_ID) {
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
                URL url = new URL("https://iiif-content.crossasia.org/xasia/dllm" + "+"+COLLECTION_PATH_PLUS_ZERO + pages_document_id + "+" + pages_id + "/info.json");
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

                String manifestID = SERVER + CollectionNames.DLLM.getName() + COLLECTION_PATH_PLUS_ZERO+ pages_document_id + "+" + pages_id;
                canvasID = manifestID + "/canvas";
                String imageID = manifestID + "/full/full/0/default.jpg";
                annoID = manifestID + "/annotation";
                annoPageID = manifestID+"/annotation_page";
                MANIFEST_THUMBNAIL_URI = SERVER + CollectionNames.DLLM.getName() + ""+ book_ID +"+"+ pages_id+   THUMBNAIL_PATH;
                manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + CollectionNames.DLLM.getName()+ book_ID +"+"+ pages_id);
                canvas = new Canvas(canvasID).setWidthHeight((int) weight, (int) height);
                canvas.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));
                imageContent = new ImageContent(imageID).setWidthHeight((int) weight, (int) height);
                imageContent.setServices(manifestThumbService);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e +" - "+ file.getName()+ ", " + pages_id +" - " + pages_document_id) ;
            }

            annoPage = new AnnotationPage<>(annoPageID);
            anno = new PaintingAnnotation(annoID, canvas);
            annoPage.addAnnotations(anno.setBodies(imageContent).setTarget(canvasID));
            canvases.add(canvas.setPaintingPages(annoPage));
            canvas.setLabel("[ "+ pages_position +" ]");
            manifest.setCanvases(canvases);

            MANIFEST_THUMBNAIL_URI = SERVER + CollectionNames.DLLM.getName() + book_ID +"+"+ first_page+ THUMBNAIL_PATH;
            manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + CollectionNames.DLLM.getName()+ book_ID +"+"+first_page);
            manifest.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));

        }
    }
}