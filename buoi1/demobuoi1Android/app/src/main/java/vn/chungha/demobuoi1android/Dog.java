package vn.chungha.demobuoi1android;

import android.util.Log;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void move() {
        Log.d(Constant.TAG_ANIMAL, "Dog " + name + " Move");
    }
}
