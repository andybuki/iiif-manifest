package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.SealInfo;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class SealDocID {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        SealInfo sealInfo = dtabAttributes.getSealInfo();

        if (sealInfo == null) {
            return null;
        }

        List<String> documentIds = sealInfo.getDocumentIds();

        if (documentIds == null || documentIds.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("none", documentIds);

        Metadata metadata = new Metadata(
                new Label("none", "dtab:seal_docID"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
