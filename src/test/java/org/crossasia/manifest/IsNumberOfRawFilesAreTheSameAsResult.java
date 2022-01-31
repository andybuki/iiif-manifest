package org.crossasia.manifest;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.endsWith;

public class IsNumberOfRawFilesAreTheSameAsResult {
    Path resultData = Paths.get(("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/final/result"));
    Path rawData = Paths.get(("/mnt/b-isiprod-udl.pk.de/itr/archive/dllm/final/raw_ORIGINAL"));

    @Test
    public void isNumberOfRawFilesAreTheSameAsResultest()  {
        long numberOfRawFiles = 0;
        long numberOfResultFiles = 0;
        try {
            numberOfRawFiles = Files.walk(rawData).filter(Files::isRegularFile).count();
            numberOfResultFiles = Files.walk(resultData).filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith("json"))
                    .count();

            System.out.println("raw files: "+numberOfRawFiles);
            System.out.println("result files: "+numberOfResultFiles);
            Assert.assertTrue(numberOfRawFiles==numberOfResultFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
