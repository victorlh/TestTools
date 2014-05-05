package com.jdbc;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.ArrayList;  
import java.util.List; 
import com.jdbc.Userinfo;
  
public class BaseDao {  
  
    // 连接地址  
    private static final String url = "jdbc:mysql://localhost:3306/accp";  
    // 驱动类  
    private static final String driverClass = "com.mysql.jdbc.Driver";  
    // 用户名  
    private static final String uname = "root";  
    // 密码  
    private static final String pwd = "admin";  
  
    /** 
     * 获取数据库连接 
     *  
     * @return 连接对象 
     */  
    protected static Connection getConnection() {  
        Connection conn = null;  
        try {  
            Class.forName(driverClass);  
            conn = DriverManager.getConnection(url, uname, pwd);  
        } catch (ClassNotFoundException e) {  
            System.out.println("找不到驱动类");  
        } catch (SQLException e) {  
            System.out.println("建立连接错误！");  
        }  
        return conn;  
    }  
  
    /** 
     * 关闭数据库连接 
     *  
     * @param conn 
     *            数据库连接 
     * @param rs 
     *            结果集 
     * @param pstmt 
     *            命令对象 
     */  
    public static void closeAll(Connection conn, ResultSet rs, Statement pstmt) {  
        try {  
            if (null != rs && !rs.isClosed()) {  
                rs.close();  
                rs = null;  
            }  
        } catch (SQLException e) {  
            System.out.println("关闭结果集出错！");  
        }  
        try {  
            if (null != pstmt && !pstmt.isClosed()) {  
                pstmt.close();  
                pstmt = null;  
            }  
        } catch (SQLException e) {  
            System.out.println("关闭命令对象出错！");  
        }  
        try {  
            if (null != conn && !conn.isClosed()) {  
                conn.close();  
                conn = null;  
            }  
        } catch (SQLException e) {  
            System.out.println("关闭链接出错");  
        }  
    }  
  
    /** 
     * 保存指定用户信息 
     *  
     * @param user 
     *            用户对象 
     * @throws Exception 
     *             抛出异常 
     */  
    public static void saveUserinfo(Userinfo user) throws Exception {  
        if (null != user) {  
            Connection conn = getConnection();  
            PreparedStatement pstmt = null;  
            String sql = "insert into USERINFO values(null,?,?,?)";  
            try {  
                pstmt = conn.prepareStatement(sql);  
                pstmt.setString(1, user.getLoginid());  
                pstmt.setString(2, user.getLoginpwd());  
                pstmt.setString(3, user.getUsername());  
                pstmt.executeUpdate();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            } finally {  
                closeAll(conn, null, pstmt);  
            }  
        } else {  
            throw new Exception("用户信息不能为空");  
        }  
    }  
  
    /** 
     * 删除指定用户信息 
     *  
     * @param user 
     *            用户对象 
     * @throws Exception 
     *             抛出异常 
     */  
    public static void deleteUserinfo(Userinfo user) throws Exception {  
        if (null != user) {  
            Connection conn = getConnection();  
            PreparedStatement pstmt = null;  
            String sql = "delete from USERINFO where userid = ?";  
            try {  
                pstmt = conn.prepareStatement(sql);  
                pstmt.setInt(1, user.getUserid());  
                pstmt.executeUpdate();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            } finally {  
                closeAll(conn, null, pstmt);  
            }  
        } else {  
            throw new Exception("用户信息不能为空");  
        }  
    }  
  
    /** 
     * 更新指定用户信息 
     *  
     * @param user 
     *            用户对象 
     * @throws Exception 
     *             抛出异常 
     */  
    public static void updateUserinfo(Userinfo user) throws Exception {  
        if (null != user) {  
            Connection conn = getConnection();  
            PreparedStatement pstmt = null;  
            String sql = "update USERINFO set loginid = ?,loginpwd = ?,username = ? where userid = ?";  
            try {  
                pstmt = conn.prepareStatement(sql);  
                pstmt.setString(1, user.getLoginid());  
                pstmt.setString(2, user.getLoginpwd());  
                pstmt.setString(3, user.getUsername());  
                pstmt.setInt(4, user.getUserid());  
                pstmt.executeUpdate();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            } finally {  
                closeAll(conn, null, pstmt);  
            }  
        } else {  
            throw new Exception("用户信息不能为空");  
        }  
    }  
  
    /** 
     * 查询指定用户信息 
     *  
     * @param id 
     *            用户编号 
     * @return 用户对象 
     * @throws Exception 
     *             抛出异常 
     */  
    public static Userinfo queryUserinfo(int id) throws Exception {  
        Userinfo user = null;  
        Connection conn = getConnection();  
        PreparedStatement pstmt = null;  
        ResultSet rs = null;  
        String sql = "select * from USERINFO where userid = ?";  
        try {  
            pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, id);  
            rs = pstmt.executeQuery();  
            if (rs.next()) {  
                user = new Userinfo(id, rs.getString(2), rs.getString(3),  
                        rs.getString(4));  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            closeAll(conn, rs, pstmt);  
        }  
        return user;  
    }  
  
    /** 
     * 分页查询用户信息列表 
     *  
     * @param currentPage 
     *            要查询页码 
     * @param pageSize 
     *            每页显示条数 
     * @return 用户对象集合 
     * @throws Exception 
     *             抛出异常 
     */  
    public static List<Userinfo> queryUserinfoList(int currentPage, int pageSize)  
            throws Exception {  
        // 计算当前页索引  
        int pageIndex = (currentPage - 1) * pageSize;  
        List<Userinfo> userList = new ArrayList<Userinfo>();  
        Connection conn = getConnection();  
        PreparedStatement pstmt = null;  
        ResultSet rs = null;  
        // MySql分页可使用limit关键字:select * from tableName limit pageIndex,pageSize  
        String sql = "select * from USERINFO limit ?,?";  
        try {  
            pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, pageIndex);  
            pstmt.setInt(2, pageSize);  
            rs = pstmt.executeQuery();  
            while (rs.next()) {  
                userList.add(new Userinfo(rs.getInt(1), rs.getString(2), rs  
                        .getString(3), rs.getString(4)));  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            closeAll(conn, rs, pstmt);  
        }  
        return userList;  
    }  
  
}  