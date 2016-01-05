package com.org.bssm.socket.server;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {
	private String ip = "127.0.0.1";  
    private int port = 9999;  
    private static Socket socket;  
      
      
    public Client() {  
        try {  
            init();  
        } catch(Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    private void init() throws Exception {  
        System.out.println("init the socket client");  
        socket = new Socket();  
        socket.setSoTimeout(0);  
        SocketAddress addr = new InetSocketAddress(ip, port);  
        socket.connect(addr);  
    }  
    public void handle() throws Exception{  
        Thread threadRead = new Thread(new ThreadRead(socket.getInputStream()),"SERVER_"+socket.getPort());  
        Thread threadwrite = new Thread(new ThreadWrite(socket.getOutputStream()));  
        threadRead.start();  
        threadwrite.start();  
    }  
      
      
    public static void main(String[] args) throws Exception {  
        Client client = new Client();  
        client.handle();  
    }  
}
