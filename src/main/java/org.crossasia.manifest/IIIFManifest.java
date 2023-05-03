package org.crossasia.manifest;

import info.freelibrary.iiif.presentation.v3.*;
import info.freelibrary.iiif.presentation.v3.properties.*;
import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.canvas.Canvas;
import org.crossasia.manifest.json.StaticJsonCallerTurfan;
import org.crossasia.manifest.metadata.StaticFieldsTurfan;
import org.crossasia.manifest.metadata.turfan.*;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

import static org.crossasia.manifest.metadata.MetadataMembers.metadataMembers;

public class IIIFManifest {
    public static void main(String[] args) throws IOException {

        File in = new File("C:\\Users\\b-ab107\\turfan\\manifests3\\");
        PrintStream out = new PrintStream(new FileOutputStream("src/main/resources/output.txt"));
        File dir = new File(String.valueOf(in));
        File[] filesDir = dir.listFiles();
        Manifestor manifestor = new Manifestor();

        for (File file : filesDir) {
            CollectionAttributes turfanAttributes = new CollectionAttributes();
            File created = new File("C:\\Users\\b-ab107\\turfan\\res\\");
            StringBuilder sb = new StringBuilder();
            JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

            StaticJsonCallerTurfan.staticJsonCaller(turfanAttributes, jsonObj);
            Manifest manifest;

            String identifier = jsonObj.get("id").toString().replace(" ", "");
            String title = jsonObj.get("dc:title").toString();
            I18n i18n_title = LabelMetadata.getLabelTitle(turfanAttributes);

            if (i18n_title!=null) {
                manifest = new Manifest(String.valueOf(file.getName()), new Label( new I18n[]{i18n_title}));
            } else {
                manifest = new Manifest(String.valueOf(file), new Label( new I18n[]{i18n_title}));
            }

            StaticFieldsTurfan.staticFields(identifier, manifest, title); //all static fields

            metadataMembers(turfanAttributes, manifest);

            Canvas canvas = new Canvas();
            canvas.createCanvas(file, turfanAttributes, jsonObj, manifest);
            File  newFile = new File(created+"\\"+ "akten"+ jsonObj.get("id") + ".json");
            manifestor.write(manifest, newFile);
            System.setOut(out);

        }
    }
}
