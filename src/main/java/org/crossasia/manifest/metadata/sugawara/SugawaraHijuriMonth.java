package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.DateInfo;
@Deprecated
public class SugawaraHijuriMonth {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        DateInfo dateInfo = sugawaraAttributes.getDateInfo();

        if (dateInfo == null) {
            return null;
        }

        String hijriMonth = dateInfo.getHijriMonth();

        if (hijriMonth == null || hijriMonth.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("none", "sugawara:hijuriMonth"),
                new Value(new I18n("none", hijriMonth))
        );

        return metadata;
    }
}
