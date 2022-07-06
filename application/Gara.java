package application;
/**
 *  This class is used to create the  object "Race"
 * @author Francesca Stefano mat. 306826
 * @author Antonio Signorelli mat. 306824
 *
 */
public class Gara 
{
	/**
	 * @param id_gara
	 * @param quota
	 * @param data
	 * @param luogo
	 */
	private String id_gara;
	private String quota;
	private String data;
	private String luogo;
	
	public Gara(String id_gara, String quota, String data, String luogo) 
	{
		super();
		this.id_gara = id_gara;
		this.quota = quota;
		this.data = data;
		this.luogo = luogo;
	}	
	/**
	 * @return the id_gara
	 */
	public String getId_gara() 
	{
		return id_gara;
	}
	/**
	 * @param id_gara the id_gara to set
	 */
	public void setId_gara(String id_gara) 
	
	{
		this.id_gara = id_gara;
	}
	/**
	 * @return the quota
	 */
	public String getQuota() 
	{
		return quota;
	}
	/**
	 * @param quota the quota to set
	 */
	public void setQuota(String quota) 
	{
		this.quota = quota;
	}
	/**
	 * @return the data
	 */
	public String getData() 
	{
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(String data) 
	{
		this.data = data;
	}
	/**
	 * @return the luogo
	 */
	public String getLuogo() 
	{
		return luogo;
	}
	/**
	 * @param luogo the luogo to set
	 */
	public void setLuogo(String luogo) 
	{
		this.luogo = luogo;
	}

	/**
	 * Method use to convert all the gara's data in a string 
	 */
	public String toString() 
	{
        return "{" +
            " id del personale='" + getId_gara() + "'" +
            ", quota='" + getQuota() + "'" +
            ", data='" + getData() + "'" +
            ", luogo='" + getLuogo() + "'" +
            "}";
    }
}
