
public class Patient 
{
	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	private String phoneNumber;
	private String emergencyContactName;
	private String emergencyPhoneNumber;

	//no-arg constructor
	public Patient()
	{
	}
	
	//first, middle, and last name constructor
	public Patient(String f, String m, String l)
	{
		firstName = f;
		middleName = m;
		lastName = l;
	}
	
	//constructor to initialize all attributes
	public Patient(String f, String m, String l, String sA, String c, String s, String zC, String pN, String eCn, String ePn)
	{
		firstName = f;
		middleName = m;
		lastName = l;
		streetAddress = sA;
		city = c;
		state = s;
		zipcode = zC;
		phoneNumber = pN;
		emergencyContactName = eCn;
		emergencyPhoneNumber = ePn;
	}
	
	//getter and setter methods for each attribute (getters first)
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getMiddleName()
	{
		return middleName;
	}
	public String getStreetAddress()
	{
		return streetAddress;
	}
	public String getCity()
	{
		return city;
	}
	public String getState()
	{
		return state;
	}
	public String getZipcode()
	{
		return zipcode;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public String getEmergencyContactName()
	{
		return emergencyContactName;
	}
	public String getEmergencyPhoneNumber()
	{
		return emergencyPhoneNumber;
	}
	
	
	//setter methods
	public void setFirstName(String fN)
	{
		firstName = fN;
	}
	public void setLastName(String lN)
	{
		lastName = lN;
	}
	public void setMiddleName(String mN)
	{
		middleName = mN;
	}
	public void setStreetAddress(String sA)
	{
		streetAddress = sA;
	}
	public void setCity(String c)
	{
		city = c;
	}
	public void setState(String s)
	{
		state = s;
	}
	public void setZipcode(String zC)
	{
		zipcode = zC;
	}
	public void setPhoneNumber(String pN)
	{
		phoneNumber = pN;
	}
	public void setEmergencyContactName(String eCn)
	{
		emergencyContactName = eCn;
	}
	public void setEmergencyPhoneNumber(String ePn)
	{
		emergencyPhoneNumber = ePn;
	}
	
	//builder methods
	public String buildFullName()
	{
		return(firstName + " " + middleName + " " + lastName);
	}
	public String buildAddress()
	{
		return(streetAddress + " " + city + " " + state + " " + zipcode);
	}
	public String buildEmergencyContact()
	{
		return(emergencyContactName + " " + emergencyPhoneNumber);
	}
	
	//toString method method to display all patient information
	public String toString()
	{
		return "Patient Information\n" 
				+ "-------------------\n"
				+ "Name: " + buildFullName()
				+ "\nAddress: " + buildAddress()
				+ "\nPhone Number: " + phoneNumber
				+ "\nEmergency Contact: " + emergencyContactName
				+ "\nPhone Valid: " + isValidPhoneNumber()
				+ "\nEmergency Phone Valid: " + isValidEmergencyPhoneNumber();
		
	}
	
	//additional methods
	public boolean isValidPhoneNumber()
	{
		//.length does NOT start at 0
		if(phoneNumber.length() != 12)
		{
			return false;
		}
		
		//make sure dashes are present
		if(phoneNumber.charAt(3) != '-' && phoneNumber.charAt(7) != '-')
		{
			return false;
		}
		
		//make sure all other input is a digit (doesnt count both dashes, then checks if every i increment is NOT a digit, returns false if it is not a digit.
		for(int i = 0; i < phoneNumber.length(); i++)
		{
			if(i != 3 && i != 7) //3 and 7 are dashes
			{
				char c = phoneNumber.charAt(i); //IN ASCII
				if (c < '0' || c > '9') //IN ASCII
				{
					return false;
				}
			}
				
		}
		//if nothing fails, the phone number is valid
		return true;
	}


	
	
	public boolean isValidEmergencyPhoneNumber()
	{
		//.length does NOT start at 0
		if(phoneNumber.length() != 12)
		{
			return false;
		}
		
		//make sure dashes are present
		if(emergencyPhoneNumber.charAt(3) != '-' && emergencyPhoneNumber.charAt(7) != '-')
		{
			return false;
		}
		
		//make sure all other input is a digit (doesnt count both dashes, then checks if every i increment is NOT a digit, returns false if it is not a digit.
		for(int i = 0; i < emergencyPhoneNumber.length(); i++)
		{
			if(i != 3 && i != 7) //3 and 7 are dashes
			{
				char c = emergencyPhoneNumber.charAt(i); //IN ASCII
				if (c < '0' || c > '9') //IN ASCII
				{
					return false;
				}
			}
				
		}
		//if nothing fails, the phone number is valid
		return true;
		
		
	}
	
	//hasSameCityState method
	public boolean hasSameCityState(String city, String state)
	{
        if(this.city.equals(city) && this.state.equals(state)) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
	
	//updateAddress method
	public void updateAddress(String street, String city, String state, String zip)
	{
		streetAddress = street;
		this.city = city;
		this.state = state;
		zipcode = zip;
	}
	
	//getContactSummary method
	public String getContactSummary()
	{
		return("Patient Information\n" 
				+ "-------------------\n"
				+ "Name: " + buildFullName()
				+ "\nAddress: " + buildAddress()
				+ "\nPhone Number: " + phoneNumber
				+ "\nEmergency Contact: " + emergencyContactName
				+ "\nPhone Valid: " + isValidPhoneNumber()
				+ "\nEmergency Phone Valid: " + isValidEmergencyPhoneNumber());
	}

}
