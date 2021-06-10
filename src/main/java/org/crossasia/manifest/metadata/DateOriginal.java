package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class DateOriginal {
    @NotNull
    public static Metadata getMetadataDateOriginal(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "date_original")),
                new Value(new I18n("en",dllmAttributes.getDate_original()),
                        new I18n("lo", dllmAttributes.getDate_original_lao())));
    }
}
