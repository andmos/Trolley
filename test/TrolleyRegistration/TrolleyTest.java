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
public class TrolleyTest {
    Trolley instance; 
    
    public TrolleyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Trolley(1, 250); 
    }
    
    @After
    public void tearDown() {
        Trolley instance = null;
    }

    /**
     * Test of getTrolleyNr method, of class Trolley.
     */
    @Test
    public void testGetTrolleyNr() {
        int expResult = 1;
        int result = instance.getTrolleyNr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setTrolleyNr method, of class Trolley.
     */
    @Test
    public void testSetTrolleyNr() {
        int nyttNr = 5;
        instance.setTrolleyNr(nyttNr);
        
        assertEquals(nyttNr, instance.getTrolleyNr()); 
    }

    /**
     * Test of getOwnWeight method, of class Trolley.
     */
    @Test
    public void testGetOwnWeight() {
        int expResult = 250;
        int result = instance.getOwnWeight();
        
        assertEquals(expResult, result);
        
       
    }

    /**
     * Test of setOwnWeight method, of class Trolley.
     */
    @Test
    public void testSetOwnWeight() {
        int nyEgenvekt = 300;
        
        instance.setOwnWeight(nyEgenvekt);
        
        assertEquals(nyEgenvekt, instance.getOwnWeight()); 
    }

    /**
     * Test of getPayLoad method, of class Trolley.
     */
    @Test
    public void testSetAndGetPayLoad() {
        int expResult = 250;
        
        instance.setPayLoad(expResult);
        
        int result = instance.getPayLoad();
       
        assertEquals(expResult, result);
       
      
    }

    /**
     * Test of getTotalWeight method, of class Trolley.
     */
    @Test
    public void testGetTotalWeight() {
        int expResult = 300;
        
        instance.setPayLoad(50);
        int result = instance.getTotalWeight();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Trolley.
     */
    @Test
    public void testToString() {
        String expResult = "Vogn 1 Egenvekt: 250 Lastvekt: 0 Totalvekt: 250";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}