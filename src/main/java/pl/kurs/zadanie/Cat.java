package pl.kurs.zadanie;

import java.util.Random;

public class Cat extends Animal{
    public Cat(String name, int age, boolean sterilized) {
        super(name, age, sterilized);
    }

    @Override
    public String toString() {
        return "Cat{}";
    }
}
