package org.crossasia.manifest;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IsResultDirectoryEmpty {
    Path resultData = Paths.get(("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/final/result_TEST/"));

    @Test
    public void isResultDirectoryEmptyTest()  {
        try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(resultData)) {
            boolean isNotEmpty= !dirStream.iterator().hasNext();
            Assert.assertFalse(isNotEmpty);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
