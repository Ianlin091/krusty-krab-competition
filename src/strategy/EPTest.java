package strategy;

import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class EPTest {

    @Test
    public void testJKeyPressCountthree() {
        boolean result = AllTest.checkTime(3);
        assertTrue(result); //
        System.out.println("Check times 3 Test pass");
    }

    @Test
    public void testJKeyPressCountOutOfRange() {
        boolean result = AllTest.checkTime(10);
        assertFalse(result);
        System.out.println("Check times 10 Test pass");
    }
}
