package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import utilities.TestBase;

public class Day15_Log4J2 extends TestBase {
    /*
        1. Create a class : Day_Log4j
        2. Create Logger object:
            private static Logger logger = LogManager.getLogger(Demo1.class.getName());
        3. Use logger object to add info
                logger.debug("This is debug logger");
                logger.info("This is info logger");
                logger.error("This is error logger");
                logger.fatal("This is fatal logger");
        4. Check the console for logs. By default logger logs error or fatal
     */

    // Create Logger object:
    private static Logger logger = LogManager.getLogger(Day15_Log4J2.class.getName());

    @Test
    public void log4jTest(){


        // 2. Use logger object to log/print info
            logger.fatal("Fatal Log !!!");
            logger.error("Error Log !!!");
            logger.warn("Warning Log !!!");
            logger.debug("Debug Log !!!");
            logger.info("Info Log !!!");

        // 3. Check the console for logs. By default logger logs error or fatal

    }
}
