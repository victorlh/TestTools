package com.test;

//单例模式
public class Singleton {
	private static Singleton singleton = null;
	private Singleton(){
		System.out.println("单例模式");
	}
	
	public static Singleton getInstance(){
		if(singleton == null){
		   singleton = new Singleton();
		}
		return singleton;
	}
	
	
	public static void main(String args[]){
		Singleton.getInstance();
	}

}
