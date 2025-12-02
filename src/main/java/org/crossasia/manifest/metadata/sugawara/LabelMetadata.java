package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.TurfanAttributes;


public class LabelMetadata {

    public static I18n getLabelTitle(SugawaraAttributes sugawaraAttributes) {
        String title = sugawaraAttributes.getTitle();

        if (title == null || title.isEmpty()) {
            title = "Untitled";
        }

        return new I18n("en", title);
    }
}
