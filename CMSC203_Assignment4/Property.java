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
public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	
	//Default constructor
	public Property()
	{
		propertyName = "";
		city = "";
		rentAmount = 0;
		owner = "";
	}
	//Parameterized constructor
	public Property(String n, String c, double r, String o)
	{
		propertyName = n;
		city = c;
		rentAmount = r;
		owner = o;
	}
	//Copy Constructor
	public Property(Property object2)
	{
		propertyName = object2.propertyName;
		city = object2.city;
		rentAmount = object2.rentAmount;
		owner = object2.owner;
	}
	
	//Getters method
	public String getPropertyName()
	{
		return propertyName;
	}
	public String getCity()
	{
		return city;
	}
	public double getRentAmount()
	{
		return rentAmount;
	}
	public String getOwner()
	{
		return owner;
	}
	
	//setters method
	public void setPropertyName(String n)
	{
		propertyName = n;
	}
	public void setCity(String c)
	{
		city = c;
	}
	public void setRentAmount(double r)
	{
		rentAmount = r;
	}
	public void setOwner(String o)
	{
		owner = o;
	}
	
	//toString method
	public String toString()
	{
		return String.format("%s, %s, Rent: $%.2f, Owner: %s", propertyName, city, rentAmount, owner);
	}
	

	
}
