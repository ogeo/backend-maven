/**
 * 
 */
package it.ogeo.persistence;

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
	
	public static Map<Integer,Person> peopleTable = new HashMap<Integer, Person>();
	public static int personId = 0;
	
	public static Map<Integer,Person> peopleNeedHostingTable = new HashMap<Integer, Person>();
	public static int peopleNeedHostingId = 0;
	
	public static Map<Integer,Device> deviceTab = new HashMap<Integer, Device>();
	public static int deviceId = 0;
	
	public static Map<Integer,Maintainable> accelerometroTable = new HashMap<Integer, Maintainable>();
	public static int accelerometroId = 0;
	
	public static Map<Integer,Maintainable> umiditaTable = new HashMap<Integer, Maintainable>();
	public static int umiditaId = 0;
	
	public static Map<Integer,Maintainable> temperaturaTable = new HashMap<Integer, Maintainable>();
	public static int temperaturaId = 0;
	
	public static Map<Integer,Maintainable> gasTable = new HashMap<Integer, Maintainable>();
	public static int gasId = 0;
	
	public static Map<Integer,Maintainable> correnteTable = new HashMap<Integer, Maintainable>();
	public static int correnteId = 0;
	
	public static Map<Integer,Maintainable> getTableFromName(String type) {
		if(type.equals("umidita")) return umiditaTable;
		else if(type.equals("temperatura")) return temperaturaTable;
		else if(type.equals("gas")) return gasTable;
		else if(type.equals("corrente")) return correnteTable;
		else return null;
	}
	
}
