package pl.kurs;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Karol", null,  "Bartek", "Kamila", null, "Pawel");

        names = names.stream()
                .filter(Objects::nonNull)
                .filter(x -> !x.endsWith("a"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(names);


        //może być jeszcze LongStream i DoubleStream


    }
}
