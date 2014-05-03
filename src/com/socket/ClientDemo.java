package com.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientDemo {
	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 8900);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		String str = in.readLine();
		System.out.println(str);
		out.println("包子");
		out.flush();
		str = in.readLine();
		System.out.println(str);
		socket.close();
	}

}
