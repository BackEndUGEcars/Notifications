package fr.uge.webservices;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class App {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(7780);
			INotifications n = new Notifications();
			Naming.bind("rmi://localhost:7780/Notifications", n);
            System.out.println("Notifications RMI loaded");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
