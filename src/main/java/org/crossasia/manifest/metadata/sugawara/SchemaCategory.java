package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
@Deprecated
public class SchemaCategory {

    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        String category = sugawaraAttributes.getCategory();
        if (category == null || category.isEmpty()) {
            return null;
        }

        return new Metadata(new Label( "none","schema:category"),
                new Value( new I18n("none", category
                )));

    }
}
