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
class SocioTest 
{
	
	private Socio instance = new Socio("ABCD", "Alex", "Malavolta","via gin tonic", "mala",  "malaalex","123456");


    @Test
    public void testgetCF() 
    {
        
        String  expResult = "ABCD";
        String result = instance.getCF();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetCF()
    {
        
        String CF = "ABCD";
        Socio instance = new Socio("ABCD", "Alex", "Malavolta","via gin tonic", "mala",  "malaalex","123456");
        instance.setCF(CF);
    }
    
    @Test
    public void testgetNome() 
    {
        
        
        String  expResult = "Alex";
        String result = instance.getNome();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetNome()
    {
        
        String nome = "Alex";
        Socio instance = new Socio("ABCD", "Alex", "Malavolta","via gin tonic", "mala",  "malaalex","123456");
        instance.setNome(nome);
    }
    @Test
    public void testgetCognome() 
    {
        
        
        String  expResult = "Malavolta";
        String result = instance.getCognome();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    @Test
    public void testsetCognome()
    {
        
        String cognome = "Malavolta";
        Socio instance = new Socio("ABCD", "Alex", "Malavolta","via gin tonic", "mala",  "malaalex","123456");
        instance.setCognome(cognome);
    }
    
    @Test
    public void testgetIndirizzo() 
    {
        
        
        String  expResult = "via gin tonic";
        String result = instance.getIndirizzo();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    @Test
    public void testsetIndirizzo()
    {
        
        String indirizzo = "via gin tonic";
        Socio instance = new Socio("ABCD", "Alex", "Malavolta","via gin tonic", "mala",  "malaalex","123456");
        instance.setCognome(indirizzo);
    }
    
    @Test
    public void testgetUsername() 
    {
        
        
        String  expResult = "mala";
        String result = instance.getUsername();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    @Test
    public void testsetUsername()
    {
        
        String username = "mala";
        Socio instance = new Socio("ABCD", "Alex", "Malavolta","via gin tonic", "mala",  "malaalex","123456");
        instance.setUsername(username);
    }
    
    
    @Test
    public void testgetPwd() 
    {
        
        
        String  expResult = "malaalex";
        String result = instance.getPwd();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    @Test
    public void testsetPwd()
    {
        
        String pwd = "malaalex";
        Socio instance = new Socio("ABCD", "Alex", "Malavolta","via gin tonic", "mala",  "malaalex","123456");
        instance.setUsername(pwd);
    }
   
    @Test
    public void testgetCarta_credito() 
    {
        
        
        String  expResult = "123456";
        String result = instance.getCarta_credito();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    @Test
    public void testsetCarta_credito()
    {
        
        String carta_credito = "123456";
        Socio instance = new Socio("ABCD", "Alex", "Malavolta","via gin tonic", "mala",  "malaalex","123456");
        instance.setUsername(carta_credito);
    }
   

}
