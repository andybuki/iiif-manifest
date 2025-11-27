package org.crossasia.manifest.canvas.model;

import org.crossasia.manifest.canvas.extractor.PageDataExtractor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PageDataExtractor Tests")
public class PageDataExtractorTest {

    @Test
    @DisplayName("Should extract basic string fields")
    public void testExtractBasicFields() throws JSONException {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", "page-123");
        jsonObj.put("name", "page1.jpg");
        jsonObj.put("position", "1");
        jsonObj.put("dc:title", "Test Title");

        PageData result = PageDataExtractor.extract(jsonObj);

        assertEquals("page-123", result.getId());
        assertEquals("page1.jpg", result.getName());
        assertEquals("1", result.getPosition());
        assertEquals("Test Title", result.getTitle());
    }

    @Test
    @DisplayName("Should normalize date strings")
    public void testDateNormalization() throws JSONException {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("dc:date", "O.Dat.");
        jsonObj.put("schema:year", "o.Dat");

        PageData result = PageDataExtractor.extract(jsonObj);

        assertEquals("o.Dat.", result.getDate());
        assertEquals("o.Dat.", result.getYear());
    }

    @Test
    @DisplayName("Should handle string values for dual-type fields")
    public void testDualTypeString() throws JSONException {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("schema:person", "John Doe");
        jsonObj.put("schema:index", "Index 1");

        PageData result = PageDataExtractor.extract(jsonObj);

        assertEquals("John Doe", result.getPerson());
        assertNull(result.getPersonArray());
        assertEquals("Index 1", result.getIndex());
        assertNull(result.getIndexArray());
    }

    @Test
    @DisplayName("Should handle array values for dual-type fields")
    public void testDualTypeArray() throws JSONException {
        JSONObject jsonObj = new JSONObject();
        JSONArray personArray = new JSONArray();
        personArray.put("Person 1");
        personArray.put("Person 2");
        jsonObj.put("schema:person", personArray);

        PageData result = PageDataExtractor.extract(jsonObj);

        assertNull(result.getPerson());
        assertNotNull(result.getPersonArray());
        assertEquals(2, result.getPersonArray().length());
    }

    @Test
    @DisplayName("Should handle empty JSON object")
    public void testEmptyJson() {
        JSONObject jsonObj = new JSONObject();

        PageData result = PageDataExtractor.extract(jsonObj);

        assertNotNull(result);
        assertNull(result.getId());
        assertNull(result.getTitle());
    }

    @Test
    @DisplayName("Should trim string values")
    public void testTrimming() throws JSONException {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("dc:title", "  Title with spaces  ");
        jsonObj.put("dc:identifier", " ID123 ");

        PageData result = PageDataExtractor.extract(jsonObj);

        assertEquals("Title with spaces", result.getTitle());
        assertEquals("ID123", result.getDcIdentifier());
    }
}
