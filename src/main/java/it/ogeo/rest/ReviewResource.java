/**
 * 
 */
package it.ogeo.rest;

import java.util.logging.Logger;

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
	private Logger log = Logger.getLogger(ReviewResource.class.getName());
	
	@POST
	@Path("/{type}")
	public String receiveReviews(@PathParam("type") String type, Maintainable object) {
		object.setType(type);
		log.info("receive reviews");
		return "thanks for the review type: "+object.getStatus();
	}
}
