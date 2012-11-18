/**
 * 
 */
package it.ogeo.rest;

import it.ogeo.model.Maintainable;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author micheleorsi
 *
 */
@Path("/reviews")
@Produces({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
public class ReviewResource {
	
	@POST
	@Path("/{type}")
	public String receiveReviews(@PathParam("type") String type, Maintainable object) {
		object.setType(type);
		return "thanks for the review type: "+object.getStatus();
	}
}
