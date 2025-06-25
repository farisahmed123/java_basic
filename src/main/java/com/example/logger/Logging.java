package com.example.logger;

import java.util.logging.Logger;
// import java.util.logging.Level;

public class Logging {
    private static final Logger logger = Logger.getLogger(Logging.class.getName());

    public static void main(String[] args) {
        logger.info("Information");
        logger.warning("Something to watch!");
        logger.severe("Critical problem");
    }
}
