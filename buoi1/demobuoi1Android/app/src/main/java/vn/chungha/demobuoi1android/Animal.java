package vn.chungha.demobuoi1android;

import android.util.Log;

public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // phuơng thức trừu tượng, không có thân hàm
    public abstract void move();

    public void printAnimal() {
        Log.d(Constant.TAG_ANIMAL, "Name Animal is " + name);
        Log.d(Constant.TAG_ANIMAL, "Age Animal is " + age);
    }
}
