package fr.uge.webservices;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notifications extends UnicastRemoteObject implements INotifications {
	public Notifications() throws RemoteException {
	}

	private final Map<Long, List<String>> notifications = new HashMap<Long, List<String>>();
	
	public void addNotification(Long id, String notif) throws RemoteException{
		if(notifications.get(id) == null) {
			ArrayList<String> na = new ArrayList<String>();
			na.add(notif);
			notifications.put(id, na);
		}
		notifications.get(id).add("{    'notifications':" + notif + "}");
	}
	
	public List<String> getNotifications(Long id) throws RemoteException{
		List<String> res = notifications.get(id);
		notifications.put(id, new ArrayList<String>());
		return res;
	}

}
