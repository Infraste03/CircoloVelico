/**
 * 
 */
package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author fstef
 *
 */
class PersonaleTest 
{
	
	private Personale instance = new Personale("aa", "Gioschio",  "top");


    @Test
    public void testgetId_personale() 
    {
        
        String  expResult = "aa";
        String result = instance.getId_personale();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetId_personale()
    {
        
        String id_personale = "aa";
        Personale instance = new Personale("aa", "Gioschio",  "top");;
        instance.setId_personale(id_personale);
    }
    
    @Test
    public void testgetUser() 
    {
        
        
        String  expResult = "Gioschio";
        String result = instance.getUser();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetUser()
    {
        
        String user = "Gioschio";
        Personale instance = new Personale("aa", "Gioschio",  "top");;
        instance.setUser(user);
    }
    @Test
    public void testgetPassword() 
    {
        
        
        String  expResult = "top";
        String result = instance.getPassword();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    @Test
    public void testsetPassword()
    {
        
        String password = "top";
        Personale instance = new Personale("aa", "Gioschio",  "top");;
        instance.setPassword(password);
    }
    
   

}
