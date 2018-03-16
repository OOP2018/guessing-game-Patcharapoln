package game;

import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController {
	private NumberGame game;
	private static int num;
	
	@FXML
	private TextField input;
	@FXML
	private Label hint;
	
	public void setController(NumberGame game) {
		this.game = game;
	}
	public void handle(ActionEvent event) {
		num = Integer.parseInt(input.getText());
		game.guess(num);
		hint.setText(game.getMessage());
	}
	
	public static int getNum() {
		return num;
	}
}
