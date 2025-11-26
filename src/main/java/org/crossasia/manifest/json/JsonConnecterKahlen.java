package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.KahlenAttributes;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonConnecterKahlen {

    public static void dctermsPlace (KahlenAttributes kahlenAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:place")) {
            if (jsonObj.get("dcterms:place") instanceof String) {
                kahlenAttributes.setPlace((String) jsonObj.get("dcterms:place"));
            } else {
                kahlenAttributes.setPlaces((JSONArray) jsonObj.get("dcterms:place"));
            }
        }
    }

    public static void schemaIndex (KahlenAttributes kahlenAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:index")) {
            if (jsonObj.get("schema:index") instanceof String) {
                kahlenAttributes.setIndex((String) jsonObj.get("schema:index"));
            } else {
                kahlenAttributes.setIndexes((JSONArray) jsonObj.get("schema:index"));
            }
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
            if (jsonObj.get("dcterms:subject") instanceof String) {
                kahlenAttributes.setSubject((String) jsonObj.get("dcterms:subject"));
            } else {
                kahlenAttributes.setSubjects((JSONArray) jsonObj.get("dcterms:subject"));
            }
        }
    }


}
