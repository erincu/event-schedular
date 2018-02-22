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


@WebServlet("/profilecontroller")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProfileController() {
        super();        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String uname = "";
		Statement statement = null;
		String fname= "";
		String sname= "";
		String age="";
		String univ= "";
		String mail= "";
		String interests="";
		String password = "";
		
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
			ResultSet rs = statement.executeQuery("select * from session where sid= '" + sid + "'");
			
			
			if(rs.next()==false)
			{
				System.out.println("Error: Session id could not found!");
			}
			else
			{
				uname = rs.getString("username");
				ResultSet rs2 = statement.executeQuery("select * from users where username= '" + uname + "'");
				
				rs2.next();
				fname = rs2.getString("name");
				sname = rs2.getString("surname");
				age = rs2.getString("age");
				univ = rs2.getString("university");
				mail = rs2.getString("email");
				password = rs2.getString("password");
				
				
				
				if(rs2.getString("interest1")!= null)
				{
					interests = interests+ rs2.getString("interest1")+" ";
				}
				if(rs2.getString("interest2")!= null)
				{
					interests = interests+rs2.getString("interest2")+" ";
				}
				if(rs2.getString("interest3")!= null)
				{
					interests = interests+rs2.getString("interest3")+" ";
				}
				if(rs2.getString("interest4")!= null)
				{
					interests = interests+rs2.getString("interest4")+" ";
				}
				if(rs2.getString("interest5")!= null)
				{
					interests = interests+rs2.getString("interest5")+" ";
				}
				if(rs2.getString("interest6")!= null)
				{
					interests = interests+rs2.getString("interest6");
				}
				
				response.setContentType( "text/html" );
				System.out.println(uname + fname+ sname + age + univ+ mail);

				response.sendRedirect( "profile.jsp?name="+fname+"&surname="+sname+"&username="+uname+"&age="+ age+"&university="+univ+"&email="+ mail +"&interests=" +interests);
				
			}
			
			
			System.out.println("Connected to MySQL");
			//Create Prepared Statement
			
			//ResultSet rs = statement.executeQuery("select * from users where username = '" + un + "' and password = '" + pwd + "'");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

}
