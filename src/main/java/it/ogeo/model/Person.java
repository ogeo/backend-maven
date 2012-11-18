/**
 * 
 */
package it.ogeo.model;

import java.io.Serializable;

/**
 * @author micheleorsi
 *
 */
public class Person extends AbstractClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String name = null;
	String email = null;
	String cellNumber = null;
	
	/**
	 * @param id
	 * @param latitude
	 * @param longitude
	 * @param name
	 * @param email
	 * @param cellNumber
	 */
	public Person(Integer id, Double latitude, Double longitude, String name,
			String email, String cellNumber) {
		super(id, latitude, longitude);
		this.name = name;
		this.email = email;
		this.cellNumber = cellNumber;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the cellNumber
	 */
	public String getCellNumber() {
		return cellNumber;
	}
	/**
	 * @param cellNumber the cellNumber to set
	 */
	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}
			
}
