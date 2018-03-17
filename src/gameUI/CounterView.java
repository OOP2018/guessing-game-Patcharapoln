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
 * Create a new window which count number of times that user guess.
 * 
 * @author Patcharapol Nirunpornputta
 *
 */
public class CounterView extends Stage implements Observer {
	private Label label = null;
	private NumberGame game;

	/**
	 * Initialize a CounterView which show a number of times that user guess.
	 * 
	 * @param game
	 *            is a number game.
	 */
	public CounterView(NumberGame game) {
		this.game = game;
		initComponents();
	}

	/**
	 * Update a number of times that user guess.
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		displayCount();
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
		this.setTitle("Counter");
		this.sizeToScene();
	}

	/**
	 * Show a number of times that user guess on a window.
	 */
	public void displayCount() {
		label.setText(game.getCount() + "");
	}

	/**
	 * Show and windows and update a number.
	 */
	public void run() {
		this.show();
		displayCount();
	}
}
