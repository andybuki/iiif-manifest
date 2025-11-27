package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

public class Title {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        String title = dtabAttributes.getTitle();

        if (title == null || title.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("en", "dc:title"),
                new Value(new I18n("en", title))
        );

        return metadata;
    }
}
