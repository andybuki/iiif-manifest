package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.PersonRole;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class Sender {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        /*Metadata metadata = null;
        I18n i18n = null;
        I18n i18n_td = null;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list_td = new ArrayList<>();

        if(dtabAttributes.getDtabSender()!=null || dtabAttributes.getDtabSenderTb()!=null) {

            for (int i = 0; i < dtabAttributes.getDtabSender().length(); i++) {
                list.add(dtabAttributes.getDtabSender().get(i).toString());
            }

            for (int i = 0; i < dtabAttributes.getDtabSenderTb().length(); i++) {
                list_td.add(dtabAttributes.getDtabSenderTb().get(i).toString());
            }

            i18n = new I18n("en", list);
            i18n_td = new I18n("bo", list_td);

            metadata = new Metadata(new Label( "en","dtab:sender"),
                    new Value(new I18n[]{i18n, i18n_td}));
            return metadata;
        }
        else {
            return metadata;
        }*/

        PersonRole sender = dtabAttributes.getSender();

        if (sender == null) {
            return null;
        }

        List<String> senderNames = sender.getPersonNames();

        if (senderNames == null || senderNames.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("de", senderNames);

        Metadata metadata = new Metadata(
                new Label("de", "dtab:sender"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
