package com.arun;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static uk.org.lidalia.slf4jtest.LoggingEvent.error;

public class LoggingInJunitTest {

    @Autowired
    private LoggingInJUnit loggingInJUnit;

    private TestLogger logger;

    @Before
    public void setUp() {
        loggingInJUnit = new LoggingInJUnit();
        logger = TestLoggerFactory.getTestLogger(LoggingInJUnit.class);
    }

    @Test
    public void howToLogTest() {
        loggingInJUnit.howToLog();
        assertThat(logger.getLoggingEvents(), is(asList(error("Denominator cannot be Zero"))));
    }
}
