package symulator;

public class SkrzyniaBiegow extends Komponent {
    int aktualnyBieg;
    int iloscBiegow;
    Sprzeglo sprzeglo;

    public SkrzyniaBiegow(int aktualnyBieg, int iloscBiegow,Sprzeglo sprzeglo, String producent, String model) {
        super(producent, model);
        this.aktualnyBieg = aktualnyBieg;
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = sprzeglo;
    }

    public void zwiekszBieg() {
        if (aktualnyBieg < iloscBiegow) {
            aktualnyBieg++;
        }
    }
    public void zmniejszBieg() {
        if (aktualnyBieg > 0) {
            aktualnyBieg--;
        }
    }

    public int getAktualnyBieg() {
        return aktualnyBieg;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }
}
