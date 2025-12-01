package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.PlaceInfo;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class Place {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        PlaceInfo placeInfo = sugawaraAttributes.getPlaceInfo();

        if (placeInfo == null) {
            return null;
        }

        List<String> places = placeInfo.getPlaces();

        if (places == null || places.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("en", places);

        Metadata metadata = new Metadata(
                new Label("en", "dc:place"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
