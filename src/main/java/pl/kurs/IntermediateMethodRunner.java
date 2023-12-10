package pl.kurs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntermediateMethodRunner {
    public static void main(String[] args) {

        //filter()
        List<Integer> integerList = List.of(1,2,3,4,19,5,10);
        integerList.stream()
                .filter(x -> x != 0 && x % 2 == 0)
                .forEach(System.out::println);

        //map()
        List<Employee> employeeList = List.of(
                new Employee("Wojciech", "Szczęsny", 200_000.0D),
                new Employee("Robert", "Lewandowski", 300_000.0D),
                new Employee("Michał", "Pazdan", 300_000.0D)
        );

        List<Double> salaries = employeeList.stream()
                .map(Employee::getSalary)
                .collect(Collectors.toList());
        salaries.forEach(System.out::println);

        //limit()
        List<Integer> list = List.of(1,2,3,4,5,6);
        List<Integer> finalList = list.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(finalList);
        IntStream intStream = IntStream.rangeClosed(0, 5);
        int[] ints = intStream.limit(3)
                .toArray();
        System.out.println(Arrays.toString(ints));


        //distinct()
        List<Car> carList = List.of(
                new Car("Audi", "RS4 B7"),
                new Car("BMW", "M3 e92"),
                new Car("BMW", "M3 e92"),
                new Car("Mercedes-Benz", "C63 AMG")
        );
        carList.stream()
                .distinct()
                .forEach(System.out::println);

        List<String> namesList = List.of("Kamil", "Karol", "Kamil", "Ania");
        List<String> collect = namesList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
        //sorted()
        integerList.stream()
                .sorted()
                .forEach(System.out::println);

        employeeList.stream()
                //.sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getLastName))
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(System.out::println);
        employeeList.stream()
                        .sorted(Comparator.comparing(Employee::getName))
                                .forEach(System.out::println);

        //peek()
        employeeList.stream()
                .peek(x -> System.out.println("Jebac piłke nożną"))
                .peek(x -> x.setSalary(x.getSalary() * 1.2))
                .forEach(System.out::println);

        //skip()
        integerList.stream()
                .skip(4)
                .forEach(System.out::println);

        //boxed()
        IntStream intStream1 = IntStream.rangeClosed(0, 10);
        List<Integer> integers = intStream1.boxed()
                .collect(Collectors.toList());
        System.out.println(integers);

        //flatMap()
        Car[] sportCarArray = {
                new Car("Ferrari", "488 GTB"),
                new Car("Lamborghini", "Huracan EVO")
        };

        Car[] suvCarArray = {
                new Car("BMW", "X5M"),
                new Car("Lamborghini", "Urus")
        };
        List<Car[]> carsArraysList = List.of(sportCarArray, suvCarArray);
        System.out.println(carsArraysList);
        carsArraysList.stream()
                .flatMap(Arrays::stream)
                .forEach(System.out::println);


    }
}
