package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.*;
import info.freelibrary.iiif.presentation.v3.services.OtherService;

import java.net.URI;

import static info.freelibrary.iiif.presentation.v3.properties.ViewingDirection.LEFT_TO_RIGHT;

public class StaticFieldsDllmtPhotoCollection {
    public static void staticFields(int counter, Manifest manifest, String plmp_id, String collection) {
        manifest.addContexts("http://iiif.io/api/presentation/3/context.json");
        manifest.setID("https://itr02.crossasia.org/fcrepo/rest/dlntm/images/"+counter+"/manifest");
        String zero_parameter = "";
        if (counter<10)
            zero_parameter = "0000";
        else if (counter>10 && counter<100)
            zero_parameter = "000";
        else if (counter>100 && counter<1000)
            zero_parameter = "00";
        else if (counter>1000 && counter<10000)
            zero_parameter = "0";
        else
            zero_parameter = "";

        Summary summary = new Summary("Digital Library of Northern Thai Manuscripts  -  Code:"+plmp_id+" (lanna_"+counter+")");

        manifest.setSummary(summary);
        manifest.setRights("http://creativecommons.org/licenses/by/4.0/");
        manifest.setViewingDirection(LEFT_TO_RIGHT);
        manifest.setHomepages(new Homepage(URI.create("https://iiif.crossasia.org"),
                new Label("en","Crossasia IIIF collections")));
        manifest.setPartOfs(new PartOf("https://iiif.crossasia.org/s/lanna","Collection"));
        OtherService otherService;
        final RequiredStatement reqStmt;
        String statement = "";

        if (collection.contains("PNTMP")) {
            statement="Images and metadata are made available by the Chiang Mai University Library in cooperation with the National Library of Laos (CC BY-NC 4.0) via the Staatsbibliothek zu Berlin | CrossAsia";
        } else if (collection.contains("DLNTM")) {
            statement="Images and metadata are made available by the National Library of Laos (CC BY-NC 4.0) via the Staatsbibliothek zu Berlin | CrossAsia";
        } else {
            statement ="2015 David Wharton, Digital Library of Northern Thai Manuscripts (CC BY-NC 4.0)";
        }

        reqStmt = new RequiredStatement(new Label("en","Attribution"),
                new Value(new I18n("en",statement)));
        manifest.setRequiredStatement(reqStmt);
    }
}
