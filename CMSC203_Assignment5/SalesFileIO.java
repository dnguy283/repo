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

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class SalesFileIO {

	public static double[][] readSalesData(String filename) throws FileNotFoundException
	{
		//create an arrayList 
		ArrayList<double[]> sales = new ArrayList<>();
		
		try(Scanner fileData = new Scanner(new File(filename)))
		{
			//keep reading if there is another line for another department
			while(fileData.hasNextLine())
			{
				//store file contents in a string
				String fileOutput = fileData.nextLine();
				
				//tokenize and store in an arrayList
				String[] tokens = fileOutput.split(" ");
				
				//create an array to store the doubles
				double[] departmentSales = new double[tokens.length];
				
				//parse the strings in the file to doubles and store in the newly created array
				for(int col = 0; col < tokens.length; col++)
				{
					departmentSales[col] = Double.parseDouble(tokens[col]);
				}
				//add the departmentSales array to the ArrayList
				sales.add(departmentSales);
				
			}
		}
		
		//convert the sales ArrayList into a 2D ragged array
		double[][] allData = new double[sales.size()][];
		for(int row = 0; row < sales.size(); row++)
		{
			allData[row] = sales.get(row);
		}
		
		return allData;
	}
	
	public static void writeSummary(String filename, double[][] data) throws FileNotFoundException
	{
		try (PrintWriter outputFile = new PrintWriter(filename)) 
		{
			outputFile.printf("Total Sales: %.2f\n",  SalesDataUtility.getTotal(data));
			outputFile.printf("Average Sale: %.2f\n", SalesDataUtility.getAverage(data));
			outputFile.printf("Highest Sale: %.2f\n", SalesDataUtility.getHighestInArray(data));
			outputFile.printf("Lowest Sale: %.2f\n", SalesDataUtility.getLowestInArray(data));
			//display row totals
			for(int row = 0; row < data.length; row++)
			{
				outputFile.println("Row " + row + " total: " + SalesDataUtility.getRowTotal(data, row));
			}
			outputFile.println();
			//display column totals, but first find the max num of columns
			int maxColumns = 0;
			for(int row = 0; row < data.length; row++)
			{
				if (data[row].length > maxColumns)
				{
					maxColumns = data[row].length;
				}
			}
			for(int col = 0; col < maxColumns; col++)
			{
				outputFile.println("Column " + col + " total: " + SalesDataUtility.getColumnTotal(data, col));
			}


		}
	}
	
}
