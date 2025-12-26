package org.example.samochodgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import symulator.*;
import java.io.IOException;

public class HelloController {

    private Samochod mojSamochod;

    @FXML public TextField modelTextField;
    @FXML public TextField nrRejestracyjnyTextField;
    @FXML public TextField wagaTextField;
    @FXML public TextField predkoscTextField;

    @FXML public TextField nazwaskrzyniaTextField;
    @FXML public TextField cenaskrzyniaTextField;
    @FXML public TextField wagaskrzyniaTextField;
    @FXML public TextField biegskrzyniaTextField;

    @FXML public TextField nazwasprzegloTextField;
    @FXML public TextField cenasprzegloTextField;
    @FXML public TextField wagasprzegloTextField;
    @FXML public TextField stansprzegloTextField;

    @FXML public TextField nazwasilnikTextField;
    @FXML public TextField cenasilnikTextField;
    @FXML public TextField wagasilnikTextField;
    @FXML public TextField obrotysilnikTextField;

    @FXML public Button wlaczButton;
    @FXML public Button wylaczButton;
    @FXML public Button zwiekszButton;
    @FXML public Button zmniejszButton;
    @FXML public Button dodajButton;
    @FXML public Button ujmijButton;
    @FXML public Button nacisnijButton;
    @FXML public Button zwolnijButton;
    @FXML public ComboBox<Samochod> listaSamochodow;


    @FXML
    public ImageView carImageView;

    private ObservableList<Samochod> naszeAuta = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listaSamochodow.setItems(naszeAuta); //wiazemy liste z kontrolka

        listaSamochodow.setOnAction(e -> {
            mojSamochod = listaSamochodow.getSelectionModel().getSelectedItem();
            refresh();
        });

        try {
            // Ścieżka musi odpowiadać lokalizacji pliku w folderze resources (np. resources/images/car.png)
            Image carImage = new Image(getClass().getResource("/images/car.png").toExternalForm());

            System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());

            carImageView.setImage(carImage);
            carImageView.setFitWidth(30); // Szerokość ikonki
            carImageView.setFitHeight(20); // Wysokość ikonki

            // Ustawienie pozycji początkowej (0,0) na AnchorPane
            carImageView.setTranslateX(0);
            carImageView.setTranslateY(0);
        } catch (Exception e) {
            System.out.println("Nie udało się załadować obrazka! Sprawdź czy plik jest w folderze resources/images/");
        }
    }

    @FXML
    protected void onDodajNowyClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("car-add.fxml")); // Upewnij się co do nazwy pliku .fxml
            Scene scene = new Scene(loader.load());

            AddCarController addController = loader.getController();
            addController.setMainController(this);

            Stage stage = new Stage();
            stage.setTitle("Dodaj nowy samochód");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void onUsunAutoClick() {
        if (mojSamochod != null) {
            naszeAuta.remove(mojSamochod);
            if (!naszeAuta.isEmpty()) {
                listaSamochodow.getSelectionModel().selectFirst();
            }
        }
    }

    public void dodajSamochod(Samochod nowySamochod) {
        naszeAuta.add(nowySamochod);
        listaSamochodow.getSelectionModel().select(nowySamochod);
    }

    @FXML
    protected void onWlaczButton() {
        mojSamochod.wlacz();
        System.out.println("Samochód włączony");
        refresh();
    }

    @FXML
    protected void onWylaczButton() {
        mojSamochod.wylacz();
        System.out.println("Samochód wyłączony");
        refresh();
    }


    @FXML
    protected void onZwiekszButton() {
        mojSamochod.getSkrzynia().zwiekszBieg();
        refresh();
    }

    @FXML
    protected void onZmniejszButton() {
        mojSamochod.getSkrzynia().zmniejszBieg();
        refresh();
    }


    @FXML
    protected void onNacisnijButton() {
        mojSamochod.getSkrzynia().getSprzeglo().wcisnij();
        System.out.println("Sprzęgło wciśnięte (Stan: " + mojSamochod.getSkrzynia().getSprzeglo().getStanSprzegla() + ")");
        refresh();
    }

    @FXML
    protected void onZwolnijButton() {
        mojSamochod.getSkrzynia().getSprzeglo().zwolnij();
        System.out.println("Sprzęgło zwolnione (Stan: " + mojSamochod.getSkrzynia().getSprzeglo().getStanSprzegla() + ")");
        refresh();
    }

    @FXML
    protected void onDodajButton() {
       mojSamochod.getSilnik().zwiekszObroty();
        refresh();
    }

    @FXML
    protected void onUjmijButton() {
        mojSamochod.getSilnik().zmniejszObroty();
        refresh();
    }

    void refresh() {
        wagaTextField.setText(String.valueOf(mojSamochod.getWaga()));
        nrRejestracyjnyTextField.setText(mojSamochod.getNrRejestracyjny());
        predkoscTextField.setText(String.valueOf(mojSamochod.getPredkosc()));
        modelTextField.setText(mojSamochod.getModel());

        //skrzynia
        biegskrzyniaTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getAktualnyBieg()));
        nazwaskrzyniaTextField.setText(mojSamochod.getSkrzynia().getNazwa());
        cenaskrzyniaTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getCena()));
        wagaskrzyniaTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getWaga()));

        //sprzeglo
        nazwasprzegloTextField.setText(mojSamochod.getSkrzynia().getSprzeglo().getNazwa());
        cenasprzegloTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getSprzeglo().getCena()));
        stansprzegloTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getSprzeglo().getStanSprzegla()));
        wagasprzegloTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getSprzeglo().getWaga()));

        //silnik
        nazwasilnikTextField.setText(String.valueOf(mojSamochod.getSilnik().getNazwa()));
        obrotysilnikTextField.setText(String.valueOf(mojSamochod.getSilnik().getObroty()));
        cenasilnikTextField.setText(String.valueOf(mojSamochod.getSilnik().getCena()));
        wagasilnikTextField.setText(String.valueOf(mojSamochod.getSilnik().getWaga()));

    }

}
