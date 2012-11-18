/**
 * 
 */
package it.ogeo.rest;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author micheleorsi
 *
 */
@Path("/units")
@Produces({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
public class UnitResource {
	
	private Logger log = Logger.getLogger(UnitResource.class.getName());
	
	@GET
	@Path("/{unitId}")
	public String receiveParametersFromDevice(@PathParam("unitId") String unitId,
			@QueryParam("accelerometrox") String accelerometrox,
			@QueryParam("accelerometroy") String accelerometroy,
			@QueryParam("accelerometroz") String accelerometroz) {
		log.info("thanks for your request: "+unitId+
				", accelerometrox: "+accelerometrox+
				", accelerometroy: "+accelerometroy+
				", accelerometroz: "+accelerometroz);
		return "thanks for your request: "+unitId+
				", accelerometrox: "+accelerometrox+
				", accelerometroy: "+accelerometroy+
				", accelerometroz: "+accelerometroz;
	}

}
