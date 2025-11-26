package org.crossasia.manifest;

import org.crossasia.manifest.start.IIIFCollection;

import java.io.FileNotFoundException;

public class IIIFCollectionStart {
    public static void main(String[] args) throws FileNotFoundException {
        IIIFCollection start = new IIIFCollection();
        IIIFCollection.buildCollection();
    }
}
