package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;


@WebServlet("/logincontroller")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   
		String un = request.getParameter("username");
		String pwd = request.getParameter("password");
	
		Statement statement = null;
		
		User user = new User();
		
		try {
			
			//Load Driver 
			Class.forName("com.mysql.jdbc.Driver");
						
			
			//Connect to DB server
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost/eventschedular","root","root");
			
			statement = connection.createStatement();
						
			if(user.login(un, pwd))
			{

				request.getSession().setAttribute("username", un);
				HttpSession session = request.getSession();
				session.setAttribute("username", un);
				

				String sid = request.getRequestedSessionId();
				
				
				PreparedStatement statement3 =
						connection.prepareStatement("delete from session where username = '" + un +"'");
				
				statement3.executeUpdate();
				
				statement = connection.createStatement();
				PreparedStatement st2 =
						connection.prepareStatement("insert into session (sid, username) values (?,?)");
				st2.setString(1, sid);
				st2.setString(2, un);
				st2.executeUpdate();
				
						
				response.sendRedirect("searchevent");
			}
			else
			{
				String loggedIn = "false";
				HttpSession session = request.getSession();
				session.setAttribute("loggedIn", loggedIn);
				response.sendRedirect("http://localhost:8080/Event_Schedular/login.jsp");
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
