package symulator;

public class Samochod  {
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    Pozycja  aktualnaPozycja;

    private String model = "XYZ Model";
    private double waga = 1500.0;
    private String nrRejestracyjny = "KR12345";
    private double predkosc = 0.0;

    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia, Pozycja aktualnaPozycja) {
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.aktualnaPozycja = aktualnaPozycja;
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
        return this.predkosc;
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
}
