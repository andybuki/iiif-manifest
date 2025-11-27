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

public class Recipient {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        PersonRole receiver = dtabAttributes.getReceiver();

        if (receiver == null) {
            return null;
        }

        String recipientName = receiver.getPersonName();
        // Note: You need to add recipientTb field to PersonRole if it doesn't exist
        // For now, assuming only one name field exists

        // Collect non-empty recipient names
        List<I18n> i18nList = new ArrayList<>();

        if (recipientName != null && !recipientName.isEmpty()) {
            i18nList.add(new I18n("en", recipientName));
        }

        // If you have a Tibetan version field in PersonRole (recipientTb):
        // String recipientTb = receiver.getRecipientTb();
        // if (recipientTb != null && !recipientTb.isEmpty()) {
        //     i18nList.add(new I18n("bo", recipientTb));
        // }

        if (i18nList.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("en", "schema:recipient"),
                new Value(i18nList.toArray(new I18n[0]))
        );

        return metadata;
    }
}

