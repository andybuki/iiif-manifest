package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class LabelMetadata {
    public static I18n getLabelTitle(CollectionAttributes collectionAttributes) {
        String title = collectionAttributes.getTitle();

        if (title == null || title.isEmpty()) {
            title = "Untitled";
        }

        I18n i18n_title = new I18n("en", title);

        return i18n_title;
    }
}
