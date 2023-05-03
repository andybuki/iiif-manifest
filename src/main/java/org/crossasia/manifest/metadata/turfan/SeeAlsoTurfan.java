package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

import java.util.ArrayList;

public class SeeAlsoTurfan {

    public static Metadata getSeeAlso(CollectionAttributes turfanAttributes, Manifest manifest) {
        ArrayList<String> list = new ArrayList<>();
        Metadata metadata = null;
        I18n i18n = null;
        if(turfanAttributes.getSeeAlso()!=null) {
            for (int i = 0; i < turfanAttributes.getSeeAlso().length(); i++) {
                list.add(turfanAttributes.getSeeAlso().get(i).toString());
            }
            i18n = new I18n("none", list);
            metadata = new Metadata(new Label("none", "turfan:seeAlso"),
                    new Value(new I18n[]{i18n}));

            return metadata;
        }
        else {
            metadata = null;
            return metadata;
        }
    }
}
