package a37445;

import java.io.File;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;


public class RemoteFSImpl implements RemoteFS
{
	String path=System.getProperty("user.home");

	public List<String> ls() throws RemoteException 
	{
		return Arrays.asList(new File(this.path).list());
	
	}

	@Override
	public boolean mkdir(String name) throws RemoteException{
		// TODO Auto-generated method stub
		File f;
		f=new File(this.path+ File.separator+name);
		return	(f.mkdir());
}
	public String cd(String path) throws RemoteException {
		// TODO Auto-generated method stub
		Path currPath= Paths.get(this.path);
		Path destPath= Paths.get(path);
		if(destPath.isAbsolute()) 
		{
		 currPath=destPath;
		}
		else {
			currPath=currPath.resolve(destPath).normalize();
			 }
		this.path=currPath.toString();
		return this.path;
	}

	@Override
	public boolean touch(String name) throws RemoteException {
		// TODO Auto-generated method stub
		File f;
		f=new File(this.path+File.separator+name);
		try {
			return(f.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean rm(String name) throws RemoteException{
		File f;
		f=new File(this.path+File.separator+name);
		return f.delete();
		
	}

	@Override
	public boolean exists() throws RemoteException {
		// TODO Auto-generated method stub
		File f;
		f=new File(this.path);
		return f.exists();
		
	}
	@Override
	public boolean isDirectory() throws RemoteException {
		// TODO Auto-generated method stub
		File f;
		f=new File(this.path);
		 
		return f.isDirectory();
	
	}
	public boolean isFile() throws RemoteException {
		// TODO Auto-generated method stub
	
		File f;
		f=new File(this.path);
		return f.isFile();
	}


	

}

