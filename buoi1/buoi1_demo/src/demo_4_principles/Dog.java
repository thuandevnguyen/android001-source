package demo_4_principles;

public class Dog extends Animal {
    private final String name;
    private int age = 0;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Dog(" + name + ")";
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating...");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Age must be not negative");
        }
        this.age = age;
    }
}
