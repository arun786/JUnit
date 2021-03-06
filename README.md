# JUnit

@BeforeClass - this is a static method and is executed only once before the test class is executed.

@Before = this is a non static method and is executed before each method.

@After = this is a non static method and is executed after each method.

@Test = This is non static method.

@AfterClass = this is a static method which is executed after the class is invoked.


    @BeforeClass
    public static void BeforeClass(){
        System.out.println("1. Before Class is invoked");
    }

    @Before
    public void before(){
        System.out.println("2. and 5. Before is invoked");
    }

    @Test
    public void test(){
        System.out.println("3. Test method is invoked");
    }

    @Test
    public void test1(){
        System.out.println("6. Test1 is invoked");
    }
    @After
    public void after(){
        System.out.println("4. and 7. After is invoked");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("8. After class is invoked");
    }
    
    
# Assert

1. assertTrue(condition) : if the condition is true, the test passes else fails.
2. assertTrue(message,condition) : if the condition is true, the test passes else fails with the message.

        assertTrue(2 < 3);
        
        assertTrue("2 is less than 3", 2 < 3);
        
3. assertFalse(condition) : if the condition is false, the test passes else fails.
4. assertFalse(message,condition) : if the condition is false, the test passes else if fails with a message.

        assertFalse(3 > 5);
        
        assertFalse("3 is less than 5", 3 > 5);
        
5. assertNull(null) : if the parameter is null, the test passes else fails.
6. assertNotNull(name) : if the parameter is not null, the test passes else fails.

        String name = null;
        assertNull(name);

        name = "arun";
        assertNotNull(name);

7. assertEquals(String message, Object expected, Object actual). If the objects are the same, the test passes else fails with the message.

        assertEquals("Objects are not same", nameExpected, nameActual);
        
8. assertEquals(Object expected, Object actual). if the objects are same, test passes else fails.

        assertEquals(nameExpected, nameActual);
        
9. assertEquals(primitive expected, primitive actual); if the primitive types are the same and equal,test passes else fails
when the objects are passed, the equals method is invoked.

        assertEquals(10,10);
        
10. assertSame(Object expected, Object actual) : if the object are pointing to the same reference, it passes else fails.
It checks the reference using the == operator.
        String name1 = "arun";
        String name2 = new String("arun");
        assertSame(name1, name2); 
        
        the above assert will fail.
        
        String name1 = "arun";
        String name2 = "arun";
        
        assertSame(name1,name2);
        
        the above assert will pass, as both point to the same reference.
        
11. assertEquals(double,double) is deprecated as the results for it are not predictable.

        double sum1 = .98 + .998;
        assertEquals(sum1, 1.988);
        
        This will fail.
        
        double sum1 = .98 + .998;
        assertEquals(sum1, 1.988,.10);
        
        this will pass.
        
# Exception Handling

    @Test(expected = RuntimeException.class)
    public void exceptionThrown(){
        throw new RuntimeException();
    }
    
    the above test case will pass. 
    
     @Test(expected = RuntimeException.class)
     public void exceptionThrown(){
         throw new NullPointerException();
     }
     
     The above test will also pass.
     
# to specify the execution order of the test.

Test when executed can execute in a ramdom order. the order is not guaranteed.

To fix the order of the methods which is to be executed, we can use the 
@FixMethodOrder

    import org.junit.Test;

    public class OrderOfTests {

    @Test
    public void remove() {
        System.out.println("Remove the data");
    }

    @Test
    public void edit() {
        System.out.println("Editing the data");
    }

    @Test
    public void create() {
        System.out.println("Create a data");
    }
}

the above code will execute the methods in any order. If we want that the methods should be executed
in a fixed order, we can use the anotation

@FixMethodOrder for the class

    import org.junit.FixMethodOrder;
    import org.junit.Test;
    import org.junit.runners.MethodSorters;

    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public class OrderOfTests {

    @Test
    public void edit() {
        System.out.println("Editing the data");
    }

    @Test
    public void create() {
        System.out.println("Create a data");
    }

    @Test
    public void remove() {
        System.out.println("Remove the data");
    }
}

output will be in the below order., Since we are using MethodSorters as Name Ascending 

1. create method will be executed.

2. Edit method will be executed.

3. remove method will be executed.


# Assumption 

Assumption is basically used when your assumptions goes wrong during the execution of the test case, because 
of some external factor or reason. Say you are expecting to execute a test case during a time frame of every
30 to 45 seconds. But when the test was executed, seconds was below 30 or above 45 seconds, in such scenario
the test should not fail, but should be ignored.

below is the example.




    @Test(expected = AssumptionViolatedException.class)
    public void currentTime() {

        long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("ss");
        Date date = new Date(time);

        String currentSeconds = sdf.format(date);
        int seconds = Integer.parseInt(currentSeconds);
        System.out.println(seconds);

        boolean isCurrentTimeInSecondsBetween30and45 = seconds > 30 && seconds < 45 ? true : false;

        assumeTrue(isCurrentTimeInSecondsBetween30and45);
        assertTrue(true);
    }
    
    
    the below test will be ignored and will not fail with an exception as below.
    
   
    "C:\Program Files\Java\jdk1.8.0_101\bin\java" -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:C:\Users\Adwiti\AppData\Roaming\JetBrains\IntelliJ IDEA 2017.2.5\lib\idea_rt.jar=61491:C:\Users\Adwiti\AppData\Roaming\JetBrains\IntelliJ IDEA 2017.2.5\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\Adwiti\AppData\Roaming\JetBrains\IntelliJ IDEA 2017.2.5\lib\idea_rt.jar;C:\Users\Adwiti\AppData\Roaming\JetBrains\IntelliJ IDEA 2017.2.5\plugins\junit\lib\junit-rt.jar;C:\Users\Adwiti\AppData\Roaming\JetBrains\IntelliJ IDEA 2017.2.5\plugins\junit\lib\junit5-rt.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\rt.jar;C:\Users\Adwiti\Desktop\WorkSpace\Junit\out\test\Junit;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\junit\arquillian-junit-container\1.1.15.Final\arquillian-junit-container-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\junit\arquillian-junit-core\1.1.15.Final\arquillian-junit-core-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\test\arquillian-test-api\1.1.15.Final\arquillian-test-api-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\core\arquillian-core-api\1.1.15.Final\arquillian-core-api-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\test\arquillian-test-spi\1.1.15.Final\arquillian-test-spi-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\core\arquillian-core-spi\1.1.15.Final\arquillian-core-spi-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\container\arquillian-container-test-api\1.1.15.Final\arquillian-container-test-api-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\shrinkwrap\shrinkwrap-api\1.2.6\shrinkwrap-api-1.2.6.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\container\arquillian-container-test-spi\1.1.15.Final\arquillian-container-test-spi-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\container\arquillian-container-spi\1.1.15.Final\arquillian-container-spi-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\shrinkwrap\descriptors\shrinkwrap-descriptors-api-base\2.0.0\shrinkwrap-descriptors-api-base-2.0.0.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\core\arquillian-core-impl-base\1.1.15.Final\arquillian-core-impl-base-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\test\arquillian-test-impl-base\1.1.15.Final\arquillian-test-impl-base-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\container\arquillian-container-impl-base\1.1.15.Final\arquillian-container-impl-base-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\config\arquillian-config-api\1.1.15.Final\arquillian-config-api-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\config\arquillian-config-impl-base\1.1.15.Final\arquillian-config-impl-base-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\shrinkwrap\descriptors\shrinkwrap-descriptors-spi\2.0.0\shrinkwrap-descriptors-spi-2.0.0.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\container\arquillian-container-test-impl-base\1.1.15.Final\arquillian-container-test-impl-base-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\shrinkwrap\shrinkwrap-impl-base\1.2.6\shrinkwrap-impl-base-1.2.6.jar;C:\Users\Adwiti\.m2\repository\org\jboss\shrinkwrap\shrinkwrap-spi\1.2.6\shrinkwrap-spi-1.2.6.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\testng\arquillian-testng-container\1.1.15.Final\arquillian-testng-container-1.1.15.Final.jar;C:\Users\Adwiti\.m2\repository\org\jboss\arquillian\testng\arquillian-testng-core\1.1.15.Final\arquillian-testng-core-1.1.15.Final.jar;C:\Users\Adwiti\AppData\Roaming\JetBrains\IntelliJ IDEA 2017.2.5\lib\junit-4.12.jar;C:\Users\Adwiti\AppData\Roaming\JetBrains\IntelliJ IDEA 2017.2.5\lib\hamcrest-core-1.3.jar" com.intellij.rt.execution.junit.JUnitStarter -ideVersion5 -junit4 Assumption,currentTime
    6
    
    org.junit.AssumptionViolatedException: got: <false>, expected: is <true>
    
    
    	at org.junit.Assume.assumeThat(Assume.java:95)
    	at org.junit.Assume.assumeTrue(Assume.java:41)
    	at Assumption.currentTime(Assumption.java:42)
    	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    	at java.lang.reflect.Method.invoke(Method.java:498)
    	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
    	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
    	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
    	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
    	at org.junit.internal.runners.statements.ExpectException.evaluate(ExpectException.java:19)
    	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
    	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
    	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
    	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
    	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
    	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
    	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
    	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
    	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
    	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
    	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
    	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
    	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
    	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
    
    
    Process finished with exit code 0

# assertThat(Object actual, Matcher match)

assertThat matches the partial or exact object.

    @Test
    public void AssertThatExplained(){
    
        String name = "adwiti";
        assertThat(name, is("adwiti"));
        assertThat(name, equalTo("adwiti"));
        assertThat(name, not(equalTo("arun")));
        assertThat(name, is(not("arun")));
    
    }
    
# Working with compound value or multiple value.

different matchers are as below.

1. either 
2. both
3. anyof
4. allof
5. not

    import static org.hamcrest.CoreMatchers.*;
    
    import static org.hamcrest.core.Is.is;
    
    import static org.junit.Assert.assertThat;


    public class AssertThatMultipleValues {

    @Test
    public void assertthatHavingMultipleValues(){

        double marks = 100.00;
        assertThat(marks, either(is(100.00)).or(is(99.99))); //either of the value should match
        assertThat(marks, both(not(99.00)).and(not(89.00))); //both of the values should not match
        assertThat(marks,not(anyOf(is(100.01),is(20.00),is(99.00)))); //none of the value should match
        assertThat(marks, anyOf(is(100.00), is(20.00))); //any of the values should match
        assertThat(marks, not(allOf(is(1.00),is(100.00),is(2000.00)))); //any one value should match
    }
}


# Testing a collection 

we can test a collection using hasItem and hasItems.

    import org.junit.Test;

    import org.junit.runner.RunWith;

    import org.junit.runners.JUnit4;
    
    import java.util.Arrays;

    import java.util.List;
    
    import static org.hamcrest.CoreMatchers.hasItem;

    import static org.hamcrest.CoreMatchers.hasItems;

    import static org.hamcrest.CoreMatchers.not;

    import static org.junit.Assert.assertThat;

    @RunWith(JUnit4.class)
    public class HasItemTest {

    @Test
    public void testingMultipleItems(){

        List<String> names = Arrays.asList("Arun","Adwiti","Shipra");

        assertThat(names, hasItem("Arun"));
        assertThat(names, hasItems("Adwiti","Shipra"));
        assertThat(names, not(hasItem("sachin")));

    }
}


# Exploring String matchers

we can match string with three methods. These methods can be used only with String

1. startsWith

2. endsWith

3. containsString


    import org.junit.Test;
    
    import org.junit.runner.RunWith;
    
    import org.junit.runners.JUnit4;
    
    import static org.hamcrest.CoreMatchers.containsString;
    
    import static org.hamcrest.CoreMatchers.endsWith;
    
    import static org.hamcrest.core.StringStartsWith.startsWith;
    
    import static org.junit.Assert.assertThat;

    @RunWith(JUnit4.class)
    public class StringMatchers {

        @Test
        public void stringMatcher(){
    
            String message = "Pride and honour";
            assertThat(message,startsWith("Pride"));
            assertThat(message, endsWith("honour"));
            assertThat(message, containsString("and"));
        }
    }

# Parameterized test

If we want to test factorial of numbers, we can use 

org.junit.runners.Parameterized class

Step 1 : create the factorial class

Step 2 : Create a test class which has got two instance variables one in the number for
which we need to calculate the factorial and the other is the result.

Step 3: initialize the values via Constructor.

Step 4: create a method which returns a Collection of Object ( 1 - D), and has got the factorial
data, first index being number and second the result.

Step 5: Parametirize of using @Parameters.

Step 6 : Write the test method.


    /**
     * This class calculates the factorial of a number
     */
    public class Factorial {
        public int factorial(int number) {
            if (number == 0) return 1;
            return number * factorial(number - 1);
        }
    }
    
    
    import com.arun.Factorial;    
    import org.junit.Test;    
    import org.junit.runner.RunWith;
    import org.junit.runners.Parameterized;
    import java.util.Arrays;
    import java.util.Collection;
    import static org.junit.Assert.assertEquals;
    
    @RunWith(Parameterized.class)
    public class FactorialTest {
        private int number;
        private int expectedValue;
    
        public FactorialTest(int number, int expectedValue) {
            this.number = number;
            this.expectedValue = expectedValue;
        }
    
        @Parameterized.Parameters
        public static Collection<Object[]> factorialData() {
            return Arrays.asList(
                    new Object[][]{{0, 1}, {1, 1}, {2, 2}, {3, 6}, {4, 24}, {5, 120}}
            );
        }
    
        @Test
        public void testFactorial() {
            Factorial fac = new Factorial();
            assertEquals(fac.factorial(number), expectedValue);
        }
    }
