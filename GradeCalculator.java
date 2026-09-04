/*
 Class: CMSC-203-23011
 Program: Assignment #1
 Instructor: Huseyin Aygun
 Summary of Description: Create a simple grade calculator that displays the students name, course, weighting, averages, and letter grade. 
 Due Date: MM/DD/YYYY 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student Name: Daniel Nguyen
 */


import java.util.Scanner;
import java.io.*;


public class GradeCalculator {

	public static void main(String[] args) throws FileNotFoundException
	{
		//use try-with-resources statement to open all three files for reading and writing (last file is for writing
		try (Scanner gradesInput = new Scanner(new File("grades_input.txt")); Scanner configInput = new Scanner(new File("gradeconfig.txt")); PrintWriter outputFile = new PrintWriter("grades_report.txt"))
		{
			double overallAverage = 0;
			String firstName = gradesInput.nextLine();
			String lastName = gradesInput.nextLine();
			String course = configInput.nextLine();
			//write course name to file
			outputFile.println("Course Name: " + course);
			//write full name to file
			outputFile.println("Student Full Name: " + firstName + " " + lastName);
			int categoryQuantity = configInput.nextInt();
			
			configInput.nextLine();
			configInput.next(); //use to skip the category name and just grab the weighting (skips "Project" in this case and allows 40 to be read instead
			int category1weight = configInput.nextInt();
			configInput.nextLine();
			configInput.next();
			int category2weight = configInput.nextInt();
			configInput.nextLine();
			configInput.next();
			int category3weight = configInput.nextInt();
			
			
			
			
			System.out.println("========================================");
			System.out.println("   CMSC203 Project 1 - Grade Calculator");
			System.out.println("========================================");
			System.out.println();

			System.out.println("Loading configuration from gradeconfig.txt ...");

			String configLoaded = "Fail";
			if (new File("gradeconfig.txt").exists())
			{
				System.out.println("Configuration loaded successfully.");
				configLoaded = "True";
			}
			else
			{
				System.out.println("Configuration failed to load successfully.");
				configLoaded = "False";
			}
			
			System.out.println();
			System.out.println("Using input file: grades_input.txt");
			System.out.println("Using output file: grades_report.txt");
			
			System.out.println();
			System.out.println("Reading student scores...");
			
			System.out.println();
			System.out.println("Student: " + firstName + " " + lastName);
			System.out.println("Course: " + course);
			System.out.println();
			
			
			
			
			
			
			for (int i = 0; i < 3; i++) // run through the category, number of scores in that category, and the scores on that line and sum it
			{
				String category = gradesInput.nextLine();
				int numOfScores = gradesInput.nextInt();
				int categoryWeight = 0;
				
				if (i == 0)
				{
					categoryWeight = category1weight;
				}
				else if (i == 1)
				{
					categoryWeight = category2weight;
				}
				else if (i == 2)
				{
					categoryWeight = category3weight;
				}
				
				
				double score, categoryScore = 0;
				
				for (int j = 0; j < numOfScores; j++)
				{
					score = gradesInput.nextDouble();
					categoryScore += score;
				}
				
				//display the category and the average
				System.out.println("Category Results:");
				//NEW; DID NOT LEARN
				System.out.printf("%s (%d%%): average = %.2f", category, categoryWeight ,categoryScore/numOfScores);
				System.out.println();
				//CALCULATE OVERALL AVERAGE USING FORMULA
				overallAverage += (categoryScore/numOfScores)*categoryWeight/100;
				gradesInput.nextLine();
				System.out.println();
				
				//write category name, average, and weight to file
				outputFile.println("Category: " + category);
				outputFile.println("Average: " + categoryScore/numOfScores);
				outputFile.println("Weight: " + categoryWeight);
			}
			
			//write overall numeric average to file
			outputFile.printf("Overall numeric average: %.2f", overallAverage);
			outputFile.println();
			
			char choice;
			//VALIDATE CHOICE INPUT
			do 
			{
				System.out.print("Apply +/- grading? (Y/N): ");
				Scanner input = new Scanner(System.in);
				choice = input.next().charAt(0);
			} while ( choice != 'Y' && choice != 'N');

			System.out.println();
			
			System.out.printf("Overall numeric average: %.2f", overallAverage);
			System.out.println();
			
			//CALCULATE LETTER GRADE
			String letterGrade;
			if (overallAverage <= 100 && overallAverage >= 95)
			{
			    letterGrade = "A+";
			}
			else if (overallAverage < 95 && overallAverage >= 90)
			{
			    letterGrade = "A-";
			}
			else if (overallAverage < 90 && overallAverage >= 85)
			{
			    letterGrade = "B+";
			}
			else if (overallAverage < 85 && overallAverage >= 80)
			{
			    letterGrade = "B-";
			}
			else if (overallAverage < 80 && overallAverage >= 75)
			{
			    letterGrade = "C+";
			}
			else if (overallAverage < 75 && overallAverage >= 70)
			{
			    letterGrade = "C-";
			}
			else if (overallAverage < 70 && overallAverage >= 65)
			{
			    letterGrade = "D+";
			}
			else if (overallAverage < 65 && overallAverage >= 60)
			{
			    letterGrade = "D-";
			}
			else
			{
				letterGrade = "F";
			}
			
			//Format letter grade based on user choice
			if (choice == 'Y')
			{
				System.out.println("Base letter grade: " + letterGrade.charAt(0));
				System.out.println("Final letter grade: " + letterGrade);
				System.out.println();
				//write final letter grade to file
				outputFile.println("Final letter grade: " + letterGrade);

			}
			else
			{
				System.out.println("Base letter grade: " + letterGrade.charAt(0));
				System.out.println("Final letter grade: " + letterGrade.charAt(0));
				System.out.println();
				//write final letter grade to file
				outputFile.println("Final letter grade: " + letterGrade.charAt(0));
			}
			

			
			System.out.println("Summary written to grades_report.txt");
			System.out.println("Program complete. Goodbye!");
			
			//write to file if the default configuration was used
			outputFile.println("Default Configuration used: " + configLoaded);

			

		}
		

	}

}
