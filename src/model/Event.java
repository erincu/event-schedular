package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class Event {
	
	private String creator;
	private int eid;
	private String eventName;
	private String eventDate;
	private String eventPlace;
	private int capacity;
	private String type;

	public Event() {
		super();
		
	}
	
	
	public Event(int eid, String eventName, String eventDate, String eventPlace, int capacity) {}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public Event(int eid, String eventName, String eventDate, String eventPlace, int capacity, String creator, String type) {
		super();
		this.creator= creator;
		this.eid = eid;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventPlace = eventPlace;
		this.capacity = capacity;
		this.type = type;
	}


	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getEventDate() {
		return eventDate;
	}


	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}


	public String getEventPlace() {
		return eventPlace;
	}


	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public ArrayList<Event> getEvent(String type) throws ClassNotFoundException
	{
		ArrayList<Event> events = new ArrayList<Event>();
		
		Class.forName("com.mysql.jdbc.Driver");
		try{
		//Connect to DB server
		Connection connection =
				DriverManager.getConnection("jdbc:mysql://localhost/eventschedular","root","");

        
		PreparedStatement statement =
				(PreparedStatement) connection.prepareStatement("select * from event where type='" + type + "'");
		
        ResultSet  rs = statement.executeQuery();
        
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
		
	} catch (Exception e) {
        e.printStackTrace();
    } 
		return events;
	}
	
}
