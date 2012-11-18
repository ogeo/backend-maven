/**
 * 
 */
package it.ogeo.rest;

import it.ogeo.model.Device;
import it.ogeo.model.Person;
import it.ogeo.persistence.FakeDb;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author micheleorsi
 *
 */
@Path("/init")
public class Iniziatilize {
	private Logger log = Logger.getLogger(Iniziatilize.class.getName());
	
	@GET
	public String init() {
		log.info("start init environment");
		StringBuilder builder = new StringBuilder();
		FakeDb.peopleTable.put(FakeDb.personId, new Person(FakeDb.personId, 45.565055, 12.427533, "Marco Bellini", "marco@bellini.it", "3381234567"));
		builder.append("created person "+FakeDb.peopleTable.get(FakeDb.personId)+"<br/>");
		FakeDb.deviceTab.put(FakeDb.deviceId, new Device(FakeDb.deviceId, 45.565055, 12.427533, FakeDb.personId));
		builder.append("created device "+FakeDb.deviceTab.get(FakeDb.deviceId)+"<br/>");
		FakeDb.personId++;
		FakeDb.deviceId++;
		
		return "environment initialized: <br/>"+builder.toString();
	}

}
