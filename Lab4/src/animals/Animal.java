package animals;

public abstract class Animal {
    int iloscNog;
    String name;

    public Animal(String name, int iloscNog) {
        this.name = name;
        this.iloscNog = iloscNog;
    }

    public int  getLegs() {
        return iloscNog;
    }


    public abstract String getDescription();
}
