package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.KahlenAttributes;
import org.crossasia.manifest.attributes.domain.PersonRole;

public class LabelMetadata {
    public static I18n getLabelTitle(DtabAttributes dtabAttributes) {
        String title = dtabAttributes.getTitle();
        if (title == null || title.isEmpty()) {
            title = "Untitled";
        }

        I18n i18n_title = new I18n("en",  title);
        return i18n_title;
    }
}
