package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.PlaceInfo;

public class CrossasiaPlaceType3 {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        PlaceInfo placeInfo = sugawaraAttributes.getPlaceInfo();

        if (placeInfo == null) {
            return null;
        }

        String place3 = placeInfo.getPlaceType3();

        if (place3 == null || place3.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("en", "crossasia:placeType3"),
                new Value(new I18n("en", place3))
        );

        return metadata;
    }
}
