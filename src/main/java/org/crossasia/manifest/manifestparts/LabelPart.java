package org.crossasia.manifest.manifestparts;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.metadata.LabelMetadata;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class LabelPart {

    @NotNull
    public static Manifest getLabelDataForManifest(File file, CollectionAttributes collectionAttributes) {
        Manifest manifest;
        I18n i18n_title_Roman = LabelMetadata.getStringsLabel(collectionAttributes);
        I18n i18n_title = LabelMetadata.getStringsLabelBoth(collectionAttributes);
        I18n i18n_title_no_title_both = LabelMetadata.getStringsLabelNoTitleBoth(collectionAttributes);
        if (i18n_title_Roman!=null) {
            manifest = new Manifest(String.valueOf(file), new Label(i18n_title));
        } else {
            manifest = new Manifest(String.valueOf(file), new Label(i18n_title_no_title_both));
        }
        return manifest;
    }
}
