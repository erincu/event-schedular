package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/eventcontroller")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eventname = request.getParameter("eventName");
		String eventdate = request.getParameter("eventDate");
		String eventplace = request.getParameter("eventPlace");
		int capacity = Integer.valueOf(request.getParameter("capacity"));		
		String music = request.getParameter("music");
		String sports = request.getParameter("sports");
		String dance = request.getParameter("dance");
		String art = request.getParameter("art");
		String party = request.getParameter("party");
		String travel = request.getParameter("travel");
		
		String type = "";
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		
		HttpSession session = request.getSession();
		String str = (String)session.getAttribute("username");
		System.out.println(str);
		
		try {
			 date = df.parse(eventdate);
		     String newDateString = df.format(date);
		     System.out.println(newDateString);
			//Load Driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//Connect to DB server
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost/eventschedular","root","root");
			
			
			if(music != null)
				type = music;
			else if(sports != null)
				type = sports;
			else if(dance != null)
				type = dance;
			else if(art != null)
				type = art;
			else if(party != null)
				type =party;
			else if(travel != null)
				type = travel;
			else
			{
				response.sendRedirect("http://localhost:8080/Event_Schedular/event.jsp");
			}
			
			System.out.println("Type bu:" + type);
			
			System.out.println("Connected to MySQL");
			//Create Prepared Statement
			PreparedStatement statement =
					connection.prepareStatement("insert into event (username,name,date,place,capacity,type) values (?,?,?,?,?,?)");
		
			
			
			statement.setString(1, str);
			statement.setString(2, eventname);
			statement.setString(3, newDateString);
			statement.setString(4,eventplace);
			statement.setInt(5,capacity);
			statement.setString(6, type);
			statement.execute();
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		response.sendRedirect("http://localhost:8080/Event_Schedular/home.jsp");
	
	}

}