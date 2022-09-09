package com.sjcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sj.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet(
		urlPatterns = { "/Login" } 
		)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
			
		}	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	        
	    try {
	    	   PrintWriter out = response.getWriter();
	    	
	    	   String userName = request.getParameter("userName");
	    	   String password = request.getParameter("password");	
	    	   
	    	   User user = new User(userName,password);
	    	   
	    	   boolean flag = user.isValid();
			   
	    	    if(flag==true) {
	    	    
	        	 RequestDispatcher dispatcher =  request.getRequestDispatcher("/welcome.jsp");
	        	   
	        	   dispatcher.include(request, response);
	        	   
	        	   out.println("some response from this servlet");
	        	   
	           }
	        	   
	           else 
	           { 
	        	   
                   RequestDispatcher dispatcher =  request.getRequestDispatcher("/index.html");
	        	   
	        	   dispatcher.forward(request, response);
	        	  
	        	//     response.sendRedirect("index.html");
	        	   
	        	   
	           }
	        	   
	        	   
	        	   
	        	   
	        	   
	        	   
	        	   
	        /*	  out.println("Welcome,<b>"+userName+"</b> How are you today?") ;
	           else
	             out.println("No such user exists,please try again");*/
	    
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	
	
	
	}

}
