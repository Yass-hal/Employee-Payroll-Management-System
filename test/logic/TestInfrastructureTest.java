package logic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

// Just a smoke test to verify that the JUnit 4 runner is configured in ant 
// and can compile and execute tests against the application classes.
public class TestInfrastructureTest {

    @Test
    public void junitRunnerExecutesAndSeesProjectClasses() {
        PayrollCalculator calculator = new PayrollCalculator();
        assertEquals(16550, calculator.increaseByAmount(16500, 50));
    }
}