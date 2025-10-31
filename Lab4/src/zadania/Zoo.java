package zadania;
import animals.*;
import java.util.Random;

public class Zoo {
    private Animal[] animals = new Animal[100];

    public void fillRandom(){
        Random rand = new Random();
        String[] names = {"Polly", "George","Tom", "Mel", "Jerry", "Mickey"};

        for(int i = 0; i < animals.length; i++){
            int number = rand.nextInt(3);
            String new_name = names[rand.nextInt(names.length)];

            switch (number){
                case 0 -> animals[i] = new Dog(new_name);
                case 1 -> animals[i] = new Parrot(new_name);
                case 2 -> animals[i] = new Snake(new_name);
            }
        }
    }

    public int countLegs(){
        int sum = 0;
        for(int i = 0; i < animals.length; i++){
            sum += animals[i].getLegs();
        }
        return sum;
    }

    public void printAnimals(){

        for(int i = 0; i < animals.length; i++){
            int legs = animals[i].getLegs();
            System.out.println(animals[i].getDescription());
            System.out.println(animals[i].makeSound());
        }
    }

    public static void main(String[] args){
        Zoo zoo = new Zoo();
        zoo.fillRandom();
        System.out.println(zoo.countLegs());
        zoo.printAnimals();

    }


}