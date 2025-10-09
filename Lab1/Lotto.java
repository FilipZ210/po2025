import java.util.Random;
import java.util.HashSet;


public class Lotto {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        Random rand  = new Random();
        while (numbers.size() <  6) {
            numbers.add(rand.nextInt(1, 50));
        }
        System.out.println(numbers);
    }
}
