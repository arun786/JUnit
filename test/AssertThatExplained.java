import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class AssertThatExplained {

    @Test
    public void AssertThatExplained(){
        String name = "adwiti";
        assertThat(name, is("adwiti"));
        assertThat(name, equalTo("adwiti"));
        assertThat(name, not(equalTo("arun")));
        assertThat(name, is(not("arun")));
    }
}
