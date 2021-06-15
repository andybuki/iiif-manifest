package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class HasColophon {

    public static Metadata getMetadataHasColophon(DllmAttributes dllmAttributes) {

        Metadata metadata_HasColophon = null;

        if(dllmAttributes.getDocuments_has_colophon()!=null) {
            metadata_HasColophon = new Metadata(new Label("has_colophon"),
                    new Value(dllmAttributes.getDocuments_has_colophon()));
            return metadata_HasColophon;
        }
        else return metadata_HasColophon;

    }
}
