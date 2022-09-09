package com.sj.model;

import com.sj.dao.LoginDao;

public class User {
    private String userName;
    private String password;   
    
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isValid() {
				
	  return(new LoginDao().
			  getUser(this.userName).getPassword().equals(this.password));
		
	}
	
		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	
	
}
