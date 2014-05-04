package com.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	//
	public static void main(String[] args) throws Exception {
		ServerDemo server = new ServerDemo();
		server.listen(8900);
	}

	public void listen(int port) throws Exception {
		ServerSocket ss = new ServerSocket(port);
		while (true) {
			Socket socket = ss.accept();// 等待客户的请求
			//创建并执行线程 
			new ClientAgent(socket).start();
		}
	}

	//用线程来实现
	class ClientAgent extends Thread {
		Socket socket;

		public ClientAgent(Socket socket) {
			this.socket = socket;
		}
		//线程执行内容
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				out.println("您好, 今天来点啥?");
				out.flush();
				String str = in.readLine();
				if (str.trim().equals("包子")) {
					out.println("这个没有!");
					out.flush();
				}
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}