package org.crossasia.manifest.start;

import info.freelibrary.iiif.presentation.v3.Collection;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Summary;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.crossasia.manifest.statics.collection.CollectionData.*;

public class IIIFCollection {
    public static void buildCollection () throws FileNotFoundException {
        File in = new File("C:\\Colllections\\dtab\\manifests\\split\\manifest\\");
        Collection collection = getCollection(in);
        PrintStream out = new PrintStream(new FileOutputStream("C:\\Colllections\\dtab\\manifests\\split\\collection.json"));
        out.println(collection);
    }

    @NotNull
    private static Collection getCollection(File in) throws FileNotFoundException {
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
                title = (String) label.getJSONArray("en").get(0);
            }


            String manifestID = id;
            Collection.Item manifest = new Collection.Item(Collection.Item.Type.MANIFEST, manifestID);
            manifest.setLabel(title);
            items.add(manifest);
            collection.setItems(items);
        }
    }
}

