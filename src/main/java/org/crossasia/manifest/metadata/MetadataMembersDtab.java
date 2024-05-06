package org.crossasia.manifest.metadata;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import org.crossasia.manifest.attributes.DtabAttributes;
import org.crossasia.manifest.metadata.dtab.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MetadataMembersDtab {
    public static List<Metadata> metadataMembersDtab(DtabAttributes dtabAttributes, Manifest manifest) {
        Metadata metadata_title = Title.get(dtabAttributes, manifest);
        Metadata metadata_invisible = Invisible.get(dtabAttributes, manifest);
        Metadata metadata_signatory = Signatory.get(dtabAttributes, manifest);
        Metadata metadata_comment = Comment.get(dtabAttributes, manifest);
        Metadata metadata_sender = Sender.get(dtabAttributes, manifest);
        Metadata metadata_sender_comment = SenderComment.get(dtabAttributes, manifest);
        Metadata metadata_comment_types = CommentTypes.get(dtabAttributes, manifest);
        Metadata metadata_seal_id = SealId.get(dtabAttributes, manifest);
        Metadata metadata_date_description_id = DateDescriptionId.get(dtabAttributes, manifest);
        Metadata metadata_archive_id = ArchiveId.get(dtabAttributes, manifest);
        Metadata metadata_date_id = DateId.get(dtabAttributes, manifest);
        Metadata metadata_description_date = DescriptionDate.get(dtabAttributes, manifest);
        Metadata metadata_schema_comment = SchemaComment.get(dtabAttributes, manifest);
        Metadata metadata_seal_name_script = SealNameScript.get(dtabAttributes, manifest);
        Metadata metadata_seal_comment_used_scripts = SealCommentUsedScripts.get(dtabAttributes, manifest);
        Metadata metadata_id = Id.get(dtabAttributes, manifest);
        Metadata metadata_text = Text.get(dtabAttributes, manifest);
        Metadata metadata_used_scripts = UsedScripts.get(dtabAttributes, manifest);
        Metadata metadata_transcription_files = TranscriptionFiles.get(dtabAttributes, manifest);
        Metadata metadata_gpos = Gpos.get(dtabAttributes, manifest);
        Metadata metadata_name_archive = NameArchive.get(dtabAttributes, manifest);
        Metadata metadata_script_role_id = ScriptRoleId.get(dtabAttributes, manifest);
        Metadata metadata_sender_id = SenderId.get(dtabAttributes, manifest);
        Metadata metadata_seal_size = SealSize.get(dtabAttributes, manifest);
        Metadata metadata_seal_form = SealForm.get(dtabAttributes, manifest);
        Metadata metadata_recipient = Recipient.get(dtabAttributes, manifest);
        Metadata metadata_date = Date.get(dtabAttributes, manifest);
        Metadata metadata_script = Script.get(dtabAttributes, manifest);
        Metadata metadata_preview_image_files = PreviewImageFiles.get(dtabAttributes, manifest);
        Metadata metadata_groupno = Groupno.get(dtabAttributes, manifest);
        Metadata metadata_idinarchive = IdInArchive.get(dtabAttributes, manifest);
        Metadata metadata_name = Name.get(dtabAttributes, manifest);
        Metadata metadata_html_files = HtmlFiles.get(dtabAttributes, manifest);
        Metadata metadata_document_id = DocumentId.get(dtabAttributes, manifest);
        Metadata metadata_seal = Seal.get(dtabAttributes, manifest);
        Metadata metadata_place_id = PlaceId.get(dtabAttributes, manifest);
        Metadata metadata_place_of_issue_id = PlaceOfIssueId.get(dtabAttributes, manifest);
        Metadata metadata_terminology = Terminology.get(dtabAttributes, manifest);
        Metadata metadata_other_files = OtherFiles.get(dtabAttributes, manifest);
        Metadata metadata_proverbs = Proverbs.get(dtabAttributes, manifest);
        Metadata metadata_sender_role_comment = SenderRoleComment.get(dtabAttributes, manifest);
        Metadata metadata_receiver_id = ReceiverId.get(dtabAttributes, manifest);
        Metadata metadata_receiver = Receiver.get(dtabAttributes, manifest);
        Metadata metadata_receiver_comment = ReceiverComment.get(dtabAttributes, manifest);
        Metadata metadata_place_comment = PlaceComment.get(dtabAttributes, manifest);
        Metadata metadata_place = Place.get(dtabAttributes, manifest);

        ArrayList<Metadata> metadataArrayList = new ArrayList<>();

        metadataArrayList.add(metadata_title);
        metadataArrayList.add(metadata_invisible);
        metadataArrayList.add(metadata_signatory);
        metadataArrayList.add(metadata_comment);
        metadataArrayList.add(metadata_sender);
        metadataArrayList.add(metadata_sender_comment);
        metadataArrayList.add(metadata_comment_types);
        metadataArrayList.add(metadata_seal_id);
        metadataArrayList.add(metadata_date_description_id);
        metadataArrayList.add(metadata_archive_id);
        metadataArrayList.add(metadata_date_id);
        metadataArrayList.add(metadata_description_date);
        metadataArrayList.add(metadata_schema_comment);
        metadataArrayList.add(metadata_seal_name_script);
        metadataArrayList.add(metadata_seal_comment_used_scripts);
        metadataArrayList.add(metadata_id);
        metadataArrayList.add(metadata_text);
        metadataArrayList.add(metadata_used_scripts);
        metadataArrayList.add(metadata_transcription_files);
        metadataArrayList.add(metadata_gpos);
        metadataArrayList.add(metadata_name_archive);
        metadataArrayList.add(metadata_script_role_id);
        metadataArrayList.add(metadata_sender_id);
        metadataArrayList.add(metadata_seal_size);
        metadataArrayList.add(metadata_seal_form);
        metadataArrayList.add(metadata_recipient);
        metadataArrayList.add(metadata_date);
        metadataArrayList.add(metadata_script);
        metadataArrayList.add(metadata_preview_image_files);
        metadataArrayList.add(metadata_groupno);
        metadataArrayList.add(metadata_idinarchive);
        metadataArrayList.add(metadata_name);
        metadataArrayList.add(metadata_html_files);
        metadataArrayList.add(metadata_document_id);
        metadataArrayList.add(metadata_seal);
        metadataArrayList.add(metadata_place_id);
        metadataArrayList.add(metadata_place_of_issue_id);
        metadataArrayList.add(metadata_terminology);
        metadataArrayList.add(metadata_other_files);
        metadataArrayList.add(metadata_proverbs);
        metadataArrayList.add(metadata_sender_role_comment);
        metadataArrayList.add(metadata_receiver_id);
        metadataArrayList.add(metadata_receiver);
        metadataArrayList.add(metadata_receiver_comment);
        metadataArrayList.add(metadata_place_comment);
        metadataArrayList.add(metadata_place);

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
