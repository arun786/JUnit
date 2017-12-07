import org.junit.Test;

public class ExceptionHnadling {

    @Test(expected = RuntimeException.class)
    public void exceptionThrown(){
        throw new NullPointerException();
    }
}
