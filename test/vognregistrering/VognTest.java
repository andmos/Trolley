/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vognregistrering;

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
public class VognTest {

    Vogn instance;

    public VognTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Vogn(1, 250);
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getVognNr method, of class Vogn.
     */
    @Test
    public void testGetVognNr() {
        int expResult = 1;
        int result = instance.getVognNr();
       
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setVognNr method, of class Vogn.
     */
    @Test
    public void testSetVognNr() {
        int nyttNr = 30;

        instance.setVognNr(nyttNr);

        assertEquals(nyttNr, instance.getVognNr());
    }

    /**
     * Test of getEgenVekt method, of class Vogn.
     */
    @Test
    public void testGetEgenVekt() {
        int expResult = 250;
        int result = instance.getEgenVekt();
        
        assertEquals(expResult, result);

    }

    /**
     * Test of setEgenVekt method, of class Vogn.
     */
    @Test
    public void testSetEgenVekt() {
        int nyEgenvekt = 300;

        instance.setEgenVekt(nyEgenvekt);

        assertEquals(nyEgenvekt, instance.getEgenVekt());

    }

    /**
     * Test of getLastVekt method, of class Vogn.
     */
    @Test
    public void testGetLastVekt() {
        int expResult = 0;
        int result = instance.getLastVekt();
        
        assertEquals(expResult, result);
       

    }

    /**
     * Test of getTotalVekt method, of class Vogn.
     */
    @Test
    public void testsetVektAndGetTotalVekt() {
        instance.setLastVekt(50);
        
        int expResult = 300;
        int result = instance.getTotalVekt();
        
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Vogn.
     */
    @Test
    public void testToString() {
        String expResult = "Vogn 1 Egenvekt: 250 Lastvekt: 0 Totalvekt: 250";
        String result = instance.toString();
        
        assertEquals(expResult, result);

    }
}