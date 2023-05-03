package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

import java.util.ArrayList;

public class DsrLink {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if(turfanAttributes.getDsrLink()!=null) {
            for (int i = 0; i < turfanAttributes.getDsrLink().length(); i++) {
                list.add(turfanAttributes.getDsrLink().get(i).toString());
            }
            i18n = new I18n("none", list);
            metadata = new Metadata(new Label("none", "turfan:dsrLink"),
                    new Value(new I18n[]{i18n}));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
