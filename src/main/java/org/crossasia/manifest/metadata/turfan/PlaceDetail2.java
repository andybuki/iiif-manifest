package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.attributes.domain.PlaceInfo;
@Deprecated
public class PlaceDetail2 {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        PlaceInfo placeInfo = turfanAttributes.getPlaceInfo();

        if (placeInfo == null) {
            return null;
        }
        String placeDetail2 = placeInfo.getPlaceDetail2();

        if (placeDetail2 == null || placeDetail2.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("de", placeDetail2);

        Metadata metadata = new Metadata(
                new Label("de", "turfan:placeDetail2"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
