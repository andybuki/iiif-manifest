
package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.crossasia.manifest.constants.OriginalLanguage;
import org.crossasia.manifest.constants.PublicConstants;


import java.util.ArrayList;
import java.util.List;

public final class Alternative {
    private static List<String> alternativeArrayList;
    private static List<String> alternativeThArrayList;
    private static Metadata metadataAlternative;

    private Alternative() {
    }

    public static Metadata getMetadataAlternative(DllmAttributes dllmAttributes) {
        if (dllmAttributes.getAlternativeLabelRo() != null) {
            metadataAlternative = new Metadata(new Label(""), new Value(""));
            for (var i = 0; i < dllmAttributes.getAlternativeLabelRo().length(); i++) {
                alternativeArrayList.add(dllmAttributes.getAlternativeLabelRo().get(i).toString());
                alternativeThArrayList.add(dllmAttributes.getAlternativeLabelTh().get(i).toString());
                var alternativeRoman = new I18n(OriginalLanguage.ENGLISH.getName(), alternativeArrayList);
                var alternativeThai = new I18n(PublicConstants.ORIGINAL_LANGUAGE, alternativeThArrayList);
                metadataAlternative = new Metadata(new Label(OriginalLanguage.ENGLISH.getName(), "dc:alternative"),
                        new Value(new I18n[]{alternativeRoman, alternativeThai}));
            }
        }
        return metadataAlternative;
    }
}
