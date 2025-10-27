import animals.Dog;
import animals.Parrot;
import animals.Snake;

public class Main {
    public static void main(String[] args) {
        Parrot parrot = new Parrot("Parrot");
        Dog dog = new Dog("Dog");
        Snake snake = new Snake("Snake");
        System.out.println(dog.getDescription());
        System.out.println(snake.getDescription());
        System.out.println(parrot.getDescription());
    }
}
