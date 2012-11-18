/**
 * 
 */
package it.ogeo.model;

import java.io.Serializable;

/**
 * @author micheleorsi
 *
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String id = null;
	String name = null;
	String email = null;
	String latitude = null;
	String longidude = null;
	String cellNumber = null;
	
	/**
	 * @param name
	 * @param email
	 * @param latitude
	 * @param longidude
	 * @param cellNumber
	 */
	public Person(String name, String email, String latitude, String longidude,
			String cellNumber) {
		super();
		this.id = "generatedId";
		this.name = name;
		this.email = email;
		this.latitude = latitude;
		this.longidude = longidude;
		this.cellNumber = cellNumber;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longidude
	 */
	public String getLongidude() {
		return longidude;
	}
	/**
	 * @param longidude the longidude to set
	 */
	public void setLongidude(String longidude) {
		this.longidude = longidude;
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
