package com.tools;

import java.lang.reflect.Method;
import java.util.Scanner;

public class TestFrame {
	public static void main(String[] args) throws Exception {
		//java反射机制
		while (true) {
			System.out.println("输入类名:");
			Scanner s = new Scanner(System.in);
			String name = s.nextLine();// 获取测试案例类名
//			Class t = TestCase2.class; //用反射获取TestCase2的类名：com.tools.TestFrame$TestCase2
//			System.out.println("内部类TestCase2，类的类名为："+t.getName());
			Class cls = Class.forName(name);// 获取测试案例的类
			Object obj = cls.newInstance();// 创建测试案例实例
			Method[] ms = cls.getMethods();// 获得全部的方法
			for (Method m : ms) {
				if (m.getName().startsWith("test")) {// 找到"test"开头的方法
					m.invoke(obj, new Object[] {});// 执行方法, 执行测试方法
					// 以上方法 obj是包含方法的对象,
					// new Object[]{}是调用方法传递的参数, 这里传递是空数组, 表示方法没有参数.
				}
			}
		}

	}

	//测试类1
	public static class TestCase2 {
		public void testVal() {
			System.out.println("val");	
		}
	}

	//测试类2
	public static class TestCase {
		public void testGBK() throws Exception {
			System.out.println(IoUtils.toHexString("中国".getBytes("GBK")));
		}

		public void testUTF8() throws Exception {
			System.out.println(IoUtils.toHexString("中国".getBytes("utf-8")));
		}

		public void testUTF16BE() throws Exception {
			System.out.println(IoUtils.toHexString("中国".getBytes("utf-16be")));
		}
	}

}
