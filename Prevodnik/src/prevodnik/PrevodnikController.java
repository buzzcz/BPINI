package prevodnik;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class PrevodnikController implements Initializable {

	@FXML
	private VBox chybyVBox;
	@FXML
	private Label chybaLabel;
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
		prevedButton.setOnAction(e -> {
			chybyVBox.setVisible(false);
			chybyVBox.setManaged(false);
			if (kontrolaVstupu()) {
				preved();
			} else {
				chybyVBox.setManaged(true);
				chybyVBox.setVisible(true);
			}
		});

		vymazButton.setOnAction(e -> {
			chybyVBox.setVisible(false);
			chybyVBox.setManaged(false);
			vstupTextField.setText("");
			vystupTextField.setText("");
		});
	}

	private boolean kontrolaVstupu() {
		String s = vstupTextField.getText();
		s = s.replaceAll(",", ".");
		if (s.trim().isEmpty()) {
			chybaLabel.setText("Nebylo zadáno žádné číslo pro převod");

			return false;
		}
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			chybaLabel.setText("Vstupní číslo není validní (není zapsáno v podporovaném formátu nebo obsahuje " +
					"nepovolené znaky - viz nápověda).");
			return false;
		}
	}

	private void preved() {
		double vysledek = Double.parseDouble(vstupTextField.getText().replaceAll(",", "."));
		if (vstupComboBox.getSelectionModel().getSelectedIndex() == vystupComboBox.getSelectionModel()
				.getSelectedIndex()) {
			vystupTextField.setText(vysledek + "");
			return;
		}
		switch (vstupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				prevedCm(vysledek);
				break;
			case 1:
			case 3:
				prevedIn(vysledek);
				break;
			case 2:
				prevedFt(vysledek);
				break;
			case 4:
				prevedM(vysledek);
				break;
			case 5:
				prevedMm(vysledek);
				break;
			case 6:
				prevedYd(vysledek);
				break;
		}
	}

	private void prevedCm(double vysledek) {
		switch (vystupComboBox.getSelectionModel().getSelectedIndex()) {
			case 1:
				vystupTextField.setText(vysledek / 2.54 + "");
				break;
			case 2:
				vystupTextField.setText(vysledek / 30.48 + "");
				break;
			case 3:
				vystupTextField.setText(vysledek / 2.54 + "");
				break;
			case 4:
				vystupTextField.setText(vysledek / 100 + "");
				break;
			case 5:
				vystupTextField.setText(vysledek * 10 + "");
				break;
			case 6:
				vystupTextField.setText(vysledek / 91.44 + "");
				break;
		}
	}

	private void prevedIn(double vysledek) {
		switch (vystupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				vystupTextField.setText(vysledek * 2.54 + "");
				break;
			case 1:
			case 3:
				vystupTextField.setText(vysledek + "");
				break;
			case 2:
				vystupTextField.setText(vysledek / 12 + "");
				break;
			case 4:
				vystupTextField.setText(vysledek * 0.0254 + "");
				break;
			case 5:
				vystupTextField.setText(vysledek * 25.4 + "");
				break;
			case 6:
				vystupTextField.setText(vysledek / 36 + "");
				break;
		}
	}

	private void prevedFt(double vysledek) {
		switch (vystupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				vystupTextField.setText(vysledek * 30.48 + "");
				break;
			case 1:
			case 3:
				vystupTextField.setText(vysledek * 12 + "");
				break;
			case 4:
				vystupTextField.setText(vysledek * 0.3048 + "");
				break;
			case 5:
				vystupTextField.setText(vysledek * 304.8 + "");
				break;
			case 6:
				vystupTextField.setText(vysledek / 3 + "");
				break;
		}
	}

	private void prevedM(double vysledek) {
		switch (vystupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				vystupTextField.setText(vysledek * 100 + "");
				break;
			case 1:
			case 3:
				vystupTextField.setText(vysledek / 0.0254 + "");
				break;
			case 2:
				vystupTextField.setText(vysledek / 0.3048 + "");
				break;
			case 5:
				vystupTextField.setText(vysledek * 1000 + "");
				break;
			case 6:
				vystupTextField.setText(vysledek / 0.9144 + "");
				break;
		}
	}

	private void prevedMm(double vysledek) {
		switch (vystupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				vystupTextField.setText(vysledek * 0.1 + "");
				break;
			case 1:
			case 3:
				vystupTextField.setText(vysledek / 25.4 + "");
				break;
			case 2:
				vystupTextField.setText(vysledek / 304.8 + "");
				break;
			case 4:
				vystupTextField.setText(vysledek * 0.001 + "");
				break;
			case 6:
				vystupTextField.setText(vysledek / 914.4 + "");
				break;
		}
	}

	private void prevedYd(double vysledek) {
		switch (vystupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				vystupTextField.setText(vysledek * 91.44 + "");
				break;
			case 1:
			case 3:
				vystupTextField.setText(vysledek * 36 + "");
				break;
			case 2:
				vystupTextField.setText(vysledek * 3 + "");
				break;
			case 4:
				vystupTextField.setText(vysledek * 0.9144 + "");
				break;
			case 5:
				vystupTextField.setText(vysledek * 914.4 + "");
				break;
		}
	}
}
