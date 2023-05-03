package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

import java.util.ArrayList;
import java.util.Collections;

public class Source {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        Metadata metadata = null;



        if(turfanAttributes.getSource()!=null) {
            ArrayList<String> l = new ArrayList<>();
            if (turfanAttributes.getSource().contains(";")) {
                String [] sources = turfanAttributes.getSource().split(";");
                Collections.addAll(l, sources);
            } else {
                l.add(turfanAttributes.getSource());
            }
            I18n i18n = new I18n("de", l);
            metadata = new Metadata(new Label( "de","dcterms:source"),
                    new Value( new I18n[]{i18n}));
            return metadata;
        }
        else {
            metadata = null;
            return metadata;
        }
    }
}
