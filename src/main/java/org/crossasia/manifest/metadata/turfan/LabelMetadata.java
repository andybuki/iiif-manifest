package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.DtabAttributes;

public class LabelMetadata {
    public static I18n getLabelTitle(DtabAttributes dtabAttributes) {
        String title = dtabAttributes.getTitle();

        if (title == null || title.isEmpty()) {
            title = "Untitled";
        }

        I18n i18n_title = new I18n("en", title);

        return i18n_title;
    }
}
