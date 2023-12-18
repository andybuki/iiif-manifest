package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;

public class SugawaraCrossasiaLanguage {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if (sugawaraAttributes.getCrossasia_languages() != null && sugawaraAttributes.getCrossasia_languages().length()!=0) {
            for (int i = 0; i < sugawaraAttributes.getCrossasia_languages().length(); i++) {
                list.add(sugawaraAttributes.getCrossasia_languages().get(i).toString());
            }
            i18n = new I18n("en", list);
            metadata = new Metadata(new Label("en", "crossasia:language"),
                    new Value(new I18n[]{i18n}));

            return metadata;
        } else if (sugawaraAttributes.getCrossasia_language() != null) {
            metadata = new Metadata(new Label( "en","crossasia:language"),
                    new Value( new I18n("en", sugawaraAttributes.getCrossasia_language())));
            return metadata;

        } else {
            return metadata;
        }
    }
}
