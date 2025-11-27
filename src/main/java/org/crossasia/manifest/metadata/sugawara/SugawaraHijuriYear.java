package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.DateInfo;

public class SugawaraHijuriYear {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        DateInfo dateInfo = sugawaraAttributes.getDateInfo();

        if (dateInfo == null) {
            return null;
        }

        String hijriYear = dateInfo.getHijriYear();

        if (hijriYear == null || hijriYear.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("none", "sugawara:hijuriYear"),
                new Value(new I18n("none", hijriYear))
        );

        return metadata;
    }
}
