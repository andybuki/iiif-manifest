package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.*;
import org.crossasia.manifest.attributes.util.JsonConverter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class JsonConnecterSugawara {

    public static void modsPhysicalLocation(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("mods:physicalLocation")) {
            sugawaraAttributes.setPhysicalLocation(JsonConverter.getString(jsonObj, "mods:physicalLocation"));
        }
    }

    public static void sugawaraFolder(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:folder")) {
            sugawaraAttributes.setFolder(JsonConverter.getString(jsonObj, "sugawara:folder"));
        }
    }

    public static void schemaCategory(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:category")) {
            sugawaraAttributes.setCategory(JsonConverter.getString(jsonObj, "schema:category"));
        }
    }

    public static void dctermsSubject(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:subject")) {
            sugawaraAttributes.setSubjects(JsonConverter.getStringList(jsonObj, "dcterms:subject"));
        }
    }

    public static void dctermsDescription(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:description")) {
            sugawaraAttributes.setDescriptions(JsonConverter.getStringList(jsonObj, "dcterms:description"));
        }
    }

    public static void sugawaraPhysicaldata(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:physicaldata")) {
            sugawaraAttributes.setPhysicalData(JsonConverter.getString(jsonObj, "sugawara:physicaldata"));
        }
    }

    public static void sugawaraPhystype(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:phystype")) {
            sugawaraAttributes.setPhysicalType(JsonConverter.getString(jsonObj, "sugawara:phystype"));
        }
    }

    public static void sugawaraTaxStamp(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:taxStamp")) {
            sugawaraAttributes.setTaxStamps(JsonConverter.getStringList(jsonObj, "sugawara:taxStamp"));
        }
    }

    public static void sugawaraDocument(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:document")) {
            sugawaraAttributes.setDocument(JsonConverter.getString(jsonObj, "sugawara:document"));
        }
    }

    public static void crossasiaDateOriginal(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:dateOriginal")) {
            DateInfo dateInfo = sugawaraAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                sugawaraAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setDateOriginal(JsonConverter.getString(jsonObj, "crossasia:dateOriginal"));
        }
    }

    public static void crossasiaYearOriginal(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:yearOriginal")) {
            DateInfo dateInfo = sugawaraAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                sugawaraAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setYearOriginal(JsonConverter.getString(jsonObj, "crossasia:yearOriginal"));
        }
    }

    public static void sugawaraHijuriYear(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:hijuriYear")) {
            DateInfo dateInfo = sugawaraAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                sugawaraAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setHijriYear(JsonConverter.getString(jsonObj, "sugawara:hijuriYear"));
        }
    }

    public static void sugawaraHijuriMonth(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:hijuriMonth")) {
            DateInfo dateInfo = sugawaraAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                sugawaraAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setHijriMonth(JsonConverter.getString(jsonObj, "sugawara:hijuriMonth"));
        }
    }

    public static void sugawaraDow(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:dow")) {
            DateInfo dateInfo = sugawaraAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                sugawaraAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setDayOfWeek(JsonConverter.getString(jsonObj, "sugawara:dow"));
        }
    }

    public static void crossasiaWholedate(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:wholedate")) {
            DateInfo dateInfo = sugawaraAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                sugawaraAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setWholeDate(JsonConverter.getString(jsonObj, "crossasia:wholedate"));
        }
    }

    public static void crossasiaAdminlevel1(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:adminlevel1")) {
            PlaceInfo placeInfo = sugawaraAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                sugawaraAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setAdminLevel1(JsonConverter.getString(jsonObj, "crossasia:adminlevel1"));
        }
    }

    public static void crossasiaAdminlevel2(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:adminlevel2")) {
            PlaceInfo placeInfo = sugawaraAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                sugawaraAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setAdminLevel2(JsonConverter.getString(jsonObj, "crossasia:adminlevel2"));
        }
    }

    public static void crossasiaPlaceType2(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:placeType2")) {
            PlaceInfo placeInfo = sugawaraAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                sugawaraAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setPlaceType2(JsonConverter.getString(jsonObj, "crossasia:placeType2"));
        }
    }

    public static void crossasiaPlaceType3(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:placeType3")) {
            PlaceInfo placeInfo = sugawaraAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                sugawaraAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setPlaceType3(JsonConverter.getString(jsonObj, "crossasia:placeType3"));
        }
    }

    public static void sugawaraPlace(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:place")) {
            PlaceInfo placeInfo = sugawaraAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                sugawaraAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setPlaces(JsonConverter.getStringList(jsonObj, "sugawara:place"));
        }
    }

    public static void sugawaraPersonRoleA(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:personRoleA")) {
            PersonRole roleA = sugawaraAttributes.getRoleA();
            if (roleA == null) {
                roleA = new PersonRole();
                sugawaraAttributes.setRoleA(roleA);
            }
            roleA.setPersonNames(JsonConverter.getStringList(jsonObj, "sugawara:personRoleA"));
        }
    }

    public static void sugawaraRoleA(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:RoleA")) {
            PersonRole roleA = sugawaraAttributes.getRoleA();
            if (roleA == null) {
                roleA = new PersonRole();
                sugawaraAttributes.setRoleA(roleA);
            }
            roleA.setRole(JsonConverter.getString(jsonObj, "sugawara:RoleA"));
        }
    }

    public static void schemaPersonRoleB(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:personRoleB")) {
            PersonRole roleB = sugawaraAttributes.getRoleB();
            if (roleB == null) {
                roleB = new PersonRole();
                sugawaraAttributes.setRoleB(roleB);
            }
            roleB.setPersonNames(JsonConverter.getStringList(jsonObj, "schema:personRoleB"));
        }
    }

    public static void sugawaraRoleB(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:RoleB")) {
            PersonRole roleB = sugawaraAttributes.getRoleB();
            if (roleB == null) {
                roleB = new PersonRole();
                sugawaraAttributes.setRoleB(roleB);
            }
            roleB.setRole(JsonConverter.getString(jsonObj, "sugawara:RoleB"));
        }
    }

    public static void sugawaraSeal(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("sugawara:seal")) {
            SealInfo sealInfo = sugawaraAttributes.getSealInfo();
            if (sealInfo == null) {
                sealInfo = new SealInfo();
                sugawaraAttributes.setSealInfo(sealInfo);
            }
            sealInfo.setSeals(JsonConverter.getStringList(jsonObj, "sugawara:seal"));
        }
    }

    public static void dctermsLanguage(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:language")) {
            ScriptInfo scriptInfo = sugawaraAttributes.getScriptInfo();
            if (scriptInfo == null) {
                scriptInfo = new ScriptInfo();
                sugawaraAttributes.setScriptInfo(scriptInfo);
            }
            scriptInfo.setLanguages(JsonConverter.getStringList(jsonObj, "dcterms:language"));
        }
    }

    public static void crossasiaLanguage(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("crossasia:language")) {
            ScriptInfo scriptInfo = sugawaraAttributes.getScriptInfo();
            if (scriptInfo == null) {
                scriptInfo = new ScriptInfo();
                sugawaraAttributes.setScriptInfo(scriptInfo);
            }
            // Store crossasia language separately or merge with languages list
            // For now, adding to the same languages list
            scriptInfo.setLanguages(JsonConverter.getStringList(jsonObj, "crossasia:language"));
        }
    }

    public static void place(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:place")) {
            PlaceInfo placeInfo = sugawaraAttributes.getPlaceInfo();
            if (placeInfo == null) {
                placeInfo = new PlaceInfo();
                sugawaraAttributes.setPlaceInfo(placeInfo);
            }
            placeInfo.setPlaces(JsonConverter.getStringList(jsonObj, "dc:place"));
        }
    }

    public static void date(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:date")) {
            DateInfo dateInfo = sugawaraAttributes.getDateInfo();
            if (dateInfo == null) {
                dateInfo = new DateInfo();
                sugawaraAttributes.setDateInfo(dateInfo);
            }
            dateInfo.setDates(JsonConverter.getStringList(jsonObj, "dc:date"));
        }
    }

    public static void dcDescription(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:description")) {
            sugawaraAttributes.setDescription(JsonConverter.getString(jsonObj, "dc:description"));
        }
    }

    public static void dctermsIdentifier(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:identifier")) {
            sugawaraAttributes.setIdentifier(JsonConverter.getString(jsonObj, "dcterms:identifier"));
        }
    }

    public static void schemaCitation(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:citation")) {
            sugawaraAttributes.setCitation(JsonConverter.getString(jsonObj, "schema:citation"));
        }
    }

    public static void schemaGrant(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:grant")) {
            sugawaraAttributes.setGrant(JsonConverter.getString(jsonObj, "schema:grant"));
        }
    }

    public static void schemaAbstract(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:abstract")) {
            sugawaraAttributes.setAbstractText(JsonConverter.getString(jsonObj, "schema:abstract"));
        }
    }

    public static void dctermsExtent(SugawaraAttributes sugawaraAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:extent")) {
            sugawaraAttributes.setExtent(JsonConverter.getString(jsonObj, "dcterms:extent"));
        }
    }
}