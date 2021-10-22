package shop;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DB_OperationsTest {
    
    public DB_OperationsTest() {
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

  
    @Test
    public void testLoginAsBuyer() {
        System.out.println("login");
        String name = "Raghad@gmail.com";
        String pass = "r12345";
        DB_Operations instance = new DB_Operations();
        int expResult = 1;
        int result = instance.login(name, pass);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLoginAsSeller() {
        System.out.println("login");
        String name = "Seller@gmail.com";
        String pass = "s12345";
        DB_Operations instance = new DB_Operations();
        int expResult = 2;
        int result = instance.login(name, pass);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testWrongLogin() {
        System.out.println("login");
        String name = "Raghad@gmail.com";
        String pass = "s12345";
        DB_Operations instance = new DB_Operations();
        int expResult = 3;
        int result = instance.login(name, pass);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertItem method, of class DB_Operations.
     */
    @Test
    public void testInsertItem() {
        System.out.println("insertItem");
        Item itm = null;
        DB_Operations instance = new DB_Operations();
        boolean expResult = false;
        boolean result = instance.insertItem(itm);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserID method, of class DB_Operations.
     */
    @Test
    public void testGetUserID() {
        System.out.println("getUserID");
        String Email = "Raghad@gmail.com";
        DB_Operations instance = new DB_Operations();
        int expResult = 106;
        int result = instance.getUserID(Email);
        assertEquals(expResult, result);
    }

    
}
