/**
 * 
 */
package it.ogeo.rest;

import java.util.Collection;
import java.util.logging.Logger;

import it.ogeo.model.Detection;
import it.ogeo.persistence.FakeDb;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author micheleorsi
 *
 */
@Path("/reviews")
@Produces({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
@Consumes({ "application/x-www-form-urlencoded; charset=utf-8" })
public class ReviewResource {
	private Logger log = Logger.getLogger(ReviewResource.class.getName());
	
	@POST
	@Path("/building")
	public String receiveBuildingReviews( 
			@FormParam("status") String status,
			@FormParam("latitude") Double latitude,
			@FormParam("longitude") Double longitude) {
		Detection detection = new Detection(FakeDb.buildingId, latitude, longitude, "building", status);
		FakeDb.buildingTable.put(FakeDb.buildingId, detection);
		FakeDb.buildingId++;
		log.info("receive building reviews");
		return "thanks for the review type building with value: "+status;
	}
	
	@GET
	@Path("/building")
	public Collection<Detection> getBuildingReviews() {
		return FakeDb.buildingTable.values();
	}
	
	@GET
	@Path("/street")
	public Collection<Detection> getStreetReviews() {
		return FakeDb.streetTable.values();
	}
	
	@GET
	@Path("/network")
	public Collection<Detection> getNetworkReviews() {
		return FakeDb.networkTable.values();
	}
	
	@POST
	@Path("/street")
	public String receivestreetReviews( 
			@FormParam("status") String status,
			@FormParam("latitude") Double latitude,
			@FormParam("longitude") Double longitude) {
		Detection detection = new Detection(FakeDb.streetId, latitude, longitude, "street", status);
		FakeDb.streetTable.put(FakeDb.streetId, detection);
		FakeDb.streetId++;
		log.info("receive street reviews");
		return "thanks for the review type street with value: "+status;
	}
	
	@POST
	@Path("/network")
	public String receivenetworkReviews( 
			@FormParam("status") String status,
			@FormParam("latitude") Double latitude,
			@FormParam("longitude") Double longitude) {
		Detection detection = new Detection(FakeDb.networkId, latitude, longitude, "network", status);
		FakeDb.networkTable.put(FakeDb.networkId, detection);
		FakeDb.networkId++;
		log.info("receive network reviews");
		return "thanks for the review type network with value: "+status;
	}
}
