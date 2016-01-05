package com.org.bssm.socket.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port = 9999;
	private ServerSocket server;
	private static Socket socket;
	
	public Server() {
		try {
			init();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void init() throws Exception {
		server = new ServerSocket(port);
		System.out.println("server socket is start, port is: " + port);
		while(true) {
			socket = server.accept();
			handle(socket);
		}
	}
	private void handle(Socket socket) throws Exception {
		String key = socket.getInetAddress().getHostAddress()+":"+socket.getPort();
		System.out.println("accept a socket: " + key);
		Thread thread = new Thread(new ThreadSocket(socket));
		thread.start();
	}
	
	public static void main(String[] args) throws Exception {
		new Server();
	} 
}
