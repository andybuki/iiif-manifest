package org.crossasia.manifest.manifestparts;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.json.StaticJsonCaller;
import org.crossasia.manifest.metadata.StaticFieldsDllmCollection;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.crossasia.manifest.constants.PublicConstants.COLLECTION_PATH_PLUS_ZERO;
import static org.crossasia.manifest.metadata.MetadataMembers.metadataMembers;
import static org.crossasia.manifest.presentations.IIIFPresentationDlllm.COLLECTION_ADDITION;
import static org.crossasia.manifest.presentations.IIIFPresentationDlllm.manifestsResultFolderPath;
import static org.crossasia.manifest.presentations.ProviderToManifest.addProviderToManifest;

public class FilePart {
    public static void fileGeneration(File[] filesInDir, Manifestor manifestor) throws IOException {
        int counter;
        for (File file : filesInDir) {
            CollectionAttributes collectionAttributes = new CollectionAttributes();
            File manifestsResultFolder = new File(manifestsResultFolderPath);

            JSONObject jsonMetadata = new JSONObject(new JSONTokener(new FileInputStream(file)));
            StaticJsonCaller.staticJsonCaller(collectionAttributes, jsonMetadata);

            Manifest manifest = LabelPart.getLabelDataForManifest(file, collectionAttributes);

            String plmp_id = collectionAttributes.getDocuments_code_number();
            // change for multiple collections
            counter = Integer.parseInt(collectionAttributes.getDocuments_id().replace("dllm_",""));

            String collection = collectionAttributes.getIn_collection();

            StaticFieldsDllmCollection.staticFields(counter, manifest, plmp_id, collection); //all static fields

            metadataMembers(collectionAttributes, manifest);
            // change for multiple collections
            String book_ID = COLLECTION_ADDITION + counter;

            ImagePart.addImagePart(file, jsonMetadata, manifest, book_ID);
            addProviderToManifest(manifest, collection);

            File newFile = new File(manifestsResultFolder + "/" + collectionAttributes.getDocuments_id() + ".json");
            manifestor.write(manifest, newFile);
        }
    }
}
