import java.util.Scanner;


public class PatientDriverApp {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		
		Patient patient = inputPatient(keyboard);
		Procedure p1 = createProcedure1();
		Procedure p2 = createProcedure2();
		Procedure p3 = createProcedure3();
		


		System.out.println();
		displayPatient(patient);
		
		System.out.println();
		displayProcedureTable(p1, p2, p3);
		
		System.out.println();
		displaySummary(p1, p2, p3);
		

	}
	
	static Patient inputPatient(Scanner keyboard)
	{
		Patient patient1 = new Patient();
		
		System.out.print("Enter first name: ");
		patient1.setFirstName(keyboard.nextLine());
		
		System.out.print("Enter middle name: ");
		patient1.setMiddleName(keyboard.nextLine());

		System.out.print("Enter last name: ");
		patient1.setLastName(keyboard.nextLine());
		
		System.out.print("Enter street address: ");
		patient1.setStreetAddress(keyboard.nextLine());
		
		System.out.print("Enter city: ");
		patient1.setCity(keyboard.nextLine());

		System.out.print("Enter state: ");
		patient1.setState(keyboard.nextLine());
		
		System.out.print("Enter zip: ");
		patient1.setZipcode(keyboard.nextLine());
		
		System.out.print("Enter phone number (###-###-####): ");
		patient1.setPhoneNumber(keyboard.nextLine());

		System.out.print("Enter emergency contact name: ");
		patient1.setEmergencyContactName(keyboard.nextLine());
		
		System.out.print("Enter emergency contact phone (###-###-####): ");
		patient1.setEmergencyPhoneNumber(keyboard.nextLine());
		
		return patient1;
	}
	
	public static Procedure createProcedure1()
	{
		Procedure p1 = new Procedure("Physical Exam", "9/17/2026", "Dr. Taban", 250);
		return p1;
	}
	public static Procedure createProcedure2()
	{
		Procedure p2 = new Procedure("X-ray", "9/17/2026", "Dr. Nassif", 550);
		return p2;
	}
	public static Procedure createProcedure3()
	{
		Procedure p3 = new Procedure("Blood Test", "9/17/2026", "Dr. Dubrow", 1250);
		return p3;
	}
	
	public static void displayPatient(Patient patient)
	{
		System.out.println(patient.toString());
	}
	
	public static void displayProcedure(Procedure procedure)
	{
		System.out.println(procedure.toString());
	}
	
	public static void displayProcedureTable(Procedure p1, Procedure p2, Procedure p3)
	{
		System.out.println("Procedure           Date         Practitioner        Charge          Category");
		System.out.println("------------------------------------------------------------------------");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
	}
	
	public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3)
	{
		return(p1.getProcedureCharge() + p2.getProcedureCharge() + p3.getProcedureCharge());
	}

	public static double calculateAverageCharge(Procedure p1, Procedure p2, Procedure p3)
	{
		return((p1.getProcedureCharge() + p2.getProcedureCharge() + p3.getProcedureCharge())/3.0);

	}
	
	public static Procedure findHighestChargeProcedure(Procedure p1, Procedure p2, Procedure p3)
	{
		if(p1.getProcedureCharge() >= p2.getProcedureCharge() && (p1.getProcedureCharge() >= p3.getProcedureCharge()))
		{
			return p1;
		}
		if(p2.getProcedureCharge() >= p1.getProcedureCharge() && (p2.getProcedureCharge() >= p3.getProcedureCharge()))
		{
			return p2;
		}
		return p3;
	}
	
	public static int countExpensiveProcedures(Procedure p1, Procedure p2, Procedure p3)
	{
		int counter = 0;
		if (p1.isExpensiveProcedure())
		{
			counter+=1;
		}
		if (p2.isExpensiveProcedure())
		{
			counter+=1;
		}
		if (p3.isExpensiveProcedure())
		{
			counter+=1;
		}
		return counter;
	}
	
	public static void displaySummary(Procedure p1, Procedure p2, Procedure p3)
	{
		System.out.printf("Total Charges: $%,.2f", calculateTotalCharges(p1, p2, p3));
		System.out.println();
		System.out.printf("Average Charges: $%,.2f", calculateAverageCharge(p1, p2, p3));
		System.out.println();
		System.out.println("Highest Charge Procedure: "+ findHighestChargeProcedure(p1, p2, p3).getProcedureName());
		System.out.println("Number of Expensive Procedures: " + countExpensiveProcedures(p1, p2, p3));
		System.out.println();
		System.out.println("The program was developed by a Student: Daniel Nguyen 9/17/26");
		
	}
}
