package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;

import java.util.ArrayList;
import java.util.List;

public class SealInfo {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        org.crossasia.manifest.attributes.domain.SealInfo sealInfo = dtabAttributes.getSealInfo();

        if (sealInfo == null) {
            return null;
        }

        List<String> multiSeal = sealInfo.getMultiSeal();

        if (multiSeal == null || multiSeal.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("en", multiSeal);

        Metadata metadata = new Metadata(
                new Label("en", "dtab:seal_info"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
