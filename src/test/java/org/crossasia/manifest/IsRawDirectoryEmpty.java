package org.crossasia.manifest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IsRawDirectoryEmpty {
    Path rawData = Paths.get(("/Users/andreybuchmann/IdeaProjects/iiif-manifest/src/main/resources/raw/"));

    @Test
    public void isRawDirectoryEmptyTest()  {
        try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(rawData)) {
            boolean isNotEmpty= !dirStream.iterator().hasNext();
            Assert.assertFalse(isNotEmpty);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
