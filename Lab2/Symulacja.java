import java.util.Random;
import java.util.ArrayList;


public class Symulacja {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rand  = new Random();
        while (numbers.size() <  6) {
            int new_number = rand.nextInt(1, 50);
            if(numbers.contains(new_number)) {
                //do nothing
            } else {
                numbers.add(new_number);
            }
        }

        int matches = 0;
        int ilosc_prob = 0;

        long start = System.currentTimeMillis();
        while (matches < 6) {
            ilosc_prob++;
            matches = 0;
            ArrayList<Integer> trafione = new ArrayList<>();
            while(trafione.size() < 6) {
                int new_number = rand.nextInt(1, 50);
                if (trafione.contains(new_number)) {

                } else {
                    trafione.add(new_number);
                }
            }

            for (int n : trafione) {
                if(numbers.contains(n)) {
                    matches++;
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(numbers);
        System.out.println("Liczba prob wynosi " + ilosc_prob);
        System.out.println("Czas wykonania programu wynosi " + (end - start) + "ms");
    }
}
