package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

public class SugawaraPhysicalData {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        String physicalData = sugawaraAttributes.getPhysicalData();

        if (physicalData == null || physicalData.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("en", "sugawara:physicaldata"),
                new Value(new I18n("en", physicalData))
        );

        return metadata;

    }
}
