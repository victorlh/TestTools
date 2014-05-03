package com.socket;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class FtpClient {
	Socket socket;
	OutputStream out;
	InputStream in;

	public static void main(String[] args) throws Exception {
		FtpClient client = new FtpClient();
		client.open("localhost", 8800);
	}

	public void open(String host, int port) throws Exception {
		socket = new Socket(host, port);
		in = socket.getInputStream();
		out = socket.getOutputStream();
		// 向服务端发送请求
		new RequestSender(out).start();
		// 接收请求
		new ResponseReceiver(in).start();
	}

	class RequestSender extends Thread {
		OutputStream out;

		public RequestSender(OutputStream out) {
			this.out = out;
		}

		public void run() {
			PrintWriter out = new PrintWriter(this.out, true);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			String str;
			try {
				while ((str = in.readLine()) != null) {
					out.println(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class ResponseReceiver extends Thread {
		InputStream in;

		public ResponseReceiver(InputStream in) {
			this.in = in;
		}

		public void run() {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					this.in));
			try {
				String str;
				while ((str = in.readLine()) != null) {
					if (str.startsWith("text")) {
						String num = str.substring(str.indexOf(",") + 1);
						printText(in, Integer.parseInt(num));
					} else if (str.startsWith("file")) {// file,4567,filename
						saveFile(this.in, str);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private void saveFile(InputStream in, String head) throws IOException {
			String[] data = head.split(",");
			int length = Integer.parseInt(data[1]);
			String name = data[2];
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream("ftp-" + name));
			for (int i = 0; i < length; i++) {
				int b = in.read();
				out.write(b);
			}
			out.close();
			System.out.println("下载了文件:" + name);
		}

		private void printText(BufferedReader in, int num) throws IOException {
			for (int i = 0; i < num; i++) {
				System.out.println(in.readLine());
			}
		}

	}

}
