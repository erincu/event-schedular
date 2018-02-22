package controller;

import java.io.IOException;
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

import model.Event;


@WebServlet("/attandanceeventcontroller")
public class attandanceeventcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public attandanceeventcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("4");
		int eid = Integer.valueOf(request.getParameter("eid"));
		String join = request.getParameter("join");
		String drop = request.getParameter("drop");
		String cancel = request.getParameter("cancel");
		String message;
			
		Statement statement = null;
		System.out.println("1");
		try {
			
			//Load Driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//Connect to DB server
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost/eventschedular","root","root");
			
			statement = connection.createStatement();		

			request.getSession();
			String sid = request.getRequestedSessionId();
			
			statement = connection.createStatement();
			ResultSet rs1 = statement.executeQuery("select * from session where sid= '" + sid + "'");
			
			rs1.next();
			String username = rs1.getString("username");
			
			statement = connection.createStatement();
			ResultSet rs2 = statement.executeQuery("select * from event where id= '" + eid + "'");
			rs2.next();
			String event_title = rs2.getString("name");
			String creator = rs2.getString("creator");
			
			if(join != null)
			{
				System.out.println("join");
				
					PreparedStatement statement1 =
							connection.prepareStatement("insert into event_join_list (id,username) values (?,?)");
					statement1.setInt(1,eid);
					statement1.setString(2,username);
					statement1.executeUpdate();
					message = "Successfully joined" + event_title + " " +creator;
				
					HttpSession session = request.getSession();
					session.setAttribute("message", message);
				
			}
			else if(drop !=null)
			{
			System.out.println("drop");
				
				PreparedStatement statement2 =
						connection.prepareStatement("delete from event_join_list where id='"+eid+"' and  username = '" +username+"'");
				
				statement2.executeUpdate();
				message = "Successfully droped"+ event_title + " " +creator;
				HttpSession session = request.getSession();
				session.setAttribute("message", message);
				
			}
			else
			{
				System.out.println("cancel");
				
				PreparedStatement statement2 =
						connection.prepareStatement("delete from event where id='"+eid+"' and creator ='" +username+"'");
					
				statement2.executeUpdate();
				message = "Successfully cancelled"+ event_title  + " " +creator;
				HttpSession session = request.getSession();
				session.setAttribute("message", message);
				
			}
			
        
            response.sendRedirect("http://localhost:8080/Event_Schedular/home.jsp");
				
				
				
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

}