package org.crossasia.manifest.presentations;

import info.freelibrary.iiif.presentation.v3.*;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Provider;
import info.freelibrary.iiif.presentation.v3.services.image.ImageService3;
import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.json.StaticJsonCaller;
import org.crossasia.manifest.metadata.LabelMetadata;
import org.crossasia.manifest.metadata.StaticFieldsDllmtPhotoCollection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import static org.crossasia.manifest.metadata.MetadataMembers.metadataMembers;

@SpringBootApplication
public class IIIFPresentationTurfan {

    public static final String ORIGINAL_LANGUAGE = "th";
    private static final String SERVER = "https://iiif-content.crossasia.org/xasia/";
    private static String THUMBNAIL_PATH = "/full/150,/0/default.jpg";
    private static final String MANIFEST_COLLECTION="turfan+images+";
    public static final String COLLECTION_PATH = "turfan/images";
    private static final String LOGO_LINK= "https://crossasia.org/fileadmin/templates/img/xa1.png";
    private static final String LOGO_LINK_LAOS= "http://nationallibraryoflaos.net/wp-content/themes/education-pro/images/header.jpg";

    public static void main(String[] args) throws IOException {

        String quote = "\u005c\u0022";
        String photos = "/data/dlmnt/photos/images.json";
        JSONArray photosObject = new JSONArray(new JSONTokener(new FileInputStream(photos)));
        PrintStream out = new PrintStream(new FileOutputStream("src/main/resources/output.txt"));

        int counter = 1;
        StringBuilder sb = new StringBuilder();
        Manifestor manifestor = new Manifestor();

        for (int i=0; i<photosObject.length(); i++) {
            CollectionAttributes dllmAttributes = new CollectionAttributes();
            File created = new File("/data/turfan/photos/final/");
            JSONObject jsonObj = (JSONObject) photosObject.get(i);
            StaticJsonCaller.staticJsonCaller(dllmAttributes, jsonObj);
            Manifest manifest;
            I18n i18n_title_Roman = LabelMetadata.getStringsLabelFromAddress(dllmAttributes);
            I18n i18n_title_Lao = LabelMetadata.getStringsLabelThai(dllmAttributes);
            I18n i18n_title_no_title = LabelMetadata.getStringsLabelFromAddress(dllmAttributes);
            I18n i18n_title_no_title_thai = LabelMetadata.getStringsLabelNoTitleThai(dllmAttributes);
            //I18n i18n_title = LabelMetadata.getStringsLabelBoth(dllmAttributes);

            I18n i18n_title_no_title_both = LabelMetadata.getStringsLabelNoTitleBoth(dllmAttributes);
            I18n i18n_title = LabelMetadata.getStringsLabelFromAddress(dllmAttributes);
            if (i18n_title!=null) {
                manifest = new Manifest(String.valueOf(i), new Label( new I18n[]{i18n_title}));
            } else {
                manifest = new Manifest(String.valueOf(i), new Label( new I18n[]{i18n_title_no_title_both}));
            }
            String plmp_id = dllmAttributes.getCode_number();

            counter = Integer.parseInt(jsonObj.get("id").toString().replace("lanna_photo_",""));
            String collection = dllmAttributes.getIn_collection();
            StaticFieldsDllmtPhotoCollection.staticFields(counter, manifest, plmp_id, collection); //all static fields

            metadataMembers(dllmAttributes, manifest);

            String book_ID = String.valueOf(counter);

            String MANIFEST_URI = SERVER + MANIFEST_COLLECTION + ""+book_ID + "/manifest";
            String MANIFEST_THUMBNAIL_URI = SERVER + MANIFEST_COLLECTION + ""+book_ID+  THUMBNAIL_PATH;

            ImageService3 manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ book_ID+"+"+book_ID);

            //start adding images
            JSONArray pages = null;
            String image ="";

            if (jsonObj.has("image")) {
                image = (String) jsonObj.get("image");

            }

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

            int pages_position = 0;

            if (jsonObj.has("position")) {
                pages_position = jsonObj.getInt("position");
            }

                try {
                    URL url = new URL("https://iiif-content.crossasia.org/xasia/turfan+images+" + "" + book_ID + "/info.json");
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

                    manifestID = SERVER + MANIFEST_COLLECTION + "" + book_ID;
                    canvasID = manifestID + "/canvas";
                    imageID = manifestID + "/full/full/0/default.jpg";
                    annoID = manifestID + "/annotation";
                    annoPageID = manifestID+"/annotation_page";
                    MANIFEST_THUMBNAIL_URI = SERVER + MANIFEST_COLLECTION + ""+book_ID+   THUMBNAIL_PATH;
                    manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ book_ID);
                    canvas = new Canvas(canvasID).setWidthHeight((int) weight, (int) height);
                    canvas.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));
                    imageContent = new ImageContent(imageID).setWidthHeight((int) weight, (int) height);
                    imageContent.setServices(manifestThumbService);

                }catch (NullPointerException e) {
                    e.printStackTrace();
                    //System.out.println(e +" - "+ i.getName()+ ", " + pages_id +" - " + pages_document_id) ;
                }catch (ParseException e) {
                    e.printStackTrace();
                    //System.out.println(e +" - "+ file.getName()+ ", " + pages_id +" - " + pages_document_id) ;
                }catch (Exception e) {
                    e.printStackTrace();
                    //System.out.println(e +" - "+ file.getName()+ ", " + pages_id +" - " + pages_document_id) ;
                }

                annoPage = new AnnotationPage<>(annoPageID);
                anno = new PaintingAnnotation(annoID, canvas);
                annoPage.addAnnotations(anno.setBodies(imageContent).setTarget(canvasID));
                canvases.add(canvas.setPaintingPages(annoPage));
                canvas.setLabel("[ "+ pages_position +" ]");

                manifest.setCanvases(canvases);

                MANIFEST_URI = SERVER + MANIFEST_COLLECTION + book_ID   + "/manifest";
                MANIFEST_THUMBNAIL_URI = SERVER + MANIFEST_COLLECTION + book_ID+   THUMBNAIL_PATH;

                manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ book_ID);
                manifest.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));

            //end adding images

            Provider provider = new Provider("crossasia.org",  "Staatsbibliothek zu Berlin | CrossAsia");

            Label label_provider_laos = new Label(new I18n("en", "National Library of Laos"),
                    new I18n(ORIGINAL_LANGUAGE,"ຫໍສະໝຸດແຫ່ງຊາດ"));
            Label label_provider_thai = new Label (new I18n("en","Chiang Mai University Library"),
                    new I18n(ORIGINAL_LANGUAGE, "สำนักหอสมุดมหาวิทยาลัยเชียงใหม่"));

            Provider provider_laos = new Provider("http://nationallibraryoflaos.net/en/", "");
            Provider provider_thai = new Provider("https://library.cmu.ac.th/","");

            provider_laos.setLabel(label_provider_laos);
            provider_thai.setLabel(label_provider_thai);

            //provider.setLogos(new ImageContent(LOGO_LINK).setWidthHeight(100, 150));
            //provider_laos.setLogos(new ImageContent(LOGO_LINK_LAOS).setWidthHeight(100, 150));
            /*provider.setHomepages(new Homepage(URI.create("https://iiif.corossasia.org"),
                    new Label("en","Crossasia IIIF collections")));*/

            /*if (collection.contains("PNTMP")) {
                manifest.setProviders(provider, provider_thai, provider_laos);
            } else if (collection.contains("DLNTM")) {
                manifest.setProviders(provider, provider_laos);
            } else {
                manifest.setProviders(provider, provider_laos);
            }*/

            File newFile = null;
            newFile = new File(created + "/" + jsonObj.get("id") + ".json"/*file.getName()*/);
            manifestor.write(manifest, newFile);
            System.setOut(out);
        }
    }
}
