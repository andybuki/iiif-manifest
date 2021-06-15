package org.crossasia.manifest;

import info.freelibrary.iiif.presentation.v3.*;
import info.freelibrary.iiif.presentation.v3.io.Manifestor;
import info.freelibrary.iiif.presentation.v3.properties.*;
import info.freelibrary.iiif.presentation.v3.services.image.ImageService3;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.crossasia.manifest.json.StaticJsonCaller;
import org.crossasia.manifest.metadata.*;
import org.crossasia.manifest.metadata.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.*;

import static org.crossasia.manifest.ManifestDllmCollection.readJsonFromUrl;

@SpringBootApplication
public class IIIFPresentationDlllm  {

    private static final String SERVER = "https://iiif-content.crossasia.org/xasia/";
    private static final String THUMBNAIL_PATH = "/full/150,/0/default.jpg";
    private static final String MANIFEST_COLLECTION="dllm+";
    private static final String LOGO_LINK= "https://crossasia.org/fileadmin/templates/img/xa1.png";

    public static void main(String[] args) throws IOException {

        String quote = "\u005c\u0022";
        File absolutePath = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/presentation/splitter/");
        PrintStream out = new PrintStream(new FileOutputStream("src/main/resources/output.txt"));
        File dir = new File(String.valueOf(absolutePath));
        File[] filesInDir = dir.listFiles();
        int counter = 1;
        final Manifestor manifestor = new Manifestor();
        for (File file : filesInDir) {
            DllmAttributes dllmAttributes = new DllmAttributes();
            File created = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/presentation/result2/");
            StringBuilder sb = new StringBuilder();
            JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));
            StaticJsonCaller.staticJsonCaller(dllmAttributes, jsonObj);

            I18n i18n_title_Roman = LabelMetadata.getStringsLabel(dllmAttributes); // get Label
            I18n i18n_title_Lao = LabelMetadata.getStringsLabel(dllmAttributes);
            Manifest manifest = new Manifest(String.valueOf(file), new Label( new I18n[]{i18n_title_Roman, i18n_title_Lao}));

            StaticFields.staticFields(counter, manifest); //all static fields
            counter++;

            metadataMembers(dllmAttributes, manifest);

            String [] book_IDs=dllmAttributes.getDocuments_id().split("_");
            String book_ID = book_IDs[0]+"_"+"000"+book_IDs[1];
            String page_ID="484597";

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

                String pages_position = "";
                String pages_image_file = "";
                String pages_id = "";
                String first_pages_id = "";
                String pages_document_id = "";
                int number_of_pages = pages.length();

                if (pagesObj.has("pages_position"))
                    pages_position = (String) pagesObj.get("pages_position").toString();

                if (pagesObj.has("pages_image_file"))
                    pages_image_file = (String) pagesObj.get("pages_image_file").toString();

                if (pagesObj.has("pages_id")) {
                    pages_id = (String) pagesObj.get("pages_id").toString();
                    first_pages_id = dllmAttributes.getDocuments_id();
                }

                if (pagesObj.has("pages_document_id"))
                    pages_document_id = (String) pagesObj.get("pages_document_id").toString();
                JSONObject json = null;
                try {
                    json = readJsonFromUrl("https://iiif-content.crossasia.org/xasia/dllm" + "+dllm_000" + pages_document_id + "+" + pages_id + "/info.json");

                    manifestID = SERVER + MANIFEST_COLLECTION + "dllm_000" + pages_document_id + "+" + pages_id;
                    canvasID = manifestID + "/canvas";
                    imageID = manifestID + "/full/full/0/default.jpg";
                    annoID = manifestID + "/annotation";
                    annoPageID = manifestID;

                    int weight = (int) json.get("width");
                    int height = (int) json.get("height");

                    canvas = new Canvas(canvasID).setWidthHeight(weight, height);
                    imageContent = new ImageContent(imageID).setWidthHeight((Integer) weight, (Integer) height);

                }catch (NullPointerException e) {
                    System.out.println(e +"NullPointerException - "+ file.getName()+ ", " + pages_id +" - " + pages_document_id) ;
                }catch (Exception e) {
                    System.out.println(e +"Exception - "+ file.getName()+ ", " + pages_id +" - " + pages_document_id) ;
                }

                annoPage = new AnnotationPage<>(annoPageID);
                anno = new PaintingAnnotation(annoID, canvas);
                annoPage.addAnnotations(anno.setBody(imageContent).setTarget(canvasID));
                canvases.add(canvas.setPaintingPages(annoPage));
                manifest.setCanvases(canvases);

                MANIFEST_URI = SERVER + MANIFEST_COLLECTION + book_ID +"+"+pages_id  + "/manifest";
                MANIFEST_THUMBNAIL_URI = SERVER + MANIFEST_COLLECTION + book_ID+"+"+ pages_id+   THUMBNAIL_PATH;

                manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ book_ID+"+"+ pages_id);
                manifest.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));
                //manifest.setStart(new Start("https://iiif-content.crossasia.org/xasia/dllm/dllm_000"+book_ID+"+"+pages_id + "/canvas/"+pages_id));
                manifest.setStart(new Start(MANIFEST_URI.replace("manifest", "canvas/")+ pages_id));

            }
            //end adding images

            Provider provider = new Provider("https://example.org/about",
                    String.valueOf(new Label("en", String.valueOf(new Value(new I18n("en", "Test"))))));

            provider.setLogos(new ImageContent(LOGO_LINK).setServices(manifestThumbService));
            manifest.setProviders(provider);
            File newFile = null;
            newFile = new File(created + "/" + dllmAttributes.getDocuments_id() + ".json"/*file.getName()*/);
            manifestor.write(manifest, newFile);

            //Logger.log();


            System.setOut(out);


        }
    }

    private static void metadataMembers(DllmAttributes dllmAttributes, Manifest manifest) {
        //Metadata metadata_title = getMetadataTitlesRomanThai(dllmAttributes, manifest);
        Metadata metadata_title = Title.getMetadataTitle(dllmAttributes);
        Metadata metadata_language = Language.getMetadataLanguageRomanThai(dllmAttributes);

        Metadata metadata_documentsID = DocumentsID.getMetadataDocumentsID(dllmAttributes);
        Metadata metadata_documentsCodeNumber = CodeNumber.getMetadataDocumentsCodeNumber(dllmAttributes);
        Metadata metadata_documents_roll = DocumentsRoll.getMetadataDocumentsRoll(dllmAttributes);

        Metadata metadata_extent = ExtentMethod.getMetadataExtentMethod(dllmAttributes);
        Metadata metadata_description = Description.getMetadataDescription(dllmAttributes);

        Metadata metadataDllmOriginal = OriginalDllm.getMetadataDllmOriginal(dllmAttributes);
        Metadata metadata_place = Places.getMetadataPlaces(dllmAttributes);
        Metadata metadata_full_location_name = FullLocationName.getMetadataFullLocationName(dllmAttributes);

        Metadata metadata_has_colophon = HasColophon.getMetadataHasColophon(dllmAttributes);
        Metadata metadata_is_illustrated = IsIllustrated.getMetadataIsIllustrated(dllmAttributes);
        Metadata metadata_is_color= IsColor.getMetadataIsColor(dllmAttributes);
        Metadata metadata_bundle_id= BundleID.getMetadataBundleID(dllmAttributes);

        Metadata metadata_is_complete= IsComplete.getMetadataIsComplete(dllmAttributes);
        Metadata metadata_pages_count= PagesCount.getMetadataPagesCount(dllmAttributes);
        Metadata metadata_material= Material.getMetadataMaterial(dllmAttributes);
        Metadata metadata_location_types_name= LocationTypes.getMetadataLocationTypesName(dllmAttributes);

        Metadata metadata_latitude= LatLon.getMetadataLatitude(dllmAttributes);
        Metadata metadata_longitude= LatLon.getMetadataLongitude(dllmAttributes);
        Metadata metadata_keywords= Keywords.getMetadataKeywords(dllmAttributes);
        Metadata metadata_categories= Categories.getMetadataCategories(dllmAttributes);

        Metadata metadata_script= Script.getMetadataScript(dllmAttributes);
        Metadata metadata_index= Index.getMetadataIndex(dllmAttributes);
        Metadata metadata_legibilities= Legibilities.getMetadataLegibilities(dllmAttributes);
        Metadata metadata_conditions= Conditions.getMetadataConditions(dllmAttributes);

        Metadata metadata_date= Date.getMetadataDate(dllmAttributes);
        Metadata metadata_date_original= DateOriginal.getMetadataDateOriginal(dllmAttributes);


        ArrayList<Metadata> metadataArrayList = new ArrayList<>();

        metadataArrayList.add(metadata_title);
        metadataArrayList.add(metadata_language);
        metadataArrayList.add(metadata_documentsID);

        metadataArrayList.add(metadata_documentsCodeNumber);
        metadataArrayList.add(metadata_documents_roll);
        metadataArrayList.add(metadata_extent);
        metadataArrayList.add(metadata_place);

        metadataArrayList.add(metadata_full_location_name);
        metadataArrayList.add(metadataDllmOriginal);
        metadataArrayList.add(metadata_description);
        metadataArrayList.add(metadata_has_colophon);

        metadataArrayList.add(metadata_is_illustrated);
        metadataArrayList.add(metadata_is_color);
        metadataArrayList.add(metadata_bundle_id);
        metadataArrayList.add(metadata_is_complete);

        metadataArrayList.add(metadata_pages_count);
        metadataArrayList.add(metadata_material);
        metadataArrayList.add(metadata_location_types_name);

        metadataArrayList.add(metadata_latitude);
        metadataArrayList.add(metadata_longitude);
        metadataArrayList.add(metadata_keywords);
        metadataArrayList.add(metadata_categories);

        metadataArrayList.add(metadata_script);
        metadataArrayList.add(metadata_index);
        metadataArrayList.add(metadata_legibilities);
        metadataArrayList.add(metadata_conditions);

        metadataArrayList.add(metadata_date);
        metadataArrayList.add(metadata_date_original);

        Iterator<Metadata> iter = metadataArrayList.iterator();

        while (iter.hasNext()) {
            Metadata md = iter.next();
            if (md==null)
                iter.remove();
        }
        manifest.setMetadata(metadataArrayList);
    }

}
