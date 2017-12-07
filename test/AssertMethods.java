import org.junit.Test;

import static org.junit.Assert.*;

public class AssertMethods {

    @Test
    public void assertMethodsCheck() {

        assertTrue(2 < 3);
        assertTrue("2 is less than 3", 2 < 3);

        assertFalse(3 > 5);
        assertFalse("3 is less than 5", 3 > 5);

        String name = null;
        assertNull(name);

        name = "arun";
        assertNotNull(name);

        String nameExpected = "arun";
        String nameActual = "arun";

        assertEquals("Objects are not same", nameExpected, nameActual);
        assertEquals(nameExpected, nameActual);

        assertEquals(10,10);

        String name1 = "arun";
        String name2 = "arun";
        assertSame(name1, name2);

        double sum1 = .98 + .998;
        assertEquals(sum1, 1.988,.10);
    }
}
