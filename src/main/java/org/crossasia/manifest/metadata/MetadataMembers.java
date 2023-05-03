package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import org.crossasia.manifest.attributes.CollectionAttributes;
import org.crossasia.manifest.metadata.turfan.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MetadataMembers {
    public static List<Metadata> metadataMembers(CollectionAttributes turfanAttributes, Manifest manifest) {
        Metadata metadata_title = TitleTurfan.getTitle(turfanAttributes, manifest);
        Metadata metadata_date = DateTurfan.getDate(turfanAttributes, manifest);
        Metadata metadata_seeAlso = SeeAlsoTurfan.getSeeAlso(turfanAttributes, manifest);
        Metadata metadata_invnumber = InvNumberTurfan.get(turfanAttributes, manifest);

        Metadata metadata_collection = CollectionTurfan.get(turfanAttributes, manifest);
        Metadata metadata_place = PlaceTurfan.get(turfanAttributes, manifest);
        Metadata metadata_placeDetail = PlaceDetailTurfan.get(turfanAttributes, manifest);
        Metadata metadata_placeDetail2 = PlaceDetail2Turfan.get(turfanAttributes, manifest);

        Metadata metadata_dsrLink = DsrLinkTurfan.get(turfanAttributes, manifest);
        Metadata metadata_siteNameGer = SiteNameGerTurfan.get(turfanAttributes, manifest);
        Metadata metadata_siteID = SiteIDTurfan.get(turfanAttributes, manifest);
        Metadata metadata_keyword = KeywordTurfan.get(turfanAttributes, manifest);

        Metadata metadata_type = TypeTurfan.get(turfanAttributes, manifest);
        Metadata metadata_objId = ObjIDTurfan.get(turfanAttributes, manifest);
        Metadata metadata_identifier = IdentifierTurfan.get(turfanAttributes, manifest);
        Metadata metadata_langeBeschreibung = LangeBeschreibung.get(turfanAttributes, manifest);

        Metadata metadata_georgBezug = GeorgBezug.get(turfanAttributes, manifest);
        Metadata metadata_description = Description.get(turfanAttributes, manifest);
        Metadata metadata_recherche = RechercheLink.get(turfanAttributes, manifest);
        Metadata metadata_noteDate = NoteDate.get(turfanAttributes, manifest);

        Metadata metadata_noteIdentifier = NoteIdentifier.get(turfanAttributes, manifest);
        Metadata metadata_noteCreator = NoteCreator.get(turfanAttributes, manifest);
        Metadata metadata_creator = Creator.get(turfanAttributes, manifest);
        Metadata metadata_format = Format.get(turfanAttributes, manifest);
        Metadata metadata_source = Source.get(turfanAttributes, manifest);
        Metadata metadata_creditText = CreditText.get(turfanAttributes, manifest);
        Metadata metadata_comment = Comment.get(turfanAttributes, manifest);
        Metadata metadata_schemaIdentifier = SchemaIdentifier.get(turfanAttributes, manifest);
        Metadata metadata_requirements = Requirements.get(turfanAttributes, manifest);

        ArrayList<Metadata> metadataArrayList = new ArrayList<>();

        metadataArrayList.add(metadata_noteIdentifier);
        metadataArrayList.add(metadata_noteCreator);
        metadataArrayList.add(metadata_creator);
        metadataArrayList.add(metadata_format);
        metadataArrayList.add(metadata_source);
        metadataArrayList.add(metadata_creditText);
        metadataArrayList.add(metadata_comment);
        metadataArrayList.add(metadata_schemaIdentifier);
        metadataArrayList.add(metadata_requirements);

        metadataArrayList.add(metadata_title);
        metadataArrayList.add(metadata_date);
        metadataArrayList.add(metadata_seeAlso);
        metadataArrayList.add(metadata_invnumber);

        metadataArrayList.add(metadata_collection);
        metadataArrayList.add(metadata_place);
        metadataArrayList.add(metadata_placeDetail);
        metadataArrayList.add(metadata_placeDetail2);

        metadataArrayList.add(metadata_dsrLink);
        metadataArrayList.add(metadata_siteNameGer);
        metadataArrayList.add(metadata_siteID);
        metadataArrayList.add(metadata_keyword);

        metadataArrayList.add(metadata_type);
        metadataArrayList.add(metadata_objId);
        metadataArrayList.add(metadata_identifier);

        metadataArrayList.add(metadata_langeBeschreibung);
        metadataArrayList.add(metadata_georgBezug);
        metadataArrayList.add(metadata_description);

        metadataArrayList.add(metadata_recherche);
        metadataArrayList.add(metadata_noteDate);

        Iterator<Metadata> iter = metadataArrayList.iterator();

        while (iter.hasNext()) {
            Metadata md = iter.next();
            if (md==null)
                iter.remove();
        }
        manifest.setMetadata(metadataArrayList);
        return metadataArrayList;
    }
}
