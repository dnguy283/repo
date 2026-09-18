
public class Procedure 
{

	private String procedureName;
	private String date;
	private String practitionerName;
	private double procedureCharge;
	
	//no-arg constructor
	public Procedure()
	{
		
	}
	
	//constructor that initializes procedure name and date
	public Procedure(String n, String d)
	{
		procedureName = n;
		date = d;
	}
	
	//constructor that initializes all attributes
	public Procedure(String procName, String d, String pracName, double procCharge)
	{
		procedureName = procName;
		date = d;
		practitionerName = pracName;
		procedureCharge = procCharge;
	}		
	
	//getter and setter methods for each attribute (getters first)
	public String getProcedureName()
	{
		return procedureName;
	}
	public String getDate()
	{
		return date;
	}
	public String getPracticionerName()
	{
		return practitionerName;
	}
	public double getProcedureCharge()
	{
		return procedureCharge;
	}
	
	
	
	//setter methods
		public void setProcedureName(String pN)
		{
			procedureName = pN;
		}
		public void setDate(String d)
		{
			date = d;
		}
		public void setPracticionerName(String pN)
		{
			practitionerName = pN;
		}
		public void setProcedureCharge(double pC)
		{
			procedureCharge = pC;
		}
		
		//toString method
		public String toString()
		{
			return String.format("%13s %13s %13s %13s %13s", procedureName, date, practitionerName, getFormattedCharge(), getChargeCategory());
		}
		
		
		//isExpensiveProcedure() method
	    public boolean isExpensiveProcedure()
	    {
	        if(procedureCharge >= 1000) 
	        {
	            return true;
	        }
	        else 
	        {
	            return false;
	        }
	    }
	    
		//applyDiscount(double percent) method
	    public void applyDiscount(double percent)
	    {
	    	if (percent > 0 && percent < 100)
	    	{
	    		procedureCharge = procedureCharge - procedureCharge*(percent/100);
	    	}
	    }
	    
		//getChargeCategory() method
		public String getChargeCategory()
		{
			if (procedureCharge < 500)
			{
				return("Low");
			}
			if (procedureCharge >= 500 && procedureCharge < 1000)
			{
				return("Medium");
			}
			return("High");
		}
		
		//isPerformedBy(String practitionerName) method
		public boolean isPerformedBy(String practitionerName)
		{
			if (this.practitionerName == practitionerName)
			{
				return true;
			}
			return false;
		}
		
		//getFormattedCharge() method
		public String getFormattedCharge()
		{
			return String.format("$%,.2f", procedureCharge);
		}

}