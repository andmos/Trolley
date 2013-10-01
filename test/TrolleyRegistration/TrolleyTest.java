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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTrolleyNr method, of class Trolley.
     */
    @Test
    public void testGetTrolleyNr() {
        System.out.println("getTrolleyNr");
        Trolley instance = null;
        int expResult = 0;
        int result = instance.getTrolleyNr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTrolleyNr method, of class Trolley.
     */
    @Test
    public void testSetTrolleyNr() {
        System.out.println("setTrolleyNr");
        int nyttNr = 0;
        Trolley instance = null;
        instance.setTrolleyNr(nyttNr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwnWeight method, of class Trolley.
     */
    @Test
    public void testGetOwnWeight() {
        System.out.println("getOwnWeight");
        Trolley instance = null;
        int expResult = 0;
        int result = instance.getOwnWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOwnWeight method, of class Trolley.
     */
    @Test
    public void testSetOwnWeight() {
        System.out.println("setOwnWeight");
        int nyEgenvekt = 0;
        Trolley instance = null;
        instance.setOwnWeight(nyEgenvekt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPayLoad method, of class Trolley.
     */
    @Test
    public void testGetPayLoad() {
        System.out.println("getPayLoad");
        Trolley instance = null;
        int expResult = 0;
        int result = instance.getPayLoad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPayLoad method, of class Trolley.
     */
    @Test
    public void testSetPayLoad() {
        System.out.println("setPayLoad");
        int nyLastVekt = 0;
        Trolley instance = null;
        instance.setPayLoad(nyLastVekt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalWeight method, of class Trolley.
     */
    @Test
    public void testGetTotalWeight() {
        System.out.println("getTotalWeight");
        Trolley instance = null;
        int expResult = 0;
        int result = instance.getTotalWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Trolley.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Trolley instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}