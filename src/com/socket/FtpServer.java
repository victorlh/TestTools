package com.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FtpServer {
	public static void main(String[] args) throws Exception {
		FtpServer server = new FtpServer();
		server.listen(8800);
	}

	//创建socket服务端
	public void listen(int port) throws Exception {
		ServerSocket ss = new ServerSocket(port);
		while (true) {
			System.out.println("等待客户端连接...");
			Socket socket = ss.accept();
			System.out.println("客户连接进来了.");
			new ClientAgent(socket).start();
		}
	}

	//线程处理
	class ClientAgent extends Thread {
		Socket socket;
		InputStream in;
		OutputStream out;

		public ClientAgent(Socket socket) throws IOException {
			this.socket = socket;
			in = socket.getInputStream();
			out = socket.getOutputStream();
		}

		@Override
		public void run() {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					this.in));
			PrintWriter out = new PrintWriter(this.out, true);
			try {
				out.println("text,1");
				out.println("你好欢迎使用FTP Demo!");
				while (true) {
					String cmd = in.readLine();
					if ("?".equals(cmd)) {
						out.println("text,1");
						out.println("支持命令: ls, get, ?, bye");
					} else if ("ls".equals(cmd)) {
						listDir(out);
					} else if (cmd.matches("^get\\s+.+")) {
						sendFile(cmd, out, this.out);
					} else {
						out.println("text,1");
						out.println("不知可否!");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//将服务端的文件发送到客户端
		private void sendFile(String cmd, PrintWriter out, OutputStream os)
				throws IOException {
			String name = cmd.split("\\s+")[1];
			File file = new File(name);
			if (!file.exists()) {
				out.println("text,1");
				out.println("没有找到文件!" + name);
				return;
			}
			out.println("file," + file.length() + "," + name);
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			int b;
			while ((b = in.read()) != -1) {
				os.write(b);
			}
			os.flush();
			in.close();
		}

		//获取目录下的文件列表
		private void listDir(PrintWriter out) {
			File dir = new File(".");
			File[] files = dir.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					return pathname.isFile();
				}
			});
			out.println("text," + (files.length + 1));
			out.println("在目录:" + dir + "中, 有文件:" + files.length);
			for (File file : files) {
				out.println(file.getName());
			}
		}
	}

}
