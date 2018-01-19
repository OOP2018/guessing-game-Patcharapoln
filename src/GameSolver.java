import java.util.Random;
import java.util.Scanner;

/**
 * Automatically find the secret to any NumberGame
 * 
 * @author Patcharapol Nirunpornputta
 */
public class GameSolver {
	/**
	 * play the game
	 * 
	 * @param game
	 *            a game that users want to play
	 * @return a secret number guess by users
	 */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		int guess = 0, value = 0;
		if (game.getUpperBound() == 1)
			guess = game.getUpperBound();
		else
			guess = game.getUpperBound() / 2;
		if (guess / 2 < 1) {
			value = (int) Math.ceil((double) guess / 2);
		} else
			value = guess / 2;
		boolean correct = false;
		while (correct == false) {
			correct = game.guess(guess);
			if (game.getMessage().contains("too small.")) {
				guess = guess + value;
			} else if (game.getMessage().contains("too large.")) {
				guess = guess - value;
			}
			if (value > 1) {
				value = value / 2;
			}
		}
		return guess;
	}
}
