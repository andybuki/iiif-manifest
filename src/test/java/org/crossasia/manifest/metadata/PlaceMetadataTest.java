package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.attributes.domain.PlaceInfo;
import org.crossasia.manifest.metadata.dtab.Place;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@DisplayName("Place Metadata Tests")
public class PlaceMetadataTest {

    @Test
    @DisplayName("Should return metadata when places exist")
    public void testWithPlaces() {
        CollectionAttributes attributes = new CollectionAttributes();
        PlaceInfo placeInfo = new PlaceInfo();
        List<String> places = Arrays.asList("Berlin", "Munich");
        placeInfo.setPlaces(places);
        attributes.setPlaceInfo(placeInfo);

        Manifest manifest = new Manifest("test-manifest");

        Metadata result = Place.get(attributes, manifest);

        assertNotNull(result);
    }

    @Test
    @DisplayName("Should return null when PlaceInfo is null")
    public void testWithNullPlaceInfo() {
        CollectionAttributes attributes = new CollectionAttributes();
        Manifest manifest = new Manifest("test-manifest");

        Metadata result = Place.get(attributes, manifest);

        assertNull(result);
    }

    @Test
    @DisplayName("Should return null when places list is null")
    public void testWithNullPlacesList() {
        CollectionAttributes attributes = new CollectionAttributes();
        PlaceInfo placeInfo = new PlaceInfo();
        // Don't set places
        attributes.setPlaceInfo(placeInfo);

        Manifest manifest = new Manifest("test-manifest");

        Metadata result = Place.get(attributes, manifest);

        assertNull(result);
    }

    @Test
    @DisplayName("Should return null when places list is empty")
    public void testWithEmptyPlacesList() {
        CollectionAttributes attributes = new CollectionAttributes();
        PlaceInfo placeInfo = new PlaceInfo();
        placeInfo.setPlaces(Arrays.asList());  // Empty list
        attributes.setPlaceInfo(placeInfo);

        Manifest manifest = new Manifest("test-manifest");

        Metadata result = Place.get(attributes, manifest);

        assertNull(result);
    }
}

