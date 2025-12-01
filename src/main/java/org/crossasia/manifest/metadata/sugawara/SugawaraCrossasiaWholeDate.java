package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.DateInfo;
@Deprecated
public class SugawaraCrossasiaWholeDate {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        DateInfo dateInfo = sugawaraAttributes.getDateInfo();

        if (dateInfo == null) {
            return null;
        }
        String wholeDate = dateInfo.getWholeDate();

        if (wholeDate == null || wholeDate.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("none", "crossasia:wholedate"),
                new Value(new I18n("none", wholeDate))
        );

        return metadata;
    }
}
