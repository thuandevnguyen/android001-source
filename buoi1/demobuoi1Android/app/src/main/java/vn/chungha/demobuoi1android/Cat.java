package vn.chungha.demobuoi1android;

import android.util.Log;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void move() {
        Log.d(Constant.TAG_ANIMAL, "Cat " + name + " Move");
    }
}
