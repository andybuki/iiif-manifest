package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

public class SugawaraDCTermsExtent {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        String extent = sugawaraAttributes.getExtent();
        if (extent == null || extent.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("none", "dcterms:extent"),
                new Value(new I18n("none", extent))
        );

        return metadata;

    }
}
