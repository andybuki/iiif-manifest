package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.attributes.domain.SealInfo;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class SugawaraSeal {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        SealInfo sealInfo = sugawaraAttributes.getSealInfo();

        if (sealInfo == null) {
            return null;
        }

        List<String> seals = sealInfo.getSeals();

        if (seals == null || seals.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("en", seals);

        Metadata metadata = new Metadata(
                new Label("en", "sugawara:seal"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
