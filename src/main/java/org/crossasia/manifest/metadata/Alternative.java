package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import static org.crossasia.manifest.IIIFPresentationDlllm.ORIGINAL_LANGUAGE;
import java.util.ArrayList;

public class Alternative {
    public static Metadata getMetadataAlternative(DllmAttributes dllmAttributes) {
        ArrayList<String> alternativeArrayList = new ArrayList<>();
        ArrayList<String> alternativeThArrayList = new ArrayList<>();

        Metadata metadata_alternative =new Metadata(new Label(""), new Value(""));
        if (dllmAttributes.getAlternative_label_ro()!=null) {
            for (int i = 0; i < dllmAttributes.getAlternative_label_ro().length(); i++) {
                alternativeArrayList.add(dllmAttributes.getAlternative_label_ro().get(i).toString());
                alternativeThArrayList.add(dllmAttributes.getAlternative_label_th().get(i).toString());
                I18n i18n_alternative_Roman = new I18n("en", alternativeArrayList);
                I18n i18n_alternative_Thai = new I18n(ORIGINAL_LANGUAGE, alternativeThArrayList);
                metadata_alternative = new Metadata(new Label("en", "dc:alternative"),
                        new Value(new I18n[]{i18n_alternative_Roman, i18n_alternative_Thai}));
            }
        }

        if (dllmAttributes.getAlternative_label_ro()==null &&
                dllmAttributes.getAlternative_label_th()==null) {
            metadata_alternative = null;
        }

        return metadata_alternative;
    }
}
