package com.example.adilservice05;

import java.io.FileDescriptor;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class ADILService extends Service {
	private String[] names=new String[]{"老男孩","春天里","在路上"};
	private String[] authors=new String[]{"筷子兄弟","汪峰","刘欢"};
	private String name,author;
	private IBinder songBinder;
	private Timer timer=new Timer();
	public class SongBinder implements IBinder	{		
		public String getName() throws RemoteException {			
			return name;
		}
		public String getAuthor() throws RemoteException {			
			return author;
		}
		@Override
		public void dump(FileDescriptor fd, String[] args)
				throws RemoteException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void dumpAsync(FileDescriptor fd, String[] args)
				throws RemoteException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public String getInterfaceDescriptor() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean isBinderAlive() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void linkToDeath(DeathRecipient recipient, int flags)
				throws RemoteException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean pingBinder() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public IInterface queryLocalInterface(String descriptor) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean transact(int code, Parcel data, Parcel reply, int flags)
				throws RemoteException {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
			// TODO Auto-generated method stub
			return false;
		}		
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return songBinder;
	}
   
	public void onCreate() {		
		songBinder=new SongBinder();
		timer.schedule(new TimerTask() {			
			public void run() {
				int rand=(int)(Math.random()*3);
				name=names[rand];
				author=authors[rand];
				System.out.println(rand);
			}
		}, 0,1000);
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		timer.cancel();
	}
}
