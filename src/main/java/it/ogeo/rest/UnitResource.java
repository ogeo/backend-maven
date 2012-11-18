/**
 * 
 */
package it.ogeo.rest;

import it.ogeo.model.Device;
import it.ogeo.model.Maintainable;
import it.ogeo.persistence.FakeDb;

import java.util.Collection;
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
	@Path("/umidita")
	public Collection<Maintainable> returnUmidita()  {
		return FakeDb.umiditaTable.values();
	}
	
	@GET
	@Path("/temperatura")
	public Collection<Maintainable> returnTemperatura()  {
		return FakeDb.temperaturaTable.values();
	}
	
	@GET
	@Path("/gas")
	public Collection<Maintainable> returnGas()  {
		return FakeDb.gasTable.values();
	}
	
	@GET
	@Path("/corrente")
	public Collection<Maintainable> returnCorrente()  {
		return FakeDb.correnteTable.values();
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
		FakeDb.maintainableTable.put(FakeDb.maintainableId, new Maintainable(FakeDb.maintainableId, dev.getLatitude(), dev.getLongitude(), "accelerometrox", accelerometrox));
		FakeDb.maintainableId++;
		FakeDb.maintainableTable.put(FakeDb.maintainableId, new Maintainable(FakeDb.maintainableId, dev.getLatitude(), dev.getLongitude(), "accelerometroy", accelerometroy));
		FakeDb.maintainableId++;
		FakeDb.maintainableTable.put(FakeDb.maintainableId, new Maintainable(FakeDb.maintainableId, dev.getLatitude(), dev.getLongitude(), "accelerometroz", accelerometroz));
		FakeDb.maintainableId++;
		FakeDb.umiditaTable.put(FakeDb.umiditaId, new Maintainable(FakeDb.umiditaId, dev.getLatitude(), dev.getLongitude(), "umidita", accelerometroz));
		FakeDb.umiditaId++;
		FakeDb.temperaturaTable.put(FakeDb.temperaturaId, new Maintainable(FakeDb.temperaturaId, dev.getLatitude(), dev.getLongitude(), "temperatura", temperatura));
		FakeDb.temperaturaId++;
		FakeDb.gasTable.put(FakeDb.gasId, new Maintainable(FakeDb.gasId, dev.getLatitude(), dev.getLongitude(), "gas", gas));
		FakeDb.gasId++;
		FakeDb.correnteTable.put(FakeDb.correnteId, new Maintainable(FakeDb.correnteId, dev.getLatitude(), dev.getLongitude(), "corrente", corrente));
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
