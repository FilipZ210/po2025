package symulator;

public class Sprzeglo extends Komponent {
    boolean stanSprzegla;

    public Sprzeglo(boolean stanSprzegla, String producent, String model ) {
        super(producent, model);
        this.stanSprzegla = stanSprzegla;
    }

    public void wcisnij(){

        stanSprzegla = true;
    }

    public void zwolnij(){

        stanSprzegla = false;
    }

    public boolean isStanSprzegla() {
        return stanSprzegla;
    }
}

