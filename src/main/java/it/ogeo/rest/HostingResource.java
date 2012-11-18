/**
 * 
 */
package it.ogeo.rest;

import it.ogeo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.DELETE;
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
	public List<Person> getPeople() {
		List<Person> listToReturn = new ArrayList<Person>();
//		listToReturn.add(new Person("testName1", "testEmail1", 12.12, 11.11,"3381379567"));
//		listToReturn.add(new Person("testName2", "testEmail2", 12.13, 11.12,"3381379567"));
		log.info("return list of person");
		return listToReturn;
	}

	@POST
	public String askPersonHost(Person person) {
		log.info("ask person host");
		return "you just requested the hosting of a person called "+person.getName();
	}
	
	@DELETE 
	@Path("/{personId}")
	public String personHosted(@PathParam("personId") String personId) {
		log.info("person hosted");
		return "the person "+personId+" has now a host";
	}
}
