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
class PagamentoTest {
	
	private Pagamento instance = new Pagamento("0102", "quota",  "1250", "ciccio","28/06/2022","iban");


    @Test
    public void testgetId_pagamento() 
    {
        
        String  expResult = "0102";
        String result = instance.getId_pagamento();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetId_pagamento()
    {
        
        String id_pagamento = "0102";
        Pagamento instance = new Pagamento("0102", "quota",  "1250", "ciccio","28/06/2022","iban");
        instance.setId_pagamento(id_pagamento);
    }
    
    @Test
    public void testgetTipo() 
    {
        
        
        String  expResult = "quota";
        String result = instance.getTipo();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetTipo()
    {
        
        String tipo = "quota";
        Pagamento instance = new Pagamento("0102", "quota",  "1250", "ciccio","28/06/2022","iban");
        instance.setTipo(tipo);
    }
    @Test
    public void testgetMetodo() 
    {
        
        
        String  expResult = "iban";
        String result = instance.getMetodo();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    @Test
    public void testsetMetodo()
    {
        
        String metodo = "iban";
        Pagamento instance = new Pagamento("0102", "quota",  "1250", "ciccio","28/06/2022","iban");
        instance.setMetodo(metodo);
    }
    
    @Test
    public void testgetImporto() 
    {
        
        
        String  expResult = "1250";
        String result = instance.getImporto();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetImporto()
    {
        
        String importo = "1250";
        Pagamento instance = new Pagamento("0102", "quota",  "1250", "ciccio","28/06/2022","iban");
        instance.setImporto(importo);
    }
    
    @Test
    public void testgetFk_soci() 
    {
        
        
        String  expResult = "ciccio";
        String result = instance.getFk_soci();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetFk_soci()
    {
        
        String fk_soci = "ciccio";
        Pagamento instance = new Pagamento("0102", "quota",  "1250", "ciccio","28/06/2022","iban");
        instance.setFk_soci(fk_soci);
    }

    @Test
    public void testgetData_pagamento() 
    {
        
        
        String  expResult = "28/06/2022";
        String result = instance.getData_pagamento();
        System.out.println(result);
        assertEquals(expResult, result);
        
        
    }
    
    @Test
    public void testsetData_pagamento()
    {
        
        String data_pagamento = "28/06/2022";
        Pagamento instance = new Pagamento("0102", "quota",  "1250", "ciccio","28/06/2022","iban");
        instance.setData_pagamento(data_pagamento);
    }
    

}
