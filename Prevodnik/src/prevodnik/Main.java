package prevodnik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * Startovací metoda JavaFX aplikace. Načte Prevodnik.fxml a zobrazí ho
	 *
	 * @param primaryStage primární okno aplikace
	 * @throws Exception výjimka, která je vyhozena v případě selhání metody load
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Prevodnik.fxml"));
		primaryStage.setTitle("PřeVODNÍK");
		primaryStage.setScene(new Scene(root, 630, 550));
		primaryStage.show();
	}

	/**
	 * Hlavní metoda programu
	 *
	 * @param args vstupní parametry
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
