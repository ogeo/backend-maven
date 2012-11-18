/**
 * 
 */
package it.ogeo.model;

import java.io.Serializable;

/**
 * @author micheleorsi
 *
 */
public class Maintainable extends AbstractClass implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String type = null;
	String status = null;
	
	/**
	 * @param id
	 * @param latitude
	 * @param longitude
	 * @param type
	 * @param status
	 */
	public Maintainable(Integer id, Double latitude, Double longitude,
			String type, String status) {
		super(id, latitude, longitude);
		this.type = type;
		this.status = status;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
