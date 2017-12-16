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
