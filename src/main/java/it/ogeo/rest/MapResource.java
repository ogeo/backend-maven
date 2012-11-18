/**
 * 
 */
package it.ogeo.rest;

import it.ogeo.model.InfoValue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author micheleorsi
 *
 */
@Path("/map")
@Produces({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
public class MapResource {
	private Logger log = Logger.getLogger(MapResource.class.getName());

	@GET
	public List<InfoValue> getMap() {
		List<InfoValue> listToReturn = new ArrayList<InfoValue>();
//		listToReturn.add(new InfoValue("description", "high", 12.123213, 23.123));
//		listToReturn.add(new InfoValue("description2", "medium", 13.123213, 23.123));
		log.info("get map");
		return listToReturn;
	}
}
