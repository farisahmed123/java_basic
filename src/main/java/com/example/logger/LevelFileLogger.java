package com.example.logger;

import java.io.IOException;
import java.util.logging.*;
import java.io.File;

public class LevelFileLogger {
    private static final Logger logger = Logger.getLogger(LevelFileLogger.class.getName());

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().reset();

        // Get project root directory
        String projectRoot = System.getProperty("user.dir");
        File logDir = new File(projectRoot, "logs");
        if (!logDir.exists()) {
            logDir.mkdirs();
        }

        // Create handlers for each log level in logs directory
        Handler infoHandler = new FileHandler(logDir.getAbsolutePath() + "/info.log", true);
        infoHandler.setLevel(Level.INFO);
        infoHandler.setFilter(record -> record.getLevel() == Level.INFO);
        infoHandler.setFormatter(new SimpleFormatter());

        Handler warningHandler = new FileHandler(logDir.getAbsolutePath() + "/warning.log", true);
        warningHandler.setLevel(Level.WARNING);
        warningHandler.setFilter(record -> record.getLevel() == Level.WARNING);
        warningHandler.setFormatter(new SimpleFormatter());

        Handler severeHandler = new FileHandler(logDir.getAbsolutePath() + "/severe.log", true);
        severeHandler.setLevel(Level.SEVERE);
        severeHandler.setFilter(record -> record.getLevel() == Level.SEVERE);
        severeHandler.setFormatter(new SimpleFormatter());

        Handler fineHandler = new FileHandler(logDir.getAbsolutePath() + "/fine.log", true);
        fineHandler.setLevel(Level.FINE);
        fineHandler.setFilter(record -> record.getLevel() == Level.FINE);
        fineHandler.setFormatter(new SimpleFormatter());

        logger.addHandler(infoHandler);
        logger.addHandler(warningHandler);
        logger.addHandler(severeHandler);
        logger.addHandler(fineHandler);
        logger.setLevel(Level.ALL);

        // Log messages at different levels
        logger.info("This is an info message");
        logger.warning("This is a warning message");
        logger.severe("This is a severe message");
        logger.fine("This is a fine message");

        // Close handlers
        infoHandler.close();
        warningHandler.close();
        severeHandler.close();
        fineHandler.close();
    }
} 