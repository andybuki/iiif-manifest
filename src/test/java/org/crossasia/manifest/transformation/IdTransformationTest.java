package org.crossasia.manifest.transformation;

import org.crossasia.manifest.statics.collection.CollectionConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class IdTransformationTest {

    @TempDir
    Path tempDir;

    @Test
    void testDtabTransformation_singleLetter() throws IOException {
        File testFile = createTestFile("B0001.json");

        String result = IdTransformation.idTransformator(testFile, CollectionConfig.DTAB);
        assertEquals("B-0001", result);
    }

    @Test
    void testDtabTransformation_multiLetterPrefix_ELA() throws IOException {
        File testFile = createTestFile("ELA0001.json");

        String result = IdTransformation.idTransformator(testFile, CollectionConfig.DTAB);
        assertEquals("ELA-0001", result);
    }

    @Test
    void testDtabTransformation_multiLetterPrefix_LA() throws IOException {
        File testFile = createTestFile("LA0001.json");

        String result = IdTransformation.idTransformator(testFile, CollectionConfig.DTAB);
        assertEquals("LA-0001", result);
    }

    @Test
    void testDtabTransformation_letterC() throws IOException {
        File testFile = createTestFile("C0123.json");

        String result = IdTransformation.idTransformator(testFile, CollectionConfig.DTAB);
        assertEquals("C-0123", result);
    }

    @Test
    void testDtabTransformation_letterD() throws IOException {
        File testFile = createTestFile("D9999.json");

        String result = IdTransformation.idTransformator(testFile, CollectionConfig.DTAB);
        assertEquals("D-9999", result);
    }

    @Test
    void testDtabTransformation_alreadyHasDash() throws IOException {
        File testFile = createTestFile("B-0001.json");

        String result = IdTransformation.idTransformator(testFile, CollectionConfig.DTAB);
        assertEquals("B-0001", result);
    }

    @Test
    void testTapTransformation_noChange() throws IOException {
        File testFile = createTestFile("A0001.json");

        String result = IdTransformation.idTransformator(testFile, CollectionConfig.TAP);
        assertEquals("A0001", result);
    }

    @Test
    void testKahlenTransformation_noChange() throws IOException {
        File testFile = createTestFile("kahlen123.json");

        String result = IdTransformation.idTransformator(testFile, CollectionConfig.KAHLEN);
        assertEquals("kahlen123", result);
    }

    @Test
    void testTurfanTransformation_noChange() throws IOException {
        File testFile = createTestFile("turfan456.json");

        String result = IdTransformation.idTransformator(testFile, CollectionConfig.TURFAN);
        assertEquals("turfan456", result);
    }

    @Test
    void testSugawaraTransformation_noChange() throws IOException {
        File testFile = createTestFile("sugawara789.json");

        String result = IdTransformation.idTransformator(testFile, CollectionConfig.SUGAWARA);
        assertEquals("sugawara789", result);
    }

    @Test
    void testLegacyMethod_appliesDtabTransformation() throws IOException {
        File testFile = createTestFile("B0001.json");

        @SuppressWarnings("deprecation")
        String result = IdTransformation.idTransformator(testFile);
        assertEquals("B-0001", result);
    }

    // Helper method to create temporary test files
    private File createTestFile(String filename) throws IOException {
        File file = tempDir.resolve(filename).toFile();
        file.createNewFile();
        return file;
    }
}
