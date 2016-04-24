package prevodnik;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class PrevodnikController implements Initializable {

	/**
	 * Grafické prvky formuláře
	 */
	@FXML
	private VBox chybyVBox;
	@FXML
	private HBox chybaKostkaHBox;
	@FXML
	private Label chybaKostkaLabel;
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

	/**
	 * Inicializační metoda formuláře. Nastaví akce tlačítek při spuštění aplikace
	 *
	 * @param location  location
	 * @param resources resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prevedButton.setOnAction(e -> {
			chybyVBox.setVisible(false);
			chybyVBox.setManaged(false);
			vstupTextField.setStyle("");
			vystupTextField.setText("");
			if (kontrolaVstupu()) preved();
			vstupTextField.requestFocus();
			vstupTextField.positionCaret(0);
		});

		vymazButton.setOnAction(e -> {
			chybyVBox.setVisible(false);
			chybyVBox.setManaged(false);
			vstupTextField.setStyle("");
			vstupTextField.setText("");
			vstupTextField.requestFocus();
		});
	}

	/**
	 * Provádí kontrolu vstupu
	 *
	 * @return <code>true</code> pokud je vstup vpořádku; <code>false</code> pokud není
	 */
	private boolean kontrolaVstupu() {
		String s = vstupTextField.getText();
		s = s.replaceAll(",", ".");
		if (s.trim().isEmpty()) {
			chybaKostkaHBox.setAlignment(Pos.CENTER_LEFT);
			chybaKostkaLabel.setText("■");
			chybaLabel.setText("Nebylo zadáno žádné číslo pro převod");
			vstupTextField.setStyle("-fx-border-color: red;");
			chybyVBox.setManaged(true);
			chybyVBox.setVisible(true);
			return false;
		}
		try {
			double d = Double.parseDouble(s);
			if (d < 0) {
				chybaKostkaHBox.setAlignment(Pos.CENTER_LEFT);
				chybaKostkaLabel.setText("■");
				chybaLabel.setText("Zadané číslo je záporné");
				vstupTextField.setStyle("-fx-border-color: red;");
				chybyVBox.setManaged(true);
				chybyVBox.setVisible(true);
				return true;
			}
			return true;
		} catch (NumberFormatException e) {
			chybaKostkaHBox.setAlignment(Pos.TOP_LEFT);
			chybaKostkaLabel.setText("\n■");
			chybaLabel.setText("Vstupní číslo není validní (není zapsáno v podporovaném formátu nebo obsahuje " +
					"nepovolené znaky - viz nápověda).");
			vstupTextField.setStyle("-fx-border-color: red;");
			chybyVBox.setManaged(true);
			chybyVBox.setVisible(true);
			return false;
		}
	}

	/**
	 * Metoda, která provede převod hodnot
	 */
	private void preved() {
		double vysledek = Double.parseDouble(vstupTextField.getText().replaceAll(",", "."));
		if (vysledek == 1.7e308) {
			vystupTextField.setText("Infinity");
			return;
		}

		switch (vstupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				vysledek = prevedCm(vysledek);
				break;
			case 1:
			case 3:
				vysledek = prevedIn(vysledek);
				break;
			case 2:
				vysledek = prevedFt(vysledek);
				break;
			case 4:
				vysledek = prevedM(vysledek);
				break;
			case 5:
				vysledek = prevedMm(vysledek);
				break;
			case 6:
				vysledek = prevedYd(vysledek);
				break;
		}
		vystupTextField.setText(vysledek + "");
	}

	/**
	 * Metoda, která provádí převod centimetrů na ostatní jednotky
	 *
	 * @param vysledek hodnota, která má být převedena
	 * @return hodnota převedená v závislosti na vybrané výstupní jednotce
	 */
	private double prevedCm(double vysledek) {
		switch (vystupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				return vysledek;
			case 1:
			case 3:
				return vysledek / 2.54;
			case 2:
				return vysledek / 30.48;
			case 4:
				return vysledek / 100;
			case 5:
				return vysledek * 10;
			case 6:
				return vysledek / 91.44;
			default:
				return 0;
		}
	}

	/**
	 * Metoda, která provádí převod palců na ostatní jednotky
	 *
	 * @param vysledek hodnota, která má být převedena
	 * @return hodnota převedená v závislosti na vybrané výstupní jednotce
	 */
	private double prevedIn(double vysledek) {
		switch (vystupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				return vysledek * 2.54;
			case 1:
			case 3:
				if (vysledek == 3) return 2.9999999999999996;
				return vysledek;
			case 2:
				return vysledek / 12;
			case 4:
				return vysledek * 0.0254;
			case 5:
				return vysledek * 25.4;
			case 6:
				return vysledek / 36;
			default:
				return 0;
		}
	}

	/**
	 * Metoda, která provádí převod stop na ostatní jednotky
	 *
	 * @param vysledek hodnota, která má být převedena
	 * @return hodnota převedená v závislosti na vybrané výstupní jednotce
	 */
	private double prevedFt(double vysledek) {
		switch (vystupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				return vysledek * 30.48;
			case 1:
			case 3:
				return vysledek * 12;
			case 2:
				return vysledek;
			case 4:
				return vysledek * 0.3048;
			case 5:
				return vysledek * 304.8;
			case 6:
				return vysledek / 3;
			default:
				return 0;
		}
	}

	/**
	 * Metoda, která provádí převod metrů na ostatní jednotky
	 *
	 * @param vysledek hodnota, která má být převedena
	 * @return hodnota převedená v závislosti na vybrané výstupní jednotce
	 */
	private double prevedM(double vysledek) {
		switch (vystupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				return vysledek * 100;
			case 1:
			case 3:
				return vysledek / 0.0254;
			case 2:
				return vysledek / 0.3048;
			case 4:
				return vysledek;
			case 5:
				return vysledek * 1000;
			case 6:
				return vysledek / 0.9144;
			default:
				return 0;
		}
	}

	/**
	 * Metoda, která provádí převod milimetrů na ostatní jednotky
	 *
	 * @param vysledek hodnota, která má být převedena
	 * @return hodnota převedená v závislosti na vybrané výstupní jednotce
	 */
	private double prevedMm(double vysledek) {
		switch (vystupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				return vysledek * 0.1;
			case 1:
			case 3:
				return vysledek / 25.4;
			case 2:
				return vysledek / 304.8;
			case 4:
				return vysledek * 0.001;
			case 5:
				return vysledek;
			case 6:
				return vysledek / 914.4;
			default:
				return 0;
		}
	}

	/**
	 * Metoda, která provádí převod yardů na ostatní jednotky
	 *
	 * @param vysledek hodnota, která má být převedena
	 * @return hodnota převedená v závislosti na vybrané výstupní jednotce
	 */
	private double prevedYd(double vysledek) {
		switch (vystupComboBox.getSelectionModel().getSelectedIndex()) {
			case 0:
				return vysledek * 91.44;
			case 1:
			case 3:
				return vysledek * 36;
			case 2:
				return vysledek * 3;
			case 4:
				return vysledek * 0.9144;
			case 5:
				return vysledek * 914.4;
			case 6:
				return vysledek;
			default:
				return 0;
		}
	}
}
