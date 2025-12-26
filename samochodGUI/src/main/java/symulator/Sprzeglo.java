package symulator;

public class Sprzeglo extends Komponent {
    private boolean stanSprzegla;

    public Sprzeglo(String nazwa, float waga, float cena, boolean stanSprzegla) {
        super(nazwa, waga, cena);
        this.stanSprzegla = stanSprzegla;
    }

    public void wcisnij(){

        stanSprzegla = true;
    }

    public void zwolnij(){

        stanSprzegla = false;
    }

    public boolean getStanSprzegla() {
        return stanSprzegla;
    }
}

