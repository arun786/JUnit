# Logging In JUnit

Few things which we need to do before we log the event in unit test cases.

Step 1 : Add Maven dependency for SL4J and for unit test

        <dependency>
            <groupId>uk.org.lidalia</groupId>
            <artifactId>slf4j-test</artifactId>
            <version>1.0.0</version>
            <scope>test</scope>
        </dependency>
        
        <dependency>
            <groupId>uk.org.lidalia</groupId>
            <artifactId>slf4j-test</artifactId>
            <version>1.0.0</version>
            <scope>test</scope>
        </dependency>

Step 2 : Create a class where you need to log some info, like when there is an exception

    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

    public class LoggingInJUnit {

        private Logger logger = LoggerFactory.getLogger(LoggingInJUnit.class);

        public void howToLog() {
            int num = 10;
            int den = 0;
            try {
                int result = num / den;
            } catch (ArithmeticException e) {
                logger.error("Denominator cannot be Zero");
            }
        }
    }

Step 3 : Create A JUnit Test class, and do the below.

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