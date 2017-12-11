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
