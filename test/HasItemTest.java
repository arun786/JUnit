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
