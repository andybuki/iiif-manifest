package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.constants.PublicConstants;

import static org.crossasia.manifest.constants.PublicConstants.ORIGINAL_LANGUAGE_ENGLISH;
import static org.crossasia.manifest.presentations.IIIFPresentationDlllm.LANGUAGE_FOREING;

public class DateOriginal {

    public static Metadata getMetadataDateOriginal(CollectionAttributes dllmAttributes) {

        Metadata metadata_date_original = null;

        if(dllmAttributes.getDate_original()!=null) {
            metadata_date_original = new Metadata(new Label(new I18n(ORIGINAL_LANGUAGE_ENGLISH, "date_original")),
                    new Value(new I18n(ORIGINAL_LANGUAGE_ENGLISH,dllmAttributes.getDate_original()),
                            new I18n(LANGUAGE_FOREING, dllmAttributes.getDate_original_lao())));
            return metadata_date_original;
        }
        else return metadata_date_original;

    }
}
