package application;
/**
 * The class " Barca"  is used to create the object Boat
 * @author Francesca Stefano mat. 306826
 * @author Antonio Signorelli mat. 306824
 *
 */
public class Barca 
{
	private String id_barca;
	private String nome;
	private String lunghezza;
	private String fk_socio;

	public Barca(String id_barca, String nome, String lunghezza, String fk_socio) 
	{		
		this.id_barca = id_barca;
		this.nome= nome;
		this.lunghezza= lunghezza;
		this.fk_socio= fk_socio;
		
	}

	/**
	 * @return the id_barca
	 */
	public String getId_barca() 
	{
		return id_barca;
	}
	/**
	 * @param id_barca the id_barca to set
	 */
	public void setId_barca(String id_barca) 
	{
		this.id_barca = id_barca;
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
	 * @return the lunghezza
	 */
	public String getLunghezza() 
	{
		return lunghezza;
	}
	/**
	 * @param lunghezza the lunghezza to set
	 */
	public void setLunghezza(String lunghezza) 
	{
		this.lunghezza = lunghezza;
	}
	/**
	 * @return the fk_socio
	 */
	public String getFk_socio() 
	{
		return fk_socio;
	}
	/**
	 * @param fk_socio the fk_socio to set
	 */
	public void setFk_socio(String fk_socio) 
	{
		this.fk_socio = fk_socio;
	}
	
	/**
	 * Method use to convert all the baraca's data in a string 
	 */
	
	public String toString() 
	{
        return "{" +
            " Id Barca='" + getId_barca() + "'" +
            ", Nome barca='" + getNome() + "'" +
            ", lunghezza ='" + getLunghezza() + "'" +
            ", id del socio='" + getFk_socio() + "'" +
            "}";
    }
}
