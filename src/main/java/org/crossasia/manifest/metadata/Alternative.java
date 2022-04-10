
package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.CollectionAttributes;
import java.util.List;

import static org.crossasia.manifest.constants.PublicConstants.ORIGINAL_LANGUAGE_ENGLISH;
import static org.crossasia.manifest.presentations.IIIFPresentationDlllm.LANGUAGE_FOREING;

public final class Alternative {
    private static List<String> alternativeArrayList;
    private static List<String> alternativeThArrayList;
    private static Metadata metadataAlternative;

    private Alternative() {
    }

    public static Metadata getMetadataAlternative(CollectionAttributes dllmAttributes) {
        if (dllmAttributes.getAlternativeLabelRo() != null) {
            metadataAlternative = new Metadata(new Label(""), new Value(""));
            for (var i = 0; i < dllmAttributes.getAlternativeLabelRo().length(); i++) {
                alternativeArrayList.add(dllmAttributes.getAlternativeLabelRo().get(i).toString());
                alternativeThArrayList.add(dllmAttributes.getAlternativeLabelTh().get(i).toString());
                var alternativeRoman = new I18n(ORIGINAL_LANGUAGE_ENGLISH, alternativeArrayList);
                var alternativeThai = new I18n(LANGUAGE_FOREING, alternativeThArrayList);
                metadataAlternative = new Metadata(new Label(ORIGINAL_LANGUAGE_ENGLISH, "dc:alternative"),
                        new Value(new I18n[]{alternativeRoman, alternativeThai}));
            }
        }
        return metadataAlternative;
    }
}
