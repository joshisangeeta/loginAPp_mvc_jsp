package com.sjcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url,userID,password;
	Connection connection;
	ServletContext context;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
    context = this.getServletContext();
	url= context.getInitParameter("url");
	//System.out.println(url);
	userID=context.getInitParameter("userID") ; 
	password = context.getInitParameter("password");
	
	try {
		connection = DriverManager.getConnection(url, userID, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }	
	}
    
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 try {
	    	   PrintWriter out = response.getWriter();
	    	
	    	   String userName = request.getParameter("userName");
	    	   String password = request.getParameter("password");	    	
			   PreparedStatement pst = connection.prepareStatement
					   ("insert into login values(?,?) ");
		       pst.setString(1, userName);
		       pst.setString(2, password);
	           int rows= pst.executeUpdate()  ;     
	           if(rows>0)
	        	  out.println("Welcome,<b>"+userName+"</b> You are registered ") ;
	           else
	             out.println("Could  not register you,please try later");
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
		
		
		
		
		
		
		
	}

}
