import java.util.Scanner;
public class MovieDriverTask1 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String name, rating;
		int ticketsSold;

		Movie movie1 = new Movie();
		System.out.println("Enter the name of a movie: ");
		name = keyboard.nextLine();
		movie1.setTitle(name);
		
		System.out.println("Enter the rating of the movie: ");
		rating = keyboard.nextLine();
		movie1.setRating(rating);

		System.out.println("Enter the number of tickets sold for this movie: ");
		ticketsSold = keyboard.nextInt();
		movie1.setSoldTickets(ticketsSold);
		
		System.out.println(movie1);
		
		System.out.println("Goodbye");


	}

}
