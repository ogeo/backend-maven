/**
 * 
 */
package it.ogeo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author micheleorsi
 *
 */
@Path("/units")
public class UnitResource {
	
	@GET
	@Path("/{unitId}")
	public String receiveParametersFromDevice(@PathParam("unitId") String unitId) {
		return "thanks for your request: "+unitId;
	}

}
