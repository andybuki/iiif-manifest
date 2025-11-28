package org.crossasia.manifest.start;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.utils.Manifestor;
import org.crossasia.manifest.attributes.KahlenAttributes;
import org.crossasia.manifest.attributes.TapAttributes;
import org.crossasia.manifest.canvas.CanvasKahlen;
import org.crossasia.manifest.json.StaticJsonCallerTurfan;
import org.crossasia.manifest.metadata.StaticFields;
import org.crossasia.manifest.metadata.kahlen.LabelMetadata;
import org.crossasia.manifest.transformation.IdTransformation;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.crossasia.manifest.metadata.MetadataMembersKahlen.metadataMembersKahlen;
import static org.crossasia.manifest.statics.manifest.ManifestData.MANIFESTS_FOLGER;

public class FileCreator {
    public static void fileCreator(File[] filesDir, Manifestor manifestor) throws IOException {
        for (File file : filesDir) {
            //SugawaraAttributes attributes = new SugawaraAttributes();
            //DtabAttributes attributes = new DtabAttributes();
            KahlenAttributes kahlenAttributes = new KahlenAttributes();
            TapAttributes tapAttributes = new TapAttributes();

            File out = new File(MANIFESTS_FOLGER);
            JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

            //StaticJsonCallerTurfan.staticJsonCaller(attributes, jsonObj);
            StaticJsonCallerTurfan.staticJsonCallerKahlen(kahlenAttributes, jsonObj);
            Manifest manifest=null;

            String id = IdTransformation.idTransformator(file).replace("kahlen_","");

            //String archive_signatory = kahlenAttributes.getDtabArchiveSignatory();

            //I18n i18n_title = LabelMetadata.getLabelTitle(kahlenAttributes);
            I18n i18n_title_kahlen = LabelMetadata.getLabelTitle(kahlenAttributes);

            if (i18n_title_kahlen.getStrings().get(0)!=null) {
                manifest = new Manifest(String.valueOf(file.getName()),
                        new Label( new I18n[]{i18n_title_kahlen}));
            } else {
                manifest = new Manifest(String.valueOf(file.getName()),
                        new Label(""+id));
            }

            //StaticFields.staticFields(id, manifest, i18n_title_kahlen.getStrings().get(0), archive_signatory); //all static fields
            StaticFields.staticFields(id, manifest, i18n_title_kahlen.getStrings().get(0));
            System.out.println(file.getName());
            metadataMembersKahlen(kahlenAttributes, manifest);
            CanvasKahlen canvasKahlen = new CanvasKahlen();
            canvasKahlen.createCanvas(file, kahlenAttributes, jsonObj, manifest);
            File  newFile = new File(out+"\\"+ file.getName());
            manifestor.write(manifest, newFile);
        }
    }
}
