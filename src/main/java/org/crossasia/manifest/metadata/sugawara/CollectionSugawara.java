package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.crossasia.manifest.statics.collection.Label.SUGAWARA;

public class CollectionSugawara {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        List<String> collections = sugawaraAttributes.getCollections();

        if (collections != null && !collections.isEmpty()) {
            I18n i18n = new I18n("none", collections);

            Metadata metadata = new Metadata(
                    new Label("none", "schema:collection"),
                    new Value(new I18n[]{i18n})
            );

            return metadata;
        } else {
            // Return default SUGAWARA value if no collections exist
            Metadata metadata = new Metadata(
                    new Label("none", "schema:collection"),
                    new Value(SUGAWARA.getVal())
            );

            return metadata;
        }
    }
}
