package animals;

public class Parrot extends Animal {

    public Parrot(String name) {
        super(name, 2);
    }

    public String getDescription() {
        return "Parrot named " + name + " has " + legs + " legs";
    }

    public String makeSound() {
        return "CWIERK";
    }
}
