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

import java.io.FileNotFoundException;
import java.util.Scanner;
public class SalesAppDriver {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//ask user for input and output file names
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the input file name?: ");
		String inputFile = keyboard.nextLine();
		System.out.println("What is the output file name?: ");
		String outputFile = keyboard.nextLine();
		
		//Uses SalesFileIO to read data and write summary
		double[][] infoArray = SalesFileIO.readSalesData(inputFile);
		
		//then write
		SalesFileIO.writeSummary(outputFile, infoArray);
		
		//display sales with SalesDataUtility
		System.out.printf("Total Sales: %.2f\n",  SalesDataUtility.getTotal(infoArray));
		System.out.printf("Average Sale: %.2f\n", SalesDataUtility.getAverage(infoArray));
		System.out.printf("Highest Sale: %.2f\n", SalesDataUtility.getHighestInArray(infoArray));
		System.out.printf("Lowest Sale: %.2f\n", SalesDataUtility.getLowestInArray(infoArray));

		
		//display row totals
		for(int row = 0; row < infoArray.length; row++)
		{
			System.out.printf("Row %s total: %.2f\n", row, SalesDataUtility.getRowTotal(infoArray, row));
		}
		System.out.println();
		//display column totals, but first find the max num of columns
		int maxColumns = 0;
		for(int row = 0; row < infoArray.length; row++)
		{
			if (infoArray[row].length > maxColumns)
			{
				maxColumns = infoArray[row].length;
			}
		}
		for(int col = 0; col < maxColumns; col++)
		{
			System.out.printf("Column %s total: %.2f\n", col, SalesDataUtility.getColumnTotal(infoArray, col));
		}

	}

}
