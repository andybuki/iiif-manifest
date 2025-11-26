package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonConnecterSugawara {

    public static void modsPhysicalLocation (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("mods:physicalLocation")) {
            sugawaraAttributes.setMods_physicalLocation((String) jsonObj.get("mods:physicalLocation"));
            sugawaraAttributes.
        }
    }
    public static void sugawaraFolder (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:folder")) {
            sugawaraAttributes.setSugawara_folder((String) jsonObj.get("sugawara:folder"));
        }
    }
    public static void schemaCategory (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:category")) {
            sugawaraAttributes.setSchema_category((String) jsonObj.get("schema:category"));

        }
    }
    public static void dctermsSubject (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:subject")) {
            if (jsonObj.get("dcterms:subject") instanceof String)
                sugawaraAttributes.setDcterms_subject((String) jsonObj.get("dcterms:subject"));
            else
                sugawaraAttributes.setDcterms_subjects((JSONArray) jsonObj.get("dcterms:subject"));
        }
    }
    public static void dctermsDescription (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:description")) {
            if (jsonObj.get("dcterms:description") instanceof String)
                sugawaraAttributes.setDcterms_description((String) jsonObj.get("dcterms:description"));
            else
                sugawaraAttributes.setDcterms_descriptions((JSONArray) jsonObj.get("dcterms:description"));

        }
    }
    public static void sugawaraPhysicaldata (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:physicaldata")) {
            sugawaraAttributes.setSugawara_physicaldata((String) jsonObj.get("sugawara:physicaldata"));
        }
    }
    public static void sugawaraPhystype (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:phystype")) {
            sugawaraAttributes.setSugawara_phystype((String) jsonObj.get("sugawara:phystype"));
        }
    }
    public static void sugawaraTaxStamp (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:taxStamp")) {
            if (jsonObj.get("sugawara:taxStamp") instanceof String)
                sugawaraAttributes.setSugawara_taxStamp((String) jsonObj.get("sugawara:taxStamp"));
            else
                sugawaraAttributes.setSugawara_taxStamps((JSONArray) jsonObj.get("sugawara:taxStamp"));
        }
    }
    public static void sugawaraDocument (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:document")) {
            sugawaraAttributes.setSugawara_document((String) jsonObj.get("sugawara:document"));
        }
    }
    public static void crossasiaDateOriginal (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:dateOriginal")) {
            sugawaraAttributes.setCrossasia_dateOriginal((String) jsonObj.get("crossasia:dateOriginal"));
        }
    }
    public static void crossasiaYearOriginal (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:yearOriginal")) {
            sugawaraAttributes.setCrossasia_yearOriginal((String) jsonObj.get("crossasia:yearOriginal"));
        }
    }
    public static void sugawaraHijuriYear (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:hijuriYear")) {
            sugawaraAttributes.setSugawara_hijuriYear((String) jsonObj.get("sugawara:hijuriYear"));
        }
    }
    public static void sugawaraHijuriMonth (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:hijuriMonth")) {
            sugawaraAttributes.setSugawara_hijuriMonth((String) jsonObj.get("sugawara:hijuriMonth"));
        }
    }
    public static void sugawaraDow (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:dow")) {
            sugawaraAttributes.setSugawara_dow((String) jsonObj.get("sugawara:dow"));
        }
    }
    public static void crossasiaWholedate (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:wholedate")) {
            sugawaraAttributes.setCrossasia_wholedate((String) jsonObj.get("crossasia:wholedate"));
        }
    }
    public static void crossasiaAdminlevel1 (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:adminlevel1")) {
            sugawaraAttributes.setCrossasia_adminlevel1((String) jsonObj.get("crossasia:adminlevel1"));
        }
    }
    public static void crossasiaAdminlevel2 (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:adminlevel2")) {
            sugawaraAttributes.setCrossasia_adminlevel2((String) jsonObj.get("crossasia:adminlevel2"));
        }
    }
    public static void crossasiaPlaceType2 (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:placeType2")) {
            sugawaraAttributes.setCrossasia_placeType2((String) jsonObj.get("crossasia:placeType2"));
        }
    }
    public static void crossasiaPlaceType3 (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:placeType3")) {
            sugawaraAttributes.setCrossasia_placeType3((String) jsonObj.get("crossasia:placeType3"));
        }
    }
    public static void sugawaraPlace (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:place")) {
            if (jsonObj.get("sugawara:place") instanceof String)
                sugawaraAttributes.setSugawara_place((String) jsonObj.get("sugawara:place"));
            else
                sugawaraAttributes.setSugawara_places((JSONArray) jsonObj.get("sugawara:place"));
        }
    }
    public static void sugawaraPersonRoleA (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:personRoleA")) {
            if (jsonObj.get("sugawara:personRoleA") instanceof String)
                sugawaraAttributes.setSugawara_personRoleA((String) jsonObj.get("sugawara:personRoleA"));
            else
                sugawaraAttributes.setSugawara_personRolesA((JSONArray) jsonObj.get("sugawara:personRoleA"));
        }
    }
    public static void sugawaraRoleA (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:RoleA")) {
            sugawaraAttributes.setSugawara_RoleA((String) jsonObj.get("sugawara:RoleA"));
        }
    }

    public static void schemaPersonRoleB (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:personRoleB")) {
            if (jsonObj.get("schema:personRoleB") instanceof String)
                sugawaraAttributes.setSchema_personRoleB((String) jsonObj.get("schema:personRoleB"));
            else
                sugawaraAttributes.setSchema_personRolesB((JSONArray) jsonObj.get("schema:personRoleB"));
        }
    }
    public static void sugawaraRoleB (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:RoleB")) {
            sugawaraAttributes.setSugawara_RoleB((String) jsonObj.get("sugawara:RoleB"));
        }
    }
    public static void sugawaraSeal (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:seal")) {
            if (jsonObj.get("sugawara:seal") instanceof String)
                sugawaraAttributes.setSugawara_seal((String) jsonObj.get("sugawara:seal"));
            else
                sugawaraAttributes.setSugawara_seals((JSONArray) jsonObj.get("sugawara:seal"));
        }
    }
    public static void dctermsLanguage (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:language")) {
            if (jsonObj.get("dcterms:language") instanceof String)
                sugawaraAttributes.setDcterms_language((String) jsonObj.get("dcterms:language"));
            else
                sugawaraAttributes.setDcterms_languages((JSONArray) jsonObj.get("dcterms:language"));
        }
    }

    public static void crossasiaLanguage (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:language")) {
            if (jsonObj.get("crossasia:language") instanceof String)
                sugawaraAttributes.setCrossasia_language((String) jsonObj.get("crossasia:language"));
            else
                sugawaraAttributes.setCrossasia_languages((JSONArray) jsonObj.get("crossasia:language"));
        }
    }

    public static void place (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:place")) {
            if (jsonObj.get("dc:place") instanceof String)
                sugawaraAttributes.setDc_place((String) jsonObj.get("dc:place"));
            else
                sugawaraAttributes.setDc_places((JSONArray) jsonObj.get("dc:place"));
        }
    }

    public static void date (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:date")) {
            if (jsonObj.get("dc:date") instanceof String)
                sugawaraAttributes.setDc_date((String) jsonObj.get("dc:date"));
            else
                sugawaraAttributes.setDc_dates((JSONArray) jsonObj.get("dc:date"));
        }
    }



    public static void dcDescription (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:description")) {
            sugawaraAttributes.setDc_description((String) jsonObj.get("dc:description"));
        }
    }

    public static void dctermsIdentifier (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:identifier")) {
            sugawaraAttributes.setDcterms_identifier((String) jsonObj.get("dcterms:identifier"));
        }
    }

    public static void schemaCitation (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:citation")) {
            sugawaraAttributes.setSchema_citation((String) jsonObj.get("schema:citation"));
        }
    }
    public static void schemaGrant (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:grant")) {
            sugawaraAttributes.setSchema_grant((String) jsonObj.get("schema:grant"));
        }
    }

    public static void schemaAbstract (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:abstract")) {
            sugawaraAttributes.setSchema_abstract((String) jsonObj.get("schema:abstract"));
        }
    }
    public static void dctermsExtent (SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:extent")) {
            sugawaraAttributes.setDcterms_extent((String) jsonObj.get("dcterms:extent"));
        }
    }

}
