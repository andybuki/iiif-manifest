package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.SealInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SealColor {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        SealInfo sealInfo = dtabAttributes.getSealInfo();

        if (sealInfo == null) {
            return null;
        }

        List<String> colors = sealInfo.getColors();

        if (colors == null || colors.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("de", colors);

        Metadata metadata = new Metadata(
                new Label("de", "dtab:seal_color"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
