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
in the a fixed order, we can use the anotation

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

