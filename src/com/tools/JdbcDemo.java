package com.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {
	public static void main(String[] arg) throws Exception{
		//加载及注册JDBC驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		//JDBC URL 定义驱动程序与数据源之间的连接
		//建立链接
		String url = "jdbc:mysql://localhost:3306/mysqldata?user=root&password=test";
		Connection con = DriverManager.getConnection(url);
		//建立SQL陈述对象（Statement Object） 每个操作需要有一个链接
		Statement stmt = con.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//定义参数可以上下回滚指针并且可被update
		Statement stmt2 = con.createStatement();
		//执行SQL语句
		//查找
		String query = "select * from test where name = \"lh01\"";
		ResultSet rs = stmt.executeQuery(query);
		rs.setFetchSize(5); //每次缓存中取多少条
//		rs.updateString("sex", "no");		
		//添加数据
		String upd = "insert into test(name,sex) values(\"name01\",\"sex01\")";
		int rsUpd = stmt2.executeUpdate(upd);
		System.out.println("修改的记录数："+rsUpd);
		//结果集ResultSet，结果集指针向下移 才能得到结果
		while(rs.next()){			
			String resutl =rs.getString("name");
			System.out.println(resutl);
			rs.deleteRow();//删除一行
		}
		
		//关闭资源，资源回收
		rs.close();
		stmt.close();
		con.close();
		
	}

}
