package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.ArchiveInfo;
@Deprecated
public class IdInArchive {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        ArchiveInfo archiveInfo = dtabAttributes.getArchiveInfo();

        if (archiveInfo == null) {
            return null;
        }

        String idInArchive = archiveInfo.getIdInArchive();

        if (idInArchive == null || idInArchive.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("none", "dtab:id_in_archive"),
                new Value(new I18n("none", idInArchive))
        );

        return metadata;
    }
}
