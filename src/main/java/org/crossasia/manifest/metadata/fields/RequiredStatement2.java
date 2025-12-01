package org.crossasia.manifest.metadata.fields;

import info.freelibrary.iiif.presentation.v3.properties.Label;
import info.freelibrary.iiif.presentation.v3.properties.RequiredStatement;
import info.freelibrary.iiif.presentation.v3.properties.Value;
@Deprecated
public class RequiredStatement2 extends RequiredStatement {
    public static final String REQUIRED2 = "© Wolf Kahlen. Commercial use only permitted after consultation with VG Bild-Kunst (https://www.bildkunst.de) and Wolf Kahlen. Licensed under CC BY-NC-SA 4.0.";
    public static final String INFO2 = "Rights Statement";


    public RequiredStatement2(Label aLabel, Value aValue) {
        super(aLabel, aValue);
    }
}
