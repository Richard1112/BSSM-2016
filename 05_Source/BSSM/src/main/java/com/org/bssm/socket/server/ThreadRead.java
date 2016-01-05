package com.org.bssm.socket.server;

import java.io.InputStream;

public class ThreadRead implements Runnable {
	
	private static int HEAD_SIZE = 5;//传输最大字节长度--99999
	private static int BUFFER_SIZE = 10;//每次读取10个字节，循环读取输入流--测试，所以读10个字节
	private InputStream is;
	
	public ThreadRead(InputStream is) {
		this.is = is;
	}

	public void run() {
		try {
			while(true) {
				boolean flag = true;
				int msgLength = 0;
				int recvSize = -HEAD_SIZE;
				byte[] buf = new byte[BUFFER_SIZE];
				StringBuffer sb = new StringBuffer();
				while(msgLength > recvSize) {
					int length = is.read(buf,0,BUFFER_SIZE);
					recvSize += length;
					if(flag) {
						String str = new String(buf,0,HEAD_SIZE);
						msgLength = Integer.parseInt(str);
						sb.append(new String(buf,HEAD_SIZE,length-HEAD_SIZE));
						flag = false;
					} else {
						sb.append(new String(buf,0,length));
					}
				}
				System.out.println(Thread.currentThread().getName() +": "+ sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
