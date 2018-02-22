package testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Event;

public class eventsearchbytype {

	Event event = new Event();
	ArrayList<Event> eventlist = new ArrayList<Event>();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testsearch() throws ClassNotFoundException
	{
		String type = "music";
		
		eventlist = event.getEvent(type);
		
		if(eventlist !=null){
            for(Event event: eventlist){
            
           assertEquals(type,event.getType());
		
	}

}
}
}
