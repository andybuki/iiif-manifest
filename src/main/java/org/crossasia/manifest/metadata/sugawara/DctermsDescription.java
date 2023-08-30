package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;

public class DctermsDescription {

    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if (sugawaraAttributes.getDcterms_descriptions() != null) {
            for (int i = 0; i < sugawaraAttributes.getDcterms_descriptions().length(); i++) {
                list.add(sugawaraAttributes.getDcterms_descriptions().get(i).toString());
            }
            i18n = new I18n("en", list);
            metadata = new Metadata(new Label("en", "dcterms:description"),
                    new Value(new I18n[]{i18n}));

            return metadata;
        } else if (sugawaraAttributes.getDcterms_description() != "") {
            metadata = new Metadata(new Label( "en","dcterms:description"),
                    new Value( new I18n("en", sugawaraAttributes.getDcterms_description())));
            return metadata;

        } else {
            return metadata;
        }
    }
}
