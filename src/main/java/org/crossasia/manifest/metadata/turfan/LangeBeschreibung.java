package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

import java.util.ArrayList;
import java.util.Collections;

public class LangeBeschreibung {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        Metadata metadata = null;

        if(turfanAttributes.getLangeBeschreibung()!=null) {

            ArrayList<String> l = new ArrayList<>();
            if (turfanAttributes.getLangeBeschreibung().contains(";")) {
                String [] s = turfanAttributes.getLangeBeschreibung().split(";");
                Collections.addAll(l, s);
            } else {
                l.add(turfanAttributes.getLangeBeschreibung());
            }
            I18n i18n = new I18n("de", l);

            metadata = new Metadata(new Label( "de","smb:langeBeschreibung"),
                    new Value( new I18n[]{i18n}));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
