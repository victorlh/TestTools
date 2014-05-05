package com.jdbc;
public class Userinfo {  
    private int userid; // 编号  
    private String loginid; // 用户名  
    private String loginpwd; // 密码  
    private String username; // 姓名  
  
    /** 
     * 构造方法 
     */  
    public Userinfo() {  
    }  
  
    /** 
     * @param loginid 
     * @param loginpwd 
     * @param username 
     */  
    public Userinfo(String loginid, String loginpwd, String username) {  
        this.loginid = loginid;  
        this.loginpwd = loginpwd;  
        this.username = username;  
    }  
  
    /** 
     * @param userid 
     * @param loginid 
     * @param loginpwd 
     * @param username 
     */  
    public Userinfo(int userid, String loginid, String loginpwd, String username) {  
        this.userid = userid;  
        this.loginid = loginid;  
        this.loginpwd = loginpwd;  
        this.username = username;  
    }

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getLoginpwd() {
		return loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	} 
    
}
  
    //getter & setter methods 略   