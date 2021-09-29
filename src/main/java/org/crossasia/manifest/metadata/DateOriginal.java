package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;
import static org.crossasia.manifest.IIIFPresentationDlmnt.ORIGINAL_LANGUAGE;
public class DateOriginal {

    public static Metadata getMetadataDateOriginal(DllmAttributes dllmAttributes) {

        Metadata metadata_date_original = null;

        if(dllmAttributes.getDate_original()!=null) {
            metadata_date_original = new Metadata(new Label(new I18n("en", "date_original")),
                    new Value(new I18n("en",dllmAttributes.getDate_original()),
                            new I18n(ORIGINAL_LANGUAGE, dllmAttributes.getDate_original_lao())));
            return metadata_date_original;
        }
        else return metadata_date_original;

    }
}
