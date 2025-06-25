package com.example.logger;

import java.io.IOException;
import java.util.logging.*;

public class Rolling {
            private static final Logger logger = Logger.getLogger(Rolling.class.getName());

    public static void main(String[] args) throws IOException {
        // Prevent default console logging
        LogManager.getLogManager().reset();

        // FileHandler: pattern, max bytes, file count, append mode
        FileHandler fh = new FileHandler("app.log", 10_000, 3, true);
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);

        logger.setLevel(Level.ALL);
        logger.warning("Watch this warning");      // goes into app.log
        logger.severe("This is a critical error"); // also goes into app.log
        logger.info("More info here");             // also logged

        // Produce enough logs to exceed 10 KB and rotate automatically
        for (int i = 0; i < 300; i++) {
            logger.fine("Line #" + i);
        }
    }
}
