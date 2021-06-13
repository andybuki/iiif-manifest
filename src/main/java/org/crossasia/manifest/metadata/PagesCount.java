package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class PagesCount {
    @NotNull
    public static Metadata getMetadataPagesCount(DllmAttributes dllmAttributes) {
        return new Metadata(new Label("pages_count"),
                new Value(String.valueOf(dllmAttributes.getDocuments_pages_count())));

        /*
        * return new Metadata(new Label(new I18n("en", "pages_count")),
                new Value(new I18n("en", String.valueOf(dllmAttributes.getDocuments_pages_count()))));
        * */
    }
}
