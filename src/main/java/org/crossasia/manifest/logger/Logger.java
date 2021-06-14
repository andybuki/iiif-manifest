package org.crossasia.manifest.logger;

import java.io.*;

public class Logger {
    public static void log(String message) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("src/main/resources/output.txt", true), true);

        System.setOut(out);
        out.close();
    }
}
