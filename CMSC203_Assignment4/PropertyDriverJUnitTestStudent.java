/*
 * Class: CMSC203 CRN 23011
 * Instructor: Huseyin Aygun
 * Description: (Create an aggregate using the class Property. For Property and ManagementClass, we declare its instance fields and create their methods accordingly. PropertyDriver then helps serve as the main class that helps create a ManagementCompany object, add properties to it, and display the information.)
 * Due: 10/26/26
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Daniel Nguyen
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PropertyDriverJUnitTestStudent {

	@Test
	void testTwoProperties() {
        ManagementCompany c1 = new ManagementCompany("Daniel Apartments", "123-45-6789");
        Property p1 = new Property("Apt 1", "Silver Spring", 3000.0, "Tyler");
        Property p2 = new Property("Apt 2", "Silver Spring", 3000.0, "Daniel");

        int index1 = c1.addProperty(p1);
        int index2 = c1.addProperty(p2);

        assertEquals(0, index1);
        assertEquals(1, index2);
        assertEquals(2, c1.getPropertyCount());
        assertEquals(6000.0, c1.totalRent(), 0.001);
	}
	
	@Test
	void testEqualAssignment() {
        ManagementCompany c1 = new ManagementCompany("Daniel Apartments", "123-45-6789");
        c1.addProperty(new Property("Apt 1", "Silver Spring", 3000.0, "Tyler"));
        c1.addProperty(new Property("Apt 1", "Silver Spring", 3000.0, "Tyler"));
        
        assertEquals(c1.getProperty(0).toString(), c1.getProperty(1).toString());
	}
	
	@Test
	void testNonEqualAssignment() {
        ManagementCompany c1 = new ManagementCompany("Daniel Apartments", "123-45-6789");
        c1.addProperty(new Property("Apt 1", "Silver Spring", 3000.0, "Tyler"));
        c1.addProperty(new Property("Apt 2", "Silver Spring", 4000.0, "Daniel"));
        
        assertNotEquals(c1.getProperty(0).toString(), c1.getProperty(1).toString());
	}

	
	@Test
	void testEqualCompanies() {
        ManagementCompany c1 = new ManagementCompany("Daniel Apartments", "123-45-6789");
        c1.addProperty(new Property("Apt 1", "Silver Spring", 3000.0, "Tyler"));
        c1.addProperty(new Property("Apt 2", "Silver Spring", 4000.0, "Daniel"));
        
        ManagementCompany c2 = new ManagementCompany(c1);
        
        assertNotEquals(c1.getProperty(0).toString(), c1.getProperty(1).toString());
	}
}
