package org.crossasia.manifest.json;

import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.attributes.SugawaraAttributes;
import org.json.JSONObject;

public class StaticJsonCallerTurfan {

    public static void staticJsonCaller(CollectionAttributes turfanAttributes, JSONObject jsonObj) {
        JsonConnecterTurfan.title(turfanAttributes, jsonObj);
        JsonConnecterTurfan.date(turfanAttributes, jsonObj);
        JsonConnecterTurfan.collection(turfanAttributes, jsonObj);
        JsonConnecterTurfan.place(turfanAttributes, jsonObj);
        JsonConnecterTurfan.placeDetail(turfanAttributes, jsonObj);
        JsonConnecterTurfan.placeDetail2(turfanAttributes, jsonObj);
        JsonConnecterTurfan.objId(turfanAttributes, jsonObj);
        JsonConnecterTurfan.seeAlso(turfanAttributes, jsonObj);
        JsonConnecterTurfan.invnumber(turfanAttributes, jsonObj);
        JsonConnecterTurfan.dsrLink(turfanAttributes, jsonObj);
        JsonConnecterTurfan.siteID(turfanAttributes, jsonObj);
        JsonConnecterTurfan.siteNameGer(turfanAttributes, jsonObj);
        JsonConnecterTurfan.type(turfanAttributes, jsonObj);
        JsonConnecterTurfan.identifier(turfanAttributes, jsonObj);
        JsonConnecterTurfan.keyword(turfanAttributes, jsonObj);
        JsonConnecterTurfan.georgBezug(turfanAttributes, jsonObj);
        JsonConnecterTurfan.langeBeschreibung(turfanAttributes, jsonObj);
        JsonConnecterTurfan.description(turfanAttributes, jsonObj);
        JsonConnecterTurfan.rechercheLink(turfanAttributes, jsonObj);
        JsonConnecterTurfan.noteDate(turfanAttributes, jsonObj);

        JsonConnecterTurfan.noteIdentifier(turfanAttributes, jsonObj);
        JsonConnecterTurfan.comment(turfanAttributes, jsonObj);
        JsonConnecterTurfan.creator(turfanAttributes, jsonObj);
        JsonConnecterTurfan.noteCreator(turfanAttributes, jsonObj);
        JsonConnecterTurfan.format(turfanAttributes, jsonObj);
        JsonConnecterTurfan.source(turfanAttributes, jsonObj);
        JsonConnecterTurfan.creditText(turfanAttributes, jsonObj);
        JsonConnecterTurfan.schemaIdentifier(turfanAttributes, jsonObj);
        JsonConnecterTurfan.requirements(turfanAttributes, jsonObj);
    }


    public static void staticJsonCallerSugawara(SugawaraAttributes sugawaraAttributes, JSONObject jsonObj) {
        JsonConnecterSugawara.dctermsIdentifier(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.modsPhysicalLocation(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraFolder(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.schemaCategory(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.dctermsSubject(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.dctermsDescription(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraPhysicaldata(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraPhystype(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraTaxStamp(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraDocument(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.crossasiaDateOriginal(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.crossasiaYearOriginal(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraHijuriYear(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraHijuriMonth(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraDow(sugawaraAttributes,jsonObj);
        JsonConnecterSugawara.crossasiaWholedate(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.crossasiaAdminlevel2(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.crossasiaAdminlevel1(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.crossasiaPlaceType2(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.crossasiaPlaceType3(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraPlace(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraPersonRoleA(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraRoleA(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.schemaPersonRoleB(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraRoleB(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.sugawaraSeal(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.dctermsLanguage(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.crossasiaLanguage(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.dcDescription(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.schemaCitation(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.schemaGrant(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.schemaAbstract(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.dctermsExtent(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.place(sugawaraAttributes, jsonObj);
        JsonConnecterSugawara.date(sugawaraAttributes, jsonObj);
    }
}
