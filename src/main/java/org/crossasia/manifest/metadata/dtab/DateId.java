package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.DateInfo;

public class DateId {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        DateInfo dateInfo = dtabAttributes.getDateInfo();

        if (dateInfo == null) {
            return null;
        }

        String dateId = dateInfo.getDateId();

        if (dateId == null || dateId.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("none", "dtab:date_id"),
                new Value(new I18n("none", dateId))
        );

        return metadata;
    }
}
