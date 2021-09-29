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
    //private String documents_private_remarks_en;
    //private  String documents_private_remark_lo;
    private String location_types_name;
    private String location_types_name_lao;
    private int locations_lft;
    private  int  locations_rgt;
    private int locations_dllm_loc_code;
    private double locations_gps_lat;
    private double locations_gps_lon;
    private JSONArray ancillary_terms_roman;
    private JSONArray ancillary_terms_lao;
    private  String     public_remarks_english;
    private String public_remarks_lao;
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
    private String microfilm_roll_number;
    private int id;
    private String code_number;
    private String active;
    private String in_collection;
    private int number_of_fascicles;
    private int number_of_digital_images;
    private boolean complete;
    private boolean has_colophon;
    private boolean illustrated;
    private boolean directly_digitised;
    private String legibility;
    private String condition;
    private int location_id;
    private int pntmp_title_id;
    private String date_system;
    private int number_of_folios;
    private int year;
    private JSONArray upload;
    private JSONArray code;
    private JSONArray province_th;
    private JSONArray province_ro;
    private JSONArray district_th;
    private JSONArray district_ro;
    private JSONArray address_th;
    private JSONArray address_ro;
    //"upload":[{"uploaded_file_id":205766,"original_file_name":"DLNTM_010701013_00_026.jpg","position":26},{"uploaded_file_id":205803,"original_file_name":"DLNTM_010701013_00_069.jpg","position":69},{"uploaded_file_id":205776,"original_file_name":"DLNTM_010701013_00_036.jpg","position":36},{"uploaded_file_id":205752,"original_file_name":"DLNTM_010701013_00_025.jpg","position":25},{"uploaded_file_id":205798,"original_file_name":"DLNTM_010701013_00_061.jpg","position":61},{"uploaded_file_id":205772,"original_file_name":"DLNTM_010701013_00_040.jpg","position":40},{"uploaded_file_id":205796,"original_file_name":"DLNTM_010701013_00_066.jpg","position":66},{"uploaded_file_id":205799,"original_file_name":"DLNTM_010701013_00_072.jpg","position":72},{"uploaded_file_id":205797,"original_file_name":"DLNTM_010701013_00_068.jpg","position":68},{"uploaded_file_id":205750,"original_file_name":"DLNTM_010701013_00_016.jpg","position":16},{"uploaded_file_id":205801,"original_file_name":"DLNTM_010701013_00_070.jpg","position":70},{"uploaded_file_id":205770,"original_file_name":"DLNTM_010701013_00_041.jpg","position":41},{"uploaded_file_id":205733,"original_file_name":"DLNTM_010701013_00_004.jpg","position":4},{"uploaded_file_id":205761,"original_file_name":"DLNTM_010701013_00_021.jpg","position":21},{"uploaded_file_id":205793,"original_file_name":"DLNTM_010701013_00_046.jpg","position":46},{"uploaded_file_id":205802,"original_file_name":"DLNTM_010701013_00_064.jpg","position":64},{"uploaded_file_id":205741,"original_file_name":"DLNTM_010701013_00_008.jpg","position":8},{"uploaded_file_id":205790,"original_file_name":"DLNTM_010701013_00_058.jpg","position":58},{"uploaded_file_id":205739,"original_file_name":"DLNTM_010701013_00_009.jpg","position":9},{"uploaded_file_id":205737,"original_file_name":"DLNTM_010701013_00_001.jpg","position":1},{"uploaded_file_id":205738,"original_file_name":"DLNTM_010701013_00_007.jpg","position":7},{"uploaded_file_id":205758,"original_file_name":"DLNTM_010701013_00_031.jpg","position":31},{"uploaded_file_id":205746,"original_file_name":"DLNTM_010701013_00_022.jpg","position":22},{"uploaded_file_id":205778,"original_file_name":"DLNTM_010701013_00_048.jpg","position":48},{"uploaded_file_id":205768,"original_file_name":"DLNTM_010701013_00_039.jpg","position":39},{"uploaded_file_id":205742,"original_file_name":"DLNTM_010701013_00_013.jpg","position":13},{"uploaded_file_id":205773,"original_file_name":"DLNTM_010701013_00_044.jpg","position":44},{"uploaded_file_id":205744,"original_file_name":"DLNTM_010701013_00_006.jpg","position":6},{"uploaded_file_id":205784,"original_file_name":"DLNTM_010701013_00_042.jpg","position":42},{"uploaded_file_id":205736,"original_file_name":"DLNTM_010701013_00_005.jpg","position":5},{"uploaded_file_id":205804,"original_file_name":"DLNTM_010701013_00_067.jpg","position":67},{"uploaded_file_id":205756,"original_file_name":"DLNTM_010701013_00_029.jpg","position":29},{"uploaded_file_id":205774,"original_file_name":"DLNTM_010701013_00_045.jpg","position":45},{"uploaded_file_id":205740,"original_file_name":"DLNTM_010701013_00_011.jpg","position":11},{"uploaded_file_id":205786,"original_file_name":"DLNTM_010701013_00_051.jpg","position":51},{"uploaded_file_id":205800,"original_file_name":"DLNTM_010701013_00_071.jpg","position":71},{"uploaded_file_id":205788,"original_file_name":"DLNTM_010701013_00_059.jpg","position":59},{"uploaded_file_id":205783,"original_file_name":"DLNTM_010701013_00_056.jpg","position":56},{"uploaded_file_id":205789,"original_file_name":"DLNTM_010701013_00_057.jpg","position":57},{"uploaded_file_id":205785,"original_file_name":"DLNTM_010701013_00_053.jpg","position":53},{"uploaded_file_id":205754,"original_file_name":"DLNTM_010701013_00_012.jpg","position":12},{"uploaded_file_id":205795,"original_file_name":"DLNTM_010701013_00_065.jpg","position":65},{"uploaded_file_id":205735,"original_file_name":"DLNTM_010701013_00_002.jpg","position":2},{"uploaded_file_id":205782,"original_file_name":"DLNTM_010701013_00_054.jpg","position":54},{"uploaded_file_id":205747,"original_file_name":"DLNTM_010701013_00_019.jpg","position":19},{"uploaded_file_id":205767,"original_file_name":"DLNTM_010701013_00_024.jpg","position":24},{"uploaded_file_id":205765,"original_file_name":"DLNTM_010701013_00_037.jpg","position":37},{"uploaded_file_id":205748,"original_file_name":"DLNTM_010701013_00_018.jpg","position":18},{"uploaded_file_id":205760,"original_file_name":"DLNTM_010701013_00_033.jpg","position":33},{"uploaded_file_id":205734,"original_file_name":"DLNTM_010701013_00_003.jpg","position":3},{"uploaded_file_id":205745,"original_file_name":"DLNTM_010701013_00_017.jpg","position":17},{"uploaded_file_id":205755,"original_file_name":"DLNTM_010701013_00_015.jpg","position":15},{"uploaded_file_id":205751,"original_file_name":"DLNTM_010701013_00_010.jpg","position":10},{"uploaded_file_id":205743,"original_file_name":"DLNTM_010701013_00_014.jpg","position":14},{"uploaded_file_id":205792,"original_file_name":"DLNTM_010701013_00_062.jpg","position":62},{"uploaded_file_id":205787,"original_file_name":"DLNTM_010701013_00_055.jpg","position":55},{"uploaded_file_id":205794,"original_file_name":"DLNTM_010701013_00_063.jpg","position":63},{"uploaded_file_id":205777,"original_file_name":"DLNTM_010701013_00_049.jpg","position":49},{"uploaded_file_id":205791,"original_file_name":"DLNTM_010701013_00_060.jpg","position":60},{"uploaded_file_id":205769,"original_file_name":"DLNTM_010701013_00_030.jpg","position":30},{"uploaded_file_id":205753,"original_file_name":"DLNTM_010701013_00_027.jpg","position":27},{"uploaded_file_id":205771,"original_file_name":"DLNTM_010701013_00_038.jpg","position":38},{"uploaded_file_id":205749,"original_file_name":"DLNTM_010701013_00_023.jpg","position":23},{"uploaded_file_id":205759,"original_file_name":"DLNTM_010701013_00_020.jpg","position":20},{"uploaded_file_id":205763,"original_file_name":"DLNTM_010701013_00_035.jpg","position":35},{"uploaded_file_id":205764,"original_file_name":"DLNTM_010701013_00_034.jpg","position":34},{"uploaded_file_id":205775,"original_file_name":"DLNTM_010701013_00_043.jpg","position":43},{"uploaded_file_id":205757,"original_file_name":"DLNTM_010701013_00_032.jpg","position":32},{"uploaded_file_id":205762,"original_file_name":"DLNTM_010701013_00_028.jpg","position":28},{"uploaded_file_id":205780,"original_file_name":"DLNTM_010701013_00_050.jpg","position":50},{"uploaded_file_id":205779,"original_file_name":"DLNTM_010701013_00_047.jpg","position":47},{"uploaded_file_id":205781,"original_file_name":"DLNTM_010701013_00_052.jpg","position":52}],
    private JSONArray latitude;
    private JSONArray longitude;
    private boolean exact;
    private JSONArray website;
    private JSONArray manuscripts_count;
    private JSONArray dlntm_title_id;
    private JSONArray dlntm_label_th;
    private JSONArray dlntm_label_ro;
    private JSONArray alternative_title_id;
    private JSONArray alternative_label_th;
    private JSONArray alternative_label_ro;
    private JSONArray label;
    private JSONArray label_ro;
    private JSONArray pntmp_label;
    private String thai_remarks;
    private String remarks;
    private int ce_year;
    private boolean in_private_collection;

    private JSONArray category;
    private JSONArray language;
    private JSONArray material;
    private JSONArray script;
    private JSONArray category_th;
    private JSONArray language_th;
    private JSONArray material_th;
    private JSONArray script_th;



    public DllmAttributes(){

    }

    public DllmAttributes(String documents_id, String documents_code_number, String documents_roll, int documents_number_of_fascicles, int documents_number_of_folios, String extent, int locations_is_top_level, int locations_parent_parent_id, String locations_parent_parent_name, String full_location_name_lao, String locations_parent_parent_name_lao, String locations_parent_name_lao, String locations_parent_name, String full_location_name, String location_name, String location_name_lao, String documents_has_colophon, String documents_is_illustrated, String documents_is_color, String documents_bundle_id, int locations_id, int locations_parent_id, int documents_position_in_bundle, String documents_is_complete, int documents_pages_count, String description, String materials_name, String materials_name_lao, String location_types_name, String location_types_name_lao, int locations_lft, int locations_rgt, int locations_dllm_loc_code, double locations_gps_lat, double locations_gps_lon, JSONArray ancillary_terms_roman, JSONArray ancillary_terms_lao, String public_remarks_english, String public_remarks_lao, JSONArray categories_name, JSONArray categories_name_lao, JSONArray languages, JSONArray languages_lao, JSONArray scripts, JSONArray scripts_lao, JSONArray title_search_roman, JSONArray title_search_lao, JSONArray dllm_title_roman, JSONArray dllm_title_lao, JSONArray plmp_title_lao, int location_documents_count, String legibilities_name, String legibilities_name_lao, String conditions_name, String conditions_name_lao, String documents_preferred_date_system, String documents_preferred_date_system_lao, String documents_date_written, String date_original, String date_original_lao, JSONArray pages, String microfilm_roll_number, int id, String code_number, String active, String in_collection, int number_of_fascicles, int number_of_digital_images, boolean complete, boolean has_colophon, boolean illustrated, boolean directly_digitised, String legibility, String condition, int location_id, int pntmp_title_id, String date_system, int number_of_folios, int year, JSONArray upload, JSONArray code, JSONArray province_th, JSONArray province_ro, JSONArray district_th, JSONArray district_ro, JSONArray address_th, JSONArray address_ro, JSONArray latitude, JSONArray longitude, boolean exact, JSONArray website, JSONArray manuscripts_count, JSONArray dlntm_title_id, JSONArray dlntm_label_th, JSONArray dlntm_label_ro, JSONArray alternative_title_id, JSONArray alternative_label_th, JSONArray alternative_label_ro, JSONArray label, JSONArray label_ro, JSONArray pntmp_label, String thai_remarks, String remarks, int ce_year, boolean in_private_collection, JSONArray category, JSONArray language, JSONArray material, JSONArray script, JSONArray category_th, JSONArray language_th, JSONArray material_th, JSONArray script_th) {
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
        this.microfilm_roll_number = microfilm_roll_number;
        this.id = id;
        this.code_number = code_number;
        this.active = active;
        this.in_collection = in_collection;
        this.number_of_fascicles = number_of_fascicles;
        this.number_of_digital_images = number_of_digital_images;
        this.complete = complete;
        this.has_colophon = has_colophon;
        this.illustrated = illustrated;
        this.directly_digitised = directly_digitised;
        this.legibility = legibility;
        this.condition = condition;
        this.location_id = location_id;
        this.pntmp_title_id = pntmp_title_id;
        this.date_system = date_system;
        this.number_of_folios = number_of_folios;
        this.year = year;
        this.upload = upload;
        this.code = code;
        this.province_th = province_th;
        this.province_ro = province_ro;
        this.district_th = district_th;
        this.district_ro = district_ro;
        this.address_th = address_th;
        this.address_ro = address_ro;
        this.latitude = latitude;
        this.longitude = longitude;
        this.exact = exact;
        this.website = website;
        this.manuscripts_count = manuscripts_count;
        this.dlntm_title_id = dlntm_title_id;
        this.dlntm_label_th = dlntm_label_th;
        this.dlntm_label_ro = dlntm_label_ro;
        this.alternative_title_id = alternative_title_id;
        this.alternative_label_th = alternative_label_th;
        this.alternative_label_ro = alternative_label_ro;
        this.label = label;
        this.label_ro = label_ro;
        this.pntmp_label = pntmp_label;
        this.thai_remarks = thai_remarks;
        this.remarks = remarks;
        this.ce_year = ce_year;
        this.in_private_collection = in_private_collection;
        this.category = category;
        this.language = language;
        this.material = material;
        this.script = script;
        this.category_th = category_th;
        this.language_th = language_th;
        this.material_th = material_th;
        this.script_th = script_th;
    }

    public String getMicrofilm_roll_number() {
        return microfilm_roll_number;
    }

    public void setMicrofilm_roll_number(String microfilm_roll_number) {
        this.microfilm_roll_number = microfilm_roll_number;
    }

    public DllmAttributes(String documents_id, String documents_code_number, String documents_roll, int documents_number_of_fascicles, int documents_number_of_folios, String extent, int locations_is_top_level, int locations_parent_parent_id, String locations_parent_parent_name, String full_location_name_lao, String locations_parent_parent_name_lao, String locations_parent_name_lao, String locations_parent_name, String full_location_name, String location_name, String location_name_lao, String documents_has_colophon, String documents_is_illustrated, String documents_is_color, String documents_bundle_id, int locations_id, int locations_parent_id, int documents_position_in_bundle, String documents_is_complete, int documents_pages_count, String description, String materials_name, String materials_name_lao, String location_types_name, String location_types_name_lao, int locations_lft, int locations_rgt, int locations_dllm_loc_code, double locations_gps_lat, double locations_gps_lon, JSONArray ancillary_terms_roman, JSONArray ancillary_terms_lao, String public_remarks_english, String public_remarks_lao, JSONArray categories_name, JSONArray categories_name_lao, JSONArray languages, JSONArray languages_lao, JSONArray scripts, JSONArray scripts_lao, JSONArray title_search_roman, JSONArray title_search_lao, JSONArray dllm_title_roman, JSONArray dllm_title_lao, JSONArray plmp_title_lao, int location_documents_count, String legibilities_name, String legibilities_name_lao, String conditions_name, String conditions_name_lao, String documents_preferred_date_system, String documents_preferred_date_system_lao, String documents_date_written, String date_original, String date_original_lao, JSONArray pages, int id, String code_number, String active, String in_collection, int number_of_fascicles, int number_of_digital_images, boolean complete, boolean has_colophon, boolean illustrated, boolean directly_digitised, String legibility, String condition, int location_id, int pntmp_title_id, String date_system, int number_of_folios, int year, JSONArray upload, JSONArray code, JSONArray province_th, JSONArray province_ro, JSONArray district_th, JSONArray district_ro, JSONArray address_th, JSONArray address_ro, JSONArray latitude, JSONArray longitude, boolean exact, JSONArray website, JSONArray manuscripts_count, JSONArray dlntm_title_id, JSONArray dlntm_label_th, JSONArray dlntm_label_ro, JSONArray alternative_title_id, JSONArray alternative_label_th, JSONArray alternative_label_ro, JSONArray label, JSONArray label_ro, JSONArray pntmp_label, String thai_remarks, String remarks, int ce_year, boolean in_private_collection, JSONArray category, JSONArray language, JSONArray material, JSONArray script, JSONArray category_th, JSONArray language_th, JSONArray material_th, JSONArray script_th) {
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
        this.id = id;
        this.code_number = code_number;
        this.active = active;
        this.in_collection = in_collection;
        this.number_of_fascicles = number_of_fascicles;
        this.number_of_digital_images = number_of_digital_images;
        this.complete = complete;
        this.has_colophon = has_colophon;
        this.illustrated = illustrated;
        this.directly_digitised = directly_digitised;
        this.legibility = legibility;
        this.condition = condition;
        this.location_id = location_id;
        this.pntmp_title_id = pntmp_title_id;
        this.date_system = date_system;
        this.number_of_folios = number_of_folios;
        this.year = year;
        this.upload = upload;
        this.code = code;
        this.province_th = province_th;
        this.province_ro = province_ro;
        this.district_th = district_th;
        this.district_ro = district_ro;
        this.address_th = address_th;
        this.address_ro = address_ro;
        this.latitude = latitude;
        this.longitude = longitude;
        this.exact = exact;
        this.website = website;
        this.manuscripts_count = manuscripts_count;
        this.dlntm_title_id = dlntm_title_id;
        this.dlntm_label_th = dlntm_label_th;
        this.dlntm_label_ro = dlntm_label_ro;
        this.alternative_title_id = alternative_title_id;
        this.alternative_label_th = alternative_label_th;
        this.alternative_label_ro = alternative_label_ro;
        this.label = label;
        this.label_ro = label_ro;
        this.pntmp_label = pntmp_label;
        this.thai_remarks = thai_remarks;
        this.remarks = remarks;
        this.ce_year = ce_year;
        this.in_private_collection = in_private_collection;
        this.category = category;
        this.language = language;
        this.material = material;
        this.script = script;
        this.category_th = category_th;
        this.language_th = language_th;
        this.material_th = material_th;
        this.script_th = script_th;
    }

    public String getLocations_parent_name() {
        return locations_parent_name;
    }

    public void setLocations_parent_name(String locations_parent_name) {
        this.locations_parent_name = locations_parent_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode_number() {
        return code_number;
    }

    public void setCode_number(String code_number) {
        this.code_number = code_number;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getIn_collection() {
        return in_collection;
    }

    public void setIn_collection(String in_collection) {
        this.in_collection = in_collection;
    }

    public int getNumber_of_fascicles() {
        return number_of_fascicles;
    }

    public void setNumber_of_fascicles(int number_of_fascicles) {
        this.number_of_fascicles = number_of_fascicles;
    }

    public int getNumber_of_digital_images() {
        return number_of_digital_images;
    }

    public void setNumber_of_digital_images(int number_of_digital_images) {
        this.number_of_digital_images = number_of_digital_images;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isHas_colophon() {
        return has_colophon;
    }

    public void setHas_colophon(boolean has_colophon) {
        this.has_colophon = has_colophon;
    }

    public boolean isIllustrated() {
        return illustrated;
    }

    public void setIllustrated(boolean illustrated) {
        this.illustrated = illustrated;
    }

    public boolean isDirectly_digitised() {
        return directly_digitised;
    }

    public void setDirectly_digitised(boolean directly_digitised) {
        this.directly_digitised = directly_digitised;
    }

    public String getLegibility() {
        return legibility;
    }

    public void setLegibility(String legibility) {
        this.legibility = legibility;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getPntmp_title_id() {
        return pntmp_title_id;
    }

    public void setPntmp_title_id(int pntmp_title_id) {
        this.pntmp_title_id = pntmp_title_id;
    }

    public String getDate_system() {
        return date_system;
    }

    public void setDate_system(String date_system) {
        this.date_system = date_system;
    }

    public int getNumber_of_folios() {
        return number_of_folios;
    }

    public void setNumber_of_folios(int number_of_folios) {
        this.number_of_folios = number_of_folios;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public JSONArray getUpload() {
        return upload;
    }

    public void setUpload(JSONArray upload) {
        this.upload = upload;
    }

    public JSONArray getCode() {
        return code;
    }

    public void setCode(JSONArray code) {
        this.code = code;
    }

    public JSONArray getProvince_th() {
        return province_th;
    }

    public void setProvince_th(JSONArray province_th) {
        this.province_th = province_th;
    }

    public JSONArray getProvince_ro() {
        return province_ro;
    }

    public void setProvince_ro(JSONArray province_ro) {
        this.province_ro = province_ro;
    }

    public JSONArray getDistrict_th() {
        return district_th;
    }

    public void setDistrict_th(JSONArray district_th) {
        this.district_th = district_th;
    }

    public JSONArray getDistrict_ro() {
        return district_ro;
    }

    public void setDistrict_ro(JSONArray district_ro) {
        this.district_ro = district_ro;
    }

    public JSONArray getAddress_th() {
        return address_th;
    }

    public void setAddress_th(JSONArray address_th) {
        this.address_th = address_th;
    }

    public JSONArray getAddress_ro() {
        return address_ro;
    }

    public void setAddress_ro(JSONArray address_ro) {
        this.address_ro = address_ro;
    }

    public JSONArray getLatitude() {
        return latitude;
    }

    public void setLatitude(JSONArray latitude) {
        this.latitude = latitude;
    }

    public JSONArray getLongitude() {
        return longitude;
    }

    public void setLongitude(JSONArray longitude) {
        this.longitude = longitude;
    }

    public boolean getExact() {
        return exact;
    }

    public void setExact(boolean exact) {
        this.exact = exact;
    }

    public JSONArray getWebsite() {
        return website;
    }

    public void setWebsite(JSONArray website) {
        this.website = website;
    }

    public JSONArray getManuscripts_count() {
        return manuscripts_count;
    }

    public void setManuscripts_count(JSONArray manuscripts_count) {
        this.manuscripts_count = manuscripts_count;
    }

    public JSONArray getDlntm_title_id() {
        return dlntm_title_id;
    }

    public void setDlntm_title_id(JSONArray dlntm_title_id) {
        this.dlntm_title_id = dlntm_title_id;
    }

    public JSONArray getDlntm_label_th() {
        return dlntm_label_th;
    }

    public void setDlntm_label_th(JSONArray dlntm_label_th) {
        this.dlntm_label_th = dlntm_label_th;
    }

    public JSONArray getDlntm_label_ro() {
        return dlntm_label_ro;
    }

    public void setDlntm_label_ro(JSONArray dlntm_label_ro) {
        this.dlntm_label_ro = dlntm_label_ro;
    }

    public JSONArray getAlternative_title_id() {
        return alternative_title_id;
    }

    public void setAlternative_title_id(JSONArray alternative_title_id) {
        this.alternative_title_id = alternative_title_id;
    }

    public JSONArray getAlternative_label_th() {
        return alternative_label_th;
    }

    public void setAlternative_label_th(JSONArray alternative_label_th) {
        this.alternative_label_th = alternative_label_th;
    }

    public JSONArray getAlternative_label_ro() {
        return alternative_label_ro;
    }

    public void setAlternative_label_ro(JSONArray alternative_label_ro) {
        this.alternative_label_ro = alternative_label_ro;
    }

    public JSONArray getLabel() {
        return label;
    }

    public void setLabel(JSONArray label) {
        this.label = label;
    }

    public JSONArray getLabel_ro() {
        return label_ro;
    }

    public void setLabel_ro(JSONArray label_ro) {
        this.label_ro = label_ro;
    }

    public JSONArray getPntmp_label() {
        return pntmp_label;
    }

    public void setPntmp_label(JSONArray pntmp_label) {
        this.pntmp_label = pntmp_label;
    }

    public String getThai_remarks() {
        return thai_remarks;
    }

    public void setThai_remarks(String thai_remarks) {
        this.thai_remarks = thai_remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getCe_year() {
        return ce_year;
    }

    public void setCe_year(int ce_year) {
        this.ce_year = ce_year;
    }

    public boolean isIn_private_collection() {
        return in_private_collection;
    }

    public void setIn_private_collection(boolean in_private_collection) {
        this.in_private_collection = in_private_collection;
    }

    public JSONArray getCategory() {
        return category;
    }

    public void setCategory(JSONArray category) {
        this.category = category;
    }

    public JSONArray getLanguage() {
        return language;
    }

    public void setLanguage(JSONArray language) {
        this.language = language;
    }

    public JSONArray getMaterial() {
        return material;
    }

    public void setMaterial(JSONArray material) {
        this.material = material;
    }

    public JSONArray getScript() {
        return script;
    }

    public void setScript(JSONArray script) {
        this.script = script;
    }

    public JSONArray getCategory_th() {
        return category_th;
    }

    public void setCategory_th(JSONArray category_th) {
        this.category_th = category_th;
    }

    public JSONArray getLanguage_th() {
        return language_th;
    }

    public void setLanguage_th(JSONArray language_th) {
        this.language_th = language_th;
    }

    public JSONArray getMaterial_th() {
        return material_th;
    }

    public void setMaterial_th(JSONArray material_th) {
        this.material_th = material_th;
    }

    public JSONArray getScript_th() {
        return script_th;
    }

    public void setScript_th(JSONArray script_th) {
        this.script_th = script_th;
    }

    public DllmAttributes(String documents_id, String documents_code_number, String documents_roll, int documents_number_of_fascicles, int documents_number_of_folios, String extent, int locations_is_top_level, int locations_parent_parent_id, String locations_parent_parent_name, String full_location_name_lao, String locations_parent_parent_name_lao, String locations_parent_name_lao, String locations_parent_name, String full_location_name, String location_name, String location_name_lao, String documents_has_colophon, String documents_is_illustrated, String documents_is_color, String documents_bundle_id, int locations_id, int locations_parent_id, int documents_position_in_bundle, String documents_is_complete, int documents_pages_count, String description, String materials_name, String materials_name_lao, String documents_private_remarks_en, String documents_private_remark_lo, String location_types_name, String location_types_name_lao, int locations_lft, int locations_rgt, int locations_dllm_loc_code, double locations_gps_lat, double locations_gps_lon, JSONArray ancillary_terms_roman, JSONArray ancillary_terms_lao, String public_remarks_english, String public_remarks_lao, JSONArray categories_name, JSONArray categories_name_lao, JSONArray languages, JSONArray languages_lao, JSONArray scripts, JSONArray scripts_lao, JSONArray title_search_roman, JSONArray title_search_lao, JSONArray dllm_title_roman, JSONArray dllm_title_lao, JSONArray plmp_title_lao, int location_documents_count, String legibilities_name, String legibilities_name_lao, String conditions_name, String conditions_name_lao, String documents_preferred_date_system, String documents_preferred_date_system_lao, String documents_date_written, String date_original, String date_original_lao, JSONArray pages) {
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
        //this.documents_private_remarks_en = documents_private_remarks_en;
        //this.documents_private_remark_lo = documents_private_remark_lo;
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

    public DllmAttributes(String documents_id, String documents_code_number, String documents_roll, int documents_number_of_fascicles, int documents_number_of_folios, String extent, int locations_is_top_level, int locations_parent_parent_id, String locations_parent_parent_name, String full_location_name_lao, String locations_parent_parent_name_lao, String locations_parent_name_lao, String full_location_name, String location_name, String location_name_lao, String documents_has_colophon, String documents_is_illustrated, String documents_is_color, String documents_bundle_id, int locations_id, int locations_parent_id, int documents_position_in_bundle, String documents_is_complete, int documents_pages_count, String description, String materials_name, String materials_name_lao, String documents_private_remarks_en, String documents_private_remark_lo, String location_types_name, String location_types_name_lao, int locations_lft, int locations_rgt, int locations_dllm_loc_code, double locations_gps_lat, double locations_gps_lon, JSONArray ancillary_terms_roman, JSONArray ancillary_terms_lao, String public_remarks_english, String public_remarks_lao, JSONArray categories_name, JSONArray categories_name_lao, JSONArray languages, JSONArray languages_lao, JSONArray scripts, JSONArray scripts_lao, JSONArray title_search_roman, JSONArray title_search_lao, JSONArray dllm_title_roman, JSONArray dllm_title_lao, JSONArray plmp_title_lao, int location_documents_count, String legibilities_name, String legibilities_name_lao, String conditions_name, String conditions_name_lao, String documents_preferred_date_system, String documents_preferred_date_system_lao, String documents_date_written, String date_original, String date_original_lao, JSONArray pages) {
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
        //this.documents_private_remarks_en = documents_private_remarks_en;
        //this.documents_private_remark_lo = documents_private_remark_lo;
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

    /*public String getDocuments_private_remarks_en() {
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
    }*/

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

    public JSONArray getAncillary_terms_roman() {
        return ancillary_terms_roman;
    }

    public void setAncillary_terms_roman(JSONArray ancillary_terms_roman) {
        this.ancillary_terms_roman = ancillary_terms_roman;
    }

    public JSONArray getAncillary_terms_lao() {
        return ancillary_terms_lao;
    }

    public void setAncillary_terms_lao(JSONArray ancillary_terms_lao) {
        this.ancillary_terms_lao = ancillary_terms_lao;
    }

    public String getPublic_remarks_english() {
        return public_remarks_english;
    }

    public void setPublic_remarks_english(String public_remarks_english) {
        this.public_remarks_english = public_remarks_english;
    }

    public String getPublic_remarks_lao() {
        return public_remarks_lao;
    }

    public void setPublic_remarks_lao(String public_remarks_lao) {
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
