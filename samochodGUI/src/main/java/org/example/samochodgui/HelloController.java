package org.example.samochodgui;

import symulator.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import symulator.Samochod;
import symulator.Silnik;
import symulator.SkrzyniaBiegow;
import symulator.Pozycja;

public class HelloController {

    public void initialize() {
        Silnik silnik = new Silnik();

    }
    @FXML
    protected void wlaczButton() {
        setText("Welcome to JavaFX Application!");
    }
}
