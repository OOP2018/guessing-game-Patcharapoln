package game;
import java.util.Random;

/**
 * Game of guessing number
 * @author Patcharapol Nirunpornputta
 */
public class PatcharapolGame extends NumberGame {
	private int upperbound;
	private int secret;
	private String hint;
	private int count;
	
	/**
	 * Set an upperbound , create a secret number and provide hint for users
	 * @param upperbound the maxmimum value of this game
	 */
	public PatcharapolGame(int upperbound) {
		this.upperbound = upperbound;
		this.secret = getRandomnumber(upperbound);
		this.hint = "I'm thinking of a number between 1 and " + upperbound;
	}
	
	/**
	 * Random number from 1 to upperbound
	 * @param limit is an upperbound
	 * @return a random number
	 */
	private int getRandomnumber(int limit) {
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		return rand.nextInt(limit) + 1;
	}
	
	/**
	 * Get upperbound
	 * @return upperbound
	 */
	@Override
	public int getUpperBound(){
		return this.upperbound;
	}

	/**
	 * Check a number that users guess and provide hint to them.
	 * @return true if a guess number is equal to secret number
	 * 		   false if isn't equal
	 */
	@Override
	public boolean guess(int number) {
		this.count++;
		setChanged();
		notifyObservers(number);
		if (this.secret == number) {
			setMessage("Correct. The secret is " + this.secret);
			return true;
		} else if (number < this.secret) {
			setMessage("Sorry, your guess is too small.");
			return false;
		} else if (number > this.secret) {
			setMessage("Sorry,you're guess is too large.");
			return false;
		}
		return false;
	}
	
	/**
	 * Show a game discription
	 * @return game discription
	 */
	@Override
	public String toString() {
		return "Guess a secret number between 1 and "+upperbound;
	}
	
	/**
	 * Get a time that user guess
	 * @return a time that user guess
	 */
	@Override
	public int getCount(){
		return this.count;
	}
}