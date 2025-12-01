package org.crossasia.manifest.metadata.dtab;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.attributes.domain.FileReferences;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class PreviewImageFiles {
    public static Metadata get(DtabAttributes dtabAttributes, Manifest manifest) {
        FileReferences fileReferences = dtabAttributes.getFileReferences();

        if (fileReferences == null) {
            return null;
        }

        List<String> previewImageFiles = fileReferences.getPreviewImageFiles();

        if (previewImageFiles == null || previewImageFiles.isEmpty()) {
            return null;
        }

        I18n i18n = new I18n("none", previewImageFiles);

        Metadata metadata = new Metadata(
                new Label("none", "dtab:preview_image_files"),
                new Value(new I18n[]{i18n})
        );

        return metadata;
    }
}
