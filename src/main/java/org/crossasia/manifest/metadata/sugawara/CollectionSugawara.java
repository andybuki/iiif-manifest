package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;

import static org.crossasia.manifest.statics.collection.Label.SUGAWARA;
import static org.crossasia.manifest.statics.collection.Label.TURFAN;

public class CollectionSugawara {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if(sugawaraAttributes.getCollection()!=null) {
            for (int i = 0; i < sugawaraAttributes.getCollection().length(); i++) {
                list.add(sugawaraAttributes.getCollection().get(i).toString());
            }
            i18n = new I18n("none", list);
            metadata = new Metadata(new Label("none", "schema:collection"),
                    new Value(new I18n[]{i18n}));
            return metadata;
        }
        else {

            metadata = new Metadata(new Label("none", "schema:collection"),
                    new Value(SUGAWARA.getVal()));
            return metadata;
        }
    }
}
