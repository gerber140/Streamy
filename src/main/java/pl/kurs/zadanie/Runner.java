package pl.kurs.zadanie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Animal> animals = generateList(100, () -> Animal.generate());
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        System.out.println();

        List<Animal> catList = animals.stream()
                .filter(x -> x.getTypeOfAnimal() == TypeOfAnimal.CAT)
                .collect(Collectors.toList());

        System.out.println("Ile kotów: " +catList.size());

        List<Animal> nonSterilizedCats = catList.stream()
                .filter(x -> x.isSterilized() == false)
                .collect(Collectors.toList());

        System.out.println("Ile niesterylizowanych kotów: " +nonSterilizedCats.size());

        nonSterilizedCats.stream()
                .forEach(x -> x.setSterilized(true));




        List<Animal> dogList = animals.stream()
                .filter(x -> x.getTypeOfAnimal() == TypeOfAnimal.DOG)
                .collect(Collectors.toList());

        System.out.println("Ile psów:" +dogList.size());

        List<Animal> nonSterilizedDogs = dogList.stream()
                .filter(x -> x.isSterilized() == false)
                .collect(Collectors.toList());

        System.out.println("Ile niesterylizowanych psów: " +nonSterilizedDogs.size());

        nonSterilizedDogs.stream()
                .forEach(x -> x.setSterilized(true));


        Animal oldestCat = animals.stream()
                .filter(x -> x.getTypeOfAnimal() == TypeOfAnimal.CAT)
                .max(Comparator.comparingInt(Animal::getAge))
                .orElseThrow();
        System.out.println("Najstarszy kot: " +oldestCat);

        Animal youngestCat = animals.stream()
                .filter(x -> x.getTypeOfAnimal() == TypeOfAnimal.CAT)
                .min(Comparator.comparingInt(Animal::getAge))
                .orElseThrow();
        System.out.println("Najmłodszy kot: " +youngestCat);

        Animal oldestDog = animals.stream()
                .filter(x -> x.getTypeOfAnimal() == TypeOfAnimal.DOG)
                .max(Comparator.comparingInt(Animal::getAge))
                .orElseThrow();
        System.out.println("Najstarszy pies: " +oldestDog);

        Animal youngestDog = animals.stream()
                .filter(x -> x.getTypeOfAnimal() == TypeOfAnimal.DOG)
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
    public static <T> void doActionForAll(List<T> list, Consumer<T> consumer){
        for (int i = 0; i < list.size(); i++) {
            consumer.accept(list.get(i));
        }
    }

}
