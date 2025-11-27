package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.PersonRole;

public class Name {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        PersonRole sender = dtabAttributes.getSender();

        if (sender == null) {
            return null;
        }

        String name = sender.getPersonName();

        if (name == null || name.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("none", "schema:name"),
                new Value(new I18n("none", name))
        );

        return metadata;
    }
}
