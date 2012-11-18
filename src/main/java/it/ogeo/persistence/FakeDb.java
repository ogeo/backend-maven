/**
 * 
 */
package it.ogeo.persistence;

import it.ogeo.model.Detection;
import it.ogeo.model.Device;
import it.ogeo.model.Maintainable;
import it.ogeo.model.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * @author micheleorsi
 *
 */
public class FakeDb {
	/**
	 * tabella detection
	 */
	public static Map<Integer,Detection> buildingTable = new HashMap<Integer, Detection>();
	public static Integer buildingId = 0;
	
	public static Map<Integer,Detection> streetTable = new HashMap<Integer, Detection>();
	public static Integer streetId = 0;
	
	public static Map<Integer,Detection> networkTable = new HashMap<Integer, Detection>();
	public static Integer networkId = 0;
	/**
	 * tabella persone
	 */
	public static Map<Integer,Person> peopleTable = new HashMap<Integer, Person>();
	public static int personId = 0;
	/**
	 * tabella persone sfollate
	 */
	public static Map<Integer,Person> peopleNeedHostingTable = new HashMap<Integer, Person>();
	public static int peopleNeedHostingId = 0;
	/**
	 * tabella device
	 */
	public static Map<Integer,Device> deviceTab = new HashMap<Integer, Device>();
	public static int deviceId = 0;
	/**
	 * dati accelerometro
	 */
	public static Map<Integer,Maintainable> accelerometroTable = new HashMap<Integer, Maintainable>();
	public static int accelerometroId = 0;
	/**
	 * dati umidita
	 */
	public static Map<Integer,Maintainable> umiditaTable = new HashMap<Integer, Maintainable>();
	public static int umiditaId = 0;
	/**
	 * dati temperatura
	 */
	public static Map<Integer,Maintainable> temperaturaTable = new HashMap<Integer, Maintainable>();
	public static int temperaturaId = 0;
	/**
	 * dati gas
	 */
	public static Map<Integer,Maintainable> gasTable = new HashMap<Integer, Maintainable>();
	public static int gasId = 0;
	/**
	 * dati corrente
	 */
	public static Map<Integer,Maintainable> correnteTable = new HashMap<Integer, Maintainable>();
	public static int correnteId = 0;
	/**
	 * ritorna tabella da nome
	 * @param type
	 * @return
	 */
	public static Map<Integer,Maintainable> getTableFromName(String type) {
		if(type.equals("umidita")) return umiditaTable;
		else if(type.equals("temperatura")) return temperaturaTable;
		else if(type.equals("gas")) return gasTable;
		else if(type.equals("corrente")) return correnteTable;
		else if(type.equals("accelerometro")) return accelerometroTable;
		else return null;
	}
	
	public static Map<Integer,Detection> getTableDetectionFromName(String type) {
		if(type.equals("building")) return buildingTable;
		else if(type.equals("street")) return streetTable;
		else if(type.equals("network")) return networkTable;
		else return null;
	}
	
	public static Integer getIdDetectionFromName(String type) {
		if(type.equals("building")) return buildingId;
		else if(type.equals("street")) return streetId;
		else if(type.equals("network")) return networkId;
		else return null;
	}
	
}
