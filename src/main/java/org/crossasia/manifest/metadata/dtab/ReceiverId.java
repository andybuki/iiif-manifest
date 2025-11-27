package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.PersonRole;

import java.util.ArrayList;

public class ReceiverId {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        PersonRole receiver = dtabAttributes.getReceiver();

        if (receiver == null) {
            return null;
        }

        String receiverId = receiver.getPersonId();

        if (receiverId == null || receiverId.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("none", receiverId);

        Metadata metadata = new Metadata(
                new Label("none", "dtab:receiver_id"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
