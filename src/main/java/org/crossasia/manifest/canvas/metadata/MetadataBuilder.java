package org.crossasia.manifest.canvas.metadata;

import info.freelibrary.iiif.presentation.v3.properties.I18n;
import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import info.freelibrary.iiif.presentation.v3.properties.Value;
import org.crossasia.manifest.canvas.model.PageData;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MetadataBuilder {

    /**
     * Builds complete metadata list from PageData
     */
    public static List<Metadata> buildMetadata(PageData data) {
        List<Metadata> list = new ArrayList<>();

        // Simple string fields
        addIfNotEmpty(list, "schema:position", data.getPosition(), "none");
        addIfNotEmpty(list, "schema:year", data.getYear(), "none");
        addIfNotEmpty(list, "turfan:noteDate", data.getNoteDate(), "none");
        addIfNotEmpty(list, "turfan:number_page", data.getTurfanNumberPage(), "none");
        addIfNotEmpty(list, "dcndl:number", data.getDcndlNumber(), "none");
        addIfNotEmpty(list, "dc:identifier", data.getDcIdentifier(), "none");
        addIfNotEmpty(list, "dc:date", data.getDate(), "none");

        // I18n fields (German)
        addI18nIfNotEmpty(list, "dc:title", data.getTitle(), "de");
        addI18nIfNotEmpty(list, "dc:subject", data.getSubject(), "de");
        addI18nIfNotEmpty(list, "dcterms:source", data.getSource(), "de");
        addI18nIfNotEmpty(list, "dcterms:medium", data.getMedium(), "de");
        addI18nIfNotEmpty(list, "schema:comment", data.getComment(), "de");
        addI18nIfNotEmpty(list, "schema:collection", data.getCollection(), "de");
        addI18nIfNotEmpty(list, "dc:description", data.getDescription(), "de");
        addI18nIfNotEmpty(list, "dc:place", data.getPlace(), "de");
        addI18nIfNotEmpty(list, "turfan:placeDetail", data.getPlaceDetail(), "de");
        addI18nIfNotEmpty(list, "schema:person", data.getPerson(), "de");
        addI18nIfNotEmpty(list, "schema:index", data.getIndex(), "de");
        addI18nIfNotEmpty(list, "dcterms:spatial", data.getSpatial(), "de");

        // Array fields
        addArrayMetadata(list, "schema:person", data.getPersonArray(), "de");
        addArrayMetadata(list, "schema:index", data.getIndexArray(), "de");
        addArrayMetadata(list, "dc:subject", data.getSubjectArray(), "de");
        addArrayMetadata(list, "dcterms:spatial", data.getSpatialArray(), "de");
        addArrayMetadata(list, "dcterms:medium", data.getMediumArray(), "de");

        // Semicolon-separated fields
        addSemicolonSeparated(list, "schema:keyword", data.getKeyword(), "de");
        addSemicolonSeparated(list, "schema:identifier", data.getSchemaIdentifier(), "none");
        addSemicolonSeparated(list, "turfan:sender", data.getSender(), "de");
        addSemicolonSeparated(list, "turfan:recipient", data.getRecipient(), "de");

        return list;
    }

    /**
     * Add simple string metadata if not empty
     */
    private static void addIfNotEmpty(List<Metadata> list, String label, String value, String lang) {
        if (value != null && !value.isEmpty()) {
            Metadata meta = new Metadata(new Label(lang, label), new Value(value));
            list.add(meta);
        }
    }

    /**
     * Add I18n string metadata if not empty
     */
    private static void addI18nIfNotEmpty(List<Metadata> list, String label, String value, String lang) {
        if (value != null && !value.isEmpty()) {
            Metadata meta = new Metadata(
                    new Label(lang, label),
                    new Value(new I18n(lang, value))
            );
            list.add(meta);
        }
    }

    /**
     * Add array metadata
     */
    private static void addArrayMetadata(List<Metadata> list, String label, JSONArray array, String lang) {
        if (array != null && array.length() > 0) {
            List<String> values = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                values.add(array.get(i).toString());
            }
            I18n i18n = new I18n(lang, values);
            Metadata meta = new Metadata(
                    new Label(lang, label),
                    new Value(new I18n[]{i18n})
            );
            list.add(meta);
        }
    }

    /**
     * Add semicolon-separated metadata
     */
    private static void addSemicolonSeparated(List<Metadata> list, String label, String value, String lang) {
        if (value != null && !value.isEmpty()) {
            List<String> values = new ArrayList<>();
            if (value.contains(";")) {
                String[] parts = value.split(";");
                Collections.addAll(values, parts);
            } else {
                values.add(value);
            }
            I18n i18n = new I18n(lang, values);
            Metadata meta = new Metadata(
                    new Label(lang, label),
                    new Value(new I18n[]{i18n})
            );
            list.add(meta);
        }
    }
}
