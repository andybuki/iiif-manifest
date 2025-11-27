package org.crossasia.manifest.attributes.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@DisplayName("PlaceInfo Tests")
public class PlaceInfoTest {

    private PlaceInfo placeInfo;

    @BeforeEach
    public void setUp() {
        placeInfo = new PlaceInfo();
    }

    @Test
    @DisplayName("Should set and get place")
    public void testSetGetPlace() {
        placeInfo.setPlace("Berlin");
        assertEquals("Berlin", placeInfo.getPlace());
    }

    @Test
    @DisplayName("Should set and get places list")
    public void testSetGetPlaces() {
        List<String> places = Arrays.asList("Berlin", "Munich", "Hamburg");
        placeInfo.setPlaces(places);

        assertEquals(3, placeInfo.getPlaces().size());
        assertEquals("Berlin", placeInfo.getPlaces().get(0));
    }

    @Test
    @DisplayName("Should set and get placeId")
    public void testSetGetPlaceId() {
        placeInfo.setPlaceId("place-123");
        assertEquals("place-123", placeInfo.getPlaceId());
    }

    @Test
    @DisplayName("Should set and get admin levels")
    public void testSetGetAdminLevels() {
        placeInfo.setAdminLevel1("Germany");
        placeInfo.setAdminLevel2("Bavaria");

        assertEquals("Germany", placeInfo.getAdminLevel1());
        assertEquals("Bavaria", placeInfo.getAdminLevel2());
    }

    @Test
    @DisplayName("Should handle null values gracefully")
    public void testNullValues() {
        assertNull(placeInfo.getPlace());
        assertNull(placeInfo.getPlaces());
        assertNull(placeInfo.getPlaceId());
    }
}
