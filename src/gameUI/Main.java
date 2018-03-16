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

	@Override
	public void start(Stage primaryStage) {
		PatcharapolGame game = new PatcharapolGame(200);
		
		try {
			URL url = this.getClass().getResource("GameUI.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();
			GameController controller = loader.getController();
			controller.setController(game);
			
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
		view.setTitle("Counter");
		game.addObserver(view);
		view.run();
		
		InputView input = new InputView();
		input.setTitle("Guess number");
		game.addObserver(input);
		input.run();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
