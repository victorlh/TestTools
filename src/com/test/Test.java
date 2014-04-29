package com.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import com.tools.IoUtils;

public class Test extends LightTest {

	public static void main(String args[]){	
//		Test.collection();
		String src = "src/test.txt";
		String dest = "src/desc.txt";
		Test test = new Test();
			try {
//				test.copyFile(src, dest);
//				IoUtils.read(src);
//				IoUtils.copyFile(src, dest);
//				IoUtils.readFromFile(src);
				ArrayList arry = IoUtils.readFile(src);
				for(int i=0;i<arry.size();i++){
					System.out.print(arry.get(i));
				}
				
				System.out.println("_____________1");
//				System.out.println(IoUtils.read(src));
//				IoUtils.appendWrite("测试lhlhlhlh", dest);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	

	public static void collection(){
		List list = new Vector();
		list.add('a');
		list.add(1);
		list.add('b');
		System.out.println(list);
		Iterator itList = list.iterator();
		while(itList.hasNext()){
			Object result = itList.next();
			System.out.println(result.toString());
		}
		System.out.println("-------------------------------------------");
		Set set = new TreeSet();
		set.add(1);
		set.add(3);
		set.add(1);
		System.out.println(set);
		Iterator iterSet = set.iterator();
		while(iterSet.hasNext()){
			Object resut = iterSet.next();
			System.out.println(resut.toString());
		}
		System.out.println("--------------------------------------");
		
		Map map = new TreeMap();
		map.put('a', 1);
		map.put('c', 3);
		map.put('b', 2);
		System.out.println(map);
		Set mapToSet = map.entrySet();
		Iterator iterMap = mapToSet.iterator();
		while(iterMap.hasNext()){
			 Map.Entry result = (Entry) iterMap.next();
			 Object key = result.getKey();
			 Object value = result.getValue();
			 System.out.println(key+" "+value);
		}
		
		System.out.println("------------------------------------");
		Set mapkeyToSet = map.keySet();
		Iterator iterKey = mapkeyToSet.iterator();
		while(iterKey.hasNext()){
			Object key = iterKey.next();
			Object value = map.get(key);
			System.out.println(key+" "+value);
		}
	}
	

	class MyFilter implements FileFilter{
	     public boolean accept(File pathname){
	          System.out.println(pathname.getName());
	          return false;
	     }
	}

	public static Map hashMapSort(Map map){
		Object[] mapToAry =  map.keySet().toArray();
		Arrays.sort(mapToAry);
		Map mapResult = new HashMap();
		for(int i=0;i<map.size();i++){
			Object key = mapToAry[i];
			mapResult.put(key, map.get(key));
		}
		return mapResult;
	}
	
	public static Map count(String str){
		Map map = new HashMap();
		for(int i=0;i<str.length();i++){
			char index = str.charAt(i);
			if(map.containsKey(index)){
				int val = (int) map.get(index)+1;
				map.put(index,val);
			}else{
				map.put(index, 1);
			}
		}
		return map;
		
	}
	
	static void col(){
		Collection colo = new ArrayList();
		ArrayList colt = new ArrayList();
		colo.add("test");
		colo.add("test");
//		System.out.println(colo.get());
		System.out.println(colt.get(1));
		colt.iterator();
		HashMap t = new HashMap();
	}
	
	public static String[] creatRandom(int n){
		String[] result = new String[n];
		String[] ary = new String[]{"00","01","02","03","04","05","06","07","08","09","10"};
		boolean[] use = new boolean[ary.length];
		Random r = new Random();
		int num =0;
		while(num<n){
			int i = r.nextInt(ary.length);
			if(use[i]==false){
				result[num]=ary[i];
				use[i]=true;
				num++;
			}
		}
		
		return result;
		
	}
	
	public static int[] creatR(int min,int max,int num){
		if(min>=max||num>(max-min)){
			return null;
		}
		int[] result = new int[num];
		//生成num个随机数
		int count =0;
		while(count<num){
			boolean flag =true;
			int num2 = (int) (Math.random()*(max-min))+min;//生成一个（min到max）范围内的随机数
			for(int i=0;i<result.length;i++){
				if(result[i]==num2){
					flag =false;
					break;
				}
			}
			if(flag){
//				System.out.println(count);
				result[count] = num2;
				count++;
			}
		}
	
		return result;
	}
	
	 /**
		 * 随机指定范围内N个不重复的数
		 * 最简单最基本的方法
		 * @param min 指定范围最小值
		 * @param max 指定范围最大值
		 * @param n 随机数个数
		 */
		public static int[] randomCommon(int min, int max, int n){
			if (n > (max - min + 1) || max < min) {
	            return null;
	        }
			int[] result = new int[n];
			int count = 0;
			while(count < n) {
				int num = (int) (Math.random() * (max - min)) + min;//生成一个（min到max）范围内的随机数
				System.out.println("--"+num);
				boolean flag = true;
				for (int j = 0; j < n; j++) {
					if(num == result[j]){
						flag = false;
						break;
					}
				}
				if(flag){
					result[count] = num;
					count++;
				}
			}
			return result;
		}

	public static int[] randoms() {
		Random r = new Random();

		int temp1, temp2;
		int send[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
				16, 17, 18, 19, 20, 21 };
		int len = send.length;
		int returnValue[] = new int[22];
		for (int i = 0; i < 22; i++) {
//			temp1 = Math.abs(r.nextInt()) % len;
			temp1 = r.nextInt(21);
			System.out.println("----"+temp1);
			returnValue[i] = send[temp1];
			temp2 = send[temp1];
			send[temp1] = send[len - 1];
			send[len - 1] = temp2;
			len--;
		}
		return returnValue;
	}

	// 抽n个号码
	public static String[] creatRand(String[] args, int i) {
		Random r = new Random();
		String[] ary2 = new String[i];
		boolean[] ary3 = new boolean[args.length];
		int ran = 0;
		for (int j = 0; j < i; j++) {
			do {
				ran = r.nextInt(args.length);
			} while (ary3[j]);
			ary3[j] = true;
			ary2[j] = args[ran];
		}
		return ary2;
	}

	// 数组排序
	public static int[] arytest(int[] ary) {
		int lengs = ary.length;
		for (int i = 0; i < ary.length; i++) {
			for (int j = i + 1; j < ary.length; j++) {
				if (ary[i] > ary[j]) {
					int k = ary[i];
					ary[i] = ary[j];
					ary[j] = k;
				}
			}
		}

		return ary;
	}

	// 冒泡排序
	public static int[] bubbleSort(int[] args) {// 冒泡排序算法
		for (int i = 0; i < args.length - 1; i++) {
			for (int j = i + 1; j < args.length; j++) {
				if (args[i] > args[j]) {
					int temp = args[i];
					args[i] = args[j];
					args[j] = temp;
				}
			}
		}
		return args;
	}

	// 选择排序
	public static int[] selectSort(int[] args) {// 选择排序算法
		for (int i = 0; i < args.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < args.length; j++) {
				if (args[min] > args[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = args[i];
				args[i] = args[min];
				args[min] = temp;
			}
		}
		return args;
	}

	// 插入排序算法
	public static int[] insertSort(int[] args) {// 插入排序算法
		for (int i = 1; i < args.length; i++) {
			for (int j = i; j > 0; j--) {
				if (args[j] < args[j - 1]) {
					int temp = args[j - 1];
					args[j - 1] = args[j];
					args[j] = temp;
				} else
					break;
			}
		}
		return args;
	}

	public static int f(int n) {
		if (n == 1) {
			return 1;
		}
		return n + f(n - 1);
	}
}
