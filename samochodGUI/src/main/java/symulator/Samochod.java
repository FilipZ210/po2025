package symulator;

import java.util.ArrayList;
import java.util.List;

public class Samochod extends Thread  {

    public Silnik silnik;
    public SkrzyniaBiegow skrzynia;
    public Pozycja cel;
    public Pozycja  pozycja;
    public String model;
    public String nrRejestracyjny;
    public int predkoscMax;
    public double predkosc = 0;
    public float waga;

    public List<Listener> listeners = new ArrayList<>();

    public Samochod(String model, String nrRejestracyjny,float waga, int predkoscMax, SkrzyniaBiegow skrzynia, Silnik silnik ) {
        this.model = model;
        this.nrRejestracyjny = nrRejestracyjny;
        this.waga = waga;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.predkoscMax = predkoscMax;

        this.pozycja = new Pozycja(0,0);

    }

    public void wlacz() {
        silnik.uruchom();
        System.out.println("Samochod wlaczony");
    }

    public void wylacz() {
        silnik.zatrzymaj();
        skrzynia.aktualnyBieg = 0;
        System.out.println("Samochod wylaczony");
    }

    public void jedzDo(Pozycja position) {
        this.cel = position;
    }

    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }

    public Silnik getSilnik() {
        return silnik;
    }
    public String getModel() {
        return this.model;
    }

    public double getWaga() {
        return this.waga;
    }

    public String getNrRejestracyjny() {
        return this.nrRejestracyjny;
    }

    public Pozycja getPozycja() {
        return pozycja;
    }

    @Override
    public String toString() {
        return this.model + " (" + this.nrRejestracyjny + ")";
    }

    public void naszaPredkosc() {
        if (skrzynia.getSprzeglo().getStanSprzegla() || skrzynia.getAktualnyBieg() == 0) {
            predkosc = 0;
        } else {
            double obroty = silnik.getObroty();
            int aktualnyBieg = skrzynia.getAktualnyBieg();
            double obliczonaPredkosc = (obroty * aktualnyBieg) / 300.0;

            if (obliczonaPredkosc > predkoscMax) {
                obliczonaPredkosc = predkoscMax;
            }
            this.predkosc = obliczonaPredkosc;
        }
    }

    @Override
    public void run() {
        double deltat = 0.1;
        while (true) {
            try {
                naszaPredkosc();
                if (cel != null && predkosc > 0) {
                    double odleglosc = Math.sqrt(Math.pow(cel.x - pozycja.x, 2) + Math.pow(cel.y - pozycja.y, 2));

                    if(odleglosc > predkosc * deltat) {
                        double dx = predkosc * deltat * (cel.x - pozycja.x) / odleglosc;
                        double dy = predkosc * deltat * (cel.y - pozycja.y) / odleglosc;
                        pozycja.x += dx;
                        pozycja.y += dy;

                    } else {
                        pozycja.x = cel.x;
                        pozycja.y = cel.y;
                        cel = null;
                    }

                }
                Thread.sleep(100);
                notifyListeners();
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for(Listener listener : listeners) {
            listener.update();
        }
    }
}
