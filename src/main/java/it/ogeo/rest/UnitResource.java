/**
 * 
 */
package it.ogeo.rest;

import it.ogeo.model.Device;
import it.ogeo.model.Maintainable;
import it.ogeo.persistence.FakeDb;

import java.util.Collection;
import java.util.Date;
import java.util.Vector;
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
	@Path("/tables/{type}")
	public Collection<Maintainable> returnTypeColl(@PathParam("type") String type)  {
		return FakeDb.getTableFromName(type).values();
	}
	
	@GET
	@Path("/tables/{type}/{personId}")
	public Collection<Maintainable> returnTypeCollPerson(@PathParam("type") String type,@PathParam("personId") int personId)  {
		Collection<Maintainable> returnColl =  new Vector<Maintainable>();
		for (Maintainable maintainable : this.returnTypeColl(type)) {
			if(maintainable.getType().equals(type)) returnColl.add(maintainable);
		}
		return returnColl;
	}
	
	@GET
	@Path("/tables/{type}/{personId}/last")
	public Maintainable returnLastTypeCollPerson(@PathParam("type") String type,@PathParam("personId") int personId)  {
		Collection<Maintainable> returnColl =  new Vector<Maintainable>();
		for (Maintainable maintainable : this.returnTypeColl(type)) {
			if(maintainable.getType().equals(type)) returnColl.add(maintainable);
		}
		return new Vector<Maintainable>(returnColl).get(returnColl.size()-1);
	}
	
	@GET
	@Path("/{unitId}")
	public String receiveParametersFromDevice(@PathParam("unitId") int unitId,
			@QueryParam("accelerometrox") String accelerometrox,
			@QueryParam("accelerometroy") String accelerometroy,
			@QueryParam("accelerometroz") String accelerometroz,
			@QueryParam("umidita") String umidita,
			@QueryParam("temperatura") String temperatura,
			@QueryParam("gas") String gas,
			@QueryParam("corrente") String corrente) {
		log.info("thanks for your request: "+unitId+
				", accelerometrox: "+accelerometrox+
				", accelerometroy: "+accelerometroy+
				", accelerometroz: "+accelerometroz+
				", umidita: "+umidita+
				", temperatura: "+temperatura+
				", gas: "+gas+
				", corrente: "+corrente);
		
		Device dev = FakeDb.deviceTab.get(unitId);
		FakeDb.accelerometroTable.put(FakeDb.accelerometroId, new Maintainable(FakeDb.accelerometroId, dev.getLatitude(), dev.getLongitude(), "accelerometro", accelerometrox+","+accelerometroy+","+accelerometroz, new Date(),unitId));
		FakeDb.accelerometroId++;
		FakeDb.umiditaTable.put(FakeDb.umiditaId, new Maintainable(FakeDb.umiditaId, dev.getLatitude(), dev.getLongitude(), "umidita", umidita, new Date(),unitId));
		FakeDb.umiditaId++;
		FakeDb.temperaturaTable.put(FakeDb.temperaturaId, new Maintainable(FakeDb.temperaturaId, dev.getLatitude(), dev.getLongitude(), "temperatura", temperatura, new Date(),unitId));
		FakeDb.temperaturaId++;
		FakeDb.gasTable.put(FakeDb.gasId, new Maintainable(FakeDb.gasId, dev.getLatitude(), dev.getLongitude(), "gas", gas, new Date(),unitId));
		FakeDb.gasId++;
		FakeDb.correnteTable.put(FakeDb.correnteId, new Maintainable(FakeDb.correnteId, dev.getLatitude(), dev.getLongitude(), "corrente", corrente, new Date(),unitId));
		FakeDb.correnteId++;
		
		return "thanks for your request: "+unitId+
				", accelerometrox: "+accelerometrox+
				", accelerometroy: "+accelerometroy+
				", accelerometroz: "+accelerometroz+
				", umidita: "+umidita+
				", temperatura: "+temperatura+
				", gas: "+gas+
				", corrente: "+corrente;
	}

}
