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
@Deprecated
public class SealSize {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        SealInfo sealInfo = dtabAttributes.getSealInfo();

        if (sealInfo == null) {
            return null;
        }

        List<String> sealSizes = sealInfo.getSizes();

        if (sealSizes == null || sealSizes.isEmpty()) {
            return null;
        }

        // Remove duplicates using HashSet
        HashSet<String> hashSet = new HashSet<>(sealSizes);
        List<String> uniqueList = new ArrayList<>(hashSet);

        I18n i18n = new I18n("none", uniqueList);

        Metadata metadata = new Metadata(
                new Label("none", "dtab:seal_size"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
