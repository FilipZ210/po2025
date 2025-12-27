package symulator;

public class SkrzyniaBiegow extends Komponent {
    int aktualnyBieg;
    public int iloscBiegow;
    public Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, float waga, float cena,int iloscBiegow,  Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.aktualnyBieg = 0;
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = sprzeglo;
    }

    public void zwiekszBieg() {
        if (sprzeglo.getStanSprzegla()) {
            if(aktualnyBieg < iloscBiegow) {
                aktualnyBieg++;
                System.out.println("Zwiekszono bieg na "+ aktualnyBieg);
            }
        } else {
            System.out.println("Sprzeglo nie jest wcisniete");
        }
    }
    public void zmniejszBieg() {
        if (sprzeglo.getStanSprzegla()) {
            if(aktualnyBieg > 0) {
                aktualnyBieg--;
                System.out.println("Zmniejszono bieg na "+ aktualnyBieg);
            }
        } else {
            System.out.println("Sprzeglo nie jest wcisniete");
        }
    }

    public int getAktualnyBieg() {
        return aktualnyBieg;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }

    @Override
    public String toString() {
        return this.nazwa;
    }
}
