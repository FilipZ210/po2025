package animals;

public class Snake extends Animal{
    public Snake(String name){
        super(name, 0);
    }
    public String getDescription(){
        return "Snake named " + name + " has " + legs + " legs";
    }

    public String makeSound() {
        return "SSSS";
    }

}