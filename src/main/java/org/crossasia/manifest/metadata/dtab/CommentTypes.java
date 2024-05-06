package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

public class CommentTypes {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        Metadata metadata = null;
        if(dtabAttributes.getDtabCommentAboutTypesOfDocument()!=""
                || dtabAttributes.getDtabCommentAboutTypesOfDocumentTb()!="") {
            metadata = new Metadata(new Label( "en","dtab:comment_about_types_of_document"),
                    new Value( new I18n("en", dtabAttributes.getDtabCommentAboutTypesOfDocument()),
                            new I18n("bo", dtabAttributes.getDtabCommentAboutTypesOfDocumentTb())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
