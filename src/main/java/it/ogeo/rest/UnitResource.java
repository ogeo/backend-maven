/**
 * 
 */
package it.ogeo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * @author micheleorsi
 *
 */
@Path("/units")
public class UnitResource {
	
	@GET
	@Path("/{unitId}")
	public String receiveParametersFromDevice(@PathParam("unitId") String unitId,
			@QueryParam("accelerometrox") String accelerometrox,
			@QueryParam("accelerometroy") String accelerometroy,
			@QueryParam("accelerometroz") String accelerometroz) {
		return "thanks for your request: "+unitId+
				", accelerometrox: "+accelerometrox+
				", accelerometroy: "+accelerometroy+
				", accelerometroz: "+accelerometroz;
	}

}
