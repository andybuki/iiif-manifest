package org.crossasia.manifest.start;

import info.freelibrary.iiif.presentation.v3.*;
import info.freelibrary.iiif.presentation.v3.properties.*;
import info.freelibrary.iiif.presentation.v3.utils.Manifestor;

import org.crossasia.manifest.attributes.KahlenAttributes;
import org.crossasia.manifest.attributes.TapAttributes;

import org.crossasia.manifest.canvas.CanvasKahlen;
import org.crossasia.manifest.json.StaticJsonCallerTurfan;
import org.crossasia.manifest.metadata.StaticFields;
import org.crossasia.manifest.metadata.kahlen.LabelMetadata;
import org.crossasia.manifest.transformation.IdTransformation;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.crossasia.manifest.metadata.MetadataMembersKahlen.metadataMembersKahlen;
import static org.crossasia.manifest.start.FileCreator.fileCreator;
import static org.crossasia.manifest.statics.manifest.ManifestData.MANIFESTS_FOLGER;
import static org.crossasia.manifest.statics.manifest.ManifestData.RESULT_FOLGER;


public class IIIFManifest {
    public static void buildManifest() throws IOException {
        File in = new File(RESULT_FOLGER);
        File directory = new File(String.valueOf(in));
        File[] filesDir = directory.listFiles();
        Manifestor manifestor = new Manifestor();
        fileCreator(filesDir, manifestor);
    }
}
