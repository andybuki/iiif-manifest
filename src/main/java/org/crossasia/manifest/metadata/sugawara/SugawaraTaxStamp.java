package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;

public class SugawaraTaxStamp {

    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
    Metadata metadata = null;
    I18n i18n = null;
    ArrayList<String> list = new ArrayList<>();
        if(sugawaraAttributes.getSugawara_taxStamps()!=null) {
            for (int i = 0; i < sugawaraAttributes.getSugawara_taxStamps().length(); i++) {
                list.add(sugawaraAttributes.getSugawara_taxStamps().get(i).toString());
            }
            i18n = new I18n("none", list);

            metadata = new Metadata(new Label("none", "sugawara:taxStamp"),
                    new Value(new I18n[]{i18n}));
            return metadata;
        } else if (sugawaraAttributes.getSugawara_taxStamp() !="") {
            metadata = new Metadata(new Label( "none","sugawara:taxStamp"),
                    new Value( new I18n("none", sugawaraAttributes.getSugawara_taxStamp())));
            return metadata;
        } else {
        return metadata;
    }

}
}
