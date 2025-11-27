package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.PersonRole;

import java.util.ArrayList;

public class SenderId {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        PersonRole sender = dtabAttributes.getSender();

        if (sender == null) {
            return null;
        }

        String senderId = sender.getPersonId();

        if (senderId == null || senderId.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("none", senderId);

        Metadata metadata = new Metadata(
                new Label("none", "dtab:sender_id"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
