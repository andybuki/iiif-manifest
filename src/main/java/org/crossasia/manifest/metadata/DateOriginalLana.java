package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import static org.crossasia.manifest.IIIFPresentationDlllm.ORIGINAL_LANGUAGE;
public class DateOriginalLana {

    public static Metadata getMetadataDateOriginal(DllmAttributes dllmAttributes) {

        Metadata metadata_date_original_lana = null;

        if(dllmAttributes.getYear()!=0) {
            metadata_date_original_lana = new Metadata(new Label(new I18n("en", "date_original")),
                    new Value(new I18n("en",dllmAttributes.getYear() + " ("+ dllmAttributes.getDocuments_preferred_date_system()+")"),
                            new I18n(ORIGINAL_LANGUAGE, dllmAttributes.getYear() + " ("+ dllmAttributes.getDocuments_preferred_date_system_lao()+")")));
            return metadata_date_original_lana;
        }
        else if (dllmAttributes.getYear()==0 && dllmAttributes.getDocuments_preferred_date_system()!=null) {
            metadata_date_original_lana = new Metadata(new Label(new I18n("en", "date_original")),
                    new Value(new I18n("en",dllmAttributes.getDocuments_preferred_date_system()),
                            new I18n(ORIGINAL_LANGUAGE,  dllmAttributes.getDocuments_preferred_date_system_lao())));
            return metadata_date_original_lana;
        }
        else return metadata_date_original_lana;
    }
}
