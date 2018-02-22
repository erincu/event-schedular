package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logoutcontroller")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {		
			//Load Driver 
			Class.forName("com.mysql.jdbc.Driver");
					
			//Connect to DB server
			Connection connection =

			DriverManager.getConnection("jdbc:mysql://localhost/eventschedular","root","root");
					
					
			request.getSession();
			String sid = request.getRequestedSessionId();
				
			PreparedStatement st2 =
						connection.prepareStatement("delete from session where sid= '" + sid + "'");
			st2.executeUpdate();
		
			request.getSession().invalidate();
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
			response.sendRedirect("http://localhost:8080/Event_Schedular/login.jsp");

			
			
		}

}
