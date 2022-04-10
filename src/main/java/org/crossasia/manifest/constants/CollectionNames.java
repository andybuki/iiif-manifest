
package org.crossasia.manifest.constants;

public enum CollectionNames {
    DLLM ("dllm+"),
    DLMNT("dlmnt+");

    private String name;

    CollectionNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
