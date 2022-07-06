package application;
/**
 *  This class is used to create the  object "Payment"
 * @author Francesca Stefano mat. 306826
 * @author Antonio Signorelli mat. 306824
 *
 */
public class Pagamento
{
	private String id_pagamento;
	private String tipo;
	private String importo;
	private String fk_soci;
	private String data_pagamento;
	private String metodo;

	public Pagamento(String id_pagamento, String tipo, String importo, String fk_soci, String data_pagamento, String metodo) 
	{
		this.id_pagamento = id_pagamento;
		this.tipo = tipo;
		this.importo=importo;
		this.fk_soci= fk_soci;
		this.data_pagamento = data_pagamento;
		this.metodo= metodo;
		
		
	}
	/**
	 * @return the id_pagamento
	 */
	public String  getId_pagamento() 
	{
		return id_pagamento;
	}
	/**
	 * @param id_pagamento the id_pagamento to set
	 */
	public void setId_pagamento(String id_pagamento) 
	{
		this.id_pagamento = id_pagamento;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() 
	{
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}	
	public String getMetodo() 
	{
		return metodo;
	}
	/**
	 * @param metodo
	 */
	public void setMetodo(String metodo) 
	{
		this.metodo = metodo;
	}
	/**
	 * @return the importo
	 */
	public String getImporto() 
	{
		return importo;
	}
	/**
	 * @param importo the importo to set
	 */
	public void setImporto(String importo) 
	{
		this.importo = importo;
	}
	/**
	 * @return the fk_soci
	 */
	public String getFk_soci() 
	{
		return fk_soci;
	}
	/**
	 * @param fk_soci the fk_soci to set
	 */
	public void setFk_soci(String fk_soci) 
	{
		this.fk_soci = fk_soci;
	}
	/**
	 * @return the data_pagamento
	 */
	public String getData_pagamento() 
	{
		return data_pagamento;
	}
	/**
	 * @param data_pagamento the data_pagamento to set
	 */
	public void setData_pagamento(String data_pagamento) 
	{
		this.data_pagamento = data_pagamento;
	}
	/**
	 * Method use to convert all the pagamento's data in a string 
	 */
	public String toString() 
	{
        return "{" +
            " id pagamento='" + getId_pagamento() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", importo='" + getImporto() + "'" +
            ", cf socio='" + getFk_soci() + "'" +
            ", data pagamento='" + getData_pagamento() + "'" +
            ", metodo='" + getMetodo() + "'" +
            "}";
    }
}
