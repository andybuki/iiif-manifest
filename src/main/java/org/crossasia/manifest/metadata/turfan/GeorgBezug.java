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

public class GeorgBezug {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {
        PlaceInfo placeInfo = turfanAttributes.getPlaceInfo();

        if (placeInfo == null) {
            return null;
        }

        List<String> geographicReferences = placeInfo.getGeographicReferences();

        if (geographicReferences == null || geographicReferences.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("de", geographicReferences);

        Metadata metadata = new Metadata(
                new Label("de", "smb:geogrBezug"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
