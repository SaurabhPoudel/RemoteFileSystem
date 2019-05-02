

package a37445;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface RemoteFS extends Remote{
		List<String> ls() throws RemoteException;
		boolean mkdir(String name) throws RemoteException;
		String cd(String path) throws RemoteException;
		boolean touch(String name)throws RemoteException;
		boolean rm(String name) throws RemoteException;
       
	   boolean exists() throws RemoteException;
       boolean isDirectory() throws RemoteException;
       boolean isFile() throws RemoteException;
}

