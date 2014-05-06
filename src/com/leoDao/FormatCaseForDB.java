package com.leoDao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class FormatCaseForDB {
	private List<LinkedHashMap<String, String>> arrCase;
	private List<IftTestCase> testCase;
	private String url;
	private String httpMethod;
	private int argcount;
	private String cookie;
	private String casesetName;
	private String sheetName;
	
	/**
	 * 构造函数
	 */
	public FormatCaseForDB() {
		this.arrCase = new ArrayList<LinkedHashMap<String, String>>();
		this.testCase = new ArrayList<IftTestCase>();
		this.url = "";
		this.httpMethod = "";
		this.argcount = 0;
		this.cookie = "";
		this.casesetName = "";
		this.sheetName = "";
	}

}
