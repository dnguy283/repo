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

import java.util.Scanner;
public class PropertyDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creates a ManagementCompany
		Scanner keyboard = new Scanner(System.in);
		ManagementCompany company1 = new ManagementCompany("Campus Realty", "123-45-6789");
		int choice;
		
		do
		{			
			System.out.println("====================================");
			System.out.println("   Assignment 4: Property Manager");
			System.out.println("====================================");
			System.out.println("1 - Add Property");
			System.out.println("2 - Display All Properties");
			System.out.println("3 - Show Total Rent");
			System.out.println("4 - Exit");
			System.out.print("Enter choice (1-4): ");
			choice = keyboard.nextInt();
			//eat whitespace
			keyboard.nextLine();
			
			switch (choice)
			{
			case 1:
				System.out.println("Enter property name: ");
				String name = keyboard.nextLine();
				System.out.println("Enter city: ");
				String city = keyboard.nextLine();
				System.out.println("Enter monthly rent: ");
				double rent = keyboard.nextDouble();
				//eat whitespace
				keyboard.nextLine();
				System.out.println("Enter owner name: ");
				String owner = keyboard.nextLine();
				Property p = new Property(name, city, rent, owner);
				int index = company1.addProperty(p);
				if(index == -1)
				{
					System.out.println("Property amount is full, cannot add property.");
				}
				else
				{
					System.out.println("Property added at index " + index + ".");
				}
				break;
				
			case 2:
				System.out.println(company1.toString());
				break;
			case 3:
				System.out.printf("Total rent: $%.2f", company1.totalRent());
				System.out.println();
				break;
			case 4:
				return;
			default:
			    System.out.println("Invalid choice. Please try again.");
				
			}
		}while (choice != 4);
	}

}
