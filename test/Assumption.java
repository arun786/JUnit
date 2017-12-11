import org.junit.AssumptionViolatedException;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

public class Assumption {


    boolean isSonarRunning = false;

    @Test
    public void check() {
        isSonarRunning = true;
        assumeFalse(isSonarRunning);
        assertTrue(true);
    }

    @Test(expected = AssumptionViolatedException.class)
    public void assumeCondition() {
        boolean isServerRunning = false;
        assumeTrue(isServerRunning);
    }

    @Test(expected = AssumptionViolatedException.class)
    public void currentTime() {

        long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("ss");
        Date date = new Date(time);

        String currentSeconds = sdf.format(date);
        int seconds = Integer.parseInt(currentSeconds);
        System.out.println(seconds);

        boolean isCurrentTimeInSecondsBetween30and45 = seconds > 30 && seconds < 45 ? true : false;

        assumeTrue(isCurrentTimeInSecondsBetween30and45);
        assertTrue(true);
    }
}
