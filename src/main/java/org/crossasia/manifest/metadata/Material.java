package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;

public class Material {

    public static Metadata getMetadataMaterial(DllmAttributes dllmAttributes) {
        return new Metadata(new Label(new I18n("en", "material")),
                new Value(new I18n("en",dllmAttributes.getMaterials_name()),
                        new I18n("lo", dllmAttributes.getMaterials_name_lao())));
    }
}
