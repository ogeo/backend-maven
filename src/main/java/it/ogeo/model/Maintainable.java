/**
 * 
 */
package it.ogeo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author micheleorsi
 *
 */
public class Maintainable extends AbstractClass implements Serializable{
	
	/**
	 * @param id
	 * @param latitude
	 * @param longitude
	 * @param type
	 * @param status
	 * @param timestamp
	 * @param idDevice
	 */
	public Maintainable(Integer id, Double latitude, Double longitude,
			String type, String status, Date timestamp, Integer idDevice) {
		super(id, latitude, longitude);
		this.type = type;
		this.status = status;
		this.timestamp = timestamp;
		this.idDevice = idDevice;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String type = null;
	String status = null;
	Date timestamp = null;
	Integer idDevice = null;
	
	
	
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
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the idDevice
	 */
	public Integer getIdDevice() {
		return idDevice;
	}
	/**
	 * @param idDevice the idDevice to set
	 */
	public void setIdDevice(Integer idDevice) {
		this.idDevice = idDevice;
	}
	
}
