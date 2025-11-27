package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.PlaceInfo;

public class PlaceComment {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {

        PlaceInfo placeInfo = dtabAttributes.getPlaceInfo();

        if (placeInfo == null) {
            return null;
        }

        String comment = placeInfo.getCommentPlace();

        if (comment == null || comment.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("en", "dtab:place_comment"),
                new Value(new I18n("en", comment))
        );

        return metadata;

    }
}
