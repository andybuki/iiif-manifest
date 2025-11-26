package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.attributes.domain.PlaceInfo;

import java.util.ArrayList;
import java.util.List;

public class Place {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {
        // Access places through PlaceInfo
        PlaceInfo placeInfo = turfanAttributes.getPlaceInfo();

        if (placeInfo == null) {
            return null;
        }

        List<String> places = placeInfo.getPlaces();

        if (places == null || places.isEmpty()) {
            return null;
        }

        // Create I18n from the list
        I18n i18n = new I18n("de", places);

        // Create and return metadata
        Metadata metadata = new Metadata(
                new Label("de", "dc:place"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
