package symulator;

public class Samochod extends Thread  {

    public Silnik silnik;
    public SkrzyniaBiegow skrzynia;
    public Pozycja  aktualnaPozycja;
    public String model;
    public String nrRejestracyjny;
    public boolean stanWlaczenia;
    public int predkoscMax;
    public float waga;

    public Samochod(String model, String nrRejestracyjny,float waga, int predkoscMax, SkrzyniaBiegow skrzynia, Silnik silnik ) {
        this.model = model;
        this.nrRejestracyjny = nrRejestracyjny;
        this.waga = waga;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.predkoscMax = predkoscMax;
        this.stanWlaczenia = false;

        this.aktualnaPozycja = new Pozycja(0,0);
        setDaemon(true); //gdy zamkniemy okno aplikacja sie gasi

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

    public double getPredkosc() {
        return this.predkoscMax;
    }

    public Pozycja getAktualnaPozycja() {
        return aktualnaPozycja;
    }

    @Override
    public String toString() {
        return this.model + " (" + this.nrRejestracyjny + ")";
    }
}
