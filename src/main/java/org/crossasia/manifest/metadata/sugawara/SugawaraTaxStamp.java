package org.crossasia.manifest.metadata.sugawara;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.SugawaraAttributes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SugawaraTaxStamp {
    public static Metadata get(SugawaraAttributes sugawaraAttributes, Manifest manifest) {
        List<String> taxStamps = sugawaraAttributes.getTaxStamps();

        if (taxStamps == null || taxStamps.isEmpty()) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>(taxStamps);
        List<String> uniqueList = new ArrayList<>(hashSet);
        I18n i18n = new I18n("none", uniqueList);

        Metadata metadata = new Metadata(
                new Label("none", "sugawara:taxStamp"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
        }
}
