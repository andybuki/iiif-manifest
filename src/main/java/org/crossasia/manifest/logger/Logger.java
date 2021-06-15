package org.crossasia.manifest.logger;

import java.io.*;

public class Logger {
    public static void log() throws IOException {
        //PrintStream out = new PrintStream(new FileOutputStream("src/main/resources/output.txt"));
        //PrintWriter out = new PrintWriter(new FileOutputStream("src/main/resources/output.txt", true), true);
        FileOutputStream file = new FileOutputStream("src/main/resources/output.txt");
        //System.setOut(out);
        LoggerStream loggerStream = new LoggerStream(file, System.out);
        System.setOut(loggerStream);
        //out.write(m);
        //out.close();
    }
}
