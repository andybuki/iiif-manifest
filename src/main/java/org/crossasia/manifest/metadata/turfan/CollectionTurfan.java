package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

import static org.crossasia.manifest.statics.collection.Label.TURFAN;
import java.util.ArrayList;
import java.util.List;

public class CollectionTurfan {
    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {
        List<String> collections = turfanAttributes.getCollections();

        if (collections != null && !collections.isEmpty()) {
            I18n i18n = new I18n("none", collections);

            Metadata metadata = new Metadata(
                    new Label("none", "schema:collection"),
                    new Value(new I18n[]{i18n})
            );

            return metadata;
        } else {
            // Return default TURFAN value if no collections exist
            Metadata metadata = new Metadata(
                    new Label("none", "schema:collection"),
                    new Value(TURFAN.getVal())
            );

            return metadata;
        }
    }
}
