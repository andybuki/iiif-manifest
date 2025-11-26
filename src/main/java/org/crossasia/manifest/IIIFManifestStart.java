package org.crossasia.manifest;

import org.crossasia.manifest.start.IIIFCollection;
import org.crossasia.manifest.start.IIIFManifest;

import java.io.FileNotFoundException;
import java.io.IOException;

public class IIIFManifestStart {
    public static void main(String[] args) throws IOException {
        IIIFManifest start = new IIIFManifest();
        IIIFManifest.buildManifest();
    }
}
