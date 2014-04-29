package com.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class CollectionRank {

	/**
	 * 数组打散排序
	 * @param array
	 * @return
	 */
	public static int[] arrayShuffle(int[] array){
		//第一种打散方法
//		List list = Arrays.asList(array);
//		Collections.shuffle(list);
		//第二种打散方法
		Random rand = new Random();
		for(int j = array.length;j>2;j--){
			//随机取一个数进行调换
			int rem = 0;
			int k = rand.nextInt(j-2);
			rem = array[k];
			array[k] = array[j-1];
			array[j-1] = rem;
		}
		return array;
	}
	
	/**
	 * 将有序的arrayList重新排序
	 * 用自带方法
	 * @param aryList
	 * @return
	 */
	public static ArrayList arrayListShuffle(ArrayList aryList){
		ArrayList result = new ArrayList();
		//将ArrayList转成数组
		List list = Arrays.asList(aryList.toArray());
		//调用集合方法进行排序
		Collections.shuffle(list);
		//迭代放入ArrayList中
		Iterator i = list.iterator();
		while(i.hasNext()){
			result.add(i.next());
		}
		return result;
	}
	
	/**
	 * LinkedList的打散方法与ArrayList类同
	 * @param linkList
	 * @return
	 */
	public static LinkedList linkedListShuffle(LinkedList linkList){
		LinkedList result = new LinkedList();
		List list = Arrays.asList(linkList.toArray());
		Collections.shuffle(list);
		Iterator i = list.iterator();
		while(i.hasNext()){
			result.add(i.next());
		}
		return result;
	}
	
	/**
	 * Map迭代
	 * @param map
	 */
	public static void mapIterator(Map map){
		//将map转成set，此方法效率比较高
		Set mapToSet = map.entrySet();
		Iterator i = mapToSet.iterator();
		while(i.hasNext()){
			Map.Entry entry= (Entry) i.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("key: "+key+"value: "+value);
		}
//		//方法二
//		Iterator j = map.keySet().iterator();
//		while(j.hasNext()){
//			Object key = j.next();
//			Object value = map.get(key);
//			System.out.println("key: "+key+"value: "+value);
//		}
	}
	
	/**
	 * HashSet迭代
	 * Set是无序的Collection,HashSet低层是HashMap实现的，每个set对应其hashCode值存储
	 * @param set
	 */
	public static void hashSetIterator(HashSet set){
		Iterator index = set.iterator();
		while(index.hasNext()){
			System.out.println(index.next());
		}
	}
	
	/**
	 * TreeSet迭代
	 * @param set
	 */
	public static void treeSetIterator(TreeSet set){
		Iterator index = set.iterator();
		while(index.hasNext()){
			System.out.println(index.next());
		}
		
	}
	
	/**
	 * 冒泡排序，从小到大
	 * @param arry
	 * @return
	 */
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
	
	/**
	 * 选择排序，从小到大
	 * @param args
	 * @return
	 */
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


	/**
	 * 插入排序
	 * @param args
	 * @return
	 */
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
    
}
