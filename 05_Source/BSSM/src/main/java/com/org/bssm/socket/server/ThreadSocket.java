package com.org.bssm.socket.server;

import java.net.Socket;

public class ThreadSocket implements Runnable {
	private Socket socket;
	
	public ThreadSocket(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			Thread threadRead = new Thread(new ThreadRead(socket.getInputStream()),"CLIENT_"+socket.getPort());
			Thread threadwrite = new Thread(new ThreadWrite(socket.getOutputStream()));
			threadRead.start();
			threadwrite.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
