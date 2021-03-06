package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class IsIllustrated {

    public static Metadata getMetadataIsIllustrated(CollectionAttributes dllmAttributes) {
        Metadata metadata_is_illustrated = null;

            if(dllmAttributes.getDocuments_is_illustrated()!=null) {
            metadata_is_illustrated = new Metadata(new Label("is_illustrated"),
                    new Value(dllmAttributes.getDocuments_is_illustrated()));
            return metadata_is_illustrated;
        }
            else return metadata_is_illustrated;

        }
}
