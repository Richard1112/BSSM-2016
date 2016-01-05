package com.org.bssm.socket.server;

import java.io.OutputStream;

import com.org.bssm.test.domain.Person; 

public class ThreadWrite implements Runnable {
	private static int HEAD_SIZE = 5;//传输最大字节长度--99999
	private OutputStream os;
	
	public ThreadWrite(OutputStream os) {
		this.os = os;
	}
	
	public void run() {
		try {
			@SuppressWarnings("resource")
			//Scanner scan = new Scanner(System.in);
//			while(true) {
			Person person = new Person();
			person.setAge(12);
			person.setName("test");
			person.setId(1);
				String sendMsg = person.toString();
				sendMsg = getMsg(sendMsg);
				os.write(sendMsg.getBytes());
				os.flush();
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @param msg--组转发送字符串，首五个字符是字符串长度，不够五位，用0补足 
	 * @return 
	 */
	private static String getMsg(String msg) {
		int length = String.valueOf(msg.length()).length();
		String slen = "";
		if(length < HEAD_SIZE) {
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<HEAD_SIZE-length; i++) {
				sb.append("0");
			}
			sb.append(String.valueOf(msg.length()));
			return sb.toString()+msg;
		} else {
			slen = String.valueOf(length);
		}
		return slen+msg;
	}

}
