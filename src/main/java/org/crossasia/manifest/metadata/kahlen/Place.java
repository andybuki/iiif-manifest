package org.crossasia.manifest.metadata.kahlen;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.KahlenAttributes;

import java.util.ArrayList;

public class Place {
    public static Metadata get(KahlenAttributes kahlenAttributes, Manifest manifest) {
        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if (kahlenAttributes.getPlaces() != null) {

            for (int i = 0; i < kahlenAttributes.getPlaces().size(); i++) {
                list.add(kahlenAttributes.getPlaces().get(i).toString());
            }

            i18n = new I18n("en", list);

            metadata = new Metadata(new Label("en", "dcterms:place"),
                    new Value(new I18n[]{i18n}));
            return metadata;
        }  else {
            return metadata;
        }
    }
}

