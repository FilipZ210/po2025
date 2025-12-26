package org.example.samochodgui;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import symulator.*;
import javafx.collections.ObservableList;

public class AddCarController {

    public HelloController mainController;
    @FXML public TextField modelTextField;
    @FXML public TextField registrationTextField;
    @FXML public TextField weightTextField;
    @FXML public TextField speedTextField;

    @FXML private ComboBox<Silnik> silnikComboBox;
    @FXML private ComboBox<SkrzyniaBiegow> skrzyniaComboBox;


    public void setMainController(HelloController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {

        Sprzeglo noweSprzeglo = new Sprzeglo("Standard", 10, 500, false);

        ObservableList<Silnik> silniki = FXCollections.observableArrayList(
                new Silnik("Benzyna", 200, 10000, 6000, 1000),
                new Silnik("Hybryda", 250, 20000, 8000, 1000),
                new Silnik("Elektryczny", 300, 30000, 10000, 1000)
        );

        silnikComboBox.setItems(silniki);
        silnikComboBox.getSelectionModel().selectFirst();

        ObservableList<SkrzyniaBiegow> skrzynie = FXCollections.observableArrayList(
                new SkrzyniaBiegow("5-biegów", 10, 1000, 5, noweSprzeglo),
                new SkrzyniaBiegow("6-biegów", 15, 2000, 6, noweSprzeglo),
                new SkrzyniaBiegow("7-biegów", 20, 3000, 7, noweSprzeglo)
        );

        skrzyniaComboBox.setItems(skrzynie);
        skrzyniaComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void onConfirmButton() {

        String model = modelTextField.getText();
        String nrRejestracyjny = registrationTextField.getText();
        float waga;
        int predkosc;

        try {
            waga = Float.parseFloat(weightTextField.getText());
            predkosc = Integer.parseInt(speedTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }

        Silnik nowySilnik = silnikComboBox.getValue();
        SkrzyniaBiegow nowaSkrzynia = skrzyniaComboBox.getValue();

        Samochod mojSamochod = new Samochod(model, nrRejestracyjny, waga, predkosc,
                nowaSkrzynia, nowySilnik);

        if (mainController != null) {
            mainController.dodajSamochod(mojSamochod);
        }

        closeWindow();
    }

    @FXML
    private void closeWindow() {
        Stage stage = (Stage) modelTextField.getScene().getWindow();
        stage.close();
    }
}
