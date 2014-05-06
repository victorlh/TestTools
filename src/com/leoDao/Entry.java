package com.leoDao;

import java.util.List;

public class Entry {
	public static void main(String[] args) {
		try {

			/*
			 * MySql中的初始数据：（编号、用户名、密码、姓名） 1 admin 123123 管理员 2 zhangsan 123123
			 * 张三 3 lisi 123123 李四 4 wangwu 123123 王五
			 */

			// 测试保存：赵六
			BaseDao.saveUserinfo(new Userinfo("zhaoliu", "123123", "赵六"));
			// 测试更新：赵六
			BaseDao.updateUserinfo(new Userinfo(5, "zhaoliu", "321321", "赵六2"));
			// 测试删除：王五
			BaseDao.deleteUserinfo(new Userinfo(4, null, null, null));
			// 测试查询：管理员
			Userinfo user = BaseDao.queryUserinfo(1);
			System.out.println(user.getUserid() + " " + user.getLoginid() + " "
					+ user.getLoginpwd() + " " + user.getUsername());
			// 测试分页：查询第2页，每页2条。王五已被删除。
			List<Userinfo> userList = BaseDao.queryUserinfoList(2, 2);
			for (Userinfo u : userList) {
				System.out.println(u.getUserid() + " " + u.getLoginid() + " "
						+ u.getLoginpwd() + " " + u.getUsername());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
