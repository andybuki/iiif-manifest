package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class DocumentsRoll {
    @NotNull
    public static Metadata getMetadataDocumentsRoll(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "otherIdentifier.roll")),
                new Value(new I18n("en",dllmAttributes.getDocuments_roll())));
    }
}
