package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

public class SenderComment {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        Metadata metadata = null;
        if(dtabAttributes.getDtabSenderComment()!=""
                || dtabAttributes.getDtabSenderCommentTb()!="") {
            metadata = new Metadata(new Label( "en","dtab:sender_comment"),
                    new Value( new I18n("en", dtabAttributes.getDtabSenderComment()),
                            new I18n("bo", dtabAttributes.getDtabSenderCommentTb())));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
