package org.crossasia.manifest.attributes.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@DisplayName("SealInfo Tests")
public class SealInfoTest {

    private SealInfo sealInfo;

    @BeforeEach
    public void setUp() {
        sealInfo = new SealInfo();
    }

    @Test
    @DisplayName("Should set and get seal IDs")
    public void testSetGetSealIds() {
        List<String> ids = Arrays.asList("seal-1", "seal-2");
        sealInfo.setSealIds(ids);

        assertEquals(2, sealInfo.getSealIds().size());
        assertEquals("seal-1", sealInfo.getSealIds().get(0));
    }

    @Test
    @DisplayName("Should set and get colors")
    public void testSetGetColors() {
        List<String> colors = Arrays.asList("red", "blue");
        sealInfo.setColors(colors);

        assertEquals(2, sealInfo.getColors().size());
        assertEquals("red", sealInfo.getColors().get(0));
    }

    @Test
    @DisplayName("Should set and get forms")
    public void testSetGetForms() {
        List<String> forms = Arrays.asList("round", "square");
        sealInfo.setForms(forms);

        assertEquals(2, sealInfo.getForms().size());
    }

    @Test
    @DisplayName("Should set and get image files")
    public void testSetGetImageFiles() {
        List<String> files = Arrays.asList("seal1.jpg", "seal2.jpg");
        sealInfo.setImageFiles(files);

        assertEquals(2, sealInfo.getImageFiles().size());
        assertEquals("seal1.jpg", sealInfo.getImageFiles().get(0));
    }
}