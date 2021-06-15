package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class DocumentsID {

    public static Metadata getMetadataDocumentsID(DllmAttributes dllmAttributes) {
        return new Metadata(new Label( "dc:identifier"),
                        new Value(dllmAttributes.getDocuments_id()));
    }
}