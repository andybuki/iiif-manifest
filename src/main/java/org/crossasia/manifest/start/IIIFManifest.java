package org.crossasia.manifest.start;

import info.freelibrary.iiif.presentation.v3.*;
import info.freelibrary.iiif.presentation.v3.properties.*;
import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.canvas.Canvas;
import org.crossasia.manifest.json.StaticJsonCallerTurfan;
import org.crossasia.manifest.metadata.StaticFields;
import org.crossasia.manifest.metadata.turfan.LabelMetadata;
import org.crossasia.manifest.transformation.IdTransformation;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.crossasia.manifest.metadata.MetadataMembersDtab.metadataMembersDtab;


public class IIIFManifest {
    public static void main(String[] args) throws IOException {
        File in = new File("C:\\Colllections\\dtab\\manifests\\split\\files\\");
        File directory = new File(String.valueOf(in));
        File[] filesDir = directory.listFiles();
        Manifestor manifestor = new Manifestor();
        fileCreator(filesDir, manifestor);
    }

    private static void fileCreator(File[] filesDir, Manifestor manifestor) throws IOException {
        for (File file : filesDir) {
            //CollectionAttributes attributes = new CollectionAttributes();
            //SugawaraAttributes attributes = new SugawaraAttributes();
            DtabAttributes attributes = new DtabAttributes();
            File out = new File("C:\\Colllections\\dtab\\manifests\\split\\manifest\\");
            JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

            //StaticJsonCallerTurfan.staticJsonCaller(attributes, jsonObj);
            StaticJsonCallerTurfan.staticJsonCallerDtab(attributes, jsonObj);
            Manifest manifest=null;

            IdTransformation transformation = new IdTransformation();
            String id = IdTransformation.idTransformator(file);

            String archive_signatory = attributes.getDtabArchiveSignatory();
            I18n i18n_title = LabelMetadata.getLabelTitle(attributes);

            if (i18n_title.getStrings().get(0)!=null) {
                manifest = new Manifest(String.valueOf(file.getName()),
                        new Label( new I18n[]{i18n_title}));
            } else {
                manifest = new Manifest(String.valueOf(file.getName()),
                        new Label("KCDC_"+id));
            }

            StaticFields.staticFields(id, manifest, i18n_title.getStrings().get(0), archive_signatory); //all static fields
            System.out.println(file.getName());
            metadataMembersDtab(attributes, manifest);
            Canvas canvas = new Canvas();
            canvas.createCanvas(file, attributes, jsonObj, manifest);
            File  newFile = new File(out+"\\"+ file.getName());
            manifestor.write(manifest, newFile);
        }
    }
}
