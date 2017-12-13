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
