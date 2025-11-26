package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

import java.util.ArrayList;

public class Place {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if(turfanAttributes.getPlace()!=null) {
            for (int i = 0; i < turfanAttributes.getPlace().length(); i++) {
                list.add(turfanAttributes.getPlace().get(i).toString());

            }
            i18n = new I18n("de", list);

            metadata = new Metadata(new Label("de", "dc:place"),
                    new Value(new I18n[]{i18n}));
            return metadata;
        }
        else {
            return metadata;
        }

    }

    /*public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        Metadata metadata = null;

        if(sugawaraAttributes.getDc_place()!="") {
            metadata = new Metadata(new Label( "en","dc:place"),
                    new Value( new I18n("en", sugawaraAttributes.getDc_place())));
            return metadata;
        }
        else {
            return metadata;
        }
    }*/
}
