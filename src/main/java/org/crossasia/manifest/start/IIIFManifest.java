package org.crossasia.manifest.start;

import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import java.io.File;
import java.io.IOException;
import static org.crossasia.manifest.start.FileCreator.fileCreator;
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
