package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

import java.util.ArrayList;
import java.util.HashSet;

public class SealFormNEW {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if(dtabAttributes.getSeal_formNEW()!=null) {

            for (int i = 0; i < dtabAttributes.getSeal_formNEW().length(); i++) {
                list.add(dtabAttributes.getSeal_formNEW().get(i).toString());
            }
            HashSet<String> hashSet = new HashSet<String>();
            hashSet.addAll(list);
            list.clear();
            list.addAll(hashSet);
            i18n = new I18n("en", list);

            metadata = new Metadata(new Label( "en","dtab:seal_form"),
                    new Value( new I18n[]{i18n}));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
