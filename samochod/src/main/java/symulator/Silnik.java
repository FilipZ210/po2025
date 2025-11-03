package symulator;

public class Silnik extends Komponent {
    int maxObroty;
    int obroty;

    public Silnik(int maxObroty, int obroty, String producent, String model) {
        super(producent, model);
        this.maxObroty = maxObroty;
        this.obroty = obroty;
    }

    void uruchom() {
        obroty = 1000;
    }

    void zatrzymaj() {
        obroty = 0;
    }
}
