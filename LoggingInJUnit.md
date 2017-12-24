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
            
            @After
            public void destroy(){
                TestLoggerFactory.clear();
            }
        }