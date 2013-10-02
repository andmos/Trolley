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
    
    FlightRoute instance;
    
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
        instance = new FlightRoute("111","Bodo"); 
    }
    
    @After
    public void tearDown() {
        instance = null; 
    }

    /**
     * Test of getFlightRouteNr method, of class FlightRoute.
     */
    @Test
    public void testGetFlightRouteNr() {
        String expResult = "111";
        String result = instance.getFlightRouteNr();
      
        assertEquals(expResult, result);
 
    }

    /**
     * Test of setFlightRouteNr method, of class FlightRoute.
     */
    @Test
    public void testSetFlightRouteNr() {
        String newNumber = "222";
       
        instance.setFlightRouteNr(newNumber);
        
        assertEquals(newNumber, instance.getFlightRouteNr()); 
    }

    /**
     * Test of getTil method, of class FlightRoute.
     */
    @Test
    public void testGetTil() {
        String expResult = "Bodo";
        String result = instance.getTil();
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setTil method, of class FlightRoute.
     */
    @Test
    public void testSetTil() {
       
        String nyTilPlass = "Tromso";
     
        instance.setTil(nyTilPlass);
       
        assertEquals(nyTilPlass, instance.getTil()); 
    }
}