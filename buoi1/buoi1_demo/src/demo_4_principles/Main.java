package demo_4_principles;

class Sum {
    static int sum(int a, int b) {
        return a + b;
    }

    static float sum(float a, float b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("A"),
                new Fish("B"),
                new Dog("C"),
                new Fish("D")
        };
        // truu tuong
        for (Animal animal : animals) {
            // đa hình tại runtime -> method eat sẽ được gọi
            // tương ừng tùy theo Dog hay Fish.
            animal.eat();
        }

        Sum.sum(1, 2);
        Sum.sum(1, 2f);

        new Dog("Dog a").setAge(-1);
    }
}
