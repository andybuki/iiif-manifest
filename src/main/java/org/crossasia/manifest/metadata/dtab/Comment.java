package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.PlaceInfo;
@Deprecated
public class Comment {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        PlaceInfo placeInfo = dtabAttributes.getPlaceInfo();

        if (placeInfo == null) {
            return null;
        }

        String commentPlace = placeInfo.getCommentPlace();

        if (commentPlace == null || commentPlace.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("de", "dtab:comment_place"),
                new Value(new I18n("de", commentPlace))
        );

        return metadata;
    }
}
