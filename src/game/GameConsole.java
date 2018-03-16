package game;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Play guessing game on the console.
 * 
 * @author Patcharapol Nirunpornputta
 */
public class GameConsole implements Observer {
	private PatcharapolGame game;

	public GameConsole(PatcharapolGame game) {
		this.game = game;
	}

	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		// describe the game
		System.out.println(game.toString());
		// This is just an example.
		boolean correct = false;
		int guess = 0;
		while (correct == false) {
			System.out.print("Your answer? ");
			guess = console.nextInt();
			correct = game.guess(guess);
			System.out.println(game.getMessage());
		}
		return guess;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("Your guess " + game.getCount() + " times");

	}
}
