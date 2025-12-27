package symulator;

public class Silnik extends Komponent {
    public int maxObroty;
    private int obroty;
    public boolean wlaczony;

    public Silnik(String nazwa, float waga, float cena, int maxObroty, int obroty) {
        super(nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = obroty;
        this.wlaczony = false;
    }
    public int getObroty() {
        return obroty;
    }

    public void uruchom() {
        this.obroty = 0;
        this.wlaczony = true;
    }

    public void zatrzymaj() {
        this.obroty = 0;
        this.wlaczony = false;
    }

    public void zwiekszObroty() {
        if (wlaczony) {
            if (obroty + 500 <= maxObroty) {
                obroty += 500;
            }
        }
    }

    public void zmniejszObroty() {
        if(wlaczony) {
            if (obroty - 500 >= 0) {
                obroty -= 500;
            }
        }
    }

    @Override
    public String toString() {
        return this.nazwa;
    }
}
