/**
 * 
 */
package it.ogeo.rest;

import it.ogeo.model.Device;
import it.ogeo.model.Maintainable;
import it.ogeo.model.Person;
import it.ogeo.persistence.FakeDb;

import java.io.IOException;
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
			@QueryParam("corrente") String corrente) throws IOException {
		log.info("thanks for your request: "+unitId+
				", accelerometrox: "+accelerometrox+
				", accelerometroy: "+accelerometroy+
				", accelerometroz: "+accelerometroz+
				", umidita: "+umidita+
				", temperatura: "+temperatura+
				", gas: "+gas+
				", corrente: "+corrente);
		
		// 10 in total
		Device dev = FakeDb.deviceTab.get(unitId);
//		int oldAccelerometroId = FakeDb.accelerometroId-1;
		FakeDb.accelerometroTable.put(FakeDb.accelerometroId, new Maintainable(FakeDb.accelerometroId, dev.getLatitude(), dev.getLongitude(), "accelerometro", accelerometrox+","+accelerometroy+","+accelerometroz, new Date(),unitId));
//		Maintainable oldMaint = FakeDb.accelerometroTable.get(oldAccelerometroId);
//		String[] results = oldMaint.getStatus().split(",");
//		int oldX = Integer.parseInt(results[0]);
//		int oldY = Integer.parseInt(results[1]);
//		int oldZ = Integer.parseInt(results[2]);
//		if((oldX-Integer.parseInt(accelerometrox)) + (oldY - Integer.parseInt(accelerometroy)) + (oldZ - Integer.parseInt(accelerometroz)) > 10) {
//			Person p = FakeDb.peopleTable.get(dev.getUserId());
//			SmsGateway.sendSms(p.getCellNumber(), "accelerometro", p.getName());
//		}
		FakeDb.accelerometroId++;
		
		// 10
		int oldUmiditaId = FakeDb.umiditaId-1;
		FakeDb.umiditaTable.put(FakeDb.umiditaId, new Maintainable(FakeDb.umiditaId, dev.getLatitude(), dev.getLongitude(), "umidita", umidita, new Date(),unitId));
//		Maintainable oldUmid = FakeDb.umiditaTable.get(oldUmiditaId);
//		if((Integer.parseInt(oldUmid.getStatus())-Integer.parseInt(umidita))>10) {
//			Person p = FakeDb.peopleTable.get(dev.getUserId());
//			SmsGateway.sendSms(p.getCellNumber(), "umidita", p.getName());
//		}
		FakeDb.umiditaId++;
		
		// 10
		int temperaturaOldId = FakeDb.temperaturaId-1;
		FakeDb.temperaturaTable.put(FakeDb.temperaturaId, new Maintainable(FakeDb.temperaturaId, dev.getLatitude(), dev.getLongitude(), "temperatura", temperatura, new Date(),unitId));
//		Maintainable oldTemp = FakeDb.temperaturaTable.get(temperaturaOldId);
//		if((Integer.parseInt(oldTemp.getStatus())-Integer.parseInt(temperatura))>10) {
//			Person p = FakeDb.peopleTable.get(dev.getUserId());
//			SmsGateway.sendSms(p.getCellNumber(), "temperatura", p.getName());
//		}
		FakeDb.temperaturaId++;
		
		// 10
		int gasOldId = FakeDb.gasId-1;
		FakeDb.gasTable.put(FakeDb.gasId, new Maintainable(FakeDb.gasId, dev.getLatitude(), dev.getLongitude(), "gas", gas, new Date(),unitId));
//		Maintainable oldGas = FakeDb.gasTable.get(gasOldId);
//		if((Integer.parseInt(oldGas.getStatus())-Integer.parseInt(gas))>10) {
//			Person p = FakeDb.peopleTable.get(dev.getUserId());
//			SmsGateway.sendSms(p.getCellNumber(), "gas", p.getName());
//		}
		FakeDb.gasId++;
		
		// 10
		int correnteOldId = FakeDb.correnteId-1;
		FakeDb.correnteTable.put(FakeDb.correnteId, new Maintainable(FakeDb.correnteId, dev.getLatitude(), dev.getLongitude(), "corrente", corrente, new Date(),unitId));
//		Maintainable oldCorrente = FakeDb.correnteTable.get(correnteOldId);
//		if((Integer.parseInt(oldCorrente.getStatus())-Integer.parseInt(corrente))>10) {
//			Person p = FakeDb.peopleTable.get(dev.getUserId());
//			SmsGateway.sendSms(p.getCellNumber(), "corrente", p.getName());
//		}
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
