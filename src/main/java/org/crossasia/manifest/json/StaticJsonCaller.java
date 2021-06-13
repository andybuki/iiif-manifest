package org.crossasia.manifest.json;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.attributes.DllmAttributes;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class StaticJsonCaller {

    public static void staticJsonCaller(DllmAttributes dllmAttributes, JSONObject jsonObj) {
        JsonConnecter.titleRoman(dllmAttributes, jsonObj);
        JsonConnecter.titleThai(dllmAttributes, jsonObj);
        JsonConnecter.languageRoman(dllmAttributes, jsonObj);
        JsonConnecter.languageThai(dllmAttributes, jsonObj);
        JsonConnecter.documentsID(dllmAttributes,jsonObj);
        JsonConnecter.documentsCodeNumber(dllmAttributes,jsonObj);
        JsonConnecter.documentsRoll(dllmAttributes,jsonObj);
        JsonConnecter.documentsExtent(dllmAttributes,jsonObj);
        JsonConnecter.documentsNumberOfFascicles(dllmAttributes,jsonObj);
        JsonConnecter.documentsNumberOfFolios(dllmAttributes,jsonObj);
        JsonConnecter.fullLocationName(dllmAttributes,jsonObj);
        JsonConnecter.fullLocationNameLao(dllmAttributes,jsonObj);
        JsonConnecter.locationsParentParentName(dllmAttributes,jsonObj);
        JsonConnecter.locationsParentParentNameLao(dllmAttributes,jsonObj);
        JsonConnecter.locationsParentName(dllmAttributes,jsonObj);
        JsonConnecter.locationsParentNameLao(dllmAttributes,jsonObj);
        JsonConnecter.locationsIsTopLevel(dllmAttributes,jsonObj);
        JsonConnecter.locationsParentParentID(dllmAttributes,jsonObj);
        JsonConnecter.documentsHasColophon(dllmAttributes,jsonObj);
        JsonConnecter.documentsIsIllustrated(dllmAttributes,jsonObj);
        JsonConnecter.documentsIsColor(dllmAttributes,jsonObj);
        JsonConnecter.documentsIsComplete(dllmAttributes,jsonObj);
        JsonConnecter.documentsPagesCount(dllmAttributes,jsonObj);
        JsonConnecter.documentsPositionInBundle(dllmAttributes,jsonObj);
        JsonConnecter.locationsParentID(dllmAttributes,jsonObj);
        JsonConnecter.locationsID(dllmAttributes,jsonObj);
        JsonConnecter.documentsBundleID(dllmAttributes,jsonObj);
        JsonConnecter.description(dllmAttributes,jsonObj);

        JsonConnecter.materialsName(dllmAttributes,jsonObj);
        JsonConnecter.materialsNameLao(dllmAttributes,jsonObj);
        JsonConnecter.locationTypesName(dllmAttributes,jsonObj);

        JsonConnecter.locationTypesNameLao(dllmAttributes,jsonObj);
        JsonConnecter.locationsLft(dllmAttributes,jsonObj);
        JsonConnecter.locationsRgt(dllmAttributes,jsonObj);

        JsonConnecter.locationsDllmLocCode(dllmAttributes,jsonObj);
        JsonConnecter.locationsGpsLat(dllmAttributes,jsonObj);
        JsonConnecter.locationsGpsLon(dllmAttributes,jsonObj);

        JsonConnecter.ancillaryTermsRoman(dllmAttributes,jsonObj);
        JsonConnecter.ancillaryTermsLao(dllmAttributes,jsonObj);
        JsonConnecter.publicRemarksEnglish(dllmAttributes,jsonObj);

        JsonConnecter.publicRemarksLao(dllmAttributes,jsonObj);
        JsonConnecter.categoriesName(dllmAttributes,jsonObj);
        JsonConnecter.categoriesNameLao(dllmAttributes,jsonObj);

        JsonConnecter.scripts(dllmAttributes,jsonObj);
        JsonConnecter.scriptsLao(dllmAttributes,jsonObj);
        JsonConnecter.titleSearchRoman(dllmAttributes,jsonObj);

        JsonConnecter.titleSearchLao(dllmAttributes,jsonObj);
        JsonConnecter.dllmTitleRoman(dllmAttributes,jsonObj);
        JsonConnecter.dllmTitleLao(dllmAttributes,jsonObj);

        JsonConnecter.plmpTitleLao(dllmAttributes,jsonObj);
        JsonConnecter.locationDocumentsCount(dllmAttributes,jsonObj);
        JsonConnecter.legibilitiesName(dllmAttributes,jsonObj);

        JsonConnecter.legibilitiesNameLao(dllmAttributes,jsonObj);
        JsonConnecter.conditionsName(dllmAttributes,jsonObj);
        JsonConnecter.conditionsNameLao(dllmAttributes,jsonObj);

        JsonConnecter.documentsPreferredDateSystem(dllmAttributes,jsonObj);
        JsonConnecter.documentsPreferredDateSystemLao(dllmAttributes,jsonObj);
        JsonConnecter.documentsDateWritten(dllmAttributes,jsonObj);
        JsonConnecter.dateOriginal(dllmAttributes,jsonObj);
        JsonConnecter.dateOriginalLao(dllmAttributes,jsonObj);
    }

    @NotNull
    public static Metadata getMetadataIsComplete(DllmAttributes dllmAttributes) {
        return new Metadata(new Label( "is_complete"),
                new Value(dllmAttributes.getDocuments_is_complete()));

        /*
        * return new Metadata(new Label(new I18n("en", "is_complete")),
                new Value(new I18n("en",dllmAttributes.getDocuments_is_complete())));
        *
        * */
    }
}
