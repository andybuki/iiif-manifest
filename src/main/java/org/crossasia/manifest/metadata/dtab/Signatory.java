package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.ArchiveInfo;

public class Signatory {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        ArchiveInfo archiveInfo = dtabAttributes.getArchiveInfo();

        if (archiveInfo == null) {
            return null;
        }

        String archiveSignatory = archiveInfo.getArchiveSignatory();

        if (archiveSignatory == null || archiveSignatory.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("none", "dtab:archive_signatory"),
                new Value(new I18n("none", archiveSignatory))
        );

        return metadata;
    }
}
