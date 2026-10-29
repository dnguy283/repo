/*
 * Class: CMSC-203-23011
 * Instructor: Huseyin Aygun
 * Description: (The SalesAppDriver helps ask the user for input and output file names and use SalesFileIO + SalesDataUtility to display the results. SalesAppFX helps serve to display the information in GUIs. SalesDataUtility helps perform ragged array operations. SalesDataUtilityTest helps perform JUnit tests on the program to ensure that the methods work as intended. SalesFileIO helps read and write file information) 
 * Due: 11/16/2026 
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Daniel Nguyen
*/
public class SalesDataUtility {
	
	public static double getTotal(double[][] data)
	{	
		double total = 0;
		for(int row = 0; row < data.length; row++)
		{			
			for(int col = 0; col < data[row].length; col++)
			{
				total+= data[row][col];
			}
		}
		return total;
	}
	
	public static double getAverage(double[][] data)
	{
		double total = 0;
		int entryCount = 0;
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				total+= data[row][col];
				entryCount++;
			}
		}
		return total/entryCount;
	}
	
	public static double getRowTotal(double[][] data, int row)
	{
		double total = 0;
		for(int col = 0; col < data[row].length; col++)
		{
			total+= data[row][col];
		}
		return total;
	}
	
	public static double getColumnTotal(double[][] data, int col)
	{
		double total = 0;
		for(int row = 0; row < data.length; row++)
		{
			//SKIP ROWS FOR A COLUMN IF IT DOESNT HAVE DATA
			if(col < data[row].length)
			{
				total+= data[row][col];
			}
		}
		return total;
	}
	
	public static double getHighestInRow(double[][] data, int row)
	{
		double highest = data[row][0];
		for(int col = 1; col < data[row].length; col++)
		{
			if(highest < data[row][col])
			{
				highest = data[row][col];
			}
		}
		return highest;
	}
	
	public static double getLowestInRow(double[][] data, int row)
	{
		double lowest = data[row][0];
		for(int col = 1; col < data[row].length; col++)
		{
			if(lowest > data[row][col])
			{
				lowest = data[row][col];
			}
		}
		return lowest;
	}
	
	public static double getHighestInArray(double[][] data)
	{	
		double highest = data[0][0];
		for(int row = 0; row < data.length; row++)
		{			
			for(int col = 0; col < data[row].length; col++)
			{
				if(highest < data[row][col])
				{
					highest = data[row][col];
				}
			}
		}
		return highest;
	}
	
	public static double getLowestInArray(double[][] data)
	{	
		double lowest = data[0][0];
		for(int row = 0; row < data.length; row++)
		{			
			for(int col = 0; col < data[row].length; col++)
			{
				if(lowest > data[row][col])
				{
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}
	
}


