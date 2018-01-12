import java.util.Random;

public class YourGame extends NumberGame {
	private int upperbound;
	private int secret;
	private String hint;
	private int count;
	
	public YourGame(int upperbound) {
		this.upperbound = upperbound;
		this.secret = getRandomnumber(upperbound);
		this.hint = "I'm thinking of a number between 1 and " + upperbound;
	}
	
	int getRandomnumber(int limit) {
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		return rand.nextInt(limit) + 1;
	}
	
	@Override
	public int getUpperBound(){
		return this.upperbound;
	}

	@Override
	public boolean guess(int number) {
		this.count++;
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
	
	@Override
	public String toString() {
		return "Guess a secret number between 1 and "+upperbound;
	}
	
	@Override
	public int getCount(){
		return this.count;
	}
}