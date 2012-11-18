/**
 * 
 */
package it.ogeo.model;

import java.io.Serializable;

/**
 * @author micheleorsi
 *
 */
public class Maintainable implements Serializable {
	
	String id = null;
	String type = null;
	String status = null;
	String latitude = null;
	String longitude = null;
	/**
	 * @param type
	 * @param status
	 * @param latitude
	 * @param longitude
	 */
	public Maintainable(String type, String status, String latitude,
			String longitude) {
		super();
		this.id = "generatedId";
		this.type = type;
		this.status = status;
		this.latitude = latitude;
		this.longitude = longitude;
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
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
