package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

import java.util.ArrayList;

public class Receiver {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        Metadata metadata = null;
        I18n i18n = null;
        I18n i18n_td = null;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list_td = new ArrayList<>();

        if(dtabAttributes.getDtabReceiver()!=null || dtabAttributes.getDtabReceiverTb()!=null) {

            for (int i = 0; i < dtabAttributes.getDtabReceiver().length(); i++) {
                list.add(dtabAttributes.getDtabReceiver().get(i).toString());
            }

            for (int i = 0; i < dtabAttributes.getDtabReceiverTb().length(); i++) {
                list_td.add(dtabAttributes.getDtabReceiverTb().get(i).toString());
            }

            i18n = new I18n("en", list);
            i18n_td = new I18n("bo", list_td);

            metadata = new Metadata(new Label( "en","dtab:receiver"),
                    new Value(new I18n[]{i18n, i18n_td}));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
