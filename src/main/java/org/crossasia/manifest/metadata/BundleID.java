package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class BundleID {
    public static Metadata getMetadataBundleID(CollectionAttributes dllmAttributes) {
        Metadata metadata_bundle_id = null;

        if(dllmAttributes.getDocuments_bundle_id()!=null) {
            metadata_bundle_id = new Metadata(new Label("otherIdentifier.bundle_id"),
                    new Value(dllmAttributes.getDocuments_bundle_id()));
            return metadata_bundle_id;
        }
            else return metadata_bundle_id;
    }
}
