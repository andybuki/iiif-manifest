package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class Date {
    @NotNull
    public static Metadata getMetadataDate(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "dc:date")),
                new Value(new I18n("en", String.valueOf(dllmAttributes.getDocuments_date_written()))));
    }
}
