package org.crossasia.manifest;

import info.freelibrary.iiif.presentation.v3.*;
import info.freelibrary.iiif.presentation.v3.io.Manifestor;
import info.freelibrary.iiif.presentation.v3.properties.*;
import info.freelibrary.iiif.presentation.v3.properties.behaviors.ManifestBehavior;
import info.freelibrary.iiif.presentation.v3.services.Service;
import info.freelibrary.iiif.presentation.v3.services.image.ImageService3;
import info.freelibrary.iiif.presentation.v3.services.OtherService;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.Collection;

import static info.freelibrary.iiif.presentation.v3.properties.ViewingDirection.RIGHT_TO_LEFT;
import static org.crossasia.manifest.ManifestDllmCollection.readJsonFromUrl;

@SpringBootApplication
public class IIIFPresentationDlllm {

    private static final String SERVER = "https://iiif-content.crossasia.org/xasia/";
    private static final String THUMBNAIL_PATH = "/full/150,/0/default.jpg";
    private static final String MANIFEST_COLLECTION="dllm+dllm_";
    private static final String LOGO_LINK= "https://ngcs-beta.staatsbibliothek-berlin.de/dc/logo-small";

    public static void main(String[] args) throws IOException {


        String quote = "\u005c\u0022";
        File absolutePath = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/presentation/raw/");

        File dir = new File(String.valueOf(absolutePath));
        File[] filesInDir = dir.listFiles();
        int counter = 1;

        for (File file : filesInDir) {
            DllmAttributes dllmAttributes = new DllmAttributes();
            File created = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/presentation/created/");
            StringBuilder sb = new StringBuilder();
            JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

            Manifestor manifestor = new Manifestor();

            titleRoman(dllmAttributes, jsonObj);
            titleThai(dllmAttributes, jsonObj);
            languageRoman(dllmAttributes, jsonObj);
            languageThai(dllmAttributes, jsonObj);
            getDllmID(dllmAttributes, jsonObj);

            I18n i18n_title_Roman = getStringsLabel(dllmAttributes); // get Label
            Manifest manifest = new Manifest(String.valueOf(file), new Label(i18n_title_Roman));
            staticFields(counter, manifest); //all static fields
            counter++;

            Metadata metadata_title = getMetadataTitleRomanThai(dllmAttributes);
            Metadata metadata_language = getMetadataLanguageRomanThai(dllmAttributes);

            manifest.setMetadata(metadata_title, metadata_language);

            String book_ID=dllmAttributes.getId();

            manifest.setStart(new Start("https://iiif-content.crossasia.org/xasia/dllm/dllm_000"+book_ID+"/canvas/1"));

            String page_ID="484597";

            String MANIFEST_URI = SERVER + MANIFEST_COLLECTION + book_ID +page_ID  + "/manifest";
            String MANIFEST_THUMBNAIL_URI = SERVER + MANIFEST_COLLECTION + book_ID+"+"+ page_ID+   THUMBNAIL_PATH;

            ImageService3 manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ book_ID+"+"+ page_ID);
            manifest.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));


            //start adding images
            JSONArray pages = null;
            if (jsonObj.has("pages")) {
                pages = (jsonObj.getJSONArray("pages"));
            }

            int page_int = pages.length();
            String manifestID ="";
            String canvasID ="";
            String annoID ="";
            String imageID ="";
            String annoPageID ="";

            Canvas canvas = new Canvas("");
            ArrayList<Canvas> canvases = new ArrayList<Canvas>();
            AnnotationPage<PaintingAnnotation> annoPage = new AnnotationPage<>("");
            PaintingAnnotation anno = new PaintingAnnotation("",canvas);
            ImageContent imageContent = new ImageContent("");

            for (int j = 0; j < pages.length(); j++) {
                JSONObject pagesObj = (JSONObject) pages.get(j);



                String pages_position="";
                String pages_image_file="";
                String pages_id="";
                String pages_document_id="";
                int number_of_pages = pages.length();

                if (pagesObj.has("pages_position"))
                    pages_position = (String) pagesObj.get("pages_position").toString();

                if (pagesObj.has("pages_image_file"))
                    pages_image_file = (String) pagesObj.get("pages_image_file").toString();

                if (pagesObj.has("pages_id"))
                    pages_id = (String) pagesObj.get("pages_id").toString();

                if (pagesObj.has("pages_document_id"))
                    pages_document_id = (String) pagesObj.get("pages_document_id").toString();

                JSONObject json = readJsonFromUrl("https://iiif-content.crossasia.org/xasia/dllm"+"+dllm_000"+pages_document_id+"+"+pages_id+"/info.json");

                manifestID = SERVER + MANIFEST_COLLECTION + "000" + pages_document_id +"+"+ pages_id;
                canvasID = manifestID +"/canvas";
                imageID = manifestID+"/full/full/0/default.jpg";
                annoID = manifestID+"/annotation";
                annoPageID = manifestID;

                canvas = new Canvas(canvasID).setWidthHeight((Integer) json.get("width"), (Integer) json.get("height"));

                imageContent = new ImageContent(imageID).setWidthHeight((Integer) json.get("width"), (Integer) json.get("height"));
                annoPage = new AnnotationPage<>(annoPageID);
                anno = new PaintingAnnotation(annoID, canvas);
                annoPage.addAnnotations(anno.setBody(imageContent).setTarget(canvasID));
                canvases.add(canvas.setPaintingPages(annoPage));
                //manifest.setCanvases(canvas.setPaintingPages(annoPage));
                manifest.setCanvases(canvases);
            }
            //end adding images

            Provider provider = new Provider("https://example.org/about",
                    String.valueOf(new Label("en", String.valueOf(new Value(new I18n("en", "Test"))))));

            provider.setLogos(new ImageContent(LOGO_LINK).setServices(manifestThumbService));
            manifest.setProviders(provider);

            File newFile = new File(created +"/" +file.getName());
            manifestor.write(manifest, newFile);

        }
    }

    private static Metadata getMetadataTitleRomanThai(DllmAttributes dllmAttributes) {
        ArrayList<String> titleRomanArrayList = new ArrayList<>();
        ArrayList<String> titleThaiArrayList = new ArrayList<>();
        Metadata metadata_title = new Metadata(new Label("en",""), new Value("en",""));

        for (int i = 0; i< dllmAttributes.getTitle_roman().length(); i++) {
            titleRomanArrayList.add(dllmAttributes.getTitle_roman().get(i).toString());
            titleThaiArrayList.add(dllmAttributes.getTitle_lao().get(i).toString());
            I18n i18n_title_Roman = new I18n("en", titleRomanArrayList);
            I18n i18n_title_Thai = new I18n("lo", titleThaiArrayList);
            metadata_title = new Metadata(new Label("en","Title") ,
                    new Value(new I18n []{i18n_title_Roman, i18n_title_Thai}));
        }
        return metadata_title;

    }

    private static Metadata getMetadataLanguageRomanThai(DllmAttributes dllmAttributes) {
        ArrayList<String> languagesRomanArrayList = new ArrayList<>();
        ArrayList<String> languagesThaiArrayList = new ArrayList<>();
        Metadata metadata_language = new Metadata(new Label("en",""), new Value("en",""));

        for (int i = 0; i< dllmAttributes.getLanguages().length(); i++) {
            languagesRomanArrayList.add(dllmAttributes.getLanguages().get(i).toString());
            languagesThaiArrayList.add(dllmAttributes.getLanguages_lao().get(i).toString());
            I18n i18n_language_Roman = new I18n("en", languagesRomanArrayList);
            I18n i18n_language_Thai = new I18n("lo", languagesThaiArrayList);
            metadata_language = new Metadata(new Label("en","Language") ,
                    new Value(new I18n []{i18n_language_Roman, i18n_language_Thai}));
        }
        return metadata_language;
    }

    private static I18n getStringsLabel(DllmAttributes dllmAttributes) {
        ArrayList<String> titlesArrayList = new ArrayList<>();
        I18n i18n_title_Roman = new I18n("en", "");
        for (int i = 0; i< dllmAttributes.getTitle_roman().length(); i++) {
            titlesArrayList.add(dllmAttributes.getTitle_roman().get(i).toString());
            i18n_title_Roman = new I18n("en", titlesArrayList);
        }
        return i18n_title_Roman;
    }

    private static void staticFields(int counter, Manifest manifest) {
        manifest.addContexts("http://iiif.io/api/presentation/3/context.json");
        manifest.setID("https://itr02.crossasia.org/fcrepo/rest/dllm/dllm_000"+counter+"/manifest");
        Summary summary = new Summary(new I18n("en", "Digital Library of Lao Manuscripts"));
        manifest.setSummary(summary);
        manifest.setRights("http://creativecommons.org/licenses/by/4.0/");
        manifest.setViewingDirection(RIGHT_TO_LEFT);
        manifest.setHomepages(new Homepage(URI.create("https://iiif.corossasia.org"),
                new Label("en","Crossasia Madoc Page")));
        manifest.setPartOfs(new PartOf("https://iiif.corossasia.org/collections","Collection"));
        OtherService otherService;
        final RequiredStatement reqStmt;
        reqStmt = new RequiredStatement(new Label("en","Attribution"),
                new Value(new I18n("en","Provided courtesy of Example Institution")));

        otherService = new OtherService("https://example.org/service/example", "example")
                .setProfile("https://example.org/docs/example-service.html");

        manifest.setRights("http://creativecommons.org/licenses/by/4.0/").setBehaviors(ManifestBehavior.PAGED)
                .setRequiredStatement(reqStmt).setServices(otherService);

        SeeAlso seeAlso = new SeeAlso("https://example.org/library/catalog/book1.xml", ResourceTypes.DATASET);
        seeAlso.setFormat("text/xml");
        seeAlso.setProfile("https//schema.org");
        manifest.setSeeAlsoRefs(seeAlso);
    }



    private static void titleRoman(DllmAttributes dllmAttributes, JSONObject jsonObj) {
        if (jsonObj.has("titles")) {
            dllmAttributes.setTitle_roman((JSONArray) jsonObj.get("titles"));
        }
    }
    private static void titleThai(DllmAttributes dllmAttributes, JSONObject jsonObj) {
        if (jsonObj.has("titles_lao")) {
            dllmAttributes.setTitle_lao((JSONArray) jsonObj.get("titles_lao"));
        }
    }

    private static void getDllmID(DllmAttributes dllmAttributes, JSONObject jsonObj) {
        if (jsonObj.has("id")) {
            dllmAttributes.setId((String) jsonObj.get("id").toString());
        }
    }


    private static void languageRoman(DllmAttributes dllmAttributes, JSONObject jsonObj) {
        if (jsonObj.has("languages")) {
            dllmAttributes.setLanguages((JSONArray) jsonObj.get("languages"));
        }
    }

    private static void languageThai(DllmAttributes dllmAttributes, JSONObject jsonObj) {
        if (jsonObj.has("languages_lao")) {
            dllmAttributes.setLanguages_lao((JSONArray) jsonObj.get("languages_lao"));
        }
    }
}
