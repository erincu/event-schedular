package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	
	private int uid;
	private String name;
	private String surname;
	private String username;
	private int age;
	private String university;
	private String email;
	private String password;
	
	public User() {
		super();
	}

	public User(int id, String name, String surname, String username, int age, String university, String email,
			String password) {
		super();
		this.uid = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.age = age;
		this.university = university;
		this.email = email;
		this.password = password;
	}


	public int getId() {
		return uid;
	}


	public void setId(int id) {
		this.uid = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}
	
	public boolean login(String username, String password) throws SQLException
	{
		Statement statement = null;
		Connection connection =
				DriverManager.getConnection("jdbc:mysql://localhost/eventschedular","root","root");
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from users where username = '" + username + "' and password = '" + password + "'");
		
		if(rs.next()==false)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean joinEvent(int eid)
	{
			int count = 0;
			
			try{
			//Connect to DB server
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost/eventschedular","root","root");

	        
			PreparedStatement statement =
					(PreparedStatement) connection.prepareStatement("select * from event_join_list where id='" + eid + "'");
			
	        ResultSet  rs = statement.executeQuery();
	        
	        statement =
					(PreparedStatement) connection.prepareStatement("select * from event where id='" + eid + "'");
	        ResultSet rs1 = statement.executeQuery();
	        rs.next();
	       
			int capacity = rs.getInt("capacity");
	        
	        while(rs.next())
	        {    
	        	count++;
	        }
	        if(count == capacity)
	        {
	        	return false;
	        }
	        else
	        {
	        	statement =
						connection.prepareStatement("insert into event_join_list (id, username) values (?,?)");
	        	statement.setInt(1,eid);
				statement.setString(2,username);
			
				statement.execute();
	        	return true;
	        }
	        
		}catch(Exception e)
			{
			e.printStackTrace();
			}
			return false;
	}
}
	
	
	
	
	


