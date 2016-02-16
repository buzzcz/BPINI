package prevodnik;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PrevodnikController implements Initializable {

	@FXML
	private TextField vstupTextField;
	@FXML
	private ComboBox<String> vstupComboBox;
	@FXML
	private TextField vystupTextField;
	@FXML
	private ComboBox<String> vystupComboBox;
	@FXML
	private Button prevedButton;
	@FXML
	private Button vymazButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}
