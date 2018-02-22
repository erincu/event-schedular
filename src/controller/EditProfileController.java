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
import javax.servlet.http.HttpSession;


@WebServlet("/editprofilecontroller")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Connected to nahSQL1");
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int age = Integer.valueOf(request.getParameter("age"));
		String university = request.getParameter("university");
		String email = request.getParameter("email");
		
		String music = request.getParameter("music");
		String sports = request.getParameter("sports");
		String dance = request.getParameter("dance");
		String art = request.getParameter("art");
		String party = request.getParameter("party");
		String travel = request.getParameter("travel");
		
		String interests = "";
		
		if(music!= null)
		{
			interests = interests+music+" ";
		}
		if(dance!= null)
		{
			interests = interests+dance+" ";
		}
		if(sports!= null)
		{
			interests = interests+sports+" ";
		}
		if(art!= null)
		{
			interests = interests+art+" ";
		}
		if(party!= null)
		{
			interests = interests+party+" ";
		}
		if(travel!= null)
		{
			interests = interests+travel;
		}
		
		
		
		System.out.println(interests);
		System.out.println("Connected to nahSQL");
		try {
			
			//Load Driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//Connect to DB server
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost/eventschedular","root","root");
			
			/*request.getSession();
			String sid = request.getRequestedSessionId();
			PreparedStatement st =
					connection.prepareStatement("select from session where sid='"+ sid+"'");*/
			
			HttpSession session = request.getSession();
			String str = (String)session.getAttribute("username");
			System.out.println(str);
			System.out.println(username);
			
			if(username.equals(str))
			{
			//Create Prepared Statement
			PreparedStatement statement =
					connection.prepareStatement("UPDATE users SET  name=?, surname=?, username=?, age=?, university=?, email=?, password=? ,interest1=?,interest2=?,interest3=?,interest4=?,interest5=?,interest6=? WHERE username= '"+username+"'");
			
			statement.setString(1,name);
			statement.setString(2,surname);
			statement.setString(3,username);
			statement.setInt(4, age);
			statement.setString(5,university);
			statement.setString(6,email);
			statement.setString(7,password);
			
			
			
			statement.setString(8,music);
			statement.setString(9,sports);
			statement.setString(10,dance);
			statement.setString(11,art);
			statement.setString(12,party);
			statement.setString(13,travel);
			//System.out.println("Connected to nahSQL");
			statement.executeUpdate();
			
			
			response.sendRedirect( "profile.jsp?name="+name+"&surname="+surname+"&username="+username+"&age="+ String.valueOf(age)+"&university="+university+"&email="+ email +"&interests=" +interests);
			
			}
			else
			{
				response.sendRedirect("editprofile.jsp");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	}

