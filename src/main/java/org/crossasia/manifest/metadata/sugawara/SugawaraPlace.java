package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;

public class SugawaraPlace {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if (sugawaraAttributes.getSugawara_places() != null && sugawaraAttributes.getSugawara_places().length()!=0) {
            for (int i = 0; i < sugawaraAttributes.getSugawara_places().length(); i++) {
                list.add(sugawaraAttributes.getSugawara_places().get(i).toString());
            }
            i18n = new I18n("en", list);
            metadata = new Metadata(new Label("en", "sugawara:place"),
                    new Value(new I18n[]{i18n}));

            return metadata;
        } else if (sugawaraAttributes.getSugawara_place() != null) {
            metadata = new Metadata(new Label( "en","sugawara:place"),
                    new Value( new I18n("en", sugawaraAttributes.getSugawara_place())));
            return metadata;

        } else {
            return metadata;
        }
    }
}
