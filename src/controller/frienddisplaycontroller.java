package controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Event;
import model.User;

/**
 * Servlet implementation class EventDisplayController
 */
@WebServlet("/frienddisplaycontroller")
public class frienddisplaycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int userid = Integer.valueOf(request.getParameter("userid"));
		
		
			
		Statement statement = null;
	
		
		try {
			
			//Load Driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//Connect to DB server
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost/eventschedular","root","root");
			
			statement = connection.createStatement();
			
			System.out.println("Connected to MySQL");
			//Create Prepared Statement			

			
				
				
			statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from users where id='"+userid+"'");
			rs.next();
			System.out.println("Result setten sonra" + userid);
			
			User ev =  new User();
			
			ev.setId(rs.getInt("id"));
			ev.setName(rs.getString("name"));
			ev.setSurname(rs.getString("surname"));
			ev.setUniversity(rs.getString("university"));
			
			
			HttpSession session = request.getSession();
            session.setAttribute("user", ev);
        
            response.sendRedirect("http://localhost:8080/Event_Schedular/friendpage.jsp");
				
				
				
				
						
				
		
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
