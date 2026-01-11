package org.example.samochodgui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import symulator.*;
import java.io.IOException;

public class HelloController  implements Listener{

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

    @FXML public AnchorPane mapa;

    @FXML
    public ImageView carImageView;

    private final ObservableList<Samochod> naszeAuta = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        mapa.setOnMouseClicked(event -> {
            if(mojSamochod != null) {

                double x = event.getX();
                double y = event.getY();
                Pozycja nowaPozycja = new Pozycja(x, y);
                mojSamochod.jedzDo(nowaPozycja);
            }
        });

        listaSamochodow.setItems(naszeAuta); //wiazemy liste z kontrolka

        listaSamochodow.setOnAction(_ -> {
            if( mojSamochod != null) {
                mojSamochod.removeListener(this);
            }
            mojSamochod = listaSamochodow.getSelectionModel().getSelectedItem();

            if (mojSamochod != null) {
                mojSamochod.addListener(this);
                refresh();
            } else {
                listaSamochodow.getSelectionModel().clearSelection();
            }
        });

        try {
            var resource = getClass().getResource("car-icon.jpg");
            if (resource != null) {
                Image carImage = new Image(resource.toExternalForm());
                carImageView.setImage(carImage);
                carImageView.setVisible(false);
                carImageView.setFitWidth(60);
                carImageView.setFitHeight(40);

                carImageView.setTranslateX(0);
                carImageView.setTranslateY(0);

            } else {
                System.err.println("BŁĄD: Nie znaleziono pliku car-icon.jpg w folderze resources!");
            }

        } catch (Exception e) {
            System.out.println("Nie udało się załadować obrazka! ");
        }
    }

    @FXML
    protected void onDodajNowyClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("car-add.fxml"));
            Scene scene = new Scene(loader.load());

            AddCarController addController = loader.getController();
            addController.setMainController(this);

            Stage stage = new Stage();
            stage.setTitle("Dodaj nowy samochód");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            pokazBlad(e.getMessage());
            e.printStackTrace();
        }
        wyczyscPola();
    }


    @FXML
    protected void onUsunAutoClick() {
        if (mojSamochod != null) {
            mojSamochod.removeListener(this);
            naszeAuta.remove(mojSamochod);
            mojSamochod = null;
            if (!naszeAuta.isEmpty()) {
                listaSamochodow.getSelectionModel().selectFirst();
            } else {
                listaSamochodow.getSelectionModel().clearSelection();
                wyczyscPola();
            }
        }
        refresh();
    }

    public void dodajSamochod(Samochod nowySamochod) {
        naszeAuta.add(nowySamochod);
        listaSamochodow.getSelectionModel().select(nowySamochod);

        this.mojSamochod = nowySamochod;
        nowySamochod.addListener(this);

        nowySamochod.setDaemon(true);
        nowySamochod.start();
        refresh();
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

    public void update() {
        Platform.runLater(this::refresh);
    }

    public void refresh() {
        if (mojSamochod != null) {
            wagaTextField.setText(String.valueOf(mojSamochod.getWaga()));
            nrRejestracyjnyTextField.setText(mojSamochod.getNrRejestracyjny());
            predkoscTextField.setText(String.format("%.2f", mojSamochod.predkosc));
            modelTextField.setText(mojSamochod.getModel());

            //skrzynia
            biegskrzyniaTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getAktualnyBieg()));
            nazwaskrzyniaTextField.setText(mojSamochod.getSkrzynia().getNazwa());
            cenaskrzyniaTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getCena()));
            wagaskrzyniaTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getWaga()));

            //sprzeglo
            nazwasprzegloTextField.setText(mojSamochod.getSkrzynia().getSprzeglo().getNazwa());
            cenasprzegloTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getSprzeglo().getCena()));
            stansprzegloTextField.setText(mojSamochod.getSkrzynia().getSprzeglo().getStanSprzegla() ? "Wciśnięte" : "Zwolnione");
            wagasprzegloTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getSprzeglo().getWaga()));

            //silnik
            nazwasilnikTextField.setText(String.valueOf(mojSamochod.getSilnik().getNazwa()));
            obrotysilnikTextField.setText(String.valueOf(mojSamochod.getSilnik().getObroty()));
            cenasilnikTextField.setText(String.valueOf(mojSamochod.getSilnik().getCena()));
            wagasilnikTextField.setText(String.valueOf(mojSamochod.getSilnik().getWaga()));

            carImageView.setVisible(true);
            carImageView.setTranslateX(mojSamochod.getPozycja().getX()-30);
            carImageView.setTranslateY(mojSamochod.getPozycja().getY()-20);
        }

    }

    private void pokazBlad(String wiadomosc) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Blad");
        alert.setHeaderText("Zla operacja");
        alert.setContentText(wiadomosc);
        alert.showAndWait();
    }

    private void wyczyscPola() {
        carImageView.setVisible(false);

        // Czyścimy pola główne
        modelTextField.clear();
        nrRejestracyjnyTextField.clear();
        wagaTextField.clear();
        predkoscTextField.clear();

        // Czyścimy pola skrzyni
        nazwaskrzyniaTextField.clear();
        cenaskrzyniaTextField.clear();
        wagaskrzyniaTextField.clear();
        biegskrzyniaTextField.clear();

        // Czyścimy pola sprzęgła
        nazwasprzegloTextField.clear();
        cenasprzegloTextField.clear();
        wagasprzegloTextField.clear();
        stansprzegloTextField.clear();

        // Czyścimy pola silnika
        nazwasilnikTextField.clear();
        cenasilnikTextField.clear();
        wagasilnikTextField.clear();
        obrotysilnikTextField.clear();

    }

}
