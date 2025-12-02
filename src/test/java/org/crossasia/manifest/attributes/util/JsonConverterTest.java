package org.crossasia.manifest.attributes.util;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonConverterTest {

    @Test
    void testGetString_withSimpleString() {
        JSONObject json = new JSONObject();
        json.put("title", "Test Title");

        String result = JsonConverter.getString(json, "title");
        assertEquals("Test Title", result);
    }

    @Test
    void testGetString_withArray_returnsFirstElement() {
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        array.put("First");
        array.put("Second");
        json.put("titles", array);

        String result = JsonConverter.getString(json, "titles");
        assertEquals("First", result);
    }

    @Test
    void testGetString_withMissingKey_returnsNull() {
        JSONObject json = new JSONObject();

        String result = JsonConverter.getString(json, "nonexistent");
        assertNull(result);
    }

    @Test
    void testGetStringList_withArray() {
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        array.put("Item1");
        array.put("Item2");
        array.put("Item3");
        json.put("items", array);

        List<String> result = JsonConverter.getStringList(json, "items");
        assertEquals(3, result.size());
        assertEquals("Item1", result.get(0));
        assertEquals("Item2", result.get(1));
        assertEquals("Item3", result.get(2));
    }

    @Test
    void testGetStringList_withSingleString() {
        JSONObject json = new JSONObject();
        json.put("item", "Single Item");

        List<String> result = JsonConverter.getStringList(json, "item");
        assertEquals(1, result.size());
        assertEquals("Single Item", result.get(0));
    }

    @Test
    void testGetStringList_withMissingKey_returnsEmptyList() {
        JSONObject json = new JSONObject();

        List<String> result = JsonConverter.getStringList(json, "missing");
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetInteger_withNumber() {
        JSONObject json = new JSONObject();
        json.put("count", 42);

        Integer result = JsonConverter.getInteger(json, "count");
        assertEquals(42, result);
    }

    @Test
    void testGetInteger_withString_parseableNumber() {
        JSONObject json = new JSONObject();
        json.put("count", "100");

        Integer result = JsonConverter.getInteger(json, "count");
        assertEquals(100, result);
    }

    @Test
    void testGetInteger_withInvalidString_returnsNull() {
        JSONObject json = new JSONObject();
        json.put("count", "not a number");

        Integer result = JsonConverter.getInteger(json, "count");
        assertNull(result);
    }

    @Test
    void testGetBoolean_withBooleanValue() {
        JSONObject json = new JSONObject();
        json.put("active", true);

        Boolean result = JsonConverter.getBoolean(json, "active");
        assertTrue(result);
    }

    @Test
    void testGetBoolean_withStringValue() {
        JSONObject json = new JSONObject();
        json.put("active", "true");

        Boolean result = JsonConverter.getBoolean(json, "active");
        assertTrue(result);
    }

    @Test
    void testHasValue_withValidString() {
        JSONObject json = new JSONObject();
        json.put("field", "value");

        assertTrue(JsonConverter.hasValue(json, "field"));
    }

    @Test
    void testHasValue_withEmptyString_returnsFalse() {
        JSONObject json = new JSONObject();
        json.put("field", "");

        assertFalse(JsonConverter.hasValue(json, "field"));
    }

    @Test
    void testHasValue_withNullValue_returnsFalse() {
        JSONObject json = new JSONObject();
        json.put("field", JSONObject.NULL);

        assertFalse(JsonConverter.hasValue(json, "field"));
    }

    @Test
    void testHasValue_withMissingKey_returnsFalse() {
        JSONObject json = new JSONObject();

        assertFalse(JsonConverter.hasValue(json, "missing"));
    }

    @Test
    void testHasValue_withNonEmptyArray_returnsTrue() {
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        array.put("item");
        json.put("items", array);

        assertTrue(JsonConverter.hasValue(json, "items"));
    }

    @Test
    void testHasValue_withEmptyArray_returnsFalse() {
        JSONObject json = new JSONObject();
        json.put("items", new JSONArray());

        assertFalse(JsonConverter.hasValue(json, "items"));
    }
}
