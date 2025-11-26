package org.crossasia.manifest.metadata.fields;

public enum Coll {
    xinjiang_legaldocuments("xinjiang-legaldocuments"),

    turfan("turfan"),
    dllm("dllm"),
    kahlen("kahlen"),
    dtab("dtab"),
    lanna("lanna");
    private String value;

    Coll(String value) {
        this.value = value;
    }

    public String getVal() {
        return value;
    }

}
