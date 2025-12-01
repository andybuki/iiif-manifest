package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class DctermsDescription {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        List<String> descriptions = sugawaraAttributes.getDescriptions();

        if (descriptions != null && !descriptions.isEmpty()) {
            I18n i18n = new I18n("en", descriptions);

            Metadata metadata = new Metadata(
                    new Label("en", "dcterms:description"),
                    new Value(new I18n[]{i18n})
            );

            return metadata;
        }
        // Fallback to single description
        String description = sugawaraAttributes.getDescription();

        if (description != null && !description.isEmpty()) {
            Metadata metadata = new Metadata(
                    new Label("en", "dcterms:description"),
                    new Value(new I18n("en", description))
            );

            return metadata;
        }

        return null;
    }
}
