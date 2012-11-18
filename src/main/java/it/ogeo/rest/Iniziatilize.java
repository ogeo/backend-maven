/**
 * 
 */
package it.ogeo.rest;

import it.ogeo.model.Detection;
import it.ogeo.model.Device;
import it.ogeo.model.Maintainable;
import it.ogeo.model.Person;
import it.ogeo.persistence.FakeDb;

import java.util.Date;
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
		// crea una persona
		FakeDb.peopleTable.put(FakeDb.personId, new Person(FakeDb.personId, 45.565055, 12.427533, "Marco Bellini", "marco@bellini.it", "3381234567"));
		builder.append("created person "+FakeDb.peopleTable.get(FakeDb.personId)+"<br/>");
		// crea un device associata alla persona
		FakeDb.deviceTab.put(FakeDb.deviceId, new Device(FakeDb.deviceId, 45.565055, 12.427533, FakeDb.personId));
		builder.append("created device "+FakeDb.deviceTab.get(FakeDb.deviceId)+"<br/>");
		FakeDb.personId++;
		FakeDb.deviceId++;

		// crea una persona
		FakeDb.peopleTable.put(FakeDb.personId, new Person(FakeDb.personId, 45.665055, 12.927533, "Marco Bellini", "marco@bellini.it", "3381234567"));
		builder.append("created person "+FakeDb.peopleTable.get(FakeDb.personId)+"<br/>");
		// crea un device associata alla persona
		FakeDb.deviceTab.put(FakeDb.deviceId, new Device(FakeDb.deviceId, 45.665055, 12.927533, FakeDb.personId));
		builder.append("created device "+FakeDb.deviceTab.get(FakeDb.deviceId)+"<br/>");
		FakeDb.personId++;
		FakeDb.deviceId++;

		for(int i=0;i<10;i++) {
			FakeDb.accelerometroTable.put(FakeDb.accelerometroId, new Maintainable(FakeDb.accelerometroId, 45.665055, 12.927533, "accelerometro", (1+i)+","+(2+i)+","+(3+i), new Date(),FakeDb.deviceId));
			FakeDb.accelerometroId++;
			FakeDb.umiditaTable.put(FakeDb.umiditaId, new Maintainable(FakeDb.umiditaId, 45.665055, 12.927533, "umidita", ""+(1+i), new Date(),FakeDb.deviceId));
			FakeDb.umiditaId++;
			FakeDb.gasTable.put(FakeDb.gasId, new Maintainable(FakeDb.gasId, 45.665055, 12.927533, "gas", ""+12+i, new Date(),FakeDb.deviceId));
			FakeDb.gasId++;
			FakeDb.correnteTable.put(FakeDb.correnteId, new Maintainable(FakeDb.correnteId, 45.665055, 12.927533, "corrente", ""+1*i, new Date(),FakeDb.deviceId));
			FakeDb.correnteId++;
			
			FakeDb.buildingTable.put(FakeDb.buildingId, new Detection(FakeDb.buildingId, 45.665055+i, 12.927533+i, "building", ReviewResource.getLevel(""+i),"a description"));
			FakeDb.buildingId++;
			FakeDb.streetTable.put(FakeDb.streetId, new Detection(FakeDb.streetId, 45.665055+i, 12.927533+i, "street", ReviewResource.getLevel(""+i),"a description"));
			FakeDb.streetId++;
			FakeDb.networkTable.put(FakeDb.networkId, new Detection(FakeDb.networkId, 45.665055+i, 12.927533+i, "network", ReviewResource.getLevel(""+i),"a description"));
			FakeDb.networkId++;
		}
		
		return "environment initialized: <br/>"+builder.toString();
	}

}
