package org.crossasia.manifest.transformation;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class IdTransformation {
    @NotNull
    public static String idTransformator(File file) {
        String id = file.getName().toString().replace(".json", "")
                .replace("B","B-")
                .replace("C","C-")
                .replace("D","D-");

        if (id.replaceAll("\\d","").equals("A"))
            id= id.replace("A","A-");

        if (id.contains("ELA"))
            id= id.replace("ELA","ELA-");
        else if (id.contains("LA"))
            id= id.replace("LA","LA-");
        return id;
    }
}
