package controller;

import model.Event;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


@WebServlet("/searchevent")
public class searchevent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username"); 
		
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Statement st;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			
			//Connect to DB server
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost/eventschedular","root","root");

            
			PreparedStatement statement =
					(PreparedStatement) connection.prepareStatement("select * from event e, users u where (e.type = u.interest1 or e.type = u.interest2 or e.type = u.interest3 or e.type = u.interest4 or e.type = u.interest5 or e.type = u.interest6) and u.username = '"+name+"'");
			
            ResultSet  rs = statement.executeQuery();

            ArrayList<Event> events = new ArrayList<Event>();
          //...
          while(rs.next())
              {
                  Event event  = new Event();
                  event.setEid(rs.getInt(1));
                  event.setCreator(rs.getString(2));
                  event.setEventName(rs.getString(3));
                  event.setEventDate(rs.getString(4));
                  event.setEventPlace(rs.getString(5));
                  event.setCapacity(rs.getInt(6));
                  event.setType(rs.getString(7));
                  
                 
                  
                  events.add(event);
                  //System.out.println(user.getName());
              }
            session = request.getSession();
        	session.setAttribute("eventList", new ArrayList<Event>());
        	session.setAttribute("eventList", events);
          
          
          response.sendRedirect("http://localhost:8080/Event_Schedular/home.jsp");

      } catch (Exception e) {
          e.printStackTrace();
      } 
  }

}
