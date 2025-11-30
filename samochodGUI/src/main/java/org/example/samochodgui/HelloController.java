package org.example.samochodgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import symulator.*;

public class HelloController {

    // Komponenty symulatora
    private Samochod mojSamochod;

    // Kontrolki FXML - przyciski
    @FXML private Button wlaczButton;
    @FXML private Button wylaczButton;
    @FXML private Button zwiekszButton;
    @FXML private Button zmniejszButton;
    @FXML private Button dodajButton;
    @FXML private Button ujmijButton;
    @FXML private Button nacisnijButton;
    @FXML private Button zwolnijButton;
    @FXML private ComboBox<String> samochodComboBox;


    public void initialize() {

        Silnik silnik = new Silnik(7000, 0, "Turbo", "V8");
        Sprzeglo sprzeglo = new Sprzeglo(false, "Sachs", "Sportowe");
        SkrzyniaBiegow skrzynia = new SkrzyniaBiegow(0, 5, sprzeglo, "Getrag", "Manuala");
        Pozycja pozycja = new Pozycja(0, 0);

        mojSamochod = new Samochod(silnik, skrzynia, pozycja);

    }


    @FXML
    protected void onWlaczButton() {
        mojSamochod.wlacz();
        System.out.println("Samochód włączony (Silnik Obroty: " + mojSamochod.getSilnik().getObroty() + ")");
    }

    @FXML
    protected void onWylaczButton() {
        mojSamochod.wylacz();
        System.out.println("Samochód wyłączony (Bieg: " + mojSamochod.getSkrzynia().getAktualnyBieg() + ")");
    }


    @FXML
    protected void onZwiekszButton() {
        mojSamochod.getSkrzynia().zwiekszBieg();
        System.out.println("Zwiększono bieg na: " + mojSamochod.getSkrzynia().getAktualnyBieg());
    }

    @FXML
    protected void onZmniejszButton() {
        mojSamochod.getSkrzynia().zmniejszBieg();
        System.out.println("Zmniejszono bieg na: " + mojSamochod.getSkrzynia().getAktualnyBieg());
    }


    @FXML
    protected void onNacisnijButton() {
        mojSamochod.getSkrzynia().getSprzeglo().wcisnij();
        System.out.println("Sprzęgło wciśnięte (Stan: " + mojSamochod.getSkrzynia().getSprzeglo().isStanSprzegla() + ")");
    }

    @FXML
    protected void onZwolnijButton() {
        mojSamochod.getSkrzynia().getSprzeglo().zwolnij();
        System.out.println("Sprzęgło zwolnione (Stan: " + mojSamochod.getSkrzynia().getSprzeglo().isStanSprzegla() + ")");
    }

    @FXML
    protected void onDodajButton() {
        // Tutaj będzie logika dodawania gazu (np. zwiększania obrotów)
        System.out.println("Dodano gazu.");
        // updateGUI(); // Pamiętaj, aby wywołać, gdy ją zaimplementujesz
    }

    @FXML
    protected void onUjmijButton() {
        // Tutaj będzie logika ujmowania gazu (np. zmniejszania obrotów)
        System.out.println("Ujęto gazu.");
        // updateGUI(); // Pamiętaj, aby wywołać, gdy ją zaimplementujesz
    }

}
