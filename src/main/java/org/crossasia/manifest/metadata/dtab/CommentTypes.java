package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

import java.util.ArrayList;
import java.util.List;

public class CommentTypes {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        String commentTypes = dtabAttributes.getCommentAboutTypesOfDocument();
        String commentTypesTb = dtabAttributes.getCommentAboutTypesOfDocumentTb();

        // Collect non-empty comments
        List<I18n> i18nList = new ArrayList<>();

        if (commentTypes != null && !commentTypes.isEmpty()) {
            i18nList.add(new I18n("en", commentTypes));
        }

        if (commentTypesTb != null && !commentTypesTb.isEmpty()) {
            i18nList.add(new I18n("bo", commentTypesTb));
        }

        // Return null if no comments exist
        if (i18nList.isEmpty()) {
            return null;
        }

        // Create metadata with both languages
        Metadata metadata = new Metadata(
                new Label("en", "dtab:comment_about_types_of_document"),
                new Value(i18nList.toArray(new I18n[0]))
        );

        return metadata;
    }
}
