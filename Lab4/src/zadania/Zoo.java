package zadania;
import animals.*;
import java.util.Random;

public class Zoo {
    Animal[] animals = new Animal[100];
    Random rand = new Random();

    private void fillAnimals() {
        String[] names = {"Polly", "George", "Tom", "Mel"};

        for (int i = 0; i < animals.length; i++) {
            int number = rand.nextInt(3);
            String name = names[rand.nextInt(names.length)];

            switch (number) {
                case 0 -> animals[i] = new Parrot(name);
                case 1 -> animals[i] = new Snake(name);
                case 2 -> animals[i] = new Dog(name);
            }


        }
    }

    public int countTotalLegs() {
        int sum = 0;
        for (Animal animal : animals) {
            sum += animal.getLegs();
        }
        return sum;
    }

    public void printAllAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal.getDescription());

        }
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.fillAnimals();
        System.out.println(zoo.countTotalLegs());
        zoo.printAllAnimals();
    }
}
