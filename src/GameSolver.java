import java.util.Random;
import java.util.Scanner;

public class GameSolver {

	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		int guess = game.getUpperBound()/2;
		int value = guess/2;
		System.out.println(game.toString());
		// This is just an example.
		boolean correct = false;
		int time=2;
		while (correct == false ) {
			System.out.println("Your answer? ");
			System.out.println(guess);
			correct = game.guess(guess);
			System.out.println(game.getMessage());
			if(game.getMessage().contains("too small.")){
				guess = guess + value;
			}else if(game.getMessage().contains("too large.")) {
				guess = guess - value;
			}else {
				return guess;
			}
			if(value > 1){
				value= value/2;
			}
		}
		return guess;
	}
}
