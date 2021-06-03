package org.crossasia.manifest.attributes;

import org.json.JSONArray;

public class DllmAttributes {
    private String  id;
    private String  code_number;
    private String  roll;
    private String  date_written ;
    private int date_written_right;
    private String  temporal_date;
    private String  temporal_date_lao;

    private int number_of_fascicles;
    private int number_of_folios;
    private int has_colophon;
    private String  has_colophon_str;
    private int is_illustrated;
    private String  is_illustrated_str;

    private String  bundle_id;

    private int position_in_bundle;
    private int pages_count;
    private int locations_id;
    private int locations_parent_id;

    private String  public_remarks_en;
    private String  public_remarks_lo ;

    private String  private_remarks_en;
    private String  private_remarks_lo ;

    private int is_color;
    private String  is_color_str ;
    private int is_complete;
    private String  is_complete_str;

    private String  materials ;
    private String  materials_lao;

    private String  name_location;
    private String  name_location_lao;

    private String  location ;
    private String  location_place ;
    private String  location_place_lao;

    private int location_lft;
    private int location_rgt;
    private int location_code;
    private double location_lat;
    private double location_lon;
    private int location_documents_count;

    private String  legibilities;
    private String  legibilities_lao;
    private String  additional_date_infos_roman;
    private String  additional_date_infos_lao;
    private String  conditions;
    private String  conditions_lao ;
    private String  preferred_date_systems;
    private String  preferred_date_systems_lao;

    private JSONArray languages;
    private JSONArray languages_lao;

    private JSONArray remark_lao;
    private JSONArray remark_english;

    private JSONArray term_roman;
    private JSONArray term_leo;

    private JSONArray categories;
    private JSONArray categories_lao;

    private JSONArray scripts;
    private JSONArray scripts_lao;

    private JSONArray title_roman;
    private JSONArray title_lao;

    private JSONArray title_search_roman;
    private JSONArray title_search_lao;

    private JSONArray plmp_title_lao;

    private JSONArray pages;

    public DllmAttributes(){

    }

    public DllmAttributes(String id, String code_number, String roll, String date_written, int date_written_right, String temporal_date, String temporal_date_lao, int number_of_fascicles, int number_of_folios, int has_colophon, String has_colophon_str, int is_illustrated, String is_illustrated_str, String bundle_id, int position_in_bundle, int pages_count, int locations_id, int locations_parent_id, String public_remarks_en, String public_remarks_lo, String private_remarks_en, String private_remarks_lo, int is_color, String is_color_str, int is_complete, String is_complete_str, String materials, String materials_lao, String name_location, String name_location_lao, String location, String location_place, String location_place_lao, int location_lft, int location_rgt, int location_code, double location_lat, double location_lon, int location_documents_count, String legibilities, String legibilities_lao, String additional_date_infos_roman, String additional_date_infos_lao, String conditions, String conditions_lao, String preferred_date_systems, String preferred_date_systems_lao, JSONArray languages, JSONArray languages_lao, JSONArray remark_lao, JSONArray remark_english, JSONArray term_roman, JSONArray term_leo, JSONArray categories, JSONArray categories_lao, JSONArray scripts, JSONArray scripts_lao, JSONArray title_roman, JSONArray title_lao, JSONArray title_search_roman, JSONArray title_search_lao, JSONArray plmp_title_lao, JSONArray pages) {
        this.id = id;
        this.code_number = code_number;
        this.roll = roll;
        this.date_written = date_written;
        this.date_written_right = date_written_right;
        this.temporal_date = temporal_date;
        this.temporal_date_lao = temporal_date_lao;
        this.number_of_fascicles = number_of_fascicles;
        this.number_of_folios = number_of_folios;
        this.has_colophon = has_colophon;
        this.has_colophon_str = has_colophon_str;
        this.is_illustrated = is_illustrated;
        this.is_illustrated_str = is_illustrated_str;
        this.bundle_id = bundle_id;
        this.position_in_bundle = position_in_bundle;
        this.pages_count = pages_count;
        this.locations_id = locations_id;
        this.locations_parent_id = locations_parent_id;
        this.public_remarks_en = public_remarks_en;
        this.public_remarks_lo = public_remarks_lo;
        this.private_remarks_en = private_remarks_en;
        this.private_remarks_lo = private_remarks_lo;
        this.is_color = is_color;
        this.is_color_str = is_color_str;
        this.is_complete = is_complete;
        this.is_complete_str = is_complete_str;
        this.materials = materials;
        this.materials_lao = materials_lao;
        this.name_location = name_location;
        this.name_location_lao = name_location_lao;
        this.location = location;
        this.location_place = location_place;
        this.location_place_lao = location_place_lao;
        this.location_lft = location_lft;
        this.location_rgt = location_rgt;
        this.location_code = location_code;
        this.location_lat = location_lat;
        this.location_lon = location_lon;
        this.location_documents_count = location_documents_count;
        this.legibilities = legibilities;
        this.legibilities_lao = legibilities_lao;
        this.additional_date_infos_roman = additional_date_infos_roman;
        this.additional_date_infos_lao = additional_date_infos_lao;
        this.conditions = conditions;
        this.conditions_lao = conditions_lao;
        this.preferred_date_systems = preferred_date_systems;
        this.preferred_date_systems_lao = preferred_date_systems_lao;
        this.languages = languages;
        this.languages_lao = languages_lao;
        this.remark_lao = remark_lao;
        this.remark_english = remark_english;
        this.term_roman = term_roman;
        this.term_leo = term_leo;
        this.categories = categories;
        this.categories_lao = categories_lao;
        this.scripts = scripts;
        this.scripts_lao = scripts_lao;
        this.title_roman = title_roman;
        this.title_lao = title_lao;
        this.title_search_roman = title_search_roman;
        this.title_search_lao = title_search_lao;
        this.plmp_title_lao = plmp_title_lao;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode_number() {
        return code_number;
    }

    public void setCode_number(String code_number) {
        this.code_number = code_number;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getDate_written() {
        return date_written;
    }

    public void setDate_written(String date_written) {
        this.date_written = date_written;
    }

    public int getDate_written_right() {
        return date_written_right;
    }

    public void setDate_written_right(int date_written_right) {
        this.date_written_right = date_written_right;
    }

    public String getTemporal_date() {
        return temporal_date;
    }

    public void setTemporal_date(String temporal_date) {
        this.temporal_date = temporal_date;
    }

    public String getTemporal_date_lao() {
        return temporal_date_lao;
    }

    public void setTemporal_date_lao(String temporal_date_lao) {
        this.temporal_date_lao = temporal_date_lao;
    }

    public int getNumber_of_fascicles() {
        return number_of_fascicles;
    }

    public void setNumber_of_fascicles(int number_of_fascicles) {
        this.number_of_fascicles = number_of_fascicles;
    }

    public int getNumber_of_folios() {
        return number_of_folios;
    }

    public void setNumber_of_folios(int number_of_folios) {
        this.number_of_folios = number_of_folios;
    }

    public int getHas_colophon() {
        return has_colophon;
    }

    public void setHas_colophon(int has_colophon) {
        this.has_colophon = has_colophon;
    }

    public String getHas_colophon_str() {
        return has_colophon_str;
    }

    public void setHas_colophon_str(String has_colophon_str) {
        this.has_colophon_str = has_colophon_str;
    }

    public int getIs_illustrated() {
        return is_illustrated;
    }

    public void setIs_illustrated(int is_illustrated) {
        this.is_illustrated = is_illustrated;
    }

    public String getIs_illustrated_str() {
        return is_illustrated_str;
    }

    public void setIs_illustrated_str(String is_illustrated_str) {
        this.is_illustrated_str = is_illustrated_str;
    }

    public String getBundle_id() {
        return bundle_id;
    }

    public void setBundle_id(String bundle_id) {
        this.bundle_id = bundle_id;
    }

    public int getPosition_in_bundle() {
        return position_in_bundle;
    }

    public void setPosition_in_bundle(int position_in_bundle) {
        this.position_in_bundle = position_in_bundle;
    }

    public int getPages_count() {
        return pages_count;
    }

    public void setPages_count(int pages_count) {
        this.pages_count = pages_count;
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

    public String getPublic_remarks_en() {
        return public_remarks_en;
    }

    public void setPublic_remarks_en(String public_remarks_en) {
        this.public_remarks_en = public_remarks_en;
    }

    public String getPublic_remarks_lo() {
        return public_remarks_lo;
    }

    public void setPublic_remarks_lo(String public_remarks_lo) {
        this.public_remarks_lo = public_remarks_lo;
    }

    public String getPrivate_remarks_en() {
        return private_remarks_en;
    }

    public void setPrivate_remarks_en(String private_remarks_en) {
        this.private_remarks_en = private_remarks_en;
    }

    public String getPrivate_remarks_lo() {
        return private_remarks_lo;
    }

    public void setPrivate_remarks_lo(String private_remarks_lo) {
        this.private_remarks_lo = private_remarks_lo;
    }

    public int getIs_color() {
        return is_color;
    }

    public void setIs_color(int is_color) {
        this.is_color = is_color;
    }

    public String getIs_color_str() {
        return is_color_str;
    }

    public void setIs_color_str(String is_color_str) {
        this.is_color_str = is_color_str;
    }

    public int getIs_complete() {
        return is_complete;
    }

    public void setIs_complete(int is_complete) {
        this.is_complete = is_complete;
    }

    public String getIs_complete_str() {
        return is_complete_str;
    }

    public void setIs_complete_str(String is_complete_str) {
        this.is_complete_str = is_complete_str;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getMaterials_lao() {
        return materials_lao;
    }

    public void setMaterials_lao(String materials_lao) {
        this.materials_lao = materials_lao;
    }

    public String getName_location() {
        return name_location;
    }

    public void setName_location(String name_location) {
        this.name_location = name_location;
    }

    public String getName_location_lao() {
        return name_location_lao;
    }

    public void setName_location_lao(String name_location_lao) {
        this.name_location_lao = name_location_lao;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation_place() {
        return location_place;
    }

    public void setLocation_place(String location_place) {
        this.location_place = location_place;
    }

    public String getLocation_place_lao() {
        return location_place_lao;
    }

    public void setLocation_place_lao(String location_place_lao) {
        this.location_place_lao = location_place_lao;
    }

    public int getLocation_lft() {
        return location_lft;
    }

    public void setLocation_lft(int location_lft) {
        this.location_lft = location_lft;
    }

    public int getLocation_rgt() {
        return location_rgt;
    }

    public void setLocation_rgt(int location_rgt) {
        this.location_rgt = location_rgt;
    }

    public int getLocation_code() {
        return location_code;
    }

    public void setLocation_code(int location_code) {
        this.location_code = location_code;
    }

    public double getLocation_lat() {
        return location_lat;
    }

    public void setLocation_lat(double location_lat) {
        this.location_lat = location_lat;
    }

    public double getLocation_lon() {
        return location_lon;
    }

    public void setLocation_lon(double location_lon) {
        this.location_lon = location_lon;
    }

    public int getLocation_documents_count() {
        return location_documents_count;
    }

    public void setLocation_documents_count(int location_documents_count) {
        this.location_documents_count = location_documents_count;
    }

    public String getLegibilities() {
        return legibilities;
    }

    public void setLegibilities(String legibilities) {
        this.legibilities = legibilities;
    }

    public String getLegibilities_lao() {
        return legibilities_lao;
    }

    public void setLegibilities_lao(String legibilities_lao) {
        this.legibilities_lao = legibilities_lao;
    }

    public String getAdditional_date_infos_roman() {
        return additional_date_infos_roman;
    }

    public void setAdditional_date_infos_roman(String additional_date_infos_roman) {
        this.additional_date_infos_roman = additional_date_infos_roman;
    }

    public String getAdditional_date_infos_lao() {
        return additional_date_infos_lao;
    }

    public void setAdditional_date_infos_lao(String additional_date_infos_lao) {
        this.additional_date_infos_lao = additional_date_infos_lao;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getConditions_lao() {
        return conditions_lao;
    }

    public void setConditions_lao(String conditions_lao) {
        this.conditions_lao = conditions_lao;
    }

    public String getPreferred_date_systems() {
        return preferred_date_systems;
    }

    public void setPreferred_date_systems(String preferred_date_systems) {
        this.preferred_date_systems = preferred_date_systems;
    }

    public String getPreferred_date_systems_lao() {
        return preferred_date_systems_lao;
    }

    public void setPreferred_date_systems_lao(String preferred_date_systems_lao) {
        this.preferred_date_systems_lao = preferred_date_systems_lao;
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

    public JSONArray getRemark_lao() {
        return remark_lao;
    }

    public void setRemark_lao(JSONArray remark_lao) {
        this.remark_lao = remark_lao;
    }

    public JSONArray getRemark_english() {
        return remark_english;
    }

    public void setRemark_english(JSONArray remark_english) {
        this.remark_english = remark_english;
    }

    public JSONArray getTerm_roman() {
        return term_roman;
    }

    public void setTerm_roman(JSONArray term_roman) {
        this.term_roman = term_roman;
    }

    public JSONArray getTerm_leo() {
        return term_leo;
    }

    public void setTerm_leo(JSONArray term_leo) {
        this.term_leo = term_leo;
    }

    public JSONArray getCategories() {
        return categories;
    }

    public void setCategories(JSONArray categories) {
        this.categories = categories;
    }

    public JSONArray getCategories_lao() {
        return categories_lao;
    }

    public void setCategories_lao(JSONArray categories_lao) {
        this.categories_lao = categories_lao;
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

    public JSONArray getTitle_roman() {
        return title_roman;
    }

    public void setTitle_roman(JSONArray title_roman) {
        this.title_roman = title_roman;
    }

    public JSONArray getTitle_lao() {
        return title_lao;
    }

    public void setTitle_lao(JSONArray title_lao) {
        this.title_lao = title_lao;
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

    public JSONArray getPlmp_title_lao() {
        return plmp_title_lao;
    }

    public void setPlmp_title_lao(JSONArray plmp_title_lao) {
        this.plmp_title_lao = plmp_title_lao;
    }

    public JSONArray getPages() {
        return pages;
    }

    public void setPages(JSONArray pages) {
        this.pages = pages;
    }
}
