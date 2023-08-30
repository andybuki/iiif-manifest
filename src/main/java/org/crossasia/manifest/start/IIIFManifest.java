package org.crossasia.manifest.start;

import info.freelibrary.iiif.presentation.v3.*;
import info.freelibrary.iiif.presentation.v3.properties.*;
import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.crossasia.manifest.canvas.Canvas;
import org.crossasia.manifest.json.StaticJsonCallerTurfan;
import org.crossasia.manifest.metadata.StaticFields;
import org.crossasia.manifest.metadata.turfan.*;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

import static org.crossasia.manifest.metadata.sugawara.MetadataMembers.metadataMembers;


public class IIIFManifest {
    public static void main(String[] args) throws IOException {
        File in = new File("C:\\Users\\b-ab107\\IdeaProjects\\iiifmanifestbuilders\\src\\main\\resources\\json\\");
        File directory = new File(String.valueOf(in));
        File[] filesDir = directory.listFiles();
        Manifestor manifestor = new Manifestor();
        fileCreator(filesDir, manifestor);
    }

    private static void fileCreator(File[] filesDir, Manifestor manifestor) throws IOException {
        for (File file : filesDir) {
            //CollectionAttributes attributes = new CollectionAttributes();
            SugawaraAttributes attributes = new SugawaraAttributes();
            File out = new File("C:\\Users\\b-ab107\\IdeaProjects\\iiifmanifestbuilders\\src\\main\\resources\\manifest\\");
            JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

            //StaticJsonCallerTurfan.staticJsonCaller(attributes, jsonObj);
            StaticJsonCallerTurfan.staticJsonCallerSugawara(attributes, jsonObj);
            Manifest manifest=null;

            String id = file.getName().toString().replace(".json", "");
            I18n i18n_title = LabelMetadata.getLabelTitle(attributes);

            if (i18n_title.getStrings().get(0)!=null) {
                manifest = new Manifest(String.valueOf(file.getName()),
                        new Label( new I18n[]{i18n_title}));
            } else {
                manifest = new Manifest(String.valueOf(file.getName()),
                        new Label( id));
            }

            StaticFields.staticFields(id, manifest, i18n_title.getStrings().get(0)); //all static fields

            metadataMembers(attributes, manifest);
            Canvas canvas = new Canvas();
            canvas.createCanvas(file, attributes, jsonObj, manifest);
            File  newFile = new File(out+"\\"+ file.getName());
            manifestor.write(manifest, newFile);
        }
    }
}
