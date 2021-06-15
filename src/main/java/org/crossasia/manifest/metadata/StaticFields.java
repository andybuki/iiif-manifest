package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.ResourceTypes;
import info.freelibrary.iiif.presentation.v3.properties.*;
import info.freelibrary.iiif.presentation.v3.properties.behaviors.ManifestBehavior;
import info.freelibrary.iiif.presentation.v3.services.OtherService;

import java.net.URI;

import static info.freelibrary.iiif.presentation.v3.properties.ViewingDirection.RIGHT_TO_LEFT;

public class StaticFields {
    public static void staticFields(int counter, Manifest manifest) {
        manifest.addContexts("http://iiif.io/api/presentation/3/context.json");
        manifest.setID("https://itr02.crossasia.org/fcrepo/rest/dllm/dllm_000"+counter+"/manifest");
        Summary summary = new Summary(new I18n("en", "The Digital Library of Lao Manuscripts makes images of over 12,000 texts from throughout Laos easily accessible for study. Collaborating institutions are the National Library of Laos, the University of Passau, and the Staatsbibliothek zu Berlin Preußischer Kulturbesitz. The project is funded by the German Research Foundation (DFG) and the German Federal Ministry of Economic Cooperation and Development (BMZ)."),
                new I18n("lo", "ຫໍສະໝຸດດິຈິຕອລໜັງສືໃບລານລາວ ມີຮູບດິຈິຕອລ ຫຼາຍກວ່າ 12,000 ຕົ້ນສະບັບຕົວຂຽນ ຈາກທົ່ວປະເທດ ເພື່ອໃຫ້ຜູ້ສົນໃຈເຂົ້າຄົ້ນຄວ້າຢ່າງສະດວກສະບາຍ. ສະຖາບັນຮ່ວມມື ມີ ຫໍສະໝຸດແຫ່ງຊາດລາວ, ມະຫາວິທະຍາໄລ ປັສເຊົາ ແລະ ຫໍສະໝຸດແຫ່ງລັດ ປະຈຳກຸງແບັກແລັງ ໂຄງການນີ້ໄດ້ຮັບທຶນອຸປະຖຳຈາກມູນນິທິ ເພື່ອການຄົ້ນຄວ້າ ເຢຍຣະມັນ (DFG) ແລະ ກະຊວງການຮ່ວມມືທາງເສດຖະກິດ ແລະ ການພັດທະນາແຫ່ງ ສ.ສ. ເຢຍຣະມັນ (BMZ)."));
        manifest.setSummary(summary);
        manifest.setRights("http://creativecommons.org/licenses/by/4.0/");
        manifest.setViewingDirection(RIGHT_TO_LEFT);
        manifest.setHomepages(new Homepage(URI.create("https://iiif.corossasia.org"),
                new Label("en","Crossasia Madoc Page")));
        manifest.setPartOfs(new PartOf("https://iiif.crossasia.org/s/dllm","Collection"));
        OtherService otherService;
        final RequiredStatement reqStmt;
        reqStmt = new RequiredStatement(new Label("en","Attribution"),
                new Value(new I18n("en","Provided courtesy of Example Institution")));

        otherService = new OtherService("https://example.org/service/example", "example")
                .setProfile("https://example.org/docs/example-service.html");

        manifest.setRights("http://creativecommons.org/licenses/by/4.0/").setBehaviors(ManifestBehavior.PAGED)
                .setRequiredStatement(reqStmt).setServices(otherService);

        /*SeeAlso seeAlso = new SeeAlso("https://example.org/library/catalog/book1.xml", ResourceTypes.DATASET);
        seeAlso.setFormat("text/xml");
        seeAlso.setProfile("https//schema.org");
        manifest.setSeeAlsoRefs(seeAlso);*/
    }
}
