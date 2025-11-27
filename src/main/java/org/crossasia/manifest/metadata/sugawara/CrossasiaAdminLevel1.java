package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.PlaceInfo;

public class CrossasiaAdminLevel1 {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        PlaceInfo placeInfo = sugawaraAttributes.getPlaceInfo();

        if (placeInfo == null) {
            return null;
        }

        String adminLevel1 = placeInfo.getAdminLevel1();

        if (adminLevel1 == null || adminLevel1.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("en", "crossasia:adminlevel1"),
                new Value(new I18n("en", adminLevel1))
        );

        return metadata;
    }
}