package org.crossasia.manifest.metadata.builder;

import info.freelibrary.iiif.presentation.v3.Manifest;
import info.freelibrary.iiif.presentation.v3.properties.Metadata;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MetadataBuilderTest {

    @Test
    void testCreateWithSingleValue() {
        Metadata metadata = MetadataBuilder.create("dcterms:title", "Test Title").build();

        assertNotNull(metadata);
        assertEquals("dcterms:title", metadata.getLabel().getStrings().get(0));
    }

    @Test
    void testCreateWithNullValue_returnsNull() {
        Metadata metadata = MetadataBuilder.create("dcterms:title", (String) null).build();

        assertNull(metadata);
    }

    @Test
    void testCreateWithEmptyValue_returnsNull() {
        Metadata metadata = MetadataBuilder.create("dcterms:title", "   ").build();

        assertNull(metadata);
    }

    @Test
    void testCreateWithList() {
        List<String> keywords = Arrays.asList("keyword1", "keyword2", "keyword3");

        Metadata metadata = MetadataBuilder.create("schema:keywords", keywords, "en").build();

        assertNotNull(metadata);
        assertTrue(metadata.hasValues());
    }

    @Test
    void testHasValues_withValues() {
        MetadataBuilder builder = MetadataBuilder.create("test", "value");

        assertTrue(builder.hasValues());
    }

    @Test
    void testHasValues_withoutValues() {
        MetadataBuilder builder = MetadataBuilder.create("test");

        assertFalse(builder.hasValues());
    }

    @Test
    void testContainsChinese() {
        assertTrue(MetadataBuilder.containsChinese("这是中文"));
        assertTrue(MetadataBuilder.containsChinese("Mixed 中文 text"));
        assertFalse(MetadataBuilder.containsChinese("English only"));
        assertFalse(MetadataBuilder.containsChinese(""));
        assertFalse(MetadataBuilder.containsChinese(null));
    }

    @Test
    void testContainsJapanese() {
        assertTrue(MetadataBuilder.containsJapanese("こんにちは"));
        assertTrue(MetadataBuilder.containsJapanese("カタカナ"));
        assertTrue(MetadataBuilder.containsJapanese("Mixed ひらがな text"));
        assertFalse(MetadataBuilder.containsJapanese("English only"));
    }

    @Test
    void testContainsKorean() {
        assertTrue(MetadataBuilder.containsKorean("안녕하세요"));
        assertTrue(MetadataBuilder.containsKorean("Mixed 한글 text"));
        assertFalse(MetadataBuilder.containsKorean("English only"));
    }

    @Test
    void testContainsThai() {
        assertTrue(MetadataBuilder.containsThai("สวัสดี"));
        assertTrue(MetadataBuilder.containsThai("Mixed ไทย text"));
        assertFalse(MetadataBuilder.containsThai("English only"));
    }

    @Test
    void testContainsTibetan() {
        assertTrue(MetadataBuilder.containsTibetan("བོད་ཡིག"));
        assertFalse(MetadataBuilder.containsTibetan("English only"));
    }

    @Test
    void testContainsArabic() {
        assertTrue(MetadataBuilder.containsArabic("مرحبا"));
        assertTrue(MetadataBuilder.containsArabic("Mixed العربية text"));
        assertFalse(MetadataBuilder.containsArabic("English only"));
    }

    @Test
    void testDetectLanguage_chinese() {
        String result = MetadataBuilder.detectLanguage("蔣經國", "en");
        assertEquals("zh", result);
    }

    @Test
    void testDetectLanguage_japanese() {
        String result = MetadataBuilder.detectLanguage("ひらがな", "en");
        assertEquals("ja", result);
    }

    @Test
    void testDetectLanguage_korean() {
        String result = MetadataBuilder.detectLanguage("한글", "en");
        assertEquals("ko", result);
    }

    @Test
    void testDetectLanguage_thai() {
        String result = MetadataBuilder.detectLanguage("ไทย", "en");
        assertEquals("th", result);
    }

    @Test
    void testDetectLanguage_arabic() {
        String result = MetadataBuilder.detectLanguage("العربية", "en");
        assertEquals("ar", result);
    }

    @Test
    void testDetectLanguage_defaultLanguage() {
        String result = MetadataBuilder.detectLanguage("English text", "en");
        assertEquals("en", result);
    }

    @Test
    void testDetectLanguage_emptyString() {
        String result = MetadataBuilder.detectLanguage("", "en");
        assertEquals("en", result);
    }

    @Test
    void testDetectLanguage_nullString() {
        String result = MetadataBuilder.detectLanguage(null, "en");
        assertEquals("en", result);
    }

    @Test
    void testCreateWithAutoLang_mixedLanguages() {
        List<String> values = Arrays.asList("English", "中文", "日本語", "한글");

        MetadataBuilder builder = MetadataBuilder.createWithAutoLang("schema:keywords", values, "en");

        assertTrue(builder.hasValues());
        Metadata metadata = builder.build();
        assertNotNull(metadata);
    }

    @Test
    void testSafeGet_withValidObject() {
        TestObject obj = new TestObject("test value");
        String result = MetadataBuilder.safeGet(obj, TestObject::getValue);

        assertEquals("test value", result);
    }

    @Test
    void testSafeGet_withNullObject() {
        String result = MetadataBuilder.safeGet(null, TestObject::getValue);

        assertNull(result);
    }

    @Test
    void testAddToManifest() {
        Manifest manifest = new Manifest("test-id");

        MetadataBuilder.create("dcterms:title", "Test Title")
                .addToManifest(manifest);

        assertNotNull(manifest.getMetadata());
        assertEquals(1, manifest.getMetadata().size());
    }

    @Test
    void testAddToManifest_withNullMetadata_doesNotAddToManifest() {
        Manifest manifest = new Manifest("test-id");

        MetadataBuilder.create("dcterms:title", (String) null)
                .addToManifest(manifest);

        // Metadata should be null or empty since nothing was added
        assertTrue(manifest.getMetadata() == null || manifest.getMetadata().isEmpty());
    }

    // Helper class for testing
    private static class TestObject {
        private final String value;

        public TestObject(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
