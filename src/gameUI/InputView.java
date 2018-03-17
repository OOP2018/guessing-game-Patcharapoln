package gameUI;

import java.util.Observable;
import java.util.Observer;

import game.NumberGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Create a new window which show user input number.
 * @author Patcharapol Nirunpornputta
 *
 */
public class InputView extends Stage implements Observer {

	private NumberGame game;
	private Label label = null;

	/**
	 * Initialize a InputView which show user input number.
	 */
	public InputView() {
		initComponents();
	}

	/**
	 * Update user input number.
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		displayInput();
	}

	/**
	 * For setting up a new window.
	 */
	private void initComponents() {
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		label = new Label();
		label.setPrefWidth(144);
		label.setFont(new Font("Arial", 80.0));
		label.setAlignment(Pos.CENTER);
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		this.setScene(scene);
		this.setTitle("Guess Number");
		this.sizeToScene();
	}

	/**
	 * Show user input value.
	 */
	public void displayInput() {
		label.setText(GameController.getNum()+ "");
	}

	/**
	 * Show a new window and update user input value.
	 */
	public void run() {
		this.show();
		displayInput();
	}
}
