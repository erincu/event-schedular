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


@WebServlet("/eventdisplaycontroller")
public class EventDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int eid = Integer.valueOf(request.getParameter("eid"));
		
		
			
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
			ResultSet rs = statement.executeQuery("select * from event where id='"+eid+"'");
			rs.next();
			
			System.out.println("2");
			// ##### get username to check that user is creator or participant of the event
			request.getSession();
			String sid = request.getRequestedSessionId();
			
			statement = connection.createStatement();
			ResultSet rs1 = statement.executeQuery("select * from session where sid= '" + sid + "'");
			rs1.next();
			String username = rs1.getString("username");
			String status = null;
			int event_id = rs.getInt("id");
			System.out.println("3");
			if(username.equals(rs.getString("creator")))
			{
				status = "creator";
			}
			System.out.println("4");
			
			statement = connection.createStatement();
			ResultSet rs2 = statement.executeQuery("select * from event_join_list where id= '" + event_id +"' and username= '" + username + "'");
			if(rs2.next()!= false)
			{
				status = "participant";
			}
			
			// ########
			System.out.println("5");
			System.out.println("Result setten sonra" + eid);
			
			Event ev =  new Event();
			ev.setEid(rs.getInt("id"));
			ev.setCreator(rs.getString("creator"));
			ev.setEventName(rs.getString("name"));
			ev.setEventDate(rs.getString("date"));
			ev.setEventPlace(rs.getString("place"));
			ev.setCapacity(rs.getInt("capacity"));
			ev.setType(rs.getString("type"));
			System.out.println("Result setten sonra" + eid);
			
			HttpSession session = request.getSession();
            session.setAttribute("event", ev);
            session.setAttribute("status", status);
        
            response.sendRedirect("http://localhost:8080/Event_Schedular/eventpage.jsp");
				
				
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
