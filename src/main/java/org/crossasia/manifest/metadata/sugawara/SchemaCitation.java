package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

public class SchemaCitation {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        String citation = sugawaraAttributes.getCitation();
        if (citation == null || citation.isEmpty()) {
            return null;
        }

        return new Metadata(new Label( "en","schema:citation"),
                new Value( new I18n("en", citation
                        )));

    }
}
