/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TrolleyRegistration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andreasmosti
 */
public class FlightRouteTest {
    
    public FlightRouteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTil method, of class FlightRoute.
     */
    @Test
    public void testGetTil() {
        System.out.println("getTil");
        FlightRoute instance = null;
        String expResult = "";
        String result = instance.getTil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setTil method, of class FlightRoute.
     */
    @Test
    public void testSetTil() {
        System.out.println("setTil");
        String nyTilPlass = "";
        FlightRoute instance = null;
        instance.setTil(nyTilPlass);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of toString method, of class FlightRoute.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FlightRoute instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
}