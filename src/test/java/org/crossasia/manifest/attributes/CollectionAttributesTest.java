package org.crossasia.manifest.attributes;

import org.crossasia.manifest.attributes.domain.DateInfo;
import org.crossasia.manifest.attributes.domain.PlaceInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@DisplayName("CollectionAttributes Tests")
public class CollectionAttributesTest {

    private CollectionAttributes attributes;

    @BeforeEach
    public void setUp() {
        attributes = new CollectionAttributes();
    }

    @Test
    @DisplayName("Should set and get basic fields")
    public void testBasicFields() {
        attributes.setId("test-123");
        attributes.setTitle("Test Title");
        attributes.setDescription("Test Description");

        assertEquals("test-123", attributes.getId());
        assertEquals("Test Title", attributes.getTitle());
        assertEquals("Test Description", attributes.getDescription());
    }

    @Test
    @DisplayName("Should set and get DateInfo")
    public void testDateInfo() {
        DateInfo dateInfo = new DateInfo();
        dateInfo.setDate("2024-01-01");

        attributes.setDateInfo(dateInfo);

        assertNotNull(attributes.getDateInfo());
        assertEquals("2024-01-01", attributes.getDateInfo().getDate());
    }

    @Test
    @DisplayName("Should set and get PlaceInfo")
    public void testPlaceInfo() {
        PlaceInfo placeInfo = new PlaceInfo();
        placeInfo.setPlace("Berlin");

        attributes.setPlaceInfo(placeInfo);

        assertNotNull(attributes.getPlaceInfo());
        assertEquals("Berlin", attributes.getPlaceInfo().getPlace());
    }

    @Test
    @DisplayName("Should set and get keywords list")
    public void testKeywords() {
        List<String> keywords = Arrays.asList("keyword1", "keyword2");
        attributes.setKeywords(keywords);

        assertEquals(2, attributes.getKeywords().size());
        assertEquals("keyword1", attributes.getKeywords().get(0));
    }

    @Test
    @DisplayName("Should handle null domain objects")
    public void testNullDomainObjects() {
        assertNull(attributes.getDateInfo());
        assertNull(attributes.getPlaceInfo());
    }
}