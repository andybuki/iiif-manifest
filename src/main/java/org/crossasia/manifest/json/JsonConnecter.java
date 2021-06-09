package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonConnecter {

    public static void documentsID (DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_id")) {
            dllmAttributes.setDocuments_id((String) jsonObj.get("documents_id"));
        }
    }

    public static void languageRoman(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("languages")) {
            dllmAttributes.setLanguages((JSONArray) jsonObj.get("languages"));
        }
    }

    public static void documentsCodeNumber(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_code_number")) {
            dllmAttributes.setDocuments_code_number((String) jsonObj.get("documents_code_number"));
        }
    }

    public static void documentsRoll(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_roll")) {
            dllmAttributes.setDocuments_roll((String) jsonObj.get("documents_roll"));
        }
    }

    public static void documentsExtent(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:extent")) {
            dllmAttributes.setExtent((String) jsonObj.get("dc:extent"));
        }
    }

    public static void documentsNumberOfFascicles(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_number_of_fascicles")) {
            dllmAttributes.setDocuments_number_of_fascicles((int) jsonObj.get("documents_number_of_fascicles"));
        }
    }

    public static void documentsNumberOfFolios(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_number_of_folios")) {
            dllmAttributes.setDocuments_number_of_folios((int) jsonObj.get("documents_number_of_folios"));
        }
    }

    public static void locationsIsTopLevel(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_is_top_level")) {
            dllmAttributes.setLocations_is_top_level((int) jsonObj.get("locations_is_top_level"));
        }
    }

    public static void locationsParentParentID(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_parent_parent_id")) {
            dllmAttributes.setLocations_parent_parent_id((int) jsonObj.get("locations_parent_parent_id"));
        }
    }

    public static void locationsParentName(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_parent_name")) {
            dllmAttributes.setLocations_parent_name((String) jsonObj.get("locations_parent_name"));
        }
    }

    public static void locationsParentNameLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_parent_name_lao")) {
            dllmAttributes.setLocations_parent_name_lao((String) jsonObj.get("locations_parent_name_lao"));
        }
    }

    public static void locationsParentParentName(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_parent_parent_name")) {
            dllmAttributes.setLocations_parent_parent_name((String) jsonObj.get("locations_parent_parent_name"));
        }
    }

    public static void locationsParentParentNameLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_parent_parent_name_lao")) {
            dllmAttributes.setLocations_parent_parent_name_lao((String) jsonObj.get("locations_parent_parent_name_lao"));
        }
    }

    public static void fullLocationName(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("full_location_name")) {
            dllmAttributes.setFull_location_name((String) jsonObj.get("full_location_name"));
        }
    }

    public static void fullLocationNameLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("full_location_name_lao")) {
            dllmAttributes.setFull_location_name_lao((String) jsonObj.get("full_location_name_lao"));
        }
    }

    public static void titleRoman(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dllm_title_roman")) {
            dllmAttributes.setDllm_title_roman((JSONArray) jsonObj.get("dllm_title_roman"));
        }
    }

    public static void titleThai(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dllm_title_lao")) {
            dllmAttributes.setDllm_title_lao((JSONArray) jsonObj.get("dllm_title_lao"));
        }
    }

    public static void languageThai(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("languages_lao")) {
            dllmAttributes.setLanguages_lao((JSONArray) jsonObj.get("languages_lao"));
        }
    }

    public static void documentsHasColophon(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_has_colophon")) {
            dllmAttributes.setDocuments_has_colophon((String) jsonObj.get("documents_has_colophon"));
        }
    }

    public static void documentsIsIllustrated(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_is_illustrated")) {
            dllmAttributes.setDocuments_is_illustrated((String) jsonObj.get("documents_is_illustrated"));
        }
    }

    public static void documentsIsColor(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_is_color")) {
            dllmAttributes.setDocuments_is_color((String) jsonObj.get("documents_is_color"));
        }
    }



    public static void documentsBundleID(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_bundle_id")) {
            dllmAttributes.setDocuments_bundle_id((String) jsonObj.get("documents_bundle_id"));
        }
    }

    public static void locationsID(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_id")) {
            dllmAttributes.setLocations_id((int) jsonObj.get("locations_id"));
        }
    }

    public static void locationsParentID(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_parent_id")) {
            dllmAttributes.setLocations_parent_id((int) jsonObj.get("locations_parent_id"));
        }
    }

    public static void documentsPositionInBundle(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_position_in_bundle")) {
            dllmAttributes.setDocuments_position_in_bundle((int) jsonObj.get("documents_position_in_bundle"));
        }
    }

    public static void documentsIsComplete(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_is_complete")) {
            dllmAttributes.setDocuments_is_complete((String) jsonObj.get("documents_is_complete"));
        }
    }

    public static void documentsPagesCount(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_pages_count")) {
            dllmAttributes.setDocuments_pages_count((int) jsonObj.get("documents_pages_count"));
        }
    }

    public static void description(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("description")) {
            dllmAttributes.setDescription((String) jsonObj.get("description"));
        }
    }


    public static void materialsName(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("materials_name")) {
            dllmAttributes.setMaterials_name((String) jsonObj.get("materials_name"));
        }
    }

    public static void materialsNameLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("materials_name_lao")) {
            dllmAttributes.setMaterials_name_lao((String) jsonObj.get("materials_name_lao"));
        }
    }

    public static void locationTypesName(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("location_types_name")) {
            dllmAttributes.setLocation_types_name((String) jsonObj.get("location_types_name"));
        }
    }

    public static void locationTypesNameLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("location_types_name_lao")) {
            dllmAttributes.setLocation_types_name_lao((String) jsonObj.get("location_types_name_lao"));
        }
    }

    public static void locationsLft(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_lft")) {
            dllmAttributes.setLocations_lft((int) jsonObj.get("locations_lft"));
        }
    }

    public static void locationsRgt(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_rgt")) {
            dllmAttributes.setLocations_rgt((int) jsonObj.get("locations_rgt"));
        }
    }

    public static void locationsDllmLocCode(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_dllm_loc_code")) {
            dllmAttributes.setLocations_dllm_loc_code((int) jsonObj.get("locations_dllm_loc_code"));
        }
    }

    public static void locationsGpsLat(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_gps_lat")) {
            dllmAttributes.setLocations_gps_lat((double) jsonObj.get("locations_gps_lat"));
        }
    }

    public static void locationsGpsLon(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("locations_gps_lon")) {
            dllmAttributes.setLocations_gps_lon((double) jsonObj.get("locations_gps_lon"));
        }
    }

    public static void ancillaryTermsRoman(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("ancillary_terms_roman")) {
            dllmAttributes.setAncillary_terms_roman((String) jsonObj.get("ancillary_terms_roman"));
        }
    }

    public static void ancillaryTermsLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("ancillary_terms_lao")) {
            dllmAttributes.setAncillary_terms_lao((String) jsonObj.get("ancillary_terms_lao"));
        }
    }

    public static void publicRemarksEnglish(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("public_remarks_english")) {
            dllmAttributes.setPublic_remarks_english((JSONArray) jsonObj.get("public_remarks_english"));
        }
    }

    public static void publicRemarksLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("public_remarks_lao")) {
            dllmAttributes.setPublic_remarks_lao((JSONArray) jsonObj.get("public_remarks_lao"));
        }
    }

    public static void categoriesName(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("categories_name")) {
            dllmAttributes.setCategories_name((JSONArray) jsonObj.get("categories_name"));
        }
    }

    public static void categoriesNameLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("categories_name_lao")) {
            dllmAttributes.setCategories_name_lao((JSONArray) jsonObj.get("categories_name_lao"));
        }
    }

    public static void languages(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("languages")) {
            dllmAttributes.setLanguages((JSONArray) jsonObj.get("languages"));
        }
    }

    public static void languagesLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("languages_lao")) {
            dllmAttributes.setLanguages_lao((JSONArray) jsonObj.get("languages_lao"));
        }
    }

    public static void scripts(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("scripts")) {
            dllmAttributes.setScripts((JSONArray) jsonObj.get("scripts"));
        }
    }

    public static void scriptsLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("scripts_lao")) {
            dllmAttributes.setScripts_lao((JSONArray) jsonObj.get("scripts_lao"));
        }
    }

    public static void titleSearchRoman(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("title_search_roman")) {
            dllmAttributes.setTitle_search_roman((JSONArray) jsonObj.get("title_search_roman"));
        }
    }

    public static void titleSearchLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("title_search_lao")) {
            dllmAttributes.setTitle_search_lao((JSONArray) jsonObj.get("title_search_lao"));
        }
    }

    public static void dllmTitleRoman(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dllm_title_roman")) {
            dllmAttributes.setDllm_title_roman((JSONArray) jsonObj.get("dllm_title_roman"));
        }
    }

    public static void dllmTitleLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dllm_title_lao")) {
            dllmAttributes.setDllm_title_lao((JSONArray) jsonObj.get("dllm_title_lao"));
        }
    }

    public static void plmpTitleLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("plmp_title_lao")) {
            dllmAttributes.setPlmp_title_lao((JSONArray) jsonObj.get("plmp_title_lao"));
        }
    }

    public static void locationDocumentsCount(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("location_documents_count")) {
            dllmAttributes.setLocation_documents_count((int) jsonObj.get("location_documents_count"));
        }
    }

    public static void legibilitiesName(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("legibilities_name")) {
            dllmAttributes.setLegibilities_name((String) jsonObj.get("legibilities_name"));
        }
    }

    public static void legibilitiesNameLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("legibilities_name_lao")) {
            dllmAttributes.setLegibilities_name_lao((String) jsonObj.get("legibilities_name_lao"));
        }
    }

    public static void conditionsName(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("conditions_name")) {
            dllmAttributes.setConditions_name((String) jsonObj.get("conditions_name"));
        }
    }

    public static void conditionsNameLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("conditions_name_lao")) {
            dllmAttributes.setConditions_name_lao((String) jsonObj.get("conditions_name_lao"));
        }
    }

    public static void documentsPreferredDateSystem(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_preferred_date_system")) {
            dllmAttributes.setDocuments_preferred_date_system((String) jsonObj.get("documents_preferred_date_system"));
        }
    }

    public static void documentsPreferredDateSystemLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_preferred_date_system_lao")) {
            dllmAttributes.setDocuments_preferred_date_system_lao((String) jsonObj.get("documents_preferred_date_system_lao"));
        }
    }


    public static void documentsDateWritten(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("documents_date_written")) {
            dllmAttributes.setDocuments_date_written((String) jsonObj.get("documents_date_written"));
        }
    }

    public static void dateOriginal(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("date_original")) {
            dllmAttributes.setDate_original((String) jsonObj.get("date_original"));
        }
    }

    public static void dateOriginalLao(DllmAttributes dllmAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("date_original_lao")) {
            dllmAttributes.setDate_original_lao((String) jsonObj.get("date_original_lao"));
        }
    }
}
