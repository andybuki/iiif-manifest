package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

import java.util.ArrayList;
import java.util.Collections;
@Deprecated
public class Creator {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        Metadata metadata = null;

        if(turfanAttributes.getCreator()!=null) {

            ArrayList<String> l = new ArrayList<>();
            if (turfanAttributes.getCreator().contains(";")) {
                String [] creators = turfanAttributes.getCreator().split(";");
                Collections.addAll(l, creators);
            } else {
                l.add(turfanAttributes.getCreator());
            }
            I18n i18n = new I18n("de", l);
            metadata = new Metadata(new Label( "de","dc:creator"),
                    new Value(new I18n[]{i18n}));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
