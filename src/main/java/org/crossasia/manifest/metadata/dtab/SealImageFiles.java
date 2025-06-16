package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

import java.util.ArrayList;
import java.util.HashSet;

public class SealImageFiles {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if(dtabAttributes.getSeal_image_files()!=null) {

            for (int i = 0; i < dtabAttributes.getSeal_image_files().length(); i++) {
                list.add(dtabAttributes.getSeal_image_files().get(i).toString());
            }
            HashSet<String> hashSet = new HashSet<String>();
            hashSet.addAll(list);
            list.clear();
            list.addAll(hashSet);
            i18n = new I18n("none", list);

            metadata = new Metadata(new Label( "none","dtab:seal_image_files"),
                    new Value( new I18n[]{i18n}));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
