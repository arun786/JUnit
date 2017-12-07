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
