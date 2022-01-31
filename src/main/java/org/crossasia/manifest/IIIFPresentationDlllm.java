package org.crossasia.manifest;

import info.freelibrary.iiif.presentation.v3.*;

import info.freelibrary.iiif.presentation.v3.properties.*;
import info.freelibrary.iiif.presentation.v3.services.image.ImageService3;
import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.crossasia.manifest.json.StaticJsonCaller;
import org.crossasia.manifest.metadata.*;
import org.crossasia.manifest.metadata.Date;
import org.crossasia.manifest.metadata.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.crossasia.manifest.IIIFPresentationDlllm.ORIGINAL_LANGUAGE;
import static org.crossasia.manifest.MetadataMembers.metadataMembers;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

@SpringBootApplication
public class IIIFPresentationDlllm  {

    private static final String SERVER = "https://iiif-content.crossasia.org/xasia/";
    private static final String THUMBNAIL_PATH = "/full/150,/0/default.jpg";
    private static final String MANIFEST_COLLECTION="dllm+";
    public static final String ORIGINAL_LANGUAGE = "th";
    public static final String COLLECTION_PATH = "dllm";
    private static final String LOGO_LINK= "https://crossasia.org/fileadmin/templates/img/xa1.png";
    private static final String LOGO_LINK_LAOS= "http://nationallibraryoflaos.net/wp-content/themes/education-pro/images/header.jpg";

    public static void main(String[] args) throws IOException {

        String quote = "\u005c\u0022";
        File absolutePath = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/final/raw/raw1/");
        PrintStream out = new PrintStream(new FileOutputStream("src/main/resources/output.txt"));
        File dir = new File(String.valueOf(absolutePath));
        File[] filesInDir = dir.listFiles();
        int counter = 1;
        Manifestor manifestor = new Manifestor();

        for (File file : filesInDir) {
            DllmAttributes dllmAttributes = new DllmAttributes();
            File created = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/final/result/");
            StringBuilder sb = new StringBuilder();
            JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));
            StaticJsonCaller.staticJsonCaller(dllmAttributes, jsonObj);
            Manifest manifest;
            I18n i18n_title_Roman = LabelMetadata.getStringsLabel(dllmAttributes);
            I18n i18n_title_Lao = LabelMetadata.getStringsLabelThai(dllmAttributes);
            I18n i18n_title_no_title = LabelMetadata.getStringsLabelNoTitle(dllmAttributes);
            I18n i18n_title_no_title_thai = LabelMetadata.getStringsLabelNoTitleThai(dllmAttributes);
            I18n i18n_title = LabelMetadata.getStringsLabelBoth(dllmAttributes);
            I18n i18n_title_no_title_both = LabelMetadata.getStringsLabelNoTitleBoth(dllmAttributes);
            if (i18n_title_Roman!=null) {
                manifest = new Manifest(String.valueOf(file), new Label( new I18n[]{i18n_title}));
            } else {
                manifest = new Manifest(String.valueOf(file), new Label( new I18n[]{i18n_title_no_title_both}));
            }
            String plmp_id = dllmAttributes.getDocuments_code_number();
            counter = Integer.parseInt(dllmAttributes.getDocuments_id().replace("dllm_",""));
            String collection = dllmAttributes.getIn_collection();
            StaticFieldsDllmCollection.staticFields(counter, manifest, plmp_id, collection); //all static fields

            metadataMembers(dllmAttributes, manifest);

            //String [] book_IDs=dllmAttributes.getDocuments_id().split("_");
            //String book_ID = book_IDs[0]+"_"+"000"+book_IDs[1];
            //String book_ID_Thumb = book_IDs[0]+"_"+book_IDs[1];
            String page_ID="484597";
            String book_ID = "dllm_000"+counter;

            String MANIFEST_URI = SERVER + MANIFEST_COLLECTION + "+"+book_ID+"+"+ page_ID + "/manifest";
            String MANIFEST_THUMBNAIL_URI = SERVER + MANIFEST_COLLECTION + "+"+book_ID+"+"+ page_ID+   THUMBNAIL_PATH;

            ImageService3 manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ book_ID+"+"+ page_ID);

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
                JSONObject pagesObj_first = (JSONObject) pages.get(0);

                int pages_position = 0;
                String pages_image_file = "";
                String pages_id = "";
                String first_pages_id = "";
                String first_page = "";
                String pages_document_id = "";
                int number_of_pages = pages.length();

                if (pagesObj_first.has("pages_id")) {
                    first_page = (String) pagesObj_first.get("pages_id").toString();
                }

                if (pagesObj.has("pages_position"))
                    pages_position = Integer.parseInt(String.valueOf(pagesObj.get("pages_position")))+1;

                if (pagesObj.has("pages_image_file"))
                    pages_image_file = (String) pagesObj.get("pages_image_file").toString();

                if (pagesObj.has("pages_id")) {
                    pages_id = (String) pagesObj.get("pages_id").toString();
                    first_pages_id = dllmAttributes.getDocuments_id();
                }

                if (pagesObj.has("pages_document_id"))
                    pages_document_id = (String) pagesObj.get("pages_document_id").toString();

                try {
                    URL url = new URL("https://iiif-content.crossasia.org/xasia/dllm" + "+dllm_000" + pages_document_id + "+" + pages_id + "/info.json");
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

                    manifestID = SERVER + MANIFEST_COLLECTION + "dllm_000" + pages_document_id + "+" + pages_id;
                    canvasID = manifestID + "/canvas";
                    imageID = manifestID + "/full/full/0/default.jpg";
                    annoID = manifestID + "/annotation";
                    //////annoPageID = manifestID;
                    annoPageID = manifestID+"/annotation_page";
                    MANIFEST_THUMBNAIL_URI = SERVER + MANIFEST_COLLECTION + ""+book_ID+"+"+ pages_id+   THUMBNAIL_PATH;
                    manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ book_ID+"+"+ pages_id);
                    canvas = new Canvas(canvasID).setWidthHeight((int) weight, (int) height);
                    canvas.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));
                    imageContent = new ImageContent(imageID).setWidthHeight((int) weight, (int) height);
                    imageContent.setServices(manifestThumbService);

                    /*canvas = new Canvas(canvasID).setWidthHeight((int) weight, (int) height);
                    imageContent = new ImageContent(imageID).setWidthHeight((int) weight, (int) height);

                    canvas.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));
                    imageContent.setServices(manifestThumbService);*/

                }catch (NullPointerException e) {
                    e.printStackTrace();
                    System.out.println(e +" - "+ file.getName()+ ", " + pages_id +" - " + pages_document_id) ;
                }catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println(e +" - "+ file.getName()+ ", " + pages_id +" - " + pages_document_id) ;
                }catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e +" - "+ file.getName()+ ", " + pages_id +" - " + pages_document_id) ;
                }

                annoPage = new AnnotationPage<>(annoPageID);
                anno = new PaintingAnnotation(annoID, canvas);
                annoPage.addAnnotations(anno.setBodies(imageContent).setTarget(canvasID));
                canvases.add(canvas.setPaintingPages(annoPage));
                canvas.setLabel("[ "+ pages_position +" ]");
                manifest.setCanvases(canvases);

                MANIFEST_URI = SERVER + MANIFEST_COLLECTION + book_ID +"+"+pages_id  + "/manifest";
                MANIFEST_THUMBNAIL_URI = SERVER + MANIFEST_COLLECTION + book_ID+"+"+ first_page+   THUMBNAIL_PATH;

                //manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ book_ID+"+"+book_ID+"_"+ pages_id);


                manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ book_ID+"+"+first_page);
                manifest.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));

            }
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

            //manifest.setProviders(provider, provider_laos);

            if (collection.contains("PNTMP")) {
                manifest.setProviders(provider, provider_thai, provider_laos);
            } else if (collection.contains("DLNTM")) {
                manifest.setProviders(provider, provider_laos);
            } else {
                manifest.setProviders(provider, provider_laos);
            }

            File newFile = null;
            newFile = new File(created + "/" + dllmAttributes.getDocuments_id() + ".json"/*file.getName()*/);
            manifestor.write(manifest, newFile);

            System.setOut(out);

        }
    }
}
