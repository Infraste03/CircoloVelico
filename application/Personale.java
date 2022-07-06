package application;
/**
 *  this class is used to create the  object "Employee"
 *  @author Francesca Stefano mat. 306826
 * @author Antonio Signorelli mat. 306824
 *
 */



public class Personale 
{
	
	
	private String id_personale;
	private String user;
    private String password;
    
    /**
     *  method costructor 
     *  
     *  @param id_personale
     *  @param user
     *  @param password
     *
     */
    
	public Personale(String id_personale, String user, String password) {
		super();
		this.id_personale = id_personale;
		this.user = user;
		this.password = password;
	}
	/**
	 * @return the id_personale
	 */
	public String getId_personale() 
	{
		return id_personale;
	}
	/**
	 * @param id_personale the id_personale to set
	 */
	public void setId_personale(String id_personale) 
	{
		this.id_personale = id_personale;
	}
	/**
	 * @return the user
	 */
	public String getUser() 
	{
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) 
	{
		this.user = user;
	}
	/**
	 * @return the password
	 */
	public String getPassword() 
	{
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}
	/**
	 * Method use to convert all the personale's data in a string 
	 */
	public String toString() 
	{
        return "{" +
            " id del personale='" + getId_personale() + "'" +
            ", username='" + getUser() + "'" +            
            "}";
    }
}
