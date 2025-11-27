package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

public class Groupno {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {

        String gposNum = dtabAttributes.getGeographicPosition();

        if (gposNum == null || gposNum.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("none", "dtab:groupno"),
                new Value(new I18n("none", gposNum))
        );

        return metadata;
    }
}
