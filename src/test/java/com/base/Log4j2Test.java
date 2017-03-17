package com.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test
{
    private static Logger logger = LogManager.getLogger("HelloLog4j");
    
    public static void main(String[] args)
    {
        
        logger.traceEntry();
        Log4j2Test log = new Log4j2Test();
        int i = 0;
        while(i++ < 30000){
            log.testLog();
        }
        logger.error("Hello, World!");
        logger.traceExit();
    }
    
    public void testLog()
    {
        logger.trace("I am testLog trace");
        logger.debug("I am testLog debug");
        logger.info("I am testLog info");
        logger.warn("I am testLog warn");
        logger.error("I am testLog error");
    }
}
