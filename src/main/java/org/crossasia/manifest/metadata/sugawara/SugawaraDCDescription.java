package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
@Deprecated
public class SugawaraDCDescription {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        String description = sugawaraAttributes.getDescription();

        if (description == null || description.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("en", "schema:abstract"),
                new Value(new I18n("en", description))
        );

        return metadata;

    }
}
