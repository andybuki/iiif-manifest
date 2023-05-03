package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

import java.util.ArrayList;

public class SiteNameGer {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        Metadata metadata = null;

        if(turfanAttributes.getSiteNameGer()!=null) {
            for (int i = 0; i < turfanAttributes.getSiteNameGer().length(); i++) {
                list.add(turfanAttributes.getSiteNameGer().get(i).toString());
            }
            i18n = new I18n("de", list);
            metadata = new Metadata(new Label("de", "turfan:siteNameGer"),
                    new Value(new I18n[]{i18n}));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
