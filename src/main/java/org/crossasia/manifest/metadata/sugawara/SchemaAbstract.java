package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

public class SchemaAbstract {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        String abstractText = sugawaraAttributes.getAbstractText();
        if (abstractText == null || abstractText.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("en", "schema:abstract"),
                new Value(new I18n("en", abstractText))
        );

        return metadata;

    }
}
