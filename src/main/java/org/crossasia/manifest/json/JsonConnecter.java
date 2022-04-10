package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.CollectionAttributes;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonConnecter {

    public static void documentsID (CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_id")) {
            dllmAttributes.setDocuments_id((String) jsonObj.get("documents_id").toString());
        }
        if (jsonObj.has("id")) {
            dllmAttributes.setDocuments_id((String) jsonObj.get("id").toString());
        }
    }

    public static void languageRoman(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("languages")) {
            dllmAttributes.setLanguages((JSONArray) jsonObj.get("languages"));
        }
    }

    public static void documentsCodeNumber(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_code_number")) {
            dllmAttributes.setDocuments_code_number((String) jsonObj.get("documents_code_number"));
        }

        if (jsonObj.has("code_number")) {
            dllmAttributes.setCode_number((String) jsonObj.get("code_number"));
        }
    }

    public static void documentsRoll(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_roll")) {
            dllmAttributes.setDocuments_roll((String) jsonObj.get("documents_roll"));
        }
    }

    public static void year(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("document_years")) {
            dllmAttributes.setYear((int) jsonObj.get("document_years"));
        }
    }

    public static void ceYear(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("ce_year")) {
            dllmAttributes.setCe_year((int) jsonObj.get("ce_year"));
        }
    }

    public static void documentsExtent(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:extent")) {
            dllmAttributes.setExtent((String) jsonObj.get("dc:extent"));
        }
    }

    public static void documentsPosition(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("position")) {
            dllmAttributes.setPosition((int) jsonObj.get("position"));
        }
    }

    public static void documentsNumberOfFascicles(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_number_of_fascicles")) {
            dllmAttributes.setDocuments_number_of_fascicles((int) jsonObj.get("documents_number_of_fascicles"));
        }
    }

    public static void documentsNumberOfFolios(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_number_of_folios")) {
            dllmAttributes.setDocuments_number_of_folios((int) jsonObj.get("documents_number_of_folios"));
        }
    }

    public static void locationsIsTopLevel(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_is_top_level")) {
            dllmAttributes.setLocations_is_top_level((int) jsonObj.get("locations_is_top_level"));
        }
    }

    public static void locationsParentParentID(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_parent_parent_id")) {
            dllmAttributes.setLocations_parent_parent_id((int) jsonObj.get("locations_parent_parent_id"));
        }
    }

    public static void locationsParentName(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_parent_name")) {
            if (jsonObj.get("locations_parent_name") instanceof String)
                dllmAttributes.setLocations_parent_name((String) jsonObj.get("locations_parent_name"));
            else
                dllmAttributes.setDistrict_ro((JSONArray) jsonObj.get("locations_parent_name"));
        }
    }

    public static void locationsParentNameLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_parent_name_lao")) {
            if (jsonObj.get("locations_parent_name_lao") instanceof String)
                dllmAttributes.setLocations_parent_name_lao((String) jsonObj.get("locations_parent_name_lao"));
            else
                dllmAttributes.setDistrict_th((JSONArray) jsonObj.get("locations_parent_name_lao"));
        }
    }

    public static void locationsParentParentName(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_parent_parent_name")) {
            if (jsonObj.get("locations_parent_parent_name") instanceof String)
                dllmAttributes.setLocations_parent_parent_name((String) jsonObj.get("locations_parent_parent_name"));
            else
                dllmAttributes.setProvince_ro((JSONArray) jsonObj.get("locations_parent_parent_name"));
        }
    }


    public static void locationsParentParentNameLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_parent_parent_name_lao")) {
            if (jsonObj.get("locations_parent_parent_name_lao") instanceof String)
                dllmAttributes.setLocations_parent_parent_name_lao((String) jsonObj.get("locations_parent_parent_name_lao"));
            else
                dllmAttributes.setProvince_th((JSONArray) jsonObj.get("locations_parent_parent_name_lao"));
        }
    }


    public static void fullLocationName(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("full_location_name")) {
            dllmAttributes.setFull_location_name((String) jsonObj.get("full_location_name"));
        }
    }

    public static void fullLocationNameLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("full_location_name_lao")) {
            dllmAttributes.setFull_location_name_lao((String) jsonObj.get("full_location_name_lao"));
        }
    }

    public static void addressRo(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("address_ro")) {
            dllmAttributes.setAddress_ro((JSONArray) jsonObj.get("address_ro"));
        }
    }

    public static void addressTh(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("address_th")) {
            dllmAttributes.setAddress_th((JSONArray) jsonObj.get("address_th"));
        }
    }

    public static void districtRo(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("district_ro")) {
            dllmAttributes.setDistrict_ro((JSONArray) jsonObj.get("district_ro"));
        }
    }

    public static void districtTh(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("district_th")) {
            dllmAttributes.setDistrict_th((JSONArray) jsonObj.get("district_th"));
        }
    }

    public static void provinceRo(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("province_ro")) {
            dllmAttributes.setProvince_ro((JSONArray) jsonObj.get("province_ro"));
        }
    }

    public static void provinceTh(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("province_th")) {
            dllmAttributes.setProvince_th((JSONArray) jsonObj.get("province_th"));
        }
    }

    public static void subjectTh(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("subject_th")) {
            dllmAttributes.setSubject_th((String) jsonObj.get("subject_th"));
        }
    }

    public static void subjectRo(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("subject_en")) {
            dllmAttributes.setSubject_ro((String) jsonObj.get("subject_en"));
        }
    }

    public static void locationName(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("location_name")) {
            if (jsonObj.get("location_name") instanceof String)
                dllmAttributes.setLocation_name((String) jsonObj.get("location_name"));
            else
                dllmAttributes.setAddress_ro((JSONArray) jsonObj.get("location_name"));
        }
    }

    public static void locationNameLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("location_name_lao")) {
            if (jsonObj.get("location_name_lao") instanceof String)
                dllmAttributes.setLocation_name_lao((String) jsonObj.get("location_name_lao"));
            else
                dllmAttributes.setAddress_th((JSONArray) jsonObj.get("location_name_lao"));
        }
    }

    public static void titleRoman(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dllm_title_roman")) {
            dllmAttributes.setDllm_title_roman((JSONArray) jsonObj.get("dllm_title_roman"));
        }
    }

    public static void titleThai(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dllm_title_lao")) {
            dllmAttributes.setDllm_title_lao((JSONArray) jsonObj.get("dllm_title_lao"));
        }
    }

    public static void languageThai(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("languages_lao")) {
            dllmAttributes.setLanguages_lao((JSONArray) jsonObj.get("languages_lao"));
        }
    }

    public static void documentsHasColophon(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_has_colophon")) {
            if (jsonObj.get("documents_has_colophon") instanceof String)
                dllmAttributes.setDocuments_has_colophon((String) jsonObj.get("documents_has_colophon"));
            else
                dllmAttributes.setHas_colophon((boolean) jsonObj.get("documents_has_colophon"));
        }
    }

    public static void documentsIsIllustrated(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_is_illustrated")) {
            if (jsonObj.get("documents_is_illustrated") instanceof String)
                dllmAttributes.setDocuments_is_illustrated((String) jsonObj.get("documents_is_illustrated"));
            else
                dllmAttributes.setIllustrated((boolean) jsonObj.get("documents_is_illustrated"));
        }
    }

    public static void documentsIsColor(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_is_color")) {
            dllmAttributes.setDocuments_is_color((String) jsonObj.get("documents_is_color"));
        }
    }

    public static void documentsInCollection(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("collection")) {
            dllmAttributes.setIn_collection((String) jsonObj.get("collection"));
        }
    }

    public static void documentsInPrivateCollection(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("in_private_collection")) {
            dllmAttributes.setIn_private_collection((boolean) jsonObj.get("in_private_collection"));
        }
    }

    public static void documentsBundleID(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_bundle_id")) {
            dllmAttributes.setDocuments_bundle_id((String) jsonObj.get("documents_bundle_id"));
        }
    }

    public static void locationsID(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_id")) {
            dllmAttributes.setLocations_id((int) jsonObj.get("locations_id"));
        }
    }

    public static void locationsParentID(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_parent_id")) {
            dllmAttributes.setLocations_parent_id((int) jsonObj.get("locations_parent_id"));
        }
    }

    public static void documentsPositionInBundle(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_position_in_bundle")) {
            dllmAttributes.setDocuments_position_in_bundle((int) jsonObj.get("documents_position_in_bundle"));
        }
    }

    public static void documentsIsComplete(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_is_complete")) {
            dllmAttributes.setDocuments_is_complete((String) jsonObj.get("documents_is_complete"));
        }
    }

    public static void documentsPagesCount(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_pages_count")) {
            dllmAttributes.setDocuments_pages_count((int) jsonObj.get("documents_pages_count"));
        }
    }

    public static void description(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("description")) {
            dllmAttributes.setDescription((String) jsonObj.get("description"));
        }
    }


    public static void materialsName(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("materials_name")) {
            if (jsonObj.get("materials_name") instanceof String)
                dllmAttributes.setMaterials_name((String) jsonObj.get("materials_name"));
            else
                dllmAttributes.setMaterial((JSONArray) jsonObj.get("materials_name"));
        }
    }

    public static void materialsNameLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("materials_name_lao")) {
            if (jsonObj.get("materials_name_lao") instanceof String)
                dllmAttributes.setMaterials_name_lao((String) jsonObj.get("materials_name_lao"));
            else
                dllmAttributes.setMaterial_th((JSONArray) jsonObj.get("materials_name_lao"));
        }
    }

    public static void locationTypesName(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("location_types_name")) {
            dllmAttributes.setLocation_types_name((String) jsonObj.get("location_types_name"));
        }
    }

    public static void exact(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("exact")) {
            dllmAttributes.setExact((boolean) jsonObj.get("exact"));
        }
    }

    public static void locationTypesNameLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("location_types_name_lao")) {
            dllmAttributes.setLocation_types_name_lao((String) jsonObj.get("location_types_name_lao"));
        }
    }

    public static void microfilmRollNumber(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("microfilm_roll_number")) {
            dllmAttributes.setMicrofilm_roll_number((String) jsonObj.get("microfilm_roll_number"));
        }
    }

    public static void numberOfDigitalImages(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("number_of_digital_images")) {
            dllmAttributes.setNumber_of_digital_images((int) jsonObj.get("number_of_digital_images"));
        }
    }

    public static void locationsLft(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_lft")) {
            dllmAttributes.setLocations_lft((int) jsonObj.get("locations_lft"));
        }
    }

    public static void locationsRgt(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_rgt")) {
            dllmAttributes.setLocations_rgt((int) jsonObj.get("locations_rgt"));
        }
    }

    public static void locationsDllmLocCode(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_dllm_loc_code")) {
            dllmAttributes.setLocations_dllm_loc_code((int) jsonObj.get("locations_dllm_loc_code"));
        }
    }

    public static void locationsGpsLat(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_gps_lat")) {
            dllmAttributes.setLocations_gps_lat((double) jsonObj.get("locations_gps_lat"));
        }
        if (jsonObj.has("latitude")){
            dllmAttributes.setLatitude((JSONArray) jsonObj.get("latitude"));
        }
    }

    public static void locationsGpsLon(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_gps_lon")) {
            dllmAttributes.setLocations_gps_lon((double) jsonObj.get("locations_gps_lon"));
        }
        if (jsonObj.has("longitude")) {
            dllmAttributes.setLongitude((JSONArray) jsonObj.get("longitude"));
        }
    }

    public static void ancillaryTermsRoman(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("ancillary_terms_roman")) {
            dllmAttributes.setAncillary_terms_roman((JSONArray) jsonObj.get("ancillary_terms_roman"));
        }
    }

    public static void ancillaryTermsLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("ancillary_terms_lao")) {
            dllmAttributes.setAncillary_terms_lao((JSONArray) jsonObj.get("ancillary_terms_lao"));
        }
    }

    public static void image(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("image")) {
            dllmAttributes.setImage((String) jsonObj.get("image"));
        }
    }

    public static void publicRemarksEnglish(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("public_remarks_english")) {
            if (jsonObj.get("public_remarks_english") instanceof String)
                dllmAttributes.setPublic_remarks_english((String) jsonObj.get("public_remarks_english"));
        }
    }

    public static void publicRemarksLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("public_remarks_lao")) {
            if (jsonObj.get("public_remarks_lao") instanceof String)
                dllmAttributes.setPublic_remarks_lao((String) jsonObj.get("public_remarks_lao"));
            else
                dllmAttributes.setPublic_remarks_lao((JSONArray) jsonObj.get("public_remarks_lao"));
        }
    }

    public static void categoriesName(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("categories_name")) {
            dllmAttributes.setCategories_name((JSONArray) jsonObj.get("categories_name"));
        }
    }

    public static void categoriesNameLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("categories_name_lao")) {
            dllmAttributes.setCategories_name_lao((JSONArray) jsonObj.get("categories_name_lao"));
        }
    }

    public static void languages(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("languages")) {
            dllmAttributes.setLanguages((JSONArray) jsonObj.get("languages"));
        }
    }

    public static void languagesLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("languages_lao")) {
            dllmAttributes.setLanguages_lao((JSONArray) jsonObj.get("languages_lao"));
        }
    }

    public static void scripts(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("scripts")) {
            dllmAttributes.setScripts((JSONArray) jsonObj.get("scripts"));
        }
    }

    public static void scriptsLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("scripts_lao")) {
            dllmAttributes.setScripts_lao((JSONArray) jsonObj.get("scripts_lao"));
        }
    }

    public static void titleSearchRoman(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("title_search_roman")) {
            dllmAttributes.setTitle_search_roman((JSONArray) jsonObj.get("title_search_roman"));
        }
    }

    public static void titleSearchLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("title_search_lao")) {
            dllmAttributes.setTitle_search_lao((JSONArray) jsonObj.get("title_search_lao"));
        }
    }

    public static void dllmTitleRoman(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dllm_title_roman")) {
            dllmAttributes.setDllm_title_roman((JSONArray) jsonObj.get("dllm_title_roman"));
        }
    }

    public static void dllmTitleLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dllm_title_lao")) {
            dllmAttributes.setDllm_title_lao((JSONArray) jsonObj.get("dllm_title_lao"));
        }
    }

    public static void plmpTitleLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("plmp_title_lao")) {
            dllmAttributes.setPlmp_title_lao((JSONArray) jsonObj.get("plmp_title_lao"));
        }
    }

    public static void locationDocumentsCount(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("location_documents_count")) {
            dllmAttributes.setLocation_documents_count((int) jsonObj.get("location_documents_count"));
        }
    }

    public static void legibilitiesName(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("legibilities_name")) {
            dllmAttributes.setLegibilities_name((String) jsonObj.get("legibilities_name"));
        }
    }

    public static void legibilitiesNameLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("legibilities_name_lao")) {
            dllmAttributes.setLegibilities_name_lao((String) jsonObj.get("legibilities_name_lao"));
        }
    }

    public static void conditionsName(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("conditions_name")) {
            dllmAttributes.setConditions_name((String) jsonObj.get("conditions_name"));
        }
    }

    public static void conditionsNameLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("conditions_name_lao")) {
            dllmAttributes.setConditions_name_lao((String) jsonObj.get("conditions_name_lao"));
        }
    }

    public static void documentsPreferredDateSystem(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_preferred_date_system")) {
            dllmAttributes.setDocuments_preferred_date_system((String) jsonObj.get("documents_preferred_date_system"));
        }
    }

    public static void documentsPreferredDateSystemLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_preferred_date_system_lao")) {
            dllmAttributes.setDocuments_preferred_date_system_lao((String) jsonObj.get("documents_preferred_date_system_lao"));
        }
    }


    public static void documentsDateWritten(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_date_written")) {
            dllmAttributes.setDocuments_date_written((String) jsonObj.get("documents_date_written"));
        }
    }

    public static void dateOriginal(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("date_original")) {
            dllmAttributes.setDate_original((String) jsonObj.get("date_original"));
        }
    }

    public static void dateOriginalLao(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("date_original_lao")) {
            dllmAttributes.setDate_original_lao((String) jsonObj.get("date_original_lao"));
        }
    }

    public static void alternativeRoman(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("alternative_label_ro")) {
            dllmAttributes.setAlternative_label_ro((JSONArray) jsonObj.get("alternative_label_ro"));
        }
    }

    public static void alternativeThai(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("alternative_label_th")) {
            dllmAttributes.setAlternative_label_th((JSONArray) jsonObj.get("alternative_label_th"));
        }
    }

    public static void website(CollectionAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("website")) {
            dllmAttributes.setWebsite((JSONArray) jsonObj.get("website"));
        }
    }
}
