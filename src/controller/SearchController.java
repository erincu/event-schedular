package controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;


@WebServlet("/searchcontroller")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("namesearch");
	
	
		
	

        Statement st;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			
			//Connect to DB server
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost/eventschedular","root","root");

            
			PreparedStatement statement =
					(PreparedStatement)connection.prepareStatement("select * from users where name='"+ name+ "'");
			
            ResultSet  rs = statement.executeQuery();

            System.out.println(name);
            ArrayList<User> users = new ArrayList<User>();
          //...
          while(rs.next())
              {
                  User user  = new User();
                  user.setId(rs.getInt(1));
                  user.setName(rs.getString(2));
                  user.setSurname(rs.getString(3));
                  user.setUsername(rs.getString(4));
                  user.setAge(rs.getInt(5));
                  user.setUniversity(rs.getString(6));
                  user.setEmail(rs.getString(7));
                  user.setPassword(rs.getString(8));
                 
                  
                  users.add(user);
                  System.out.println(user.getName());
              }
          	
          	
          	
          	HttpSession session = request.getSession();
          	session.setAttribute("userList", new ArrayList<User>());
          	session.setAttribute("userList", users);
            //request.setAttribute("userList",users);
           
            response.sendRedirect("http://localhost:8080/Event_Schedular/friendlist.jsp");
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

}