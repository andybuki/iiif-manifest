package org.crossasia.manifest.start;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.I18n;
import org.crossasia.manifest.attributes.*;
import org.crossasia.manifest.json.StaticJsonCaller;
import org.crossasia.manifest.statics.collection.CollectionConfig;
import org.json.JSONObject;

import static org.crossasia.manifest.metadata.MetadataMembersDtab.metadataMembersDtab;
import static org.crossasia.manifest.metadata.MetadataMembersKahlen.metadataMembersKahlen;
import static org.crossasia.manifest.metadata.MetadataMembersSugawara.metadataMembersSugawara;
import static org.crossasia.manifest.metadata.MetadataMembersTap.metadataMembersTap;

/**
 * Handles collection-specific attribute parsing and metadata.
 *
 * Maps to existing code:
 * - StaticJsonCallerTurfan.staticJsonCaller() for Turfan
 * - StaticJsonCallerTurfan.staticJsonCallerSugawara() for Sugawara
 * - StaticJsonCallerTurfan.staticJsonCallerDtab() for DTAB
 * - StaticJsonCallerTurfan.staticJsonCallerKahlen() for Kahlen
 */
public interface AttributeProcessor {

    /**
     * Extract title from JSON for this collection
     */
    I18n extractTitle(JSONObject jsonObj);

    /**
     * Add collection-specific metadata to manifest
     */
    void addMetadata(JSONObject jsonObj, Manifest manifest);

    /**
     * Get the appropriate processor for a collection
     */
    static AttributeProcessor forCollection(CollectionConfig config) {
        switch (config) {
            case KAHLEN:
                return new KahlenProcessor();
            case TAP:
                return new TapProcessor();
            case DTAB:
                return new DtabProcessor();
            case TURFAN:
                return new TurfanProcessor();
            case SUGAWARA:
                return new SugawaraProcessor();
            default:
                return new DefaultProcessor();
        }
    }

    // ========== Processor Implementations ==========

    /**
     * Kahlen collection processor
     */
    class KahlenProcessor implements AttributeProcessor {
        @Override
        public I18n extractTitle(JSONObject jsonObj) {
            KahlenAttributes attributes = new KahlenAttributes();
            StaticJsonCaller.staticJsonCallerKahlen(attributes, jsonObj);
            return org.crossasia.manifest.metadata.kahlen.LabelMetadata.getLabelTitle(attributes);
        }

        @Override
        public void addMetadata(JSONObject jsonObj, Manifest manifest) {
            KahlenAttributes attributes = new KahlenAttributes();
            StaticJsonCaller.staticJsonCallerKahlen(attributes, jsonObj);
            metadataMembersKahlen(attributes, manifest);
        }
    }

    /**
     * TAP collection processor
     * Uses same structure as Kahlen (adjust if TAP has different parsing)
     */
    class TapProcessor implements AttributeProcessor {
        @Override
        public I18n extractTitle(JSONObject jsonObj) {
            // TAP uses Kahlen structure based on your original code
            TapAttributes attributes = new TapAttributes();
            //KahlenAttributes attributes = new KahlenAttributes();
            StaticJsonCaller.staticJsonCallerTap(attributes, jsonObj);
            return org.crossasia.manifest.metadata.tap.LabelMetadata.getLabelTitle(attributes);
        }

        @Override
        public void addMetadata(JSONObject jsonObj, Manifest manifest) {
            //KahlenAttributes attributes = new KahlenAttributes();
            TapAttributes attributes = new TapAttributes();
            StaticJsonCaller.staticJsonCallerTap(attributes, jsonObj);
            metadataMembersTap(attributes, manifest);
        }
    }

    /**
     * DTAB collection processor
     * Uses staticJsonCallerDtab() with DtabAttributes
     */
    class DtabProcessor implements AttributeProcessor {
        @Override
        public I18n extractTitle(JSONObject jsonObj) {
            //DtabAttributes attributes = new DtabAttributes();
            CollectionAttributes attributes = new CollectionAttributes();
            //StaticJsonCallerTurfan.staticJsonCallerDtab(attributes, jsonObj);
            //return org.crossasia.manifest.metadata.dtab.LabelMetadata.getLabelTitle(attributes);
            return null;
        }

        @Override
        public void addMetadata(JSONObject jsonObj, Manifest manifest) {
            DtabAttributes attributes = new DtabAttributes();
            StaticJsonCaller.staticJsonCallerDtab(attributes, jsonObj);
            metadataMembersDtab(attributes, manifest);
        }
    }

    /**
     * Turfan collection processor
     * Uses staticJsonCaller() with CollectionAttributes
     */
    class TurfanProcessor implements AttributeProcessor {
        @Override
        public I18n extractTitle(JSONObject jsonObj) {
            CollectionAttributes attributes = new CollectionAttributes();
            StaticJsonCaller.staticJsonCaller(attributes, jsonObj);
            return org.crossasia.manifest.metadata.turfan.LabelMetadata.getLabelTitle(attributes);
        }

        @Override
        public void addMetadata(JSONObject jsonObj, Manifest manifest) {
            CollectionAttributes attributes = new CollectionAttributes();
            TurfanAttributes turfanAttributes = new TurfanAttributes();
            StaticJsonCaller.staticJsonCaller(attributes, jsonObj);
            //metadataMembersTurfan(turfanAttributes, manifest);
        }
    }

    /**
     * Sugawara collection processor
     */
    class SugawaraProcessor implements AttributeProcessor {
        @Override
        public I18n extractTitle(JSONObject jsonObj) {
            SugawaraAttributes attributes = new SugawaraAttributes();
            StaticJsonCaller.staticJsonCallerSugawara(attributes, jsonObj);
            return org.crossasia.manifest.metadata.sugawara.LabelMetadata.getLabelTitle(attributes);
        }

        @Override
        public void addMetadata(JSONObject jsonObj, Manifest manifest) {
            SugawaraAttributes attributes = new SugawaraAttributes();
            StaticJsonCaller.staticJsonCallerSugawara(attributes, jsonObj);
            metadataMembersSugawara(attributes, manifest);
        }
    }

    /**
     * Default processor for unknown collections
     */
    class DefaultProcessor implements AttributeProcessor {
        @Override
        public I18n extractTitle(JSONObject jsonObj) {
            // Try common field names
            if (jsonObj.has("title")) {
                return new I18n("en", jsonObj.getString("title"));
            }
            if (jsonObj.has("dcTitle")) {
                return new I18n("en", jsonObj.getString("dcTitle"));
            }
            if (jsonObj.has("name")) {
                return new I18n("en", jsonObj.getString("name"));
            }
            if (jsonObj.has("id")) {
                Object id = jsonObj.get("id");
                return new I18n("en", String.valueOf(id));
            }
            return null;
        }

        @Override
        public void addMetadata(JSONObject jsonObj, Manifest manifest) {
            // No metadata for default processor
        }
    }
}