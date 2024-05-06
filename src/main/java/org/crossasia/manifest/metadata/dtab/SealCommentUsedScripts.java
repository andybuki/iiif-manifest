package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

import java.util.ArrayList;

public class SealCommentUsedScripts {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        Metadata metadata = null;
        I18n i18n = null;
        ArrayList<String> list = new ArrayList<>();
        if(dtabAttributes.getDtabSealCommentUsedScripts()!=null) {
            for (int i = 0; i < dtabAttributes.getDtabSealCommentUsedScripts().length(); i++) {
                list.add(dtabAttributes.getDtabSealCommentUsedScripts().get(i).toString());
            }
            i18n = new I18n("none", list);
            metadata = new Metadata(new Label( "none","dtab:seal_comment_used_scripts"),
                    new Value( new I18n[]{i18n}));
            return metadata;
        }
        else {
            return metadata;
        }
    }
}
