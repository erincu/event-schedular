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

import model.User;


@WebServlet("/friendaddcontroller")
public class friendaddcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
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
			
			//Create Prepared Statement			

			request.getSession();
			String sid = request.getRequestedSessionId();
			
			statement = connection.createStatement();
			ResultSet rs1 = statement.executeQuery("select * from session where sid= '" + sid + "'");
			
			rs1.next();
			String username = rs1.getString("username");
				
			ResultSet rs2 = statement.executeQuery("select * from users where username= '" + username + "'");
			rs2.next();
			int id = Integer.valueOf(rs2.getString("id"));
			
			ResultSet rs = statement.executeQuery("select * from friendrequest where id='"+id+"'and  id2 = '" +userid+"'");
			
			if(rs.next()==false)
			{
				PreparedStatement statement1 =
						connection.prepareStatement("insert into friendrequest (id,id2) values (?,?)");
				statement1.setInt(1,id);
				statement1.setInt(2,userid);
				statement1.executeUpdate();
			}
			
        
            response.sendRedirect("http://localhost:8080/Event_Schedular/home.jsp");
				
				
				
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

}