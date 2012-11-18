/**
 * 
 */
package it.ogeo.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author micheleorsi
 *
 */
@Path("/reviews")
public class ReviewResource {
	
	@POST
	@Path("/{type}")
	public String receiveReviews(@PathParam("type") String type) {
		return "thanks for the review type: "+type;
	}
}
