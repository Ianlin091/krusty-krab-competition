package strategy;

import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BVA {
	
    @Test
    public void testJKeyPressCountzero() {
        boolean result = AllTest.checkTime(0);
        assertFalse(result); // 
    }
    
    @Test
    public void testJKeyPressCountone() {
        boolean result = AllTest.checkTime(1);
        assertTrue(result); // 
    }
    
    @Test
    public void testJKeyPressCounttwo() {
        boolean result = AllTest.checkTime(2);
        assertTrue(result); // 
    }
    
    @Test
    public void testJKeyPressCountsix() {
        boolean result = AllTest.checkTime(6);
        assertTrue(result);
    }
    
    @Test
    public void testJKeyPressCountseven() {
        boolean result = AllTest.checkTime(7);
        assertTrue(result);
    }
    

    @Test
    public void testJKeyPressCounteight() {
        boolean result = AllTest.checkTime(8);
        assertFalse(result); 
    }
}

