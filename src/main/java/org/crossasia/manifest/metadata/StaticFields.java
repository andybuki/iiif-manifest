package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.*;
import info.freelibrary.iiif.presentation.v3.services.OtherService;
import org.crossasia.manifest.metadata.fields.Coll;
import org.crossasia.manifest.metadata.fields.Languages;

import java.net.URI;

import static info.freelibrary.iiif.presentation.v3.properties.ViewingDirection.LEFT_TO_RIGHT;
import static org.crossasia.manifest.metadata.fields.Contexts.CONTEXT;
import static org.crossasia.manifest.metadata.fields.Homepage.HOMEPAGE;
import static org.crossasia.manifest.metadata.fields.Homepage.HOMEPAGE_DESCRIPTION;
import static org.crossasia.manifest.metadata.fields.Id.FEDORA;
import static org.crossasia.manifest.metadata.fields.PartOf.PARTOF;
import static org.crossasia.manifest.metadata.fields.Provider.PROVIDER;
import static org.crossasia.manifest.metadata.fields.Provider.WEBSITE;
import static org.crossasia.manifest.metadata.fields.RequiredStatement.INFO;
import static org.crossasia.manifest.metadata.fields.RequiredStatement.REQUIRED;
import static org.crossasia.manifest.metadata.fields.Rights.RIGHTS;
import static org.crossasia.manifest.metadata.fields.SummaryData.SUMMARY;

public class StaticFields {
    public static void staticFields(String id, Manifest manifest, String title) {

        Summary summary = new Summary(SUMMARY + title);

        RequiredStatement reqStmt = new RequiredStatement(new Label("de",INFO),
                new Value(new I18n("de", REQUIRED)));

        Provider provider = new Provider(WEBSITE,  PROVIDER);

        manifest.addContexts(CONTEXT);

        manifest.setViewingDirection(LEFT_TO_RIGHT);

        manifest.setRights(RIGHTS);

        manifest.setHomepages(new Homepage(URI.create(HOMEPAGE),
                new Label("en",HOMEPAGE_DESCRIPTION)));

        manifest.setID(FEDORA + Coll.xinjiang_legaldocuments.getVal() + "/"+id+"/manifest");

        manifest.setSummary(summary);

        manifest.setPartOfs(new PartOf(PARTOF,"Collection"));

        manifest.setRequiredStatement(reqStmt);

        manifest.setProviders(provider);

        //manifest.setSeeAlsoRefs(seeAlso);
    }
}
