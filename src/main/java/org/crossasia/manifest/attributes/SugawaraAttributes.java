package org.crossasia.manifest.attributes;

import org.json.JSONArray;

public class SugawaraAttributes extends CollectionAttributes{

    String dcterms_identifier ="";
    String mods_physicalLocation="";
    String sugawara_folder="";
    String schema_category="";
    String dcterms_subject="";
    JSONArray dcterms_subjects = null;
    String dcterms_description="";

    String dc_place="";
    JSONArray dc_places = null;

    String dc_date="";

    JSONArray dc_dates = null;

    JSONArray dcterms_descriptions = null;
    String sugawara_physicaldata="";
    String sugawara_phystype="";
    String sugawara_taxStamp="";
    JSONArray sugawara_taxStamps = null;
    String sugawara_document="";
    String crossasia_dateOriginal="";
    String crossasia_yearOriginal="";
    String sugawara_hijuriYear="";
    String sugawara_hijuriMonth="";
    String sugawara_dow="";
    String crossasia_wholedate="";
    String crossasia_adminlevel1="";
    String crossasia_adminlevel2="";
    String crossasia_placeType2="";
    String crossasia_placeType3="";
    String sugawara_place="";

    JSONArray sugawara_places = null;
    String sugawara_personRoleA="";
    JSONArray sugawara_personRolesA = null;
    String sugawara_RoleA="";
    String schema_personRoleB="";
    JSONArray schema_personRolesB = null;
    String sugawara_RoleB="";
    String sugawara_seal="";
    JSONArray sugawara_seals = null;
    String dcterms_language="";
    JSONArray dcterms_languages = null;
    String crossasia_language="";
    JSONArray crossasia_languages = null;
    String dc_description="";
    String schema_citation="";
    String schema_grant="";
    String dcterms_extent="";

    public SugawaraAttributes() {}

    public SugawaraAttributes(String id, String title, JSONArray date, JSONArray keyword, JSONArray place, JSONArray seeAlso, JSONArray invnumber, JSONArray collection, String placeDetail, JSONArray dsrLink, JSONArray siteNameGer, JSONArray siteID, String placeDetail2, JSONArray type, JSONArray objId, String identifier, String rechercheLink, String langeBeschreibung, JSONArray georgBezug, String description, JSONArray descriptions, String noteDate, String noteIdentifier, String comment, String creator, String noteCreator, String format, String source, String creditText, JSONArray schemaIdentifier, String requirements, String dcterms_identifier, String mods_physicalLocation, String sugawara_folder, String schema_category, String dcterms_subject, JSONArray dcterms_subjects, String dcterms_description, String dc_place, JSONArray dc_places, String dc_date, JSONArray dc_dates, JSONArray dcterms_descriptions, String sugawara_physicaldata, String sugawara_phystype, String sugawara_taxStamp, JSONArray sugawara_taxStamps, String sugawara_document, String crossasia_dateOriginal, String crossasia_yearOriginal, String sugawara_hijuriYear, String sugawara_hijuriMonth, String sugawara_dow, String crossasia_wholedate, String crossasia_adminlevel1, String crossasia_adminlevel2, String crossasia_placeType2, String crossasia_placeType3, String sugawara_place, JSONArray sugawara_places, String sugawara_personRoleA, JSONArray sugawara_personRolesA, String sugawara_RoleA, String schema_personRoleB, JSONArray schema_personRolesB, String sugawara_RoleB, String sugawara_seal, JSONArray sugawara_seals, String dcterms_language, JSONArray dcterms_languages, String crossasia_language, JSONArray crossasia_languages, String dc_description, String schema_citation, String schema_grant, String dcterms_extent) {
        super(id, title, date, keyword, place, seeAlso, invnumber, collection, placeDetail, dsrLink, siteNameGer, siteID, placeDetail2, type, objId, identifier, rechercheLink, langeBeschreibung, georgBezug, description, descriptions, noteDate, noteIdentifier, comment, creator, noteCreator, format, source, creditText, schemaIdentifier, requirements);
        this.dcterms_identifier = dcterms_identifier;
        this.mods_physicalLocation = mods_physicalLocation;
        this.sugawara_folder = sugawara_folder;
        this.schema_category = schema_category;
        this.dcterms_subject = dcterms_subject;
        this.dcterms_subjects = dcterms_subjects;
        this.dcterms_description = dcterms_description;
        this.dc_place = dc_place;
        this.dc_places = dc_places;
        this.dc_date = dc_date;
        this.dc_dates = dc_dates;
        this.dcterms_descriptions = dcterms_descriptions;
        this.sugawara_physicaldata = sugawara_physicaldata;
        this.sugawara_phystype = sugawara_phystype;
        this.sugawara_taxStamp = sugawara_taxStamp;
        this.sugawara_taxStamps = sugawara_taxStamps;
        this.sugawara_document = sugawara_document;
        this.crossasia_dateOriginal = crossasia_dateOriginal;
        this.crossasia_yearOriginal = crossasia_yearOriginal;
        this.sugawara_hijuriYear = sugawara_hijuriYear;
        this.sugawara_hijuriMonth = sugawara_hijuriMonth;
        this.sugawara_dow = sugawara_dow;
        this.crossasia_wholedate = crossasia_wholedate;
        this.crossasia_adminlevel1 = crossasia_adminlevel1;
        this.crossasia_adminlevel2 = crossasia_adminlevel2;
        this.crossasia_placeType2 = crossasia_placeType2;
        this.crossasia_placeType3 = crossasia_placeType3;
        this.sugawara_place = sugawara_place;
        this.sugawara_places = sugawara_places;
        this.sugawara_personRoleA = sugawara_personRoleA;
        this.sugawara_personRolesA = sugawara_personRolesA;
        this.sugawara_RoleA = sugawara_RoleA;
        this.schema_personRoleB = schema_personRoleB;
        this.schema_personRolesB = schema_personRolesB;
        this.sugawara_RoleB = sugawara_RoleB;
        this.sugawara_seal = sugawara_seal;
        this.sugawara_seals = sugawara_seals;
        this.dcterms_language = dcterms_language;
        this.dcterms_languages = dcterms_languages;
        this.crossasia_language = crossasia_language;
        this.crossasia_languages = crossasia_languages;
        this.dc_description = dc_description;
        this.schema_citation = schema_citation;
        this.schema_grant = schema_grant;
        this.dcterms_extent = dcterms_extent;
    }

    public String getDc_place() {
        return dc_place;
    }

    public void setDc_place(String dc_place) {
        this.dc_place = dc_place;
    }

    public JSONArray getDc_places() {
        return dc_places;
    }

    public void setDc_places(JSONArray dc_places) {
        this.dc_places = dc_places;
    }

    public String getDc_date() {
        return dc_date;
    }

    public void setDc_date(String dc_date) {
        this.dc_date = dc_date;
    }

    public JSONArray getDc_dates() {
        return dc_dates;
    }

    public void setDc_dates(JSONArray dc_dates) {
        this.dc_dates = dc_dates;
    }

    public JSONArray getSugawara_places() {
        return sugawara_places;
    }

    public void setSugawara_places(JSONArray sugawara_places) {
        this.sugawara_places = sugawara_places;
    }

    public JSONArray getDcterms_subjects() {
        return dcterms_subjects;
    }

    public void setDcterms_subjects(JSONArray dcterms_subjects) {
        this.dcterms_subjects = dcterms_subjects;
    }

    public JSONArray getSugawara_taxStamps() {
        return sugawara_taxStamps;
    }

    public void setSugawara_taxStamps(JSONArray sugawara_taxStamps) {
        this.sugawara_taxStamps = sugawara_taxStamps;
    }

    public JSONArray getSchema_personRolesB() {
        return schema_personRolesB;
    }

    public void setSchema_personRolesB(JSONArray schema_personRolesB) {
        this.schema_personRolesB = schema_personRolesB;
    }

    public JSONArray getSugawara_seals() {
        return sugawara_seals;
    }

    public void setSugawara_seals(JSONArray sugawara_seals) {
        this.sugawara_seals = sugawara_seals;
    }

    public JSONArray getCrossasia_languages() {
        return crossasia_languages;
    }

    public void setCrossasia_languages(JSONArray crossasia_languages) {
        this.crossasia_languages = crossasia_languages;
    }

    public JSONArray getDcterms_languages() {
        return dcterms_languages;
    }

    public void setDcterms_languages(JSONArray dcterms_languages) {
        this.dcterms_languages = dcterms_languages;
    }

    public JSONArray getSugawara_personRolesA() {
        return sugawara_personRolesA;
    }

    public void setSugawara_personRolesA(JSONArray sugawara_personRolesA) {
        this.sugawara_personRolesA = sugawara_personRolesA;
    }

    public JSONArray getDcterms_descriptions() {
        return dcterms_descriptions;
    }

    public void setDcterms_descriptions(JSONArray dcterms_descriptions) {
        this.dcterms_descriptions = dcterms_descriptions;
    }

    public String getDcterms_identifier() {
        return dcterms_identifier;
    }

    public void setDcterms_identifier(String dcterms_identifier) {
        this.dcterms_identifier = dcterms_identifier;
    }

    public String getMods_physicalLocation() {
        return mods_physicalLocation;
    }

    public void setMods_physicalLocation(String mods_physicalLocation) {
        this.mods_physicalLocation = mods_physicalLocation;
    }

    public String getSugawara_folder() {
        return sugawara_folder;
    }

    public void setSugawara_folder(String sugawara_folder) {
        this.sugawara_folder = sugawara_folder;
    }

    public String getSchema_category() {
        return schema_category;
    }

    public void setSchema_category(String schema_category) {
        this.schema_category = schema_category;
    }

    public String getDcterms_subject() {
        return dcterms_subject;
    }

    public void setDcterms_subject(String dcterms_subject) {
        this.dcterms_subject = dcterms_subject;
    }

    public String getDcterms_description() {
        return dcterms_description;
    }

    public void setDcterms_description(String dcterms_description) {
        this.dcterms_description = dcterms_description;
    }

    public String getSugawara_physicaldata() {
        return sugawara_physicaldata;
    }

    public void setSugawara_physicaldata(String sugawara_physicaldata) {
        this.sugawara_physicaldata = sugawara_physicaldata;
    }

    public String getSugawara_phystype() {
        return sugawara_phystype;
    }

    public void setSugawara_phystype(String sugawara_phystype) {
        this.sugawara_phystype = sugawara_phystype;
    }

    public String getSugawara_taxStamp() {
        return sugawara_taxStamp;
    }

    public void setSugawara_taxStamp(String sugawara_taxStamp) {
        this.sugawara_taxStamp = sugawara_taxStamp;
    }

    public String getSugawara_document() {
        return sugawara_document;
    }

    public void setSugawara_document(String sugawara_document) {
        this.sugawara_document = sugawara_document;
    }

    public String getCrossasia_dateOriginal() {
        return crossasia_dateOriginal;
    }

    public void setCrossasia_dateOriginal(String crossasia_dateOriginal) {
        this.crossasia_dateOriginal = crossasia_dateOriginal;
    }

    public String getCrossasia_yearOriginal() {
        return crossasia_yearOriginal;
    }

    public void setCrossasia_yearOriginal(String crossasia_yearOriginal) {
        this.crossasia_yearOriginal = crossasia_yearOriginal;
    }

    public String getSugawara_hijuriYear() {
        return sugawara_hijuriYear;
    }

    public void setSugawara_hijuriYear(String sugawara_hijuriYear) {
        this.sugawara_hijuriYear = sugawara_hijuriYear;
    }

    public String getSugawara_hijuriMonth() {
        return sugawara_hijuriMonth;
    }

    public void setSugawara_hijuriMonth(String sugawara_hijuriMonth) {
        this.sugawara_hijuriMonth = sugawara_hijuriMonth;
    }

    public String getSugawara_dow() {
        return sugawara_dow;
    }

    public void setSugawara_dow(String sugawara_dow) {
        this.sugawara_dow = sugawara_dow;
    }

    public String getCrossasia_wholedate() {
        return crossasia_wholedate;
    }

    public void setCrossasia_wholedate(String crossasia_wholedate) {
        this.crossasia_wholedate = crossasia_wholedate;
    }

    public String getCrossasia_adminlevel1() {
        return crossasia_adminlevel1;
    }

    public void setCrossasia_adminlevel1(String crossasia_adminlevel1) {
        this.crossasia_adminlevel1 = crossasia_adminlevel1;
    }

    public String getCrossasia_adminlevel2() {
        return crossasia_adminlevel2;
    }

    public void setCrossasia_adminlevel2(String crossasia_adminlevel2) {
        this.crossasia_adminlevel2 = crossasia_adminlevel2;
    }

    public String getCrossasia_placeType2() {
        return crossasia_placeType2;
    }

    public void setCrossasia_placeType2(String crossasia_placeType2) {
        this.crossasia_placeType2 = crossasia_placeType2;
    }

    public String getCrossasia_placeType3() {
        return crossasia_placeType3;
    }

    public void setCrossasia_placeType3(String crossasia_placeType3) {
        this.crossasia_placeType3 = crossasia_placeType3;
    }

    public String getSugawara_place() {
        return sugawara_place;
    }

    public void setSugawara_place(String sugawara_place) {
        this.sugawara_place = sugawara_place;
    }

    public String getSugawara_personRoleA() {
        return sugawara_personRoleA;
    }

    public void setSugawara_personRoleA(String sugawara_personRoleA) {
        this.sugawara_personRoleA = sugawara_personRoleA;
    }

    public String getSugawara_RoleA() {
        return sugawara_RoleA;
    }

    public void setSugawara_RoleA(String sugawara_RoleA) {
        this.sugawara_RoleA = sugawara_RoleA;
    }

    public String getSchema_personRoleB() {
        return schema_personRoleB;
    }

    public void setSchema_personRoleB(String schema_personRoleB) {
        this.schema_personRoleB = schema_personRoleB;
    }

    public String getSugawara_RoleB() {
        return sugawara_RoleB;
    }

    public void setSugawara_RoleB(String sugawara_RoleB) {
        this.sugawara_RoleB = sugawara_RoleB;
    }

    public String getSugawara_seal() {
        return sugawara_seal;
    }

    public void setSugawara_seal(String sugawara_seal) {
        this.sugawara_seal = sugawara_seal;
    }

    public String getDcterms_language() {
        return dcterms_language;
    }

    public void setDcterms_language(String dcterms_language) {
        this.dcterms_language = dcterms_language;
    }

    public String getCrossasia_language() {
        return crossasia_language;
    }

    public void setCrossasia_language(String crossasia_language) {
        this.crossasia_language = crossasia_language;
    }

    public String getDc_description() {
        return dc_description;
    }

    public void setDc_description(String dc_description) {
        this.dc_description = dc_description;
    }

    public String getSchema_citation() {
        return schema_citation;
    }

    public void setSchema_citation(String schema_citation) {
        this.schema_citation = schema_citation;
    }

    public String getSchema_grant() {
        return schema_grant;
    }

    public void setSchema_grant(String schema_grant) {
        this.schema_grant = schema_grant;
    }

    public String getDcterms_extent() {
        return dcterms_extent;
    }

    public void setDcterms_extent(String dcterms_extent) {
        this.dcterms_extent = dcterms_extent;
    }
}
