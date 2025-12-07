package org.example.samochodgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import symulator.*;

public class HelloController {

    private Samochod mojSamochod;

    @FXML private TextField modelTextField;
    @FXML private TextField nrRejestracyjnyTextField;
    @FXML private TextField wagaTextField;
    @FXML private TextField predkoscTextField;

    @FXML private Button wlaczButton;
    @FXML private Button wylaczButton;
    @FXML private Button zwiekszButton;
    @FXML private Button zmniejszButton;
    @FXML private Button dodajButton;
    @FXML private Button ujmijButton;
    @FXML private Button nacisnijButton;
    @FXML private Button zwolnijButton;
    @FXML private ComboBox<String> samochodComboBox;

    @FXML
    private ImageView carImageView;

    @FXML
    public void initialize() {
        System.out.println("HelloController initialized");

        Silnik silnik = new Silnik(7000, 0, "Turbo", "V8");
        Sprzeglo sprzeglo = new Sprzeglo(false, "Sachs", "Sportowe");
        SkrzyniaBiegow skrzynia = new SkrzyniaBiegow(0, 5, sprzeglo, "Getrag", "Manuala");
        Pozycja pozycja = new Pozycja(0, 0);

        mojSamochod = new Samochod(silnik, skrzynia, pozycja);

        Image carImage = new Image(getClass().getResource("car-icon.jpg").toExternalForm());
        System.out.println("Width: " + carImage.getWidth() + ",Height: " + carImage.getHeight());

        this.carImageView.setImage(carImage);

        this.carImageView.setFitWidth(30);
        this.carImageView.setFitHeight(20);

        this.carImageView.setTranslateX(0);
        this.carImageView.setTranslateY(0);

        refresh();
    }





    @FXML
    protected void onWlaczButton() {
        mojSamochod.wlacz();
        System.out.println("Samochód włączony (Silnik Obroty: " + mojSamochod.getSilnik().getObroty() + ")");
        refresh();
    }

    @FXML
    protected void onWylaczButton() {
        mojSamochod.wylacz();
        System.out.println("Samochód wyłączony (Bieg: " + mojSamochod.getSkrzynia().getAktualnyBieg() + ")");
        refresh();
    }


    @FXML
    protected void onZwiekszButton() {
        mojSamochod.getSkrzynia().zwiekszBieg();
        System.out.println("Zwiększono bieg na: " + mojSamochod.getSkrzynia().getAktualnyBieg());
        refresh();
    }

    @FXML
    protected void onZmniejszButton() {
        mojSamochod.getSkrzynia().zmniejszBieg();
        System.out.println("Zmniejszono bieg na: " + mojSamochod.getSkrzynia().getAktualnyBieg());
        refresh();
    }


    @FXML
    protected void onNacisnijButton() {
        mojSamochod.getSkrzynia().getSprzeglo().wcisnij();
        System.out.println("Sprzęgło wciśnięte (Stan: " + mojSamochod.getSkrzynia().getSprzeglo().isStanSprzegla() + ")");
        refresh();
    }

    @FXML
    protected void onZwolnijButton() {
        mojSamochod.getSkrzynia().getSprzeglo().zwolnij();
        System.out.println("Sprzęgło zwolnione (Stan: " + mojSamochod.getSkrzynia().getSprzeglo().isStanSprzegla() + ")");
        refresh();
    }

    @FXML
    protected void onDodajButton() {
        System.out.println("Dodano gazu.");
        refresh();
    }

    @FXML
    protected void onUjmijButton() {
        System.out.println("Ujęto gazu.");
        refresh();
    }

    void refresh() {
        wagaTextField.setText(String.valueOf(mojSamochod.getWaga()));
        nrRejestracyjnyTextField.setText(mojSamochod.getNrRejestracyjny());
        predkoscTextField.setText(String.valueOf(mojSamochod.getPredkosc()));
        modelTextField.setText(mojSamochod.getModel());


    }

}
