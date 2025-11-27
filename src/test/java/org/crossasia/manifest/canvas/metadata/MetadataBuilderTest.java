package org.crossasia.manifest.canvas.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import org.crossasia.manifest.canvas.model.PageData;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@DisplayName("MetadataBuilder Tests")
public class MetadataBuilderTest {

    @Test
    @DisplayName("Should build metadata from simple fields")
    public void testSimpleFields() {
        PageData data = new PageData();
        data.setPosition("1");
        data.setYear("2024");
        data.setDcIdentifier("ID-123");

        List<Metadata> result = MetadataBuilder.buildMetadata(data);

        assertNotNull(result);
        assertTrue(result.size() >= 3);
    }

    @Test
    @DisplayName("Should skip empty fields")
    public void testSkipEmptyFields() {
        PageData data = new PageData();
        data.setTitle("");  // Empty should be skipped
        data.setPosition("1");  // Only this should be included

        List<Metadata> result = MetadataBuilder.buildMetadata(data);

        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Should handle array fields")
    public void testArrayFields() {
        PageData data = new PageData();
        JSONArray subjects = new JSONArray();
        subjects.put("Subject 1");
        subjects.put("Subject 2");
        data.setSubjectArray(subjects);

        List<Metadata> result = MetadataBuilder.buildMetadata(data);

        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Should handle semicolon-separated fields")
    public void testSemicolonSeparated() {
        PageData data = new PageData();
        data.setKeyword("keyword1;keyword2;keyword3");

        List<Metadata> result = MetadataBuilder.buildMetadata(data);

        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Should return empty list for empty PageData")
    public void testEmptyPageData() {
        PageData data = new PageData();

        List<Metadata> result = MetadataBuilder.buildMetadata(data);

        assertNotNull(result);
        assertEquals(0, result.size());
    }
}
