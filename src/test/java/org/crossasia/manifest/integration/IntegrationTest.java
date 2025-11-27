package org.crossasia.manifest.integration;

import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.attributes.domain.DateInfo;
import org.crossasia.manifest.attributes.domain.PlaceInfo;
import org.crossasia.manifest.attributes.util.JsonConverter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@DisplayName("Integration Tests")
public class IntegrationTest {

    @Test
    @DisplayName("Complete workflow: JSON -> Attributes -> List")
    public void testCompleteWorkflow() throws JSONException {
        // 1. Create JSON data
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", "doc-123");
        jsonObj.put("dc:title", "Test Document");

        JSONArray dates = new JSONArray();
        dates.put("2024-01-01");
        dates.put("2024-12-31");
        jsonObj.put("dc:date", dates);

        JSONArray places = new JSONArray();
        places.put("Berlin");
        places.put("Munich");
        jsonObj.put("dc:place", places);

        // 2. Extract to attributes
        CollectionAttributes attributes = new CollectionAttributes();
        attributes.setId(JsonConverter.getString(jsonObj, "id"));
        attributes.setTitle(JsonConverter.getString(jsonObj, "dc:title"));

        DateInfo dateInfo = new DateInfo();
        dateInfo.setDates(JsonConverter.getStringList(jsonObj, "dc:date"));
        attributes.setDateInfo(dateInfo);

        PlaceInfo placeInfo = new PlaceInfo();
        placeInfo.setPlaces(JsonConverter.getStringList(jsonObj, "dc:place"));
        attributes.setPlaceInfo(placeInfo);

        // 3. Verify data integrity
        assertEquals("doc-123", attributes.getId());
        assertEquals("Test Document", attributes.getTitle());

        assertNotNull(attributes.getDateInfo());
        assertEquals(2, attributes.getDateInfo().getDates().size());
        assertEquals("2024-01-01", attributes.getDateInfo().getDates().get(0));

        assertNotNull(attributes.getPlaceInfo());
        assertEquals(2, attributes.getPlaceInfo().getPlaces().size());
        assertEquals("Berlin", attributes.getPlaceInfo().getPlaces().get(0));

        // 4. Convert back to JSON
        JSONArray resultDates = JsonConverter.toJsonArray(attributes.getDateInfo().getDates());
        JSONArray resultPlaces = JsonConverter.toJsonArray(attributes.getPlaceInfo().getPlaces());

        assertEquals(2, resultDates.length());
        assertEquals(2, resultPlaces.length());
        assertEquals("2024-01-01", resultDates.get(0));
        assertEquals("Berlin", resultPlaces.get(0));
    }

    @Test
    @DisplayName("Handle mixed string and array values")
    public void testMixedStringAndArray() throws JSONException {
        JSONObject jsonObj = new JSONObject();

        // Single string value
        jsonObj.put("singleValue", "test");
        List<String> single = JsonConverter.getStringList(jsonObj, "singleValue");
        assertEquals(1, single.size());
        assertEquals("test", single.get(0));

        // Array value
        JSONArray array = new JSONArray();
        array.put("item1");
        array.put("item2");
        jsonObj.put("arrayValue", array);
        List<String> multiple = JsonConverter.getStringList(jsonObj, "arrayValue");
        assertEquals(2, multiple.size());
    }

    @Test
    @DisplayName("Handle null and missing values gracefully")
    public void testNullAndMissingValues() throws JSONException {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("nullValue", JSONObject.NULL);

        String nullResult = JsonConverter.getString(jsonObj, "nullValue");
        assertNull(nullResult);

        String missingResult = JsonConverter.getString(jsonObj, "missing");
        assertNull(missingResult);

        List<String> missingList = JsonConverter.getStringList(jsonObj, "missing");
        assertNull(missingList);
    }
}
