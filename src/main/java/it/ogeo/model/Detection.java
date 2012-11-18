/**
 * 
 */
package it.ogeo.model;

import java.io.Serializable;

/**
 * @author micheleorsi
 *
 */
public class Detection extends AbstractClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String type = null;
	String value = null;
	
	/**
	 * @param id
	 * @param latitude
	 * @param longitude
	 * @param type
	 * @param value
	 */
	public Detection(Integer id, Double latitude, Double longitude, String type,
			String value) {
		super(id, latitude, longitude);
		this.type = type;
		this.value = value;
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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
