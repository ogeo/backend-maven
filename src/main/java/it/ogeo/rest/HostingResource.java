/**
 * 
 */
package it.ogeo.rest;

import it.ogeo.model.Person;
import it.ogeo.persistence.FakeDb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author micheleorsi
 *
 */
@Path("/hosting/people")
@Produces({ MediaType.APPLICATION_JSON+"; charset=utf-8" })
public class HostingResource {
	
	private Logger log = Logger.getLogger(HostingResource.class.getName());
	
	@GET
	public Collection<Person> getPeople() {
		Collection<Person> listToReturn = FakeDb.peopleNeedHostingTable.values();
		return listToReturn;
	}

	@POST
	@Consumes({ "application/x-www-form-urlencoded; charset=utf-8" })
	public String askPersonHost(@FormParam("cellNumber") String cellNumber,
			@FormParam("email") String email,
			@FormParam("latitude") Double latitude,
			@FormParam("longitude") Double longitude,
			@FormParam("name") String name) {
		log.info("ask person host");
//		person.setId(FakeDb.personId);
//		FakeDb.peopleTable.put(FakeDb.personId, person);
//		FakeDb.peopleNeedHostingTable.put(FakeDb.personId, person);
//		FakeDb.personId++;
		return "you just requested the hosting of a person called "+name;
	}
	
	@DELETE 
	@Path("/{personId}")
	public String personHosted(@PathParam("personId") int personId) {
		log.info("removed person hosted");
		FakeDb.peopleNeedHostingTable.remove(personId);
		return "the person "+personId+" has now a host";
	}
}
