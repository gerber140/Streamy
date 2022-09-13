package pl.kurs.zadanie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;



public class Runner {


    public static void main(String[] args) {
        List<Animal> animals = generateList(100, () -> generate());
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        System.out.println();

        List<Animal> catList = animals.stream()
                .filter(x -> x.getClass().getSimpleName().equals(Cat.class.getSimpleName()))
                .collect(Collectors.toList());

        System.out.println("Ile kotów: " +catList.size());

        List<Animal> nonSterilizedCats = catList.stream()
                .filter(x -> x.isSterilized() == false)
                .collect(Collectors.toList());

        System.out.println("Ile niesterylizowanych kotów: " +nonSterilizedCats.size());

        nonSterilizedCats.stream()
                .forEach(x -> x.setSterilized(true));



        List<Animal> dogList = animals.stream()
                .filter(x -> x.getClass().getSimpleName().equals(Dog.class.getSimpleName()))
                .collect(Collectors.toList());

        System.out.println("Ile psów:" +dogList.size());

        List<Animal> nonSterilizedDogs = dogList.stream()
                .filter(x -> x.isSterilized() == false)
                .collect(Collectors.toList());

        System.out.println("Ile niesterylizowanych psów: " +nonSterilizedDogs.size());

        nonSterilizedDogs.stream()
                .forEach(x -> x.setSterilized(true));


        Animal oldestCat = animals.stream()
                .filter(x -> x.getClass().getSimpleName().equals(Cat.class.getSimpleName()))
                .max(Comparator.comparingInt(Animal::getAge))
                .orElseThrow();
        System.out.println("Najstarszy kot: " +oldestCat);

        Animal youngestCat = animals.stream()
                .filter(x -> x.getClass().getSimpleName().equals(Cat.class.getSimpleName()))
                .min(Comparator.comparingInt(Animal::getAge))
                .orElseThrow();
        System.out.println("Najmłodszy kot: " +youngestCat);

        Animal oldestDog = animals.stream()
                .filter(x -> x.getClass().getSimpleName().equals(Dog.class.getSimpleName()))
                .max(Comparator.comparingInt(Animal::getAge))
                .orElseThrow();
        System.out.println("Najstarszy pies: " +oldestDog);

        Animal youngestDog = animals.stream()
                .filter(x -> x.getClass().getSimpleName().equals(Dog.class.getSimpleName()))
                .min(Comparator.comparingInt(Animal::getAge))
                .orElseThrow();
        System.out.println("Najmłodszy pies: " +youngestDog);

        System.out.println("Różnica: " +(oldestCat.getAge() - youngestDog.getAge()));


    }
    public static <T> List<T> generateList(int size, Supplier<T> supplier) {
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i, supplier.get());
        }
        return list;
    }
    private static String[] names = {"Marian", "Staś", "Garfield", "Czaruś", "Jacuś", "Ludomir", "Borowik", "Kedi"};
    private static int[] ages = {1,2,3,4,5,6,7,8,9,10};
    private static boolean[] booleans = {true, false};

    private static Random random = new Random();
    public static Animal generate() {
        String generatedName = names[random.nextInt(names.length)];
        int generatedAge = ages[random.nextInt(ages.length)];
        boolean generatedBoolean = booleans[random.nextInt(booleans.length)];
        Animal[] animals = {new Cat(generatedName, generatedAge, generatedBoolean), new Dog(generatedName, generatedAge, generatedBoolean)};

        return animals[random.nextInt(animals.length)];
    }


}
