package fr.uge.webservices;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Allow to manage Notifications
 *
 */
public class Notifications extends UnicastRemoteObject implements INotifications {
	
	/**
	 * Notifications constructor
	 * @throws RemoteException
	 */
	public Notifications() throws RemoteException {
	}

	private final Map<Long, Map<Long, String>> notifications = new HashMap<Long,  Map<Long, String>>();
	
	/**
     * Add notifications to an employee
     * @param employeeID, the employee id
     * @param carID, the car id
     * @param imagePath, the image path
     * @param notif, the notification
     */
	public void addNotification(Long employeeID, Long carID, String imagePath, String notif) throws RemoteException{
		if(notifications.get(employeeID) == null) {
			Map<Long, String> na = new  HashMap<Long, String>();
			notifications.put(employeeID, na);
		}
		notifications.get(employeeID).put(carID, "{\"carID\":" + carID + ", \"imagePath\":\"" + imagePath + "\", \"notification\":\"" + notif + "\"}");
	}
	
	/**
     * Remove notification to an employee
     * @param employeeId, the employee id
     * @param carId, the car id
     */
	public void removeNotifications(Long employeeId, Long carId) throws RemoteException{
		notifications.get(employeeId).remove(carId);
	}
	
	/**
	 * Get notifications of an employee
	 * @param id, the employee id
	 * @return List<String> the notifications list of an employee 
	 */
	public List<String> getNotifications(Long id) throws RemoteException{
		List<String> l = new ArrayList<String>();
		for (String s : notifications.get(id).values()) {
			l.add(s);
		}
		return l;
	}
}
