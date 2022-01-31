package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;
import static org.crossasia.manifest.IIIFPresentationDlllm.ORIGINAL_LANGUAGE;
import java.util.ArrayList;

public class Material {

    public static Metadata getMetadataMaterial(DllmAttributes dllmAttributes) {

        ArrayList<String> materialRomanArrayList = new ArrayList<>();
        ArrayList<String> materialThaiArrayList = new ArrayList<>();
        Metadata metadata_material = new Metadata(new Label(""), new Value(""));
        if (dllmAttributes.getMaterials_name() instanceof String) {
            return new Metadata(new Label(new I18n("en", "material")),
                    new Value(new I18n("en", dllmAttributes.getMaterials_name()),
                            new I18n(ORIGINAL_LANGUAGE, dllmAttributes.getMaterials_name_lao())));
        } else {
            if (dllmAttributes.getMaterial() != null &&
                    dllmAttributes.getMaterial_th() != null) {
                for (int i = 0; i < dllmAttributes.getMaterial().length(); i++) {
                    materialRomanArrayList.add(dllmAttributes.getMaterial().get(i).toString());
                    materialThaiArrayList.add(dllmAttributes.getMaterial_th().get(i).toString());
                    I18n i18n_material = new I18n("en", materialRomanArrayList);
                    I18n i18n_material_Thai = new I18n(ORIGINAL_LANGUAGE, materialThaiArrayList);
                    metadata_material = new Metadata(new Label("en", "material"),
                            new Value(new I18n[]{i18n_material, i18n_material_Thai}));
                }
            } else {
                metadata_material = null;
            }
            return metadata_material;
        }
    }
}
