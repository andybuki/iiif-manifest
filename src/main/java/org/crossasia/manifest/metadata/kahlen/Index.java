package org.crossasia.manifest.metadata.kahlen;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.KahlenAttributes;

import java.util.ArrayList;

public class Index {
    public static Metadata get(KahlenAttributes kahlenAttributes, Manifest manifest) {
        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if(kahlenAttributes.getIndexes()!=null) {

            for (int i = 0; i < kahlenAttributes.getIndexes().length(); i++) {
                list.add(kahlenAttributes.getIndexes().get(i).toString());
            }

            i18n = new I18n("en", list);

            metadata = new Metadata(new Label( "en","schema:index"),
                    new Value( new I18n[]{i18n}));
            return metadata;
        }
        else if (kahlenAttributes.getIndex()!=null) {
            metadata = new Metadata(new Label( "en","schema:index"),
                    new Value( kahlenAttributes.getIndex()));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
