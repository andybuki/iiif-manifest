package org.crossasia.manifest.presentations;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Provider;
import org.crossasia.manifest.constants.OriginalLanguage;

public class ProviderToManifest {
    public static void addProviderToManifest(Manifest manifest, String collection) {
        Provider provider = new Provider("crossasia.org",  "Staatsbibliothek zu Berlin | CrossAsia");
        Label label_provider_laos = new Label(new I18n("en", "National Library of Laos"),
                new I18n(String.valueOf(OriginalLanguage.Thai),"ຫໍສະໝຸດແຫ່ງຊາດ"));
        Label label_provider_thai = new Label (new I18n("en","Chiang Mai University Library"),
                new I18n(String.valueOf(OriginalLanguage.Thai), "สำนักหอสมุดมหาวิทยาลัยเชียงใหม่"));

        Provider provider_laos = new Provider("http://nationallibraryoflaos.net/en/", "");
        Provider provider_thai = new Provider("https://library.cmu.ac.th/","");

        provider_laos.setLabel(label_provider_laos);
        provider_thai.setLabel(label_provider_thai);

        if (collection.contains("PNTMP")) {
            manifest.setProviders(provider, provider_thai, provider_laos);
        } else if (collection.contains("DLNTM")) {
            manifest.setProviders(provider, provider_laos);
        } else {
            manifest.setProviders(provider, provider_laos);
        }
    }
}
