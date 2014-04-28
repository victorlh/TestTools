package com.tools;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class IoUtils {

	/**
	 * 读取文件（InputStream）
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static StringBuilder read(String filePathAndName) throws IOException {
		InputStream in = new FileInputStream(filePathAndName);
		byte[] buf = new byte[1024];
		// 如果文件不存在则创建
		File file = new File(filePathAndName);
		// String str = null;
		StringBuilder strb = new StringBuilder();
		if (!file.exists()) {
			file.createNewFile();
		}
		int bytesRead = 0;
		while ((bytesRead = in.read(buf) )!= -1) {
			String str = new String(buf,0, bytesRead);
			strb.append(str);
		}
		in.close();
		return strb;
	}
	
	/**
	 * 带缓冲的读取文件(BufferedInputStream)
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static String readBuffer(String filePathAndName) throws IOException {
		byte[] buffer = new byte[1024];
		// 创建BufferedInputStream 对象
		BufferedInputStream bufferedInput = new BufferedInputStream(
				new FileInputStream(filePathAndName));
		int bytesRead = 0;
		String chunk = null;
		// 从文件中按字节读取内容，到文件尾部时read方法将返回-1
		while ((bytesRead = bufferedInput.read(buffer)) != -1) {
			// 将读取的字节转为字符串对象
			chunk = new String(buffer, 0, bytesRead);
			System.out.print(chunk);
		}
		// 关闭 BufferedInputStream
		if (bufferedInput != null)
			bufferedInput.close();
		return chunk;
	}
	
	public static ArrayList readFile(String filePathAndName) throws Exception{
		File file = new File(filePathAndName);
		ArrayList text = new ArrayList();
		int dex;
		//判断file是否为一个标准文件且文件存在
		if(file.isFile()&&file.exists()){
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
			//顺序读取文件text里的内容并赋值给整型变量b,直到文件结束为止。
			while((dex = read.read())!=-1){
				text.add((char)dex);
				System.out.print((char)dex);
			}
		}else{
			System.out.println("读取文件内容操作出错");
		}
		return text;
	}
	
	/**
	 * BufferedReader读取文件
	 * @param filePathAndName
	 * @return
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 */
	public static String readFileBuffer(String filePathAndName)
			throws Exception {
		String fileContent = "";
		File f = new File(filePathAndName);
		//判断是否为一个文件且存在
		if (f.isFile() && f.exists()) {
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					f), "UTF-8");
			BufferedReader reader = new BufferedReader(read);
			String line;
			while ((line = reader.readLine()) != null) {
				fileContent += line + "\n";
			}
			read.close();
		}else{
			System.out.println("读取文件内容操作出错");
		}
		return fileContent;
	}



	/**
	 * 文件拷贝
	 * 
	 * @param fileName1
	 * @param fileName2
	 * @throws Exception
	 */
	public static void copyFile(String fileName1, String fileName2)
			throws Exception {
		InputStream in = new FileInputStream(fileName1);
		OutputStream out = new FileOutputStream(fileName2);
		byte[] buf = new byte[1024];
		File file1 = new File(fileName1);
		File file2 = new File(fileName2);
		// 判断file1是否存在
		if (!file1.exists()) {
			file1.createNewFile();
		}
		// 判断file2是否存在
		if (!file2.exists()) {
			file2.createNewFile();
		}
		// 拷贝文件
		while (in.read(buf) != -1) {
			out.write(buf);
		}
		in.close();
		out.close();
		System.out.println("done!");
	}

	/**
	 * 追加写文件
	 * 
	 * @param str
	 * @param fileName
	 * @throws IOException
	 */
	public static void appendWrite(String str, String fileName)
			throws IOException {
		File file = new File(fileName);
		// 创意一个可追加的写入数据流
		OutputStream out = new FileOutputStream(file, true);
		byte[] buf = str.getBytes("GBK");
		out.write(buf);
		out.close();
	}

}
