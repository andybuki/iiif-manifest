package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

public class Gpos {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        String gpos = dtabAttributes.getGeographicPosition();

        if (gpos == null || gpos.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("none", "dtab:gpos"),
                new Value(new I18n("none", gpos))
        );

        return metadata;
    }
}
