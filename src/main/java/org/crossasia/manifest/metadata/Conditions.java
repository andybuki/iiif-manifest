package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

import static org.crossasia.manifest.IIIFPresentationDlllm.ORIGINAL_LANGUAGE;
public class Conditions {

    public static Metadata getMetadataConditions(DllmAttributes dllmAttributes) {

        String condition ="";
        String condition_lao ="";
        Metadata metadata_condition = null;

        if (dllmAttributes.getConditions_name()!=null)
            condition = dllmAttributes.getConditions_name();

        if (dllmAttributes.getConditions_name()!=null)
            condition_lao = dllmAttributes.getConditions_name_lao();


        if (condition!="" || condition_lao!="") {
            metadata_condition = new Metadata(new Label(new I18n("en", "conditions")),
                    new Value(new I18n("en", condition),
                            new I18n(ORIGINAL_LANGUAGE, condition_lao)));
        }
        return metadata_condition;
    }
}
