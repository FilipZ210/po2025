package symulator;

public class Silnik extends Komponent {
    private int maxObroty;
    private int obroty;

    public Silnik(String nazwa, float waga, float cena, int maxObroty, int obroty) {
        super(nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = obroty;
    }
    public int getObroty() {
        return obroty;
    }

    public int getMaxObroty() {
        return maxObroty;
    }

    public void uruchom() {
        obroty = 1000;
    }

    public void zatrzymaj() {
        obroty = 0;
    }

    public void zwiekszObroty() {
        if ( obroty + 100 <=  maxObroty) {
            obroty += 100;
        }
    }

    public void zmniejszObroty() {
        if ( obroty - 100 >= 0) {
            obroty -= 100;
        }
    }

    @Override
    public String toString() {
        return this.nazwa;
    }
}
