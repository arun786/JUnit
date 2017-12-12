import org.junit.Test;

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
