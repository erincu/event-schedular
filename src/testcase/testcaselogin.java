package testcase;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import model.User;

public class testcaselogin {
	
	User yasemin = new User();
	User erincu = new User();
	@Test
	public void userlogin()
	{
		try {
			assertTrue(yasemin.login("yaseminy","qwerty" ));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void falseLogin()
	{
		try {
			boolean check = erincu.login("yy","2818" );
			System.out.println(check);
			assertFalse(check);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
