package demo_4_principles;

public class Fish extends Animal {
    private final String name;

    public Fish(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Fish(" + name + ")";
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating...");
    }
}
