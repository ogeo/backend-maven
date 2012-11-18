/**
 * 
 */
package it.ogeo.model;

import java.io.Serializable;

/**
 * @author micheleorsi
 *
 */
public class InfoValue extends AbstractClass implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String description = null;
	String level = null;
	
	
	/**
	 * @param id
	 * @param latitude
	 * @param longitude
	 * @param description
	 * @param level
	 */
	public InfoValue(Integer id, Double latitude, Double longitude,
			String description, String level) {
		super(id, latitude, longitude);
		this.description = description;
		this.level = level;
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
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
}
