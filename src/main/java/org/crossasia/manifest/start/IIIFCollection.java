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

import static org.crossasia.manifest.collection.CollectionAttributes.getCollection;
import static org.crossasia.manifest.statics.collection.CollectionData.*;

public class IIIFCollection {
    public static void buildCollection () throws FileNotFoundException {
        File in = new File(MANIFESTS_FOLGER);
        Collection collection = getCollection(in);
        PrintStream out = new PrintStream(new FileOutputStream(COLLECTION));
        out.println(collection);
    }
}

