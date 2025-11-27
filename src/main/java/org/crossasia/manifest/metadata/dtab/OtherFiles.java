package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.FileReferences;

public class OtherFiles {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        FileReferences fileReferences = dtabAttributes.getFileReferences();

        if (fileReferences == null) {
            return null;
        }

        String otherFiles = fileReferences.getOtherFiles();

        if (otherFiles == null || otherFiles.isEmpty()) {
            return null;
        }

        Metadata metadata = new Metadata(
                new Label("none", "dtab:other_files"),
                new Value(new I18n("none", otherFiles))
        );

        return metadata;
    }
}
