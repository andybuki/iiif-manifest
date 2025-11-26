package org.crossasia.manifest.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonConverter {
    /**
     * Converts JSONArray to List<String>
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
     */
    public static String getString(JSONObject jsonObj, String key) {
        if (jsonObj.has(key)) {
            Object value = jsonObj.get(key);
            if (value instanceof String) {
                return (String) value;
            }
            return value != null ? value.toString() : null;
        }
        return null;
    }

    /**
     * Safely gets a List<String> from JSONObject (handles both JSONArray and single values)
     */
    public static List<String> getStringList(JSONObject jsonObj, String key) {
        if (!jsonObj.has(key)) {
            return null;
        }

        Object value = jsonObj.get(key);
        if (value instanceof JSONArray) {
            return toStringList((JSONArray) value);
        } else if (value != null) {
            // Single value - wrap in list
            List<String> list = new ArrayList<>();
            list.add(value.toString());
            return list;
        }
        return null;
    }
}
