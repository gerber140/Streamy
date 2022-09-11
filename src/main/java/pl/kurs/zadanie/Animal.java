package pl.kurs.zadanie;

import java.util.Random;

public class Animal {
    private String name;
    private int age;
    private boolean sterilized;
    private TypeOfAnimal typeOfAnimal;


    public Animal(String name, int age, boolean sterilized, TypeOfAnimal typeOfAnimal) {
        this.name = name;
        this.age = age;
        this.sterilized = sterilized;
        this.typeOfAnimal = typeOfAnimal;
    }

    public TypeOfAnimal getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public void setTypeOfAnimal(TypeOfAnimal typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }



    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sterilized=" + sterilized +
                ", typeOfAnimal=" + typeOfAnimal +
                '}';
    }

    private static String[] names = {"Marian", "Staś", "Garfield", "Czaruś", "Jacuś", "Ludomir", "Borowik", "Kedi"};
    private static int[] ages = {1,2,3,4,5,6,7,8,9,10};
    private static boolean[] booleans = {true, false};
    private static TypeOfAnimal[] typeOfAnimals = {TypeOfAnimal.CAT, TypeOfAnimal.DOG};
    private static Random random = new Random();

    public static Animal generate(){
        String generatedName = names[random.nextInt(names.length)];
        int generatedAge = ages[random.nextInt(ages.length)];
        boolean generatedBoolean = booleans[random.nextInt(booleans.length)];
        TypeOfAnimal generatedTypeOfAnimal = typeOfAnimals[random.nextInt(typeOfAnimals.length)];

        return new Animal(generatedName, generatedAge, generatedBoolean, generatedTypeOfAnimal);
    }
}
