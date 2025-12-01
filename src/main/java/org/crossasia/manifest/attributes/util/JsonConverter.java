package org.crossasia.manifest.attributes.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for converting JSON values to Java types.
 * Handles both single values and arrays transparently.
 */
public class JsonConverter {

    /**
     * Get a String value from JSON object.
     * Returns null if not found or not a String.
     */
    public static String getString(JSONObject jsonObj, String key) {
        if (!jsonObj.has(key)) {
            return null;
        }
        Object value = jsonObj.get(key);
        if (value instanceof String) {
            return (String) value;
        }
        // If it's an array, return the first element
        if (value instanceof JSONArray) {
            JSONArray arr = (JSONArray) value;
            if (arr.length() > 0 && arr.get(0) instanceof String) {
                return (String) arr.get(0);
            }
        }
        return null;
    }

    /**
     * Get a List of Strings from JSON object.
     * Handles both single String values and JSONArray.
     *
     * @param jsonObj The JSON object
     * @param key The field key
     * @return List of strings, or empty list if not found
     */
    public static List<String> getStringList(JSONObject jsonObj, String key) {
        List<String> result = new ArrayList<>();

        if (!jsonObj.has(key)) {
            return result;
        }

        Object value = jsonObj.get(key);

        // If it's a single String, wrap in list
        if (value instanceof String) {
            String str = (String) value;
            if (!str.isEmpty()) {
                result.add(str);
            }
            return result;
        }

        // If it's an array, extract all strings
        if (value instanceof JSONArray) {
            JSONArray arr = (JSONArray) value;
            for (int i = 0; i < arr.length(); i++) {
                Object item = arr.get(i);
                if (item instanceof String) {
                    result.add((String) item);
                } else if (item != null) {
                    result.add(item.toString());
                }
            }
        }

        return result;
    }

    /**
     * Get an Integer value from JSON object.
     * Returns null if not found or not a number.
     */
    public static Integer getInteger(JSONObject jsonObj, String key) {
        if (!jsonObj.has(key)) {
            return null;
        }
        Object value = jsonObj.get(key);
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        if (value instanceof String) {
            try {
                return Integer.parseInt((String) value);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * Get a Boolean value from JSON object.
     */
    public static Boolean getBoolean(JSONObject jsonObj, String key) {
        if (!jsonObj.has(key)) {
            return null;
        }
        Object value = jsonObj.get(key);
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        if (value instanceof String) {
            return Boolean.parseBoolean((String) value);
        }
        return null;
    }

    /**
     * Check if a key exists and has a non-null, non-empty value.
     */
    public static boolean hasValue(JSONObject jsonObj, String key) {
        if (!jsonObj.has(key)) {
            return false;
        }
        Object value = jsonObj.get(key);
        if (value == null || JSONObject.NULL.equals(value)) {
            return false;
        }
        if (value instanceof String) {
            return !((String) value).isEmpty();
        }
        if (value instanceof JSONArray) {
            return ((JSONArray) value).length() > 0;
        }
        return true;
    }
}