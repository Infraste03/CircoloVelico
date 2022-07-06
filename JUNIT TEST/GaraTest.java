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
class GaraTest {
	
	private Gara instance = new Gara("Gara1", "123",  "10/08/2022", "Sanremo");


    @Test
    public void testgetid_gara() 
    {
        
        String  expResult = "Gara1";
        String result = instance.getId_gara();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetId_gara()
    {
        System.out.println("setId_boat");
        String id_gara = "1";
        Gara instance = new Gara("Gara1", "123", "10/08/2022", "Sanremo");
        instance.setId_gara(id_gara);
    }
    
    @Test
    public void testgetQuota() 
    {
        
        
        String  expResult = "123";
        String result = instance.getQuota();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetQuota()
    {
        
        String quota = "123";
        Gara instance = new Gara("Gara1", "123", "10/08/2022", "Sanremo");
        instance.setQuota(quota);
    }
    @Test
    public void testgetData() 
    {
        
        
        String  expResult = "10/08/2022";
        String result = instance.getData();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    @Test
    public void testsetData()
    {
        
        String data = "10/08/2022";
        Gara instance = new Gara("Gara1", "123", "10/08/2022", "Sanremo");
        instance.setData(data);
    }
    
    @Test
    public void testgetLuogo() 
    {
        
        
        String  expResult = "Sanremo";
        String result = instance.getLuogo();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetLuogo()
    {
        
        String luogo = "Sanremo";
        Gara instance = new Gara("Gara1", "123", "10/08/2022", "Sanremo");
        instance.setLuogo(luogo);
    }

    
    

}
