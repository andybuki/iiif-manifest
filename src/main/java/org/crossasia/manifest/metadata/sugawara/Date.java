package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;

public class Date {

    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {

        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if(sugawaraAttributes.getDc_dates()!=null) {
            for (int i = 0; i < sugawaraAttributes.getDc_dates().length(); i++) {
                list.add(sugawaraAttributes.getDc_dates().get(i).toString());
            }
            i18n = new I18n("none", list);
            metadata = new Metadata(new Label("none", "dc:date"),
                    new Value(new I18n[]{i18n}));

            return metadata;
        }  else if (sugawaraAttributes.getDc_date()!="") {
            metadata = new Metadata(new Label( "none","dc:date"),
                    new Value( new I18n("none", sugawaraAttributes.getDc_date())));
            return metadata;
        } else {
            return metadata;
        }
    }


    /*public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        Metadata metadata = null;

        if(sugawaraAttributes.getDc_date()!="") {
            metadata = new Metadata(new Label( "none","dc:date"),
                    new Value( new I18n("none", sugawaraAttributes.getDc_date())));
            return metadata;
        }
        else {
            return metadata;
        }
    }*/
}
