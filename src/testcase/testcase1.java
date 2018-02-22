package testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import model.User;

public class testcase1 {
String message1 = "Hello World";
String message2 = "Hello World2";
   User erinc = new User();
   
   
   @Test
   public void testsetter()
   {
	   erinc.setName("erinc");
	   
	   String baran = erinc.getName();
	   
	   assertEquals(baran,"erinc");
   }
   
}
