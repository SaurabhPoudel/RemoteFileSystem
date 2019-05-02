package a37445;

import java.rmi.NotBoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;


public class Client {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		
		String name = "RemoteConnection";

		Registry registry = LocateRegistry.getRegistry("localhost");
		
		RemoteFS ri = (RemoteFS) registry.lookup(name);
		//String s=" ";
		System.out.println("YOUR COMMAND LINE INTERFACE IS ENABLED:");
		System.out.println("TYPE ls TO list,cd <name of dir/file> TO ENTER TO A FILE OR A DIRECTORY,mkdir<name of dir> TO MAKE A DIRECTORY,touch <name of file> TO MAKE A FILE AND rm<name of file> TO REMOVE!\nHAPPY CODING!!");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				
			for (String s=br.readLine(); s!= null; s = br.readLine()) {
				String[] strs = s.trim().split(" ");
				switch (strs[0]) {
				case "ls":
					
					List<String> fileList = ri.ls();
				int	n=fileList.size();
				for(String fi : fileList) {
				System.out.println(fi);
				}
				System.out.println("This directory contains "+n+" files");
				break;
				case "mkdir":
					if(strs.length<2) {
					System.out.println("Invalid command");}
					else {
						boolean succ = ri.mkdir(strs[1]);
					  if(succ==false) {
					  System.out.println("couldn't create dir");
							  }
					//System.out.println(m);
					break;
					}
				case "cd":
					if(strs.length<2) {
						System.out.println("Invalid command");
					
					}
						else 
						{
							String newPath=ri.cd(strs[1]);
							System.out.println("The new path is "+newPath+" ");
							if(ri.isDirectory()) {
							System.out.println("This is a directory");
							}
							if(ri.isFile()) {
							System.out.println("This is a file");
							}
					    }
					break;
				
				case "touch":
					if(strs.length<2) {
						System.out.println("Invalid command");
					}
					else {
						boolean succ= ri.touch(strs[1]);
						if(succ==false) {
							System.out.print("Couldn´t create file");
					}
					
						break;
					}
				case "rm":
					if(strs.length<2) {
						System.out.println("Invalid command");
					}
					else {
						boolean succ= ri.rm(strs[1]);
						if(succ==false) {
							System.out.print("Couldn´t delete the file");
					}
						break;
					}
			
				case"exit":
					break;
					
				default:
					break;
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}



