package com.arun;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.org.lidalia.slf4jext.Level;
import uk.org.lidalia.slf4jtest.LoggingEvent;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

public class LoggingInJunitTest {

    private LoggingInJUnit loggingInJUnit;

    private TestLogger logger;

    @Before
    public void setUp() {
        loggingInJUnit = new LoggingInJUnit();
        logger = TestLoggerFactory.getTestLogger(LoggingInJUnit.class);
        logger.clearAll();
    }

    @Test
    public void howToLogTest() {
        loggingInJUnit.howToLog();
        assertALog("Denominator cannot be Zero ", Level.ERROR, logger);
    }

    @Test
    public void howToLogWhenParameterIsPassedIntheLogTest() {
        loggingInJUnit.howToLogWhenParameterIsPassedIntheLog();
        assertALog("Denominator cannot be Zero {}", Level.ERROR, logger);
    }

    @After
    public void destroy() {
        TestLoggerFactory.clear();
    }


    public void assertALog(String expectedMessage, Level level, TestLogger logger) {

        for(LoggingEvent events : logger.getLoggingEvents()){
            if(events.getMessage().startsWith(expectedMessage) && events.getLevel() == level){
                return;
            }
        }
        throw new AssertionError("Message : " + expectedMessage + " Level : " + level + " not found");
    }
}
