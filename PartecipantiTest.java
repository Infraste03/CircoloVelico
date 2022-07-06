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
class PartecipantiTest 
{
	
	private Partecipanti instance = new Partecipanti("ciccio", "Gara1",  true);


    @Test
    public void testgetFk_partecipante() 
    {
        
        String  expResult = "ciccio";
        String result = instance.getFk_partecipante();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetFk_partecipante()
    {
        
        String fk_partecipante = "ciccio";
        Partecipanti instance = new Partecipanti("ciccio", "Gara1",  true);
        instance.setFk_partecipante(fk_partecipante);
    }
    
    @Test
    public void testgetFk_gara() 
    {
        
        
        String  expResult = "Gara1";
        String result = instance.getFk_gara();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetFk_gara()
    {
        
        String fk_gara = "Gara1";
        Partecipanti instance = new Partecipanti("ciccio", "Gara1",  true);
        instance.setFk_gara(fk_gara);
    }
    @Test
    public void testgetPagato() 
    {
        
        
    	boolean  expResult = true;
        boolean result = instance.getPagato();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    @Test
    public void testsetPagato()
    {
        
    	boolean pagato = true;
        Partecipanti instance = new Partecipanti("ciccio", "Gara1",  true);
        instance.setPagato(pagato);
    }
    
   
    

}
