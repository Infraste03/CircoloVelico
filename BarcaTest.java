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
class BarcaTest {
	
	private Barca instance = new Barca("1", "Panna",  "12", "ciccio");


    @Test
    public void testgetId_barca() 
    {
        
        String  expResult = "1";
        String result = instance.getId_barca();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetId_barca()
    {
        System.out.println("setId_boat");
        String id_barca = "1";
        Barca instance = new Barca("1", "Panna",  "12", "ciccio");
        instance.setId_barca(id_barca);
    }
    
    @Test
    public void testgetNome() 
    {
        
        
        String  expResult = "Panna";
        String result = instance.getNome();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetNome()
    {
        
        String nome = "Panna";
        Barca instance = new Barca("1", "Panna",  "12", "ciccio");
        instance.setNome(nome);
    }
    @Test
    public void testgetLunghezza() 
    {
        
        
        String  expResult = "12";
        String result = instance.getLunghezza();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    @Test
    public void testsetLunghezza()
    {
        
        String lunghezza = "12";
        Barca instance = new Barca("1", "Panna",  "12", "ciccio");
        instance.setLunghezza(lunghezza);
    }
    
    @Test
    public void testgetFk_socio() 
    {
        
        
        String  expResult = "ciccio";
        String result = instance.getFk_socio();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetFk_socio()
    {
        
        String Fk_socio = "ciccio";
        Barca instance = new Barca("1", "Panna",  "12", "ciccio");
        instance.setFk_socio(Fk_socio);
    }

    
    

}
