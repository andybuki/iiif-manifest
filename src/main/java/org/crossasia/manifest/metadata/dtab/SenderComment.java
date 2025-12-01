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
public class SenderComment {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        PersonRole sender = dtabAttributes.getSender();

        if (sender == null) {
            return null;
        }

        String senderComment = sender.getRoleComment();
        // Note: You need to add senderCommentTb field to PersonRole if it doesn't exist
        // For now, assuming only one comment field exists in PersonRole

        // Collect non-empty comments
        List<I18n> i18nList = new ArrayList<>();

        if (senderComment != null && !senderComment.isEmpty()) {
            i18nList.add(new I18n("en", senderComment));
        } else {
            // Add "none" if English comment is empty but we have other data
            i18nList.add(new I18n("en", "none"));
        }

        // If you have a Tibetan version field in PersonRole (senderCommentTb):
        // String senderCommentTb = sender.getSenderCommentTb();
        // if (senderCommentTb != null && !senderCommentTb.isEmpty()) {
        //     i18nList.add(new I18n("bo", senderCommentTb));
        // }

        if (i18nList.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("en", "dtab:sender_comment"),
                new Value(i18nList.toArray(new I18n[0]))
        );

        return metadata;
    }
}
