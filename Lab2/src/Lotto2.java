import java.util.Random;
import java.util.ArrayList;


public class Lotto2 {
    public static void main(String[] args) {
        ArrayList<Integer> my_numbers = new ArrayList<>();
        for(int i = 0; i < args.length; i++){
            my_numbers.add(Integer.parseInt(args[i]));
        }

        for(int i = 0; i < args.length; i++){
            if (Integer.parseInt(args[i]) > 49 || Integer.parseInt(args[i]) < 0) {
                System.out.println(args[i] + " jest zlym numerem, dopuszczone sa liczzby od 1 do 49");
                System.exit(0);
            }
        }

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
        int guesses = 0;

        for( int n : my_numbers){
            if(numbers.contains(n)) {
                guesses += 1;
            }
        }

        System.out.println("Twoje typy: " + my_numbers);
        System.out.println("Wylosowane liczby " + numbers);
        System.out.println("Liczba trafien "+ guesses);
    }
}