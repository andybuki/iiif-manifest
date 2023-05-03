package org.crossasia.manifest.metadata.turfan;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;

public class TitleTurfan {

    public static Metadata getTitle(CollectionAttributes turfanAttributes, Manifest manifest) {

        Metadata metadata_title = null;

        if(turfanAttributes.getTitle()!=null) {
            metadata_title = new Metadata(new Label( "de","dc:title"),
                    new Value( new I18n("de", turfanAttributes.getTitle())));
            return metadata_title;
        }
        else {
            metadata_title = null;
            return metadata_title;
        }
    }
}
