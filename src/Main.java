/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new PatcharapolGame (upperBound);
		GameSolver ui = new GameSolver( );
		int solution = ui.play( game );
		System.out.println("A secret number is "+solution);
		System.out.println("You count "+game.getCount()+" times");
	}
}
