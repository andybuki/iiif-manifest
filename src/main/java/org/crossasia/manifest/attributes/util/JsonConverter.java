package org.crossasia.manifest.attributes.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonConverter {

    /**
     * Converts JSONArray to List<String>
     * @param jsonArray the JSONArray to convert
     * @return List<String> or null if input is null
     */
    public static List<String> toStringList(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            Object value = jsonArray.get(i);
            list.add(value != null ? value.toString() : null);
        }
        return list;
    }

    /**
     * Converts List<String> to JSONArray
     * @param list the List to convert
     * @return JSONArray or null if input is null
     */
    public static JSONArray toJsonArray(List<String> list) {
        if (list == null) {
            return null;
        }

        JSONArray jsonArray = new JSONArray();
        for (String item : list) {
            jsonArray.put(item);
        }
        return jsonArray;
    }

    /**
     * Safely gets a string from JSONArray at index 0
     * @param jsonArray the JSONArray
     * @return first element as String or null
     */
    public static String getFirstElement(JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.length() == 0) {
            return null;
        }
        Object value = jsonArray.get(0);
        return value != null ? value.toString() : null;
    }

    /**
     * Safely gets a string value from JSONObject
     * Returns null if key doesn't exist
     * @param jsonObj the JSONObject
     * @param key the key to retrieve
     * @return String value or null
     */
    public static String getString(JSONObject jsonObj, String key) {
        if (!jsonObj.has(key)) {
            return null;
        }

        Object value = jsonObj.get(key);
        if (value == null) {
            return null;
        }

        if (value instanceof String) {
            return (String) value;
        }

        return value.toString();
    }

    /**
     * Safely gets a List<String> from JSONObject
     * Handles both JSONArray and single String values
     * Returns null if key doesn't exist
     * @param jsonObj the JSONObject
     * @param key the key to retrieve
     * @return List<String> or null
     */
    public static List<String> getStringList(JSONObject jsonObj, String key) {
        if (!jsonObj.has(key)) {
            return null;
        }

        Object value = jsonObj.get(key);
        if (value == null) {
            return null;
        }

        // If it's already a JSONArray, convert it
        if (value instanceof JSONArray) {
            return toStringList((JSONArray) value);
        }

        // If it's a single value, wrap it in a list
        List<String> list = new ArrayList<>();
        list.add(value.toString());
        return list;
    }

    /**
     * Safely gets an integer value from JSONObject
     * Returns null if key doesn't exist or value is not a number
     * @param jsonObj the JSONObject
     * @param key the key to retrieve
     * @return Integer value or null
     */
    public static Integer getInt(JSONObject jsonObj, String key) {
        if (!jsonObj.has(key)) {
            return null;
        }

        try {
            return jsonObj.getInt(key);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Safely gets a boolean value from JSONObject
     * Returns null if key doesn't exist
     * @param jsonObj the JSONObject
     * @param key the key to retrieve
     * @return Boolean value or null
     */
    public static Boolean getBoolean(JSONObject jsonObj, String key) {
        if (!jsonObj.has(key)) {
            return null;
        }

        try {
            return jsonObj.getBoolean(key);
        } catch (Exception e) {
            return null;
        }
    }
}