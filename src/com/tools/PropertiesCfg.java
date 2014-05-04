package com.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesCfg {
	private static String FILEPATH = "src/config.properties";
	public static Object readPro(String key) throws Exception{
		File file = new File(FILEPATH);
		Properties cfg = new Properties();
		//以reader方法读文件
//		FileReader reader = new FileReader(file);
//		cfg.load(reader);
		//以InputStreamReader方法读取
		InputStreamReader stream = new InputStreamReader(new FileInputStream(file),"utf-8");
		cfg.load(stream);
		Object value = cfg.get(key);
		return value;
	}

}
