package gameUI;
import java.net.URL;

import game.GameConsole;
import game.PatcharapolGame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main extends Application {
	
	static int upperBound = 100;
	/**
	 * Start an user interface.
	 */
	@Override
	public void start(Stage primaryStage) {
		PatcharapolGame game = new PatcharapolGame(200);	
		try {
			URL url = this.getClass().getResource("GameUI.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();
			GameController controller = loader.getController();
			controller.setController(game);
			controller.setHint(game.getMessage());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Guessing Game");
			primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
			return;
		}

		GameConsole console = new GameConsole(game);
		game.addObserver(console);
		
		CounterView view = new CounterView(game);
		game.addObserver(view);
		view.run();
		
		InputView input = new InputView();
		game.addObserver(input);
		input.run();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
