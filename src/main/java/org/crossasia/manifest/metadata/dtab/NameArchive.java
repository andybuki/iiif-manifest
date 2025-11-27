package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.ArchiveInfo;
import org.crossasia.manifest.attributes.domain.PersonRole;

public class NameArchive {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {

        ArchiveInfo archiveInfo = dtabAttributes.getArchiveInfo();

        if (archiveInfo == null) {
            return null;
        }

        String archiveName = archiveInfo.getArchiveName();

        if (archiveName == null || archiveName.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("en", "dtab:name_of_archive"),
                new Value(new I18n("en", archiveName))
        );

        return metadata;
    }
}
