package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;
import static org.crossasia.manifest.IIIFPresentationDlmnt.ORIGINAL_LANGUAGE;
public class Legibilities {

    public static Metadata getMetadataLegibilities(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "legibilities")),
                new Value(new I18n("en",dllmAttributes.getLegibilities_name()),
                        new I18n(ORIGINAL_LANGUAGE, dllmAttributes.getLegibilities_name_lao())));
    }
}
