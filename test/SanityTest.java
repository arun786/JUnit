import org.junit.*;

public class SanityTest {

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
}
