package application;
/**
 *  This class is used to create the  object "Competitors"
 *  @author Francesca Stefano mat. 306826
 * @author Antonio Signorelli mat. 306824
 *
 */
public class Partecipanti 
{
	/**
	 * @param fk_partecipante
	 * @param fk_gara
	 * @param pagato
	 */
	public Partecipanti(String fk_partecipante, String fk_gara, boolean pagato) {
		super();
		this.fk_partecipante = fk_partecipante;
		this.fk_gara = fk_gara;
		this.pagato = pagato;
	}
	private String fk_partecipante;
	private String fk_gara;
	private boolean pagato;
	/**
	 * @return the fk_partecipante
	 */
	public String getFk_partecipante() 
	{
		return fk_partecipante;
	}
	/**
	 * @param pagato
	 */
	public void setPagato(boolean pagato) 
	{
		this.pagato = pagato;
	}
	
	public boolean getPagato() 
	{
		return pagato;
	}
	/**
	 * @param fk_partecipante the fk_partecipante to set
	 */
	public void setFk_partecipante(String fk_partecipante) 
	{
		this.fk_partecipante = fk_partecipante;
	}
	/**
	 * @return the fk_gara
	 */
	public String getFk_gara() 
	{
		return fk_gara;
	}
	/**
	 * @param fk_gara the fk_gara to set
	 */
	public void setFk_gara(String fk_gara) 
	{
		this.fk_gara = fk_gara;
	}
	/**
	 * Method use to convert all the partecipanti's data in a string 
	 */
	
	public String toString() 
	{
        return "{" +
            " cf partecipante='" + getFk_partecipante() + "'" +
            ", codice gara='" + getFk_gara() + "'" +
            ", Pagato='" + getPagato() + "'" +
            "}";
    }
}
