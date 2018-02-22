package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registercontroller")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String username = request.getParameter("username");
		int age = Integer.valueOf(request.getParameter("age"));
		String university = request.getParameter("university");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		try {
			
			//Load Driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//Connect to DB server
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost/eventschedular","root","root");
			
			
			
			System.out.println("Connected to nahSQL");
			//Create Prepared Statement
			PreparedStatement statement =
					connection.prepareStatement("insert into users (name, surname,username,age,university,email,password,interest1,interest2,interest3,interest4,interest5,interest6) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
			System.out.println("oluyo mu");
						
			statement.setString(1,name);
			statement.setString(2,surname);
			statement.setString(3,username);
			statement.setInt(4, age);
			statement.setString(5,university);
			statement.setString(6,email);
			statement.setString(7,password);
		
			statement.execute();
		

			
			
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		response.sendRedirect("http://localhost:8080/Event_Schedular/login.jsp");


	}

}
