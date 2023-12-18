package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;

public class SugawaraDctermsLanguage {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if (sugawaraAttributes.getDcterms_languages() != null && sugawaraAttributes.getDcterms_languages().length()!=0) {
            for (int i = 0; i < sugawaraAttributes.getDcterms_languages().length(); i++) {
                list.add(sugawaraAttributes.getDcterms_languages().get(i).toString());
            }
            i18n = new I18n("none", list);
            metadata = new Metadata(new Label("none", "dcterms:language"),
                    new Value(new I18n[]{i18n}));

            return metadata;
        } else if (sugawaraAttributes.getDcterms_language() != null) {
            metadata = new Metadata(new Label( "none","dcterms:language"),
                    new Value( new I18n("none", sugawaraAttributes.getDcterms_language())));
            return metadata;

        } else {
            return metadata;
        }
    }
}
