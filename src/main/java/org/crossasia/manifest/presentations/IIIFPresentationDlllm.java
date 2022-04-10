/*
* Create a presentation manifest for DLLM Collection
**/
package org.crossasia.manifest.presentations;

import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.constants.CollectionNames;
import org.crossasia.manifest.manifestparts.FilePart;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

import static org.crossasia.manifest.constants.PublicConstants.*;

@SpringBootApplication
public class IIIFPresentationDlllm  {

    public static String manifestsResultFolderPath = MANIFESTS_DLLM_PATH;
    public static String COLLECTION_NAME = CollectionNames.DLLM.getName();
    public static String COLLECTION_ADDITION = COLLECTION_PATH_PLUS_ZERO;
    public static String LANGUAGE_FOREING = LANGUAGE_LAO;
    public static void main(String[] args) throws IOException {
        File rawData = new File(DLLM_RAW_DATA);
        File[] filesInDir = rawData.listFiles();
        Manifestor manifestor = new Manifestor();
        FilePart.fileGeneration( filesInDir != null ? filesInDir : new File[0], manifestor);
    }
}
