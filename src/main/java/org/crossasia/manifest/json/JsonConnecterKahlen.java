package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.KahlenAttributes;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonConnecterKahlen {

    public static void dctermsPlace (KahlenAttributes kahlenAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:place")) {
                kahlenAttributes.setPlaces(JsonConverter.getStringList(jsonObj, "dcterms:place"));
        }
    }


    public static void schemaIndex (KahlenAttributes kahlenAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:index")) {
                kahlenAttributes.setIndexes(JsonConverter.getStringList(jsonObj, "schema:index"));
        }
    }

    public static void dctermsDate (KahlenAttributes kahlenAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:date")) {
            if (jsonObj.get("dcterms:date") instanceof String) {
                kahlenAttributes.setDate((String) jsonObj.get("dcterms:date"));
            }
        }
    }

    public static void dcTitle (KahlenAttributes kahlenAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:title")) {
            if (jsonObj.get("dc:title") instanceof String) {
                kahlenAttributes.setTitle((String) jsonObj.get("dc:title"));
            }
        }
    }

    public static void schemaKeyword (KahlenAttributes kahlenAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:keywords")) {
            if (jsonObj.get("schema:keywords") instanceof String) {
                kahlenAttributes.setKeyword((String) jsonObj.get("schema:keywords"));
            }
        }
    }

    public static void kahlenLabel (KahlenAttributes kahlenAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("kahlen:label")) {
            if (jsonObj.get("kahlen:label") instanceof String) {
                kahlenAttributes.setLabel((String) jsonObj.get("kahlen:label"));
            }
        }
    }

    public static void kahlenIdentifier (KahlenAttributes kahlenAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dc:identifier")) {
            if (jsonObj.get("dc:identifier") instanceof String) {
                kahlenAttributes.setIdentifier((String) jsonObj.get("dc:identifier"));
            }
        }
    }

    public static void dctermsSubject (KahlenAttributes kahlenAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:subject")) {
            kahlenAttributes.setSubjects(JsonConverter.getStringList( jsonObj, "dcterms:subject"));
        }
    }
}
