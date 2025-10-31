package animals;

public class Dog extends Animal{
    public Dog(String name) {
        super(name, 4);
    }

    public String getDescription() {
        return "Dog named " + name + " has " + legs + " legs";
    }

    public String makeSound() {
        return "HAU HAU";
    }
}


