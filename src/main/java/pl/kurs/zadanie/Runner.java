package pl.kurs.zadanie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<Animal> animals = List.of(
                new Dog("Burek", 3, false),
                new Dog("Azor", 2, false),
                new Dog("Lola", 4, true),
                new Dog("Cezar", 5, false),
                new Dog("Daisy", 1, true),
                new Cat("Mruczek", 2, true),
                new Cat("Filemon", 4, false),
                new Cat("Fru-Fru", 3, true),
                new Cat("Kropka", 1, false),
                new Cat("Puszek", 5, true)
        );


        for (Animal animal : animals) {
            System.out.println(animal);
        }


        long LiczbaKotow = animals.stream()
                .filter(animal -> animal instanceof Cat)
                .count();

        long NieWysterylizowaneKoty = animals.stream()
                .filter(animal -> animal instanceof Cat)
                .filter(animal -> !((Cat) animal).isSterilized())
                .count();


        animals.stream()
                .filter(animal -> animal instanceof Cat)
                .forEach(animal -> animal.setSterilized(true));


        long LiczbaPsow = animals.stream()
                .filter(animal -> animal instanceof Dog)
                .count();

        long NieWysterylizowanePsy = animals.stream()
                .filter(animal -> animal instanceof Dog && !animal.isSterilized())
                .count();

        animals.stream()
                .filter(animal -> animal instanceof Dog && !animal.isSterilized())
                .forEach(animal -> animal.setSterilized(true));


        Dog najstarszyPies = (Dog) animals.stream()
                .filter(animal -> animal instanceof Dog)
                .max(Comparator.comparingInt(Animal::getAge))
                .orElse(null);

        Dog najmlodszyPies = (Dog) animals.stream()
                .filter(animal -> animal instanceof Dog)
                .min(Comparator.comparingInt(Animal::getAge))
                .orElse(null);


        Cat najstarszyKot = (Cat) animals.stream()
                .filter(animal -> animal instanceof Cat)
                .max(Comparator.comparingInt(Animal::getAge))
                .orElse(null);

        Cat najmlodszyKot = (Cat) animals.stream()
                .filter(animal -> animal instanceof Cat)
                .min(Comparator.comparingInt(Animal::getAge))
                .orElse(null);


        System.out.println();
        System.out.println("Liczba kotów: " + LiczbaKotow);
        System.out.println("Nie wysterylizowane koty: " + NieWysterylizowaneKoty);
        System.out.println("Liczba psów: " + LiczbaPsow);
        System.out.println("Nie wysterylizowane psy: " + NieWysterylizowanePsy);
        System.out.println("Najstarszy kot: " + najstarszyKot.getName() + "  Lat: " + najstarszyKot.getAge());
        System.out.println("Najstarszy pies: " + najstarszyPies.getName() + "  Lat: " + najstarszyPies.getAge());
        System.out.println("Najmlodszy kot: " + najmlodszyKot.getName() + "  Lat: " + najmlodszyKot.getAge());
        System.out.println("Najmlodszy pies: " + najmlodszyPies.getName() + "  Lat: " + najmlodszyPies.getAge());
        System.out.println("Róźnica wieku miedzy najstarszym kotem a najmlodszym psem: " + (najstarszyKot.getAge() - najmlodszyPies.getAge()));
        System.out.println();

        for (Animal animal : animals) {
            System.out.println(animal);
        }


    }

}
