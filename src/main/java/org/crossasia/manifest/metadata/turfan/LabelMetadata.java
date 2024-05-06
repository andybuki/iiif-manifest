package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.DtabAttributes;

public class LabelMetadata {
    public static I18n getLabelTitle(DtabAttributes dtabAttributes) {
        I18n i18n_title = new I18n("en",  dtabAttributes.getDcTitle());
        //I18n i18n_title = new I18n("de",  turfanAttributes.getIdentifier()+": "+turfanAttributes.getTitle());
        return i18n_title;
    }
}
