package org.crossasia.manifest.attributes;

import org.json.JSONArray;

public class DllmAttributes {

    private String  documents_id;
    private String  documents_code_number;
    private String  documents_roll;
    private int documents_number_of_fascicles;
    private int documents_number_of_folios;
    private String extent;
    private int locations_is_top_level;
    private int locations_parent_parent_id;
    private String locations_parent_parent_name;
    private String full_location_name_lao;
    private  String locations_parent_parent_name_lao;
    private String locations_parent_name_lao;
    private String locations_parent_name;
    private String full_location_name;
    private String location_name;
    private String location_name_lao;
    private String documents_has_colophon;
    private String documents_is_illustrated;
    private String documents_is_color;
    private String documents_bundle_id;
    private int locations_id;
    private int locations_parent_id;
    private int documents_position_in_bundle;
    private String documents_is_complete;
    private int documents_pages_count;
    private String description;
    private String materials_name;
    private String materials_name_lao;
    private String documents_private_remarks_en;
    private  String documents_private_remark_lo;
    private String location_types_name;
    private String location_types_name_lao;
    private int locations_lft;
    private  int  locations_rgt;
    private int locations_dllm_loc_code;
    private double locations_gps_lat;
    private double locations_gps_lon;
    private String ancillary_terms_roman;
    private String ancillary_terms_lao;
    private  JSONArray     public_remarks_english;
    private JSONArray public_remarks_lao;
    private  JSONArray     categories_name;
    private JSONArray categories_name_lao;
    private  JSONArray languages;
    private JSONArray languages_lao;
    private JSONArray scripts;
    private JSONArray scripts_lao;
    private JSONArray title_search_roman;
    private JSONArray title_search_lao;
    private JSONArray dllm_title_roman;
    private JSONArray dllm_title_lao;
    private  JSONArray plmp_title_lao;
    private int location_documents_count;
    private String legibilities_name;
    private String legibilities_name_lao;
    private String conditions_name;
    private String conditions_name_lao;
    private String documents_preferred_date_system;
    private  String     documents_preferred_date_system_lao;
    private String documents_date_written;
    private  String date_original;
    private String date_original_lao;

    private JSONArray pages;

    public DllmAttributes(){

    }

    public String getLocations_parent_name() {
        return locations_parent_name;
    }

    public void setLocations_parent_name(String locations_parent_name) {
        this.locations_parent_name = locations_parent_name;
    }

    public DllmAttributes(String documents_id, String documents_code_number, String documents_roll, int documents_number_of_fascicles, int documents_number_of_folios, String extent, int locations_is_top_level, int locations_parent_parent_id, String locations_parent_parent_name, String full_location_name_lao, String locations_parent_parent_name_lao, String locations_parent_name_lao, String locations_parent_name, String full_location_name, String location_name, String location_name_lao, String documents_has_colophon, String documents_is_illustrated, String documents_is_color, String documents_bundle_id, int locations_id, int locations_parent_id, int documents_position_in_bundle, String documents_is_complete, int documents_pages_count, String description, String materials_name, String materials_name_lao, String documents_private_remarks_en, String documents_private_remark_lo, String location_types_name, String location_types_name_lao, int locations_lft, int locations_rgt, int locations_dllm_loc_code, double locations_gps_lat, double locations_gps_lon, String ancillary_terms_roman, String ancillary_terms_lao, JSONArray public_remarks_english, JSONArray public_remarks_lao, JSONArray categories_name, JSONArray categories_name_lao, JSONArray languages, JSONArray languages_lao, JSONArray scripts, JSONArray scripts_lao, JSONArray title_search_roman, JSONArray title_search_lao, JSONArray dllm_title_roman, JSONArray dllm_title_lao, JSONArray plmp_title_lao, int location_documents_count, String legibilities_name, String legibilities_name_lao, String conditions_name, String conditions_name_lao, String documents_preferred_date_system, String documents_preferred_date_system_lao, String documents_date_written, String date_original, String date_original_lao, JSONArray pages) {
        this.documents_id = documents_id;
        this.documents_code_number = documents_code_number;
        this.documents_roll = documents_roll;
        this.documents_number_of_fascicles = documents_number_of_fascicles;
        this.documents_number_of_folios = documents_number_of_folios;
        this.extent = extent;
        this.locations_is_top_level = locations_is_top_level;
        this.locations_parent_parent_id = locations_parent_parent_id;
        this.locations_parent_parent_name = locations_parent_parent_name;
        this.full_location_name_lao = full_location_name_lao;
        this.locations_parent_parent_name_lao = locations_parent_parent_name_lao;
        this.locations_parent_name_lao = locations_parent_name_lao;
        this.locations_parent_name = locations_parent_name;
        this.full_location_name = full_location_name;
        this.location_name = location_name;
        this.location_name_lao = location_name_lao;
        this.documents_has_colophon = documents_has_colophon;
        this.documents_is_illustrated = documents_is_illustrated;
        this.documents_is_color = documents_is_color;
        this.documents_bundle_id = documents_bundle_id;
        this.locations_id = locations_id;
        this.locations_parent_id = locations_parent_id;
        this.documents_position_in_bundle = documents_position_in_bundle;
        this.documents_is_complete = documents_is_complete;
        this.documents_pages_count = documents_pages_count;
        this.description = description;
        this.materials_name = materials_name;
        this.materials_name_lao = materials_name_lao;
        this.documents_private_remarks_en = documents_private_remarks_en;
        this.documents_private_remark_lo = documents_private_remark_lo;
        this.location_types_name = location_types_name;
        this.location_types_name_lao = location_types_name_lao;
        this.locations_lft = locations_lft;
        this.locations_rgt = locations_rgt;
        this.locations_dllm_loc_code = locations_dllm_loc_code;
        this.locations_gps_lat = locations_gps_lat;
        this.locations_gps_lon = locations_gps_lon;
        this.ancillary_terms_roman = ancillary_terms_roman;
        this.ancillary_terms_lao = ancillary_terms_lao;
        this.public_remarks_english = public_remarks_english;
        this.public_remarks_lao = public_remarks_lao;
        this.categories_name = categories_name;
        this.categories_name_lao = categories_name_lao;
        this.languages = languages;
        this.languages_lao = languages_lao;
        this.scripts = scripts;
        this.scripts_lao = scripts_lao;
        this.title_search_roman = title_search_roman;
        this.title_search_lao = title_search_lao;
        this.dllm_title_roman = dllm_title_roman;
        this.dllm_title_lao = dllm_title_lao;
        this.plmp_title_lao = plmp_title_lao;
        this.location_documents_count = location_documents_count;
        this.legibilities_name = legibilities_name;
        this.legibilities_name_lao = legibilities_name_lao;
        this.conditions_name = conditions_name;
        this.conditions_name_lao = conditions_name_lao;
        this.documents_preferred_date_system = documents_preferred_date_system;
        this.documents_preferred_date_system_lao = documents_preferred_date_system_lao;
        this.documents_date_written = documents_date_written;
        this.date_original = date_original;
        this.date_original_lao = date_original_lao;
        this.pages = pages;
    }

    public DllmAttributes(String documents_id, String documents_code_number, String documents_roll, int documents_number_of_fascicles, int documents_number_of_folios, String extent, int locations_is_top_level, int locations_parent_parent_id, String locations_parent_parent_name, String full_location_name_lao, String locations_parent_parent_name_lao, String locations_parent_name_lao, String full_location_name, String location_name, String location_name_lao, String documents_has_colophon, String documents_is_illustrated, String documents_is_color, String documents_bundle_id, int locations_id, int locations_parent_id, int documents_position_in_bundle, String documents_is_complete, int documents_pages_count, String description, String materials_name, String materials_name_lao, String documents_private_remarks_en, String documents_private_remark_lo, String location_types_name, String location_types_name_lao, int locations_lft, int locations_rgt, int locations_dllm_loc_code, double locations_gps_lat, double locations_gps_lon, String ancillary_terms_roman, String ancillary_terms_lao, JSONArray public_remarks_english, JSONArray public_remarks_lao, JSONArray categories_name, JSONArray categories_name_lao, JSONArray languages, JSONArray languages_lao, JSONArray scripts, JSONArray scripts_lao, JSONArray title_search_roman, JSONArray title_search_lao, JSONArray dllm_title_roman, JSONArray dllm_title_lao, JSONArray plmp_title_lao, int location_documents_count, String legibilities_name, String legibilities_name_lao, String conditions_name, String conditions_name_lao, String documents_preferred_date_system, String documents_preferred_date_system_lao, String documents_date_written, String date_original, String date_original_lao, JSONArray pages) {
        this.documents_id = documents_id;
        this.documents_code_number = documents_code_number;
        this.documents_roll = documents_roll;
        this.documents_number_of_fascicles = documents_number_of_fascicles;
        this.documents_number_of_folios = documents_number_of_folios;
        this.extent = extent;
        this.locations_is_top_level = locations_is_top_level;
        this.locations_parent_parent_id = locations_parent_parent_id;
        this.locations_parent_parent_name = locations_parent_parent_name;
        this.full_location_name_lao = full_location_name_lao;
        this.locations_parent_parent_name_lao = locations_parent_parent_name_lao;
        this.locations_parent_name_lao = locations_parent_name_lao;
        this.full_location_name = full_location_name;
        this.location_name = location_name;
        this.location_name_lao = location_name_lao;
        this.documents_has_colophon = documents_has_colophon;
        this.documents_is_illustrated = documents_is_illustrated;
        this.documents_is_color = documents_is_color;
        this.documents_bundle_id = documents_bundle_id;
        this.locations_id = locations_id;
        this.locations_parent_id = locations_parent_id;
        this.documents_position_in_bundle = documents_position_in_bundle;
        this.documents_is_complete = documents_is_complete;
        this.documents_pages_count = documents_pages_count;
        this.description = description;
        this.materials_name = materials_name;
        this.materials_name_lao = materials_name_lao;
        this.documents_private_remarks_en = documents_private_remarks_en;
        this.documents_private_remark_lo = documents_private_remark_lo;
        this.location_types_name = location_types_name;
        this.location_types_name_lao = location_types_name_lao;
        this.locations_lft = locations_lft;
        this.locations_rgt = locations_rgt;
        this.locations_dllm_loc_code = locations_dllm_loc_code;
        this.locations_gps_lat = locations_gps_lat;
        this.locations_gps_lon = locations_gps_lon;
        this.ancillary_terms_roman = ancillary_terms_roman;
        this.ancillary_terms_lao = ancillary_terms_lao;
        this.public_remarks_english = public_remarks_english;
        this.public_remarks_lao = public_remarks_lao;
        this.categories_name = categories_name;
        this.categories_name_lao = categories_name_lao;
        this.languages = languages;
        this.languages_lao = languages_lao;
        this.scripts = scripts;
        this.scripts_lao = scripts_lao;
        this.title_search_roman = title_search_roman;
        this.title_search_lao = title_search_lao;
        this.dllm_title_roman = dllm_title_roman;
        this.dllm_title_lao = dllm_title_lao;
        this.plmp_title_lao = plmp_title_lao;
        this.location_documents_count = location_documents_count;
        this.legibilities_name = legibilities_name;
        this.legibilities_name_lao = legibilities_name_lao;
        this.conditions_name = conditions_name;
        this.conditions_name_lao = conditions_name_lao;
        this.documents_preferred_date_system = documents_preferred_date_system;
        this.documents_preferred_date_system_lao = documents_preferred_date_system_lao;
        this.documents_date_written = documents_date_written;
        this.date_original = date_original;
        this.date_original_lao = date_original_lao;
        this.pages = pages;
    }

    public String getDocuments_id() {
        return documents_id;
    }

    public void setDocuments_id(String documents_id) {
        this.documents_id = documents_id;
    }

    public String getDocuments_code_number() {
        return documents_code_number;
    }

    public void setDocuments_code_number(String documents_code_number) {
        this.documents_code_number = documents_code_number;
    }

    public String getDocuments_roll() {
        return documents_roll;
    }

    public void setDocuments_roll(String documents_roll) {
        this.documents_roll = documents_roll;
    }

    public int getDocuments_number_of_fascicles() {
        return documents_number_of_fascicles;
    }

    public void setDocuments_number_of_fascicles(int documents_number_of_fascicles) {
        this.documents_number_of_fascicles = documents_number_of_fascicles;
    }

    public int getDocuments_number_of_folios() {
        return documents_number_of_folios;
    }

    public void setDocuments_number_of_folios(int documents_number_of_folios) {
        this.documents_number_of_folios = documents_number_of_folios;
    }

    public String getExtent() {
        return extent;
    }

    public void setExtent(String extent) {
        this.extent = extent;
    }

    public int getLocations_is_top_level() {
        return locations_is_top_level;
    }

    public void setLocations_is_top_level(int locations_is_top_level) {
        this.locations_is_top_level = locations_is_top_level;
    }

    public int getLocations_parent_parent_id() {
        return locations_parent_parent_id;
    }

    public void setLocations_parent_parent_id(int locations_parent_parent_id) {
        this.locations_parent_parent_id = locations_parent_parent_id;
    }

    public String getLocations_parent_parent_name() {
        return locations_parent_parent_name;
    }

    public void setLocations_parent_parent_name(String locations_parent_parent_name) {
        this.locations_parent_parent_name = locations_parent_parent_name;
    }

    public String getFull_location_name_lao() {
        return full_location_name_lao;
    }

    public void setFull_location_name_lao(String full_location_name_lao) {
        this.full_location_name_lao = full_location_name_lao;
    }

    public String getLocations_parent_parent_name_lao() {
        return locations_parent_parent_name_lao;
    }

    public void setLocations_parent_parent_name_lao(String locations_parent_parent_name_lao) {
        this.locations_parent_parent_name_lao = locations_parent_parent_name_lao;
    }

    public String getLocations_parent_name_lao() {
        return locations_parent_name_lao;
    }

    public void setLocations_parent_name_lao(String locations_parent_name_lao) {
        this.locations_parent_name_lao = locations_parent_name_lao;
    }

    public String getFull_location_name() {
        return full_location_name;
    }

    public void setFull_location_name(String full_location_name) {
        this.full_location_name = full_location_name;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getLocation_name_lao() {
        return location_name_lao;
    }

    public void setLocation_name_lao(String location_name_lao) {
        this.location_name_lao = location_name_lao;
    }

    public String getDocuments_has_colophon() {
        return documents_has_colophon;
    }

    public void setDocuments_has_colophon(String documents_has_colophon) {
        this.documents_has_colophon = documents_has_colophon;
    }

    public String getDocuments_is_illustrated() {
        return documents_is_illustrated;
    }

    public void setDocuments_is_illustrated(String documents_is_illustrated) {
        this.documents_is_illustrated = documents_is_illustrated;
    }

    public String getDocuments_is_color() {
        return documents_is_color;
    }

    public void setDocuments_is_color(String documents_is_color) {
        this.documents_is_color = documents_is_color;
    }

    public String getDocuments_bundle_id() {
        return documents_bundle_id;
    }

    public void setDocuments_bundle_id(String documents_bundle_id) {
        this.documents_bundle_id = documents_bundle_id;
    }

    public int getLocations_id() {
        return locations_id;
    }

    public void setLocations_id(int locations_id) {
        this.locations_id = locations_id;
    }

    public int getLocations_parent_id() {
        return locations_parent_id;
    }

    public void setLocations_parent_id(int locations_parent_id) {
        this.locations_parent_id = locations_parent_id;
    }

    public int getDocuments_position_in_bundle() {
        return documents_position_in_bundle;
    }

    public void setDocuments_position_in_bundle(int documents_position_in_bundle) {
        this.documents_position_in_bundle = documents_position_in_bundle;
    }

    public String getDocuments_is_complete() {
        return documents_is_complete;
    }

    public void setDocuments_is_complete(String documents_is_complete) {
        this.documents_is_complete = documents_is_complete;
    }

    public int getDocuments_pages_count() {
        return documents_pages_count;
    }

    public void setDocuments_pages_count(int documents_pages_count) {
        this.documents_pages_count = documents_pages_count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterials_name() {
        return materials_name;
    }

    public void setMaterials_name(String materials_name) {
        this.materials_name = materials_name;
    }

    public String getMaterials_name_lao() {
        return materials_name_lao;
    }

    public void setMaterials_name_lao(String materials_name_lao) {
        this.materials_name_lao = materials_name_lao;
    }

    public String getDocuments_private_remarks_en() {
        return documents_private_remarks_en;
    }

    public void setDocuments_private_remarks_en(String documents_private_remarks_en) {
        this.documents_private_remarks_en = documents_private_remarks_en;
    }

    public String getDocuments_private_remark_lo() {
        return documents_private_remark_lo;
    }

    public void setDocuments_private_remark_lo(String documents_private_remark_lo) {
        this.documents_private_remark_lo = documents_private_remark_lo;
    }

    public String getLocation_types_name() {
        return location_types_name;
    }

    public void setLocation_types_name(String location_types_name) {
        this.location_types_name = location_types_name;
    }

    public String getLocation_types_name_lao() {
        return location_types_name_lao;
    }

    public void setLocation_types_name_lao(String location_types_name_lao) {
        this.location_types_name_lao = location_types_name_lao;
    }

    public int getLocations_lft() {
        return locations_lft;
    }

    public void setLocations_lft(int locations_lft) {
        this.locations_lft = locations_lft;
    }

    public int getLocations_rgt() {
        return locations_rgt;
    }

    public void setLocations_rgt(int locations_rgt) {
        this.locations_rgt = locations_rgt;
    }

    public int getLocations_dllm_loc_code() {
        return locations_dllm_loc_code;
    }

    public void setLocations_dllm_loc_code(int locations_dllm_loc_code) {
        this.locations_dllm_loc_code = locations_dllm_loc_code;
    }

    public double getLocations_gps_lat() {
        return locations_gps_lat;
    }

    public void setLocations_gps_lat(double locations_gps_lat) {
        this.locations_gps_lat = locations_gps_lat;
    }

    public double getLocations_gps_lon() {
        return locations_gps_lon;
    }

    public void setLocations_gps_lon(double locations_gps_lon) {
        this.locations_gps_lon = locations_gps_lon;
    }

    public String getAncillary_terms_roman() {
        return ancillary_terms_roman;
    }

    public void setAncillary_terms_roman(String ancillary_terms_roman) {
        this.ancillary_terms_roman = ancillary_terms_roman;
    }

    public String getAncillary_terms_lao() {
        return ancillary_terms_lao;
    }

    public void setAncillary_terms_lao(String ancillary_terms_lao) {
        this.ancillary_terms_lao = ancillary_terms_lao;
    }

    public JSONArray getPublic_remarks_english() {
        return public_remarks_english;
    }

    public void setPublic_remarks_english(JSONArray public_remarks_english) {
        this.public_remarks_english = public_remarks_english;
    }

    public JSONArray getPublic_remarks_lao() {
        return public_remarks_lao;
    }

    public void setPublic_remarks_lao(JSONArray public_remarks_lao) {
        this.public_remarks_lao = public_remarks_lao;
    }

    public JSONArray getCategories_name() {
        return categories_name;
    }

    public void setCategories_name(JSONArray categories_name) {
        this.categories_name = categories_name;
    }

    public JSONArray getCategories_name_lao() {
        return categories_name_lao;
    }

    public void setCategories_name_lao(JSONArray categories_name_lao) {
        this.categories_name_lao = categories_name_lao;
    }

    public JSONArray getLanguages() {
        return languages;
    }

    public void setLanguages(JSONArray languages) {
        this.languages = languages;
    }

    public JSONArray getLanguages_lao() {
        return languages_lao;
    }

    public void setLanguages_lao(JSONArray languages_lao) {
        this.languages_lao = languages_lao;
    }

    public JSONArray getScripts() {
        return scripts;
    }

    public void setScripts(JSONArray scripts) {
        this.scripts = scripts;
    }

    public JSONArray getScripts_lao() {
        return scripts_lao;
    }

    public void setScripts_lao(JSONArray scripts_lao) {
        this.scripts_lao = scripts_lao;
    }

    public JSONArray getTitle_search_roman() {
        return title_search_roman;
    }

    public void setTitle_search_roman(JSONArray title_search_roman) {
        this.title_search_roman = title_search_roman;
    }

    public JSONArray getTitle_search_lao() {
        return title_search_lao;
    }

    public void setTitle_search_lao(JSONArray title_search_lao) {
        this.title_search_lao = title_search_lao;
    }

    public JSONArray getDllm_title_roman() {
        return dllm_title_roman;
    }

    public void setDllm_title_roman(JSONArray dllm_title_roman) {
        this.dllm_title_roman = dllm_title_roman;
    }

    public JSONArray getDllm_title_lao() {
        return dllm_title_lao;
    }

    public void setDllm_title_lao(JSONArray dllm_title_lao) {
        this.dllm_title_lao = dllm_title_lao;
    }

    public JSONArray getPlmp_title_lao() {
        return plmp_title_lao;
    }

    public void setPlmp_title_lao(JSONArray plmp_title_lao) {
        this.plmp_title_lao = plmp_title_lao;
    }

    public int getLocation_documents_count() {
        return location_documents_count;
    }

    public void setLocation_documents_count(int location_documents_count) {
        this.location_documents_count = location_documents_count;
    }

    public String getLegibilities_name() {
        return legibilities_name;
    }

    public void setLegibilities_name(String legibilities_name) {
        this.legibilities_name = legibilities_name;
    }

    public String getLegibilities_name_lao() {
        return legibilities_name_lao;
    }

    public void setLegibilities_name_lao(String legibilities_name_lao) {
        this.legibilities_name_lao = legibilities_name_lao;
    }

    public String getConditions_name() {
        return conditions_name;
    }

    public void setConditions_name(String conditions_name) {
        this.conditions_name = conditions_name;
    }

    public String getConditions_name_lao() {
        return conditions_name_lao;
    }

    public void setConditions_name_lao(String conditions_name_lao) {
        this.conditions_name_lao = conditions_name_lao;
    }

    public String getDocuments_preferred_date_system() {
        return documents_preferred_date_system;
    }

    public void setDocuments_preferred_date_system(String documents_preferred_date_system) {
        this.documents_preferred_date_system = documents_preferred_date_system;
    }

    public String getDocuments_preferred_date_system_lao() {
        return documents_preferred_date_system_lao;
    }

    public void setDocuments_preferred_date_system_lao(String documents_preferred_date_system_lao) {
        this.documents_preferred_date_system_lao = documents_preferred_date_system_lao;
    }

    public String getDocuments_date_written() {
        return documents_date_written;
    }

    public void setDocuments_date_written(String documents_date_written) {
        this.documents_date_written = documents_date_written;
    }

    public String getDate_original() {
        return date_original;
    }

    public void setDate_original(String date_original) {
        this.date_original = date_original;
    }

    public String getDate_original_lao() {
        return date_original_lao;
    }

    public void setDate_original_lao(String date_original_lao) {
        this.date_original_lao = date_original_lao;
    }

    public JSONArray getPages() {
        return pages;
    }

    public void setPages(JSONArray pages) {
        this.pages = pages;
    }
}
