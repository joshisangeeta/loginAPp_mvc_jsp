package com.sj.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sj.model.User;
public class LoginDao {
	Connection connection;
     public LoginDao() {
		super();
		// TODO Auto-generated constructor stub
		try {
			connection=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/jd","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		}
     }	
	public User getUser(String userName) {    	 
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement
					   ("select password from login where username = ?");		
			pst.setString(1, userName);
	        ResultSet user = pst.executeQuery()  ;     
	        user.next();
	        String pass = user.getString(1);
	        User user1 = new User(userName,pass);	
	        return user1;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       return new User("noValue","noValue");
    	 
     }




}
