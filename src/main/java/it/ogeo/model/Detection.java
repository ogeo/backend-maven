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
	 * @param id
	 * @param latitude
	 * @param longitude
	 * @param type
	 * @param value
	 * @param description
	 */
	public Detection(Integer id, Double latitude, Double longitude,
			String type, String value, String description) {
		super(id, latitude, longitude);
		this.type = type;
		this.value = value;
		this.description = description;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String type = null;
	String value = null;
	String description = null;
	
	
	
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

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
