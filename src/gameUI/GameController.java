package gameUI;

import java.util.Observable;
import java.util.Observer;

import game.NumberGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * A controller of UI that handle user input and set hint for a user.
 * @author Patcharapol Nirunpornputta
 *
 */
public class GameController {
	private NumberGame game;
	private static int num;
	
	@FXML
	private TextField input;
	@FXML
	private Label hint;
	
	/**
	 * Set controller to work for NumberGame.
	 * @param game
	 */
	public void setController(NumberGame game) {
		this.game = game;
	}
	
	/**
	 * Handle user input.
	 * @param event is an action of user for example press enter.
	 */
	public void handle(ActionEvent event) {
		num = Integer.parseInt(input.getText());
		game.guess(num);
		this.setHint(game.getMessage());
	}
	
	/**
	 * @return number that user input.
	 */
	public static int getNum() {
		return num;
	}
	
	/**
	 * Set hint for users.
	 * @param hint
	 */
	public void setHint(String hint) {
		this.hint.setText(hint);
	}
}
