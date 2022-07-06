package application;
import java.util.List;
/**
 *  This class is used to create the  object "Associate"
 * @author Francesca Stefano mat. 306826
 * @author Antonio Signorelli mat. 306824
 *
 */


public class Socio 

{
	private String CF;
	private String nome;
    private String cognome;
    private String indirizzo;
    private String username;
    private String pwd;
   // private String carta_credito;
    
    /**
     *  method constructor
	 * @param CF
	 * @param nome
	 * @param cognome
	 * @param indirizzo
	 * @param username
	 * @param pwd
	 * @param carta_credito
	 */
	public Socio(String CF, String nome, String cognome, String indirizzo, String username, String pwd,
			String carta_credito) {
		super();
		this.CF = CF;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.username = username;
		this.pwd = pwd;
		this.carta_credito = carta_credito;
	}


	private String carta_credito;
	/**
	 * @return the cF
	 */
	public String getCF() 
	{
		return CF;
	}
	/**
	 * @param CF the CF to set
	 */
	
	public void setCF(String CF) 
	{
		this.CF = CF;
	}
	/**
	 * @return the nome
	 */
	public String getNome() 
	{
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	/**
	 * @return the cognome
	 */
	public String getCognome() 
	{
		return cognome;
	}
	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}
	/**
	 * @return the indirizzo
	 */
	public String getIndirizzo() 
	{
		return indirizzo;
	}
	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(String indirizzo) 
	{
		this.indirizzo = indirizzo;
	}
	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() 
	{
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) 
	{
		this.pwd = pwd;
	}
	/**
	 * @return the carta_credito
	 */
	public String getCarta_credito()
	{
		return carta_credito;
	}
	/**
	 * @param carta_credito the carta_credito to set
	 */
	public void setCarta_credito(String carta_credito)
	{
		this.carta_credito = carta_credito;
	}
	
	public Barca addBarca(String id_barca, String nome, String lunghezza, String fk_socio) 
	{
		Barca b = new Barca(id_barca, nome,  lunghezza, fk_socio);
    	return b;   
    }
		
	public String removeBarca(String id_barca, List<Barca>listaBarche) 
	{
    	for(int i = 0;i<listaBarche.size();i++) 
    	{
    		if(id_barca.equals(listaBarche.get(i).getId_barca()))
    		{
    			listaBarche.remove(i);
    	    	return "\n Removed Boat ";
  			}
    	}   
    	return "\n Not Removed boat ";
    }
	
	
	public Pagamento addPay(String id_pagamento, String tipo, String importo, String fk_soci,String data_pagamento, String metodo) 
	{
		Pagamento P = new Pagamento(id_pagamento, tipo, importo, fk_soci,data_pagamento,metodo);
    	return P;   
    }

	/**
	 * Method use to convert all the socio's data in a string 
	 */
	public String toString() 
	{
        return "{" +
            " name='" + getCF() + "'" +
            ", surname='" + getNome() + "'" +
            ", username='" + getCognome() + "'" +
            ", password='" + getIndirizzo() + "'" +
            "}";
    }
	
}
