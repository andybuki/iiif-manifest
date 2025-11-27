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

public class ReceiverComment {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        PersonRole receiver = dtabAttributes.getReceiver();

        if (receiver == null) {
            return null;
        }

        String receiverComment = receiver.getRoleComment();
        // Note: You need to add receiverCommentTb field to PersonRole if it doesn't exist
        // For now, assuming only one comment field exists

        // Collect non-empty comments
        List<I18n> i18nList = new ArrayList<>();

        if (receiverComment != null && !receiverComment.isEmpty()) {
            i18nList.add(new I18n("en", receiverComment));
        }

        // If you have a Tibetan version field in PersonRole (receiverCommentTb):
        // String receiverCommentTb = receiver.getReceiverCommentTb();
        // if (receiverCommentTb != null && !receiverCommentTb.isEmpty()) {
        //     i18nList.add(new I18n("bo", receiverCommentTb));
        // }

        if (i18nList.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("en", "dtab:receiver_comment"),
                new Value(i18nList.toArray(new I18n[0]))
        );

        return metadata;
    }
}
