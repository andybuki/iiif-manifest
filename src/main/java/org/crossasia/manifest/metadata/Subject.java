package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.constants.PublicConstants;

import static org.crossasia.manifest.constants.PublicConstants.ORIGINAL_LANGUAGE_ENGLISH;

public class Subject {

    public static Metadata getMetadataSubject(CollectionAttributes dllmAttributes) {

        Metadata metadata_subject = null;

        if(dllmAttributes.getSubject_ro()!=null) {
            metadata_subject = new Metadata(new Label( "dc:subject"),
                    new Value(new I18n(ORIGINAL_LANGUAGE_ENGLISH, dllmAttributes.getSubject_ro()),
                            new I18n(PublicConstants.ORIGINAL_LANGUAGE, dllmAttributes.getSubject_th())));
            return metadata_subject;
        }
        else return metadata_subject;

    }
}
