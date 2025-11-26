package org.crossasia.manifest.collection;

import info.freelibrary.iiif.presentation.v3.Collection;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Summary;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.crossasia.manifest.statics.collection.CollectionData.*;
import static org.crossasia.manifest.statics.collection.CollectionData.COLLECTION_URL_LINK_ID;

public class CollectionAttributes {
    @NotNull
    public static Collection getCollection(File in) throws FileNotFoundException {
        File dir = new File(String.valueOf(in));
        File[] filesInDir = dir.listFiles();

        Collection collection = new Collection("Collection", COLLECTION_LABEL);
        List<Collection.Item> items = new ArrayList<>();
        Summary summary =
                new Summary(new I18n(LANGUAGE, COLLECTION_SUMMARY));
        collection.setSummary(summary);
        collection.setID(COLLECTION_URL_LINK_ID);

        getManifestData(filesInDir, collection, items);
        return collection;
    }

    private static void getManifestData(File[] filesInDir, Collection collection, List<Collection.Item> items)
            throws FileNotFoundException {
        for (File file : filesInDir) {
            JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));
            String id = (String) jsonObj.get("id");
            JSONObject label= (JSONObject) jsonObj.get("label");
            String title = "";
            if (label!=null) {
                if (label.has("en")) {
                    title = (String) label.getJSONArray("en").get(0);
                }
                System.out.println(id);
            } else {
                title= "No title";
            }

            String manifestID = id;
            Collection.Item manifest = new Collection.Item(Collection.Item.Type.MANIFEST, manifestID);
            manifest.setLabel(title);
            items.add(manifest);
            collection.setItems(items);
        }
    }
}
