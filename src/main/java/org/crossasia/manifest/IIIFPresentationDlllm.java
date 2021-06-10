package org.crossasia.manifest;

import info.freelibrary.iiif.presentation.v3.*;
import info.freelibrary.iiif.presentation.v3.io.Manifestor;
import info.freelibrary.iiif.presentation.v3.properties.*;
import info.freelibrary.iiif.presentation.v3.properties.behaviors.ManifestBehavior;
import info.freelibrary.iiif.presentation.v3.services.image.ImageService3;
import info.freelibrary.iiif.presentation.v3.services.OtherService;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.crossasia.manifest.json.JsonConnecter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.*;

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
        File absolutePath = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/presentation/splitter2/");

        File dir = new File(String.valueOf(absolutePath));
        File[] filesInDir = dir.listFiles();
        int counter = 1;

        for (File file : filesInDir) {
            DllmAttributes dllmAttributes = new DllmAttributes();
            File created = new File("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/presentation/result/");
            StringBuilder sb = new StringBuilder();
            JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

            Manifestor manifestor = new Manifestor();

            JsonConnecter.titleRoman(dllmAttributes, jsonObj);
            JsonConnecter.titleThai(dllmAttributes, jsonObj);
            JsonConnecter.languageRoman(dllmAttributes, jsonObj);
            JsonConnecter.languageThai(dllmAttributes, jsonObj);
            JsonConnecter.documentsID(dllmAttributes,jsonObj);
            JsonConnecter.documentsCodeNumber(dllmAttributes,jsonObj);
            JsonConnecter.documentsRoll(dllmAttributes,jsonObj);
            JsonConnecter.documentsExtent(dllmAttributes,jsonObj);
            JsonConnecter.documentsNumberOfFascicles(dllmAttributes,jsonObj);
            JsonConnecter.documentsNumberOfFolios(dllmAttributes,jsonObj);
            JsonConnecter.fullLocationName(dllmAttributes,jsonObj);
            JsonConnecter.fullLocationNameLao(dllmAttributes,jsonObj);
            JsonConnecter.locationsParentParentName(dllmAttributes,jsonObj);
            JsonConnecter.locationsParentParentNameLao(dllmAttributes,jsonObj);
            JsonConnecter.locationsParentName(dllmAttributes,jsonObj);
            JsonConnecter.locationsParentNameLao(dllmAttributes,jsonObj);
            JsonConnecter.locationsIsTopLevel(dllmAttributes,jsonObj);
            JsonConnecter.locationsParentParentID(dllmAttributes,jsonObj);
            JsonConnecter.documentsHasColophon(dllmAttributes,jsonObj);
            JsonConnecter.documentsIsIllustrated(dllmAttributes,jsonObj);
            JsonConnecter.documentsIsColor(dllmAttributes,jsonObj);
            JsonConnecter.documentsIsComplete(dllmAttributes,jsonObj);
            JsonConnecter.documentsPagesCount(dllmAttributes,jsonObj);
            JsonConnecter.documentsPositionInBundle(dllmAttributes,jsonObj);
            JsonConnecter.locationsParentID(dllmAttributes,jsonObj);
            JsonConnecter.locationsID(dllmAttributes,jsonObj);
            JsonConnecter.documentsBundleID(dllmAttributes,jsonObj);
            JsonConnecter.description(dllmAttributes,jsonObj);

            JsonConnecter.materialsName(dllmAttributes,jsonObj);
            JsonConnecter.materialsNameLao(dllmAttributes,jsonObj);
            JsonConnecter.locationTypesName(dllmAttributes,jsonObj);

            JsonConnecter.locationTypesNameLao(dllmAttributes,jsonObj);
            JsonConnecter.locationsLft(dllmAttributes,jsonObj);
            JsonConnecter.locationsRgt(dllmAttributes,jsonObj);

            JsonConnecter.locationsDllmLocCode(dllmAttributes,jsonObj);
            JsonConnecter.locationsGpsLat(dllmAttributes,jsonObj);
            JsonConnecter.locationsGpsLon(dllmAttributes,jsonObj);

            JsonConnecter.ancillaryTermsRoman(dllmAttributes,jsonObj);
            JsonConnecter.ancillaryTermsLao(dllmAttributes,jsonObj);
            JsonConnecter.publicRemarksEnglish(dllmAttributes,jsonObj);

            JsonConnecter.publicRemarksLao(dllmAttributes,jsonObj);
            JsonConnecter.categoriesName(dllmAttributes,jsonObj);
            JsonConnecter.categoriesNameLao(dllmAttributes,jsonObj);

            JsonConnecter.scripts(dllmAttributes,jsonObj);
            JsonConnecter.scriptsLao(dllmAttributes,jsonObj);
            JsonConnecter.titleSearchRoman(dllmAttributes,jsonObj);

            JsonConnecter.titleSearchLao(dllmAttributes,jsonObj);
            JsonConnecter.dllmTitleRoman(dllmAttributes,jsonObj);
            JsonConnecter.dllmTitleLao(dllmAttributes,jsonObj);

            JsonConnecter.plmpTitleLao(dllmAttributes,jsonObj);
            JsonConnecter.locationDocumentsCount(dllmAttributes,jsonObj);
            JsonConnecter.legibilitiesName(dllmAttributes,jsonObj);

            JsonConnecter.legibilitiesNameLao(dllmAttributes,jsonObj);
            JsonConnecter.conditionsName(dllmAttributes,jsonObj);
            JsonConnecter.conditionsNameLao(dllmAttributes,jsonObj);

            JsonConnecter.documentsPreferredDateSystem(dllmAttributes,jsonObj);
            JsonConnecter.documentsPreferredDateSystemLao(dllmAttributes,jsonObj);
            JsonConnecter.documentsDateWritten(dllmAttributes,jsonObj);
            JsonConnecter.dateOriginal(dllmAttributes,jsonObj);
            JsonConnecter.dateOriginalLao(dllmAttributes,jsonObj);

            I18n i18n_title_Roman = getStringsLabel(dllmAttributes); // get Label
            Manifest manifest = new Manifest(String.valueOf(file), new Label(i18n_title_Roman));

            staticFields(counter, manifest); //all static fields
            counter++;

            Metadata metadata_title = getMetadataTitlesRomanThai(dllmAttributes, manifest);
            Metadata metadata_language = getMetadataLanguageRomanThai(dllmAttributes);

            Metadata metadata_documentsID = getMetadataDocumentsID(dllmAttributes);
            Metadata metadata_documentsCodeNumber = getMetadataDocumentsCodeNumber(dllmAttributes);
            Metadata metadata_documents_roll = getMetadataDocumentsRoll(dllmAttributes);

            Metadata metadata_extent = getMetadataExtentMethod(dllmAttributes);
            Metadata metadata_description = getMetadataDescription(dllmAttributes);

            Metadata metadataDllmOriginal = getMetadataDllmOriginal(dllmAttributes);
            Metadata metadata_place = getMetadataPlaces(dllmAttributes);
            Metadata metadata_full_location_name = getMetadataFullLocationName(dllmAttributes);

            Metadata metadata_has_colophon = getMetadataHasColophon(dllmAttributes);
            Metadata metadata_is_illustrated = getMetadataIsIllustrated(dllmAttributes);
            Metadata metadata_is_color= getMetadataIsColor(dllmAttributes);
            Metadata metadata_bundle_id= getMetadataBundleID(dllmAttributes);

            Metadata metadata_is_complete= getMetadataIsComplete(dllmAttributes);
            Metadata metadata_pages_count= getMetadataPagesCount(dllmAttributes);
            Metadata metadata_material= getMetadataMaterial(dllmAttributes);
            Metadata metadata_location_types_name= getMetadataLocationTypesName(dllmAttributes);

            Metadata metadata_latitude= getMetadataLatitude(dllmAttributes);
            Metadata metadata_longitude= getMetadataLongitude(dllmAttributes);
            Metadata metadata_keywords= getMetadataKeywords(dllmAttributes);
            Metadata metadata_categories= getMetadataCategories(dllmAttributes);

            Metadata metadata_script= getMetadataScript(dllmAttributes);
            Metadata metadata_index= getMetadataIndex(dllmAttributes);
            Metadata metadata_legibilities= getMetadataLegibilities(dllmAttributes);
            Metadata metadata_conditions= getMetadataConditions(dllmAttributes);

            Metadata metadata_date= getMetadataDate(dllmAttributes);
            Metadata metadata_date_original= getMetadataDateOriginal(dllmAttributes);


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

            String book_ID=dllmAttributes.getDocuments_id();
            String page_ID="484597";

            String MANIFEST_URI = SERVER + MANIFEST_COLLECTION + book_ID +page_ID  + "/manifest";
            String MANIFEST_THUMBNAIL_URI = SERVER + MANIFEST_COLLECTION + book_ID+"+"+ page_ID+   THUMBNAIL_PATH;

            ImageService3 manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ book_ID+"+"+ page_ID);
            //manifest.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));

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
                String first_pages_id="";
                String pages_document_id="";
                int number_of_pages = pages.length();

                if (pagesObj.has("pages_position"))
                    pages_position = (String) pagesObj.get("pages_position").toString();

                if (pagesObj.has("pages_image_file"))
                    pages_image_file = (String) pagesObj.get("pages_image_file").toString();

                if (pagesObj.has("pages_id")) {
                    pages_id = (String) pagesObj.get("pages_id").toString();
                    //first_pages_id = pagesObj.get("pages_id").toString();
                    first_pages_id = dllmAttributes.getDocuments_id();
                }

                if (pagesObj.has("pages_document_id"))
                    pages_document_id = (String) pagesObj.get("pages_document_id").toString();

                JSONObject json = readJsonFromUrl("https://iiif-content.crossasia.org/xasia/dllm"+"+dllm_000"+pages_document_id+"+"+pages_id+"/info.json");

                manifestID = SERVER + MANIFEST_COLLECTION + "000" + pages_document_id +"+"+ pages_id;
                canvasID = manifestID +"/canvas";
                imageID = manifestID+"/full/full/0/default.jpg";
                annoID = manifestID+"/annotation";
                annoPageID = manifestID;

                int weight = (int) json.get("width");
                int height = (int) json.get("height");
                canvas = new Canvas(canvasID).setWidthHeight(weight, height);

                System.out.println(file.getName());

                imageContent = new ImageContent(imageID).setWidthHeight((Integer) json.get("width"), (Integer) json.get("height"));
                annoPage = new AnnotationPage<>(annoPageID);
                anno = new PaintingAnnotation(annoID, canvas);
                annoPage.addAnnotations(anno.setBody(imageContent).setTarget(canvasID));
                canvases.add(canvas.setPaintingPages(annoPage));
                //manifest.setCanvases(canvas.setPaintingPages(annoPage));
                manifest.setCanvases(canvases);

                MANIFEST_URI = SERVER + MANIFEST_COLLECTION + book_ID +pages_id  + "/manifest";
                MANIFEST_THUMBNAIL_URI = SERVER + MANIFEST_COLLECTION + book_ID+"+"+ pages_id+   THUMBNAIL_PATH;

                manifestThumbService = new ImageService3(ImageService3.Profile.LEVEL_TWO, SERVER + MANIFEST_COLLECTION+ book_ID+"+"+ pages_id);
                manifest.setThumbnails(new ImageContent(MANIFEST_THUMBNAIL_URI).setServices(manifestThumbService));
                manifest.setStart(new Start("https://iiif-content.crossasia.org/xasia/dllm/dllm_000"+book_ID+"+"+pages_id + "/canvas/"+pages_id));

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

    @NotNull
    private static Metadata getMetadataDateOriginal(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "date_original")),
                new Value(new I18n("en",dllmAttributes.getDate_original()),
                        new I18n("lo", dllmAttributes.getDate_original_lao())));
    }

    @NotNull
    private static Metadata getMetadataDate(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "dc:date")),
                new Value(new I18n("en", String.valueOf(dllmAttributes.getDocuments_date_written()))));
    }

    @NotNull
    private static Metadata getMetadataConditions(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "conditions")),
                new Value(new I18n("en",dllmAttributes.getConditions_name()),
                        new I18n("lo", dllmAttributes.getConditions_name_lao())));
    }

    @NotNull
    private static Metadata getMetadataLegibilities(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "legibilities")),
                new Value(new I18n("en",dllmAttributes.getLegibilities_name()),
                        new I18n("lo", dllmAttributes.getLegibilities_name_lao())));
    }

    @NotNull
    private static Metadata getMetadataIndex(DllmAttributes dllmAttributes) {

        ArrayList<String> indexRomanArrayList = new ArrayList<>();
        ArrayList<String> indexThaiArrayList = new ArrayList<>();
        Metadata metadata_index = new Metadata(new Label("en",""), new Value("en",""));

        if (dllmAttributes.getTitle_search_roman()!=null) {

            for (int i = 0; i < dllmAttributes.getTitle_search_roman().length(); i++) {
                indexRomanArrayList.add(dllmAttributes.getTitle_search_roman().get(i).toString());
                indexThaiArrayList.add(dllmAttributes.getTitle_search_lao().get(i).toString());
                indexThaiArrayList.add(dllmAttributes.getPlmp_title_lao().get(i).toString());
                I18n i18n_index_Roman = new I18n("en", indexRomanArrayList);
                I18n i18n_index__Thai = new I18n("lo", indexThaiArrayList);
                metadata_index = new Metadata(new Label("en", "index"),
                        new Value(new I18n[]{i18n_index_Roman, i18n_index__Thai}));
            }
        }

        return metadata_index;
    }

    @NotNull
    private static Metadata getMetadataScript(DllmAttributes dllmAttributes) {

        ArrayList<String> scriptRomanArrayList = new ArrayList<>();
        ArrayList<String> scriptThaiArrayList = new ArrayList<>();
        Metadata metadata_script = new Metadata(new Label("en",""), new Value("en",""));

        if (dllmAttributes.getScripts()!=null) {

            for (int i = 0; i < dllmAttributes.getScripts().length(); i++) {
                scriptRomanArrayList.add(dllmAttributes.getScripts().get(i).toString());
                scriptThaiArrayList.add(dllmAttributes.getScripts_lao().get(i).toString());
                I18n i18n_script_Roman = new I18n("en", scriptRomanArrayList);
                I18n i18n_script_Thai = new I18n("lo", scriptThaiArrayList);
                metadata_script = new Metadata(new Label("en", "dc:subject"),
                        new Value(new I18n[]{i18n_script_Roman, i18n_script_Thai}));
            }
        }

        return metadata_script;
    }


    @NotNull
    private static Metadata getMetadataCategories(DllmAttributes dllmAttributes) {

        ArrayList<String> categoriesRomanArrayList = new ArrayList<>();
        ArrayList<String> categoriesThaiArrayList = new ArrayList<>();
        Metadata metadata_categories = new Metadata(new Label("en",""), new Value("en",""));

        if (dllmAttributes.getAncillary_terms_roman()!=null) {

            for (int i = 0; i < dllmAttributes.getAncillary_terms_roman().length(); i++) {
                categoriesRomanArrayList.add(dllmAttributes.getCategories_name().get(i).toString());
                categoriesThaiArrayList.add(dllmAttributes.getCategories_name_lao().get(i).toString());
                I18n i18n_categories_Roman = new I18n("en", categoriesRomanArrayList);
                I18n i18n_categories_Thai = new I18n("lo", categoriesThaiArrayList);
                metadata_categories = new Metadata(new Label("en", "dc:subject"),
                        new Value(new I18n[]{i18n_categories_Roman, i18n_categories_Thai}));
            }
        }

        return metadata_categories;
    }

    @NotNull
    private static Metadata getMetadataKeywords(DllmAttributes dllmAttributes) {

        ArrayList<String> keywordsRomanArrayList = new ArrayList<>();
        ArrayList<String> keywordsThaiArrayList = new ArrayList<>();
        Metadata metadata_keywords = new Metadata(new Label("en",""), new Value("en",""));

        if (dllmAttributes.getAncillary_terms_roman()!=null) {

            for (int i = 0; i < dllmAttributes.getAncillary_terms_roman().length(); i++) {
                keywordsRomanArrayList.add(dllmAttributes.getAncillary_terms_roman().get(i).toString());
                keywordsThaiArrayList.add(dllmAttributes.getAncillary_terms_lao().get(i).toString());
                I18n i18n_keywords_Roman = new I18n("en", keywordsRomanArrayList);
                I18n i18n_keywords_Thai = new I18n("lo", keywordsThaiArrayList);
                metadata_keywords = new Metadata(new Label("en", "schema:keywords"),
                        new Value(new I18n[]{i18n_keywords_Roman, i18n_keywords_Thai}));
            }
        }

        return metadata_keywords;
    }

    @NotNull
    private static Metadata getMetadataLatitude(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "schema:latitude")),
                new Value(new I18n("en", String.valueOf(dllmAttributes.getLocations_gps_lat()))));
    }

    @NotNull
    private static Metadata getMetadataLongitude(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "schema:longitude")),
                new Value(new I18n("en", String.valueOf(dllmAttributes.getLocations_gps_lon()))));
    }

    @NotNull
    private static Metadata getMetadataLocationTypesName(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "location_type")),
                new Value(new I18n("en",dllmAttributes.getLocation_types_name()),
                        new I18n("lo", dllmAttributes.getLocation_types_name_lao())));
    }

    @NotNull
    private static Metadata getMetadataMaterial(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "material")),
                new Value(new I18n("en",dllmAttributes.getMaterials_name()),
                        new I18n("lo", dllmAttributes.getMaterials_name_lao())));
    }

    @NotNull
    private static Metadata getMetadataPagesCount(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "pages_count")),
                new Value(new I18n("en", String.valueOf(dllmAttributes.getDocuments_pages_count()))));
    }

    @NotNull
    private static Metadata getMetadataIsComplete(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "is_complete")),
                new Value(new I18n("en",dllmAttributes.getDocuments_is_complete())));
    }

    @NotNull
    private static Metadata getMetadataBundleID(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "otherIdentifier.bundle_id")),
                new Value(new I18n("en",dllmAttributes.getDocuments_bundle_id())));
    }

    @NotNull
    private static Metadata getMetadataDocumentsRoll(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "otherIdentifier.roll")),
                new Value(new I18n("en",dllmAttributes.getDocuments_roll())));
    }

    @NotNull
    private static Metadata getMetadataIsColor(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "is_color")),
                new Value(new I18n("en",dllmAttributes.getDocuments_is_color())));
    }

    @NotNull
    private static Metadata getMetadataDocumentsID(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "dc:identifier")),
                        new Value(new I18n("en",dllmAttributes.getDocuments_id())));
    }

    @NotNull
    private static Metadata getMetadataDocumentsCodeNumber(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "otherIdentifier.code_number")),
        new Value(new I18n("en",dllmAttributes.getDocuments_code_number())));
    }

    @NotNull
    private static Metadata getMetadataExtentMethod(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "dc:extent")),
                new Value(new I18n("en",dllmAttributes.getExtent())));
    }

    @NotNull
    private static Metadata getMetadataHasColophon(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "has_colophon")),
                new Value(new I18n("en",dllmAttributes.getDocuments_has_colophon())));
    }

    @NotNull
    private static Metadata getMetadataIsIllustrated(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "is_illustrated")),
                new Value(new I18n("en",dllmAttributes.getDocuments_is_illustrated())));
    }

    @NotNull
    private static Metadata getMetadataDescription(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "dc:description")),
                new Value(new I18n("en",dllmAttributes.getDescription())));
    }

    @NotNull
    private static Metadata getMetadataDllmOriginal(DllmAttributes dllmAttributes) {
        ArrayList<String> dllmArrayList = new ArrayList<>();

        dllmArrayList.add("documents_id : " + dllmAttributes.getDocuments_id());
        dllmArrayList.add("documents_code_number : " +dllmAttributes.getDocuments_code_number());
        dllmArrayList.add("documents_roll : " +dllmAttributes.getDocuments_roll());
        dllmArrayList.add("documents_number_of_fascicles : " +String.valueOf(dllmAttributes.getDocuments_number_of_fascicles()));
        dllmArrayList.add("documents_number_of_folios : " +String.valueOf(dllmAttributes.getDocuments_number_of_folios()));
        dllmArrayList.add("locations_is_top_level : " +String.valueOf(dllmAttributes.getLocations_is_top_level()));
        dllmArrayList.add("locations_parent_parent_id : " +String.valueOf(dllmAttributes.getLocations_parent_parent_id()));
        dllmArrayList.add("full_location_name : " +dllmAttributes.getFull_location_name());
        dllmArrayList.add("full_location_name_lao : " +dllmAttributes.getFull_location_name_lao());
        dllmArrayList.add("documents_has_colophon : " +dllmAttributes.getDocuments_has_colophon());
        dllmArrayList.add("documents_is_illustrated : " +dllmAttributes.getDocuments_is_illustrated());
        dllmArrayList.add("documents_is_color : " +dllmAttributes.getDocuments_is_color());

        dllmArrayList.add("documents_bundle_id : " +dllmAttributes.getDocuments_bundle_id());
        dllmArrayList.add("locations_id : " +String.valueOf(dllmAttributes.getLocations_id()));
        dllmArrayList.add("locations_parent_id : " +String.valueOf(dllmAttributes.getLocations_parent_id()));
        dllmArrayList.add("documents_position_in_bundle : "+String.valueOf(dllmAttributes.getDocuments_position_in_bundle()));
        dllmArrayList.add("documents_is_complete : " +dllmAttributes.getDocuments_is_complete());
        dllmArrayList.add("documents_pages_count : " +String.valueOf(dllmAttributes.getDocuments_pages_count()));

        dllmArrayList.add("materials_name : " +dllmAttributes.getMaterials_name());
        dllmArrayList.add("materials_name_lao : " +dllmAttributes.getMaterials_name_lao());

        dllmArrayList.add("location_types_name : " +dllmAttributes.getLocation_types_name());
        dllmArrayList.add("location_types_name_lao : " +dllmAttributes.getLocation_types_name_lao());
        dllmArrayList.add("locations_rgt : " +String.valueOf(dllmAttributes.getLocations_rgt()));
        dllmArrayList.add("locations_lft : " +String.valueOf(dllmAttributes.getLocations_lft()));
        dllmArrayList.add("locations_dllm_loc_code : " +String.valueOf(dllmAttributes.getLocations_dllm_loc_code()));
        dllmArrayList.add("locations_gps_lat : " +String.valueOf(dllmAttributes.getLocations_gps_lat()));
        dllmArrayList.add("locations_gps_lon : " +String.valueOf(dllmAttributes.getLocations_gps_lon()));

        if (dllmAttributes.getAncillary_terms_roman()!= null)
            dllmArrayList.add("ancillary_terms_roman : " +String.valueOf(dllmAttributes.getAncillary_terms_roman())); //ARRAY

        if (dllmAttributes.getAncillary_terms_lao()!= null)
            dllmArrayList.add("ancillary_terms_lao : " +String.valueOf(dllmAttributes.getAncillary_terms_lao())); //ARRAY

        if (dllmAttributes.getPublic_remarks_english()!= null)
            dllmArrayList.add("public_remarks_english : " +String.valueOf(dllmAttributes.getPublic_remarks_english()));  //ARRAY

        if (dllmAttributes.getPublic_remarks_lao()!= null)
            dllmArrayList.add("public_remarks_lao : " +String.valueOf(dllmAttributes.getPublic_remarks_lao()));  //ARRAY

        if (dllmAttributes.getPublic_remarks_lao()!= null)
            dllmArrayList.add("categories_name : " +String.valueOf(dllmAttributes.getPublic_remarks_lao())); //ARRAY

        if (dllmAttributes.getCategories_name_lao()!= null)
            dllmArrayList.add("categories_name_lao : " +String.valueOf(dllmAttributes.getCategories_name_lao())); //ARRAY

        if (dllmAttributes.getLanguages()!= null)
            dllmArrayList.add("languages : " +String.valueOf(dllmAttributes.getLanguages())); //ARRAY

        if (dllmAttributes.getLanguages_lao()!= null)
            dllmArrayList.add("languages_lao : " +String.valueOf(dllmAttributes.getLanguages_lao())); //ARRAY

        if (dllmAttributes.getScripts()!= null)
            dllmArrayList.add("scripts : " +String.valueOf(dllmAttributes.getScripts())); //ARRAY

        if (dllmAttributes.getScripts_lao()!= null)
            dllmArrayList.add("scripts_lao : " +String.valueOf(dllmAttributes.getScripts_lao())); //ARRAY

        if (dllmAttributes.getTitle_search_roman()!= null)
            dllmArrayList.add("title_search_roman : " +String.valueOf(dllmAttributes.getTitle_search_roman())); //ARRAY

        if (dllmAttributes.getTitle_search_lao()!= null)
            dllmArrayList.add("title_search_lao : " +String.valueOf(dllmAttributes.getTitle_search_lao())); //ARRAY

        if (dllmAttributes.getDllm_title_roman()!= null)
            dllmArrayList.add("dllm_title_roman : " +String.valueOf(dllmAttributes.getDllm_title_roman())); //ARRAY

        if (dllmAttributes.getDllm_title_lao()!= null)
            dllmArrayList.add("dllm_title_lao : " +String.valueOf(dllmAttributes.getDllm_title_lao())); //ARRAY

        if (dllmAttributes.getPlmp_title_lao()!= null)
            dllmArrayList.add("plmp_title_lao : " +String.valueOf(dllmAttributes.getPlmp_title_lao())); //ARRAY

        dllmArrayList.add("location_documents_count : " +String.valueOf(dllmAttributes.getLocation_documents_count()));
        dllmArrayList.add("legibilities_name : " +dllmAttributes.getLegibilities_name());
        dllmArrayList.add("legibilities_name_lao : " +dllmAttributes.getLegibilities_name_lao());
        dllmArrayList.add("conditions_name : " +dllmAttributes.getConditions_name());
        dllmArrayList.add("conditions_name_lao : " +dllmAttributes.getConditions_name_lao());
        dllmArrayList.add("documents_preferred_date_system : " +dllmAttributes.getDocuments_preferred_date_system());
        dllmArrayList.add("documents_preferred_date_system_lao : " +dllmAttributes.getDocuments_preferred_date_system_lao());

        if (dllmAttributes.getDocuments_date_written()!= null)
            dllmArrayList.add("documents_date_written : " +dllmAttributes.getDocuments_date_written());

        Iterator<String> iterDllm_original = dllmArrayList.iterator();

        while (iterDllm_original.hasNext()) {
            String md = iterDllm_original.next();
            if (md==null)
                iterDllm_original.remove();
        }

        I18n dllm_org = new I18n("en", dllmArrayList);

        return new Metadata(new Label(new I18n("en", "dllm_original")),
                new Value(new I18n []{ dllm_org }));
    }

    @NotNull
    private static Metadata getMetadataFullLocationName(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "full_location_name")),
                new Value(new I18n("en",dllmAttributes.getFull_location_name()),
                        new I18n("lo", dllmAttributes.getFull_location_name_lao())));
    }

    @NotNull
    private static Metadata getMetadataPlaces(DllmAttributes dllmAttributes) {
        ArrayList<String> placesArrayList = new ArrayList<>();
        ArrayList<String> placesArrayListLao = new ArrayList<>();
        placesArrayList.add(dllmAttributes.getLocations_parent_parent_name());
        placesArrayList.add(dllmAttributes.getLocations_parent_name());
        placesArrayListLao.add(dllmAttributes.getLocations_parent_parent_name_lao());
        placesArrayListLao.add(dllmAttributes.getLocations_parent_name_lao());

        I18n places_roman = new I18n("en", placesArrayList);
        I18n places_lao = new I18n("lo", placesArrayListLao);

        return new Metadata(new Label(new I18n("en", "dc:place")),
                new Value(new I18n [] {places_roman, places_lao}));
    }

    private static Metadata getMetadataTitlesRomanThai(DllmAttributes dllmAttributes, Manifest manifest) {
        if (dllmAttributes.getDllm_title_roman()!=null) {
            Metadata  metadata_title = getMetadataTitleRomanThai(dllmAttributes);
            manifest.setMetadata(metadata_title);
            return metadata_title;
        }
        return null;
    }

    private static Metadata getMetadataTitleRomanThai(DllmAttributes dllmAttributes) {
        Metadata metadata_title = new Metadata(new Label("en", ""), new Value("en", ""));
        if (dllmAttributes.getDllm_title_roman()!=null || dllmAttributes.getDllm_title_lao()!=null) {
            ArrayList<String> titleRomanArrayList = new ArrayList<>();
            ArrayList<String> titleThaiArrayList = new ArrayList<>();

            for (int i = 0; i < dllmAttributes.getDllm_title_roman().length(); i++) {
                titleRomanArrayList.add(dllmAttributes.getDllm_title_roman().get(i).toString());
                titleThaiArrayList.add(dllmAttributes.getDllm_title_lao().get(i).toString());
                I18n i18n_title_Roman = new I18n("en", titleRomanArrayList);
                I18n i18n_title_Thai = new I18n("lo", titleThaiArrayList);
                metadata_title = new Metadata(new Label("en", "title"),
                        new Value(new I18n[]{i18n_title_Roman, i18n_title_Thai}));
            }
            return metadata_title;
        } else
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
            metadata_language = new Metadata(new Label("en","dc:language") ,
                    new Value(new I18n []{i18n_language_Roman, i18n_language_Thai}));
        }
        return metadata_language;
    }

    private static I18n getStringsLabel(DllmAttributes dllmAttributes) {
        ArrayList<String> titlesArrayList = new ArrayList<>();
        I18n i18n_title_Roman = new I18n("en", "");
        if (dllmAttributes.getDllm_title_roman()!=null) {
            for (int i = 0; i < dllmAttributes.getDllm_title_roman().length(); i++) {
                titlesArrayList.add(dllmAttributes.getDllm_title_roman().get(i).toString());
                i18n_title_Roman = new I18n("en", titlesArrayList);
            }
            return i18n_title_Roman;
        } else
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
}
