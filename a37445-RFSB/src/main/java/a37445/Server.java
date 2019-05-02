package a37445;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server 
 {
	public static void main(String[] args) throws RemoteException{
		if(System.getSecurityManager()==null) {
			System.setSecurityManager(new SecurityManager());
		}
		String name="RemoteConnection";
		RemoteFSImpl ri=new RemoteFSImpl();
		@SuppressWarnings("unused")
		RemoteFS r=(RemoteFS)UnicastRemoteObject.exportObject(ri, 0);
		Registry registry= LocateRegistry.createRegistry(1099);
		registry.rebind(name, ri);
		System.out.println("Remote bounded and waiting.");
	}

}
