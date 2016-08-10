package com.hisuntech.ArchOnlineSchoolBack.test.socket.client;

import java.io.*;
import java.net.*;

/**
 * UDP客户端程序，用于对服务端发送数据，并接收服务端的回应信息
 */
public class UdpClientSocket {
	
	private byte[] buffer = new byte[1024];
	
	private static DatagramSocket ds = null;
	
	/**
	 * 测试客户端发包和接收回应信息的方法
	 */
	public static void main(String[] args) throws Exception {
		UdpClientSocket client = new UdpClientSocket();
		String serverHost = "192.168.1.126";
		int serverPort = 3344;
		client.send(serverHost, serverPort, ("getAllMessageList").getBytes());
		byte[] bt = client.receive();
		System.out.println("服务端回应数据：" + new String(bt));
		// 关闭连接
		try {
			ds.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 构造函数，创建UDP客户端
	 */
	public UdpClientSocket() throws Exception {
		ds = new DatagramSocket(8899); // 邦定本地端口作为客户端
	}
	
	/**
	 * 向指定的服务端发送数据信息
	 */
	public final void send(final String host, final int port,
			final byte[] bytes) throws IOException {
		DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(host), port);
		ds.send(dp);
	}

	/**
	 * 接收从指定的服务端发回的数据
	 */
	public final byte[] receive()
			throws Exception {
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
		ds.receive(dp);		
		byte[] data = new byte[dp.getLength()];
		System.arraycopy(dp.getData(), 0, data, 0, dp.getLength());		
		return data;
	}
}
