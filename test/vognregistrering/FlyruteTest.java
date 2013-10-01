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
public class FlyruteTest {
    
    Flyrute instance; 
    public FlyruteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         instance = new Flyrute("Bodo", "Trondheim");
    }
    
    @After
    public void tearDown() {
        instance = null; 
    }

    /**
     * Test of getFra method, of class Flyrute.
     */
    @Test
    public void testGetFra() { 
        String expResult = "Bodo";
        String result = instance.getFra();
       
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getTil method, of class Flyrute.
     */
    @Test
    public void testGetTil() {
        String expResult = "Trondheim";
        String result = instance.getTil();
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFra method, of class Flyrute.
     */
    @Test
    public void testSetFra() {
        String nyFraPlass = "Tromso";
        
        instance.setFra(nyFraPlass);
        
        assertEquals(nyFraPlass, instance.getFra());
    }

    /**
     * Test of setTil method, of class Flyrute.
     */
    @Test
    public void testSetTil() {
        String nyTilPlass = "Oslo";
       
        instance.setTil(nyTilPlass);
        
        assertEquals(nyTilPlass, instance.getTil());
        
    }

    /**
     * Test of toString method, of class Flyrute.
     */
    @Test
    public void testToString() {
        String expResult = "Flygning fra Bodo Til Trondheim";
        
        String result = instance.toString();
        
        assertEquals(expResult, result);
    
    }
}