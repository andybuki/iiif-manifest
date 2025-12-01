package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.TapAttributes;
import org.crossasia.manifest.attributes.util.JsonConverter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.List;

/**
 * JSON connector for TAP collection.
 * Maps JSON fields to TapAttributes.
 */
public class JsonConnecterTap {

    public static void alternative(TapAttributes tapAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:alternative")) {
            if (jsonObj.get("schema:alternative") instanceof String) {
                tapAttributes.setAlternative((String) jsonObj.get("schema:alternative"));
            }
        }
    }

    public static void caption(TapAttributes tapAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:caption")) {
            if (jsonObj.get("schema:caption") instanceof String) {
                tapAttributes.setCaption((String) jsonObj.get("schema:caption"));
            }
        }
    }

    public static void label(TapAttributes tapAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:label")) {
            if (jsonObj.get("schema:label") instanceof String) {
                tapAttributes.setLabel((String) jsonObj.get("schema:label"));
            }
        }
    }

    // ========== List fields - use getStringList instead of getString ==========

    public static void organization(TapAttributes tapAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:organization")) {
            List<String> values = JsonConverter.getStringList(jsonObj, "schema:organization");
            if (values != null && !values.isEmpty()) {
                tapAttributes.setOrganization(values);
            }
        }
    }

    public static void people(TapAttributes tapAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:people")) {
            List<String> values = JsonConverter.getStringList(jsonObj, "schema:people");
            if (values != null && !values.isEmpty()) {
                tapAttributes.setPeople(values);
            }
        }
    }

    public static void keywords(TapAttributes tapAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("schema:keywords")) {
            List<String> values = JsonConverter.getStringList(jsonObj, "schema:keywords");
            if (values != null && !values.isEmpty()) {
                tapAttributes.setKeywords(values);
            }
        }
    }

    public static void subject(TapAttributes tapAttributes, @NotNull JSONObject jsonObj) {
        if (jsonObj.has("dcterms:subject")) {
            List<String> values = JsonConverter.getStringList(jsonObj, "dcterms:subject");
            if (values != null && !values.isEmpty()) {
                tapAttributes.setSubject(values);
            }
        }
    }
}