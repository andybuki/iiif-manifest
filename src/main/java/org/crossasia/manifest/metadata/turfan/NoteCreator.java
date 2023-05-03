package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class NoteCreator {

    public static Metadata get(CollectionAttributes turfanAttributes, Manifest manifest) {

        Metadata metadata = null;

        if(turfanAttributes.getNoteCreator()!=null) {
            metadata = new Metadata(new Label( "de","turfan:noteCreator"),
                    new Value( new I18n("de", turfanAttributes.getNoteCreator())));
            return metadata;
        }
        else {
            metadata = null;
            return metadata;
        }
    }
}
