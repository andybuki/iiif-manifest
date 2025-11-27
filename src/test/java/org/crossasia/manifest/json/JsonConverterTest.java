package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.util.JsonConverter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("JsonConverter Tests")
public class JsonConverterTest {
    @Test
    @DisplayName("toStringList - should convert JSONArray to List<String>")
    public void testToStringList_withValidArray() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("value1");
        jsonArray.put("value2");
        jsonArray.put("value3");

        List<String> result = JsonConverter.toStringList(jsonArray);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("value1", result.get(0));
        assertEquals("value2", result.get(1));
        assertEquals("value3", result.get(2));
    }

    @Test
    @DisplayName("toStringList - should return null for null input")
    public void testToStringList_withNull() {
        List<String> result = JsonConverter.toStringList(null);
        assertNull(result);
    }

    @Test
    @DisplayName("toStringList - should handle empty array")
    public void testToStringList_withEmptyArray() {
        JSONArray jsonArray = new JSONArray();
        List<String> result = JsonConverter.toStringList(jsonArray);

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("toJsonArray - should convert List<String> to JSONArray")
    public void testToJsonArray_withValidList() throws JSONException {
        List<String> list = Arrays.asList("value1", "value2", "value3");

        JSONArray result = JsonConverter.toJsonArray(list);

        assertNotNull(result);
        assertEquals(3, result.length());
        assertEquals("value1", result.get(0));
        assertEquals("value2", result.get(1));
        assertEquals("value3", result.get(2));
    }

    @Test
    @DisplayName("toJsonArray - should return null for null input")
    public void testToJsonArray_withNull() {
        JSONArray result = JsonConverter.toJsonArray(null);
        assertNull(result);
    }

    @Test
    @DisplayName("getString - should extract string from JSONObject")
    public void testGetString_withValidKey() throws JSONException {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("key", "value");

        String result = JsonConverter.getString(jsonObj, "key");

        assertEquals("value", result);
    }

    @Test
    @DisplayName("getString - should return null for missing key")
    public void testGetString_withMissingKey() {
        JSONObject jsonObj = new JSONObject();

        String result = JsonConverter.getString(jsonObj, "nonexistent");

        assertNull(result);
    }

    @Test
    @DisplayName("getString - should handle null value")
    public void testGetString_withNullValue() throws JSONException {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("key", JSONObject.NULL);

        String result = JsonConverter.getString(jsonObj, "key");

        assertNull(result);
    }

    @Test
    @DisplayName("getStringList - should handle JSONArray value")
    public void testGetStringList_withArray() throws JSONException {
        JSONObject jsonObj = new JSONObject();
        JSONArray array = new JSONArray();
        array.put("item1");
        array.put("item2");
        jsonObj.put("key", array);

        List<String> result = JsonConverter.getStringList(jsonObj, "key");

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("item1", result.get(0));
        assertEquals("item2", result.get(1));
    }

    @Test
    @DisplayName("getStringList - should handle single String value")
    public void testGetStringList_withSingleString() throws JSONException {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("key", "singleValue");

        List<String> result = JsonConverter.getStringList(jsonObj, "key");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("singleValue", result.get(0));
    }

    @Test
    @DisplayName("getStringList - should return null for missing key")
    public void testGetStringList_withMissingKey() {
        JSONObject jsonObj = new JSONObject();

        List<String> result = JsonConverter.getStringList(jsonObj, "nonexistent");

        assertNull(result);
    }
}
