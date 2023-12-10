package pl.kurs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalMethodsRunner {
    public static void main(String[] args) {
        //Metoda forEach()
        List<String> carNames = List.of("Audi", "Bmw", "Pagani", "Fiat", "Skoda");
        carNames.stream()
                .forEach(x -> System.out.println("Jebac straż pożarną"));


        //Metoda count() - zwraca longa z liczbą elementów w strumieniu
        long count = carNames.stream()
                .skip(2)
                .count();
        System.out.println(count);

        //Metoda min/max() - zwraca Optionala z najmniejszym bądź największym elementem w strumieniu
        List<Employee> employeeList = List.of(
                new Employee("Wojciech", "Szczęsny", 200_000.0D),
                new Employee("Robert", "Lewandowski", 300_000.0D),
                new Employee("Michał", "Pazdan", 300_000.0D)

        );
        Employee employee = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
        System.out.println(employee);

        Employee employee1 = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary)
                        .thenComparing(Employee::getLastName))
                .orElseThrow();
        System.out.println(employee1);

        employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(x -> System.out.println("Najbogatszy piłkarz: " + x));

        //anyMatch() / allMatch() / noneMatch()

        List<Integer> integers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        boolean b1 = integers.stream()
                .anyMatch(x -> x != 0 && x % 2 == 0);
        System.out.println(b1);

        boolean b2 = integers.stream()
                .allMatch(x -> x != 0 && x % 2 == 0);
        System.out.println(b2);

        boolean b3 = integers.stream()
                .noneMatch(x -> x != 0 && x % 2 == 0);
        System.out.println(b3);




        //collect()
        //toList()
        Stream<Boolean> booleanStream = Stream.of(true, true, false, false, true);
        List<Boolean> booleanList = booleanStream.collect(Collectors.toList());
        System.out.println(booleanList);

        //toSet()
        Stream<String> stringStream = Stream.of("Kamil", "Kuba", "Ptak", "Rower");
        Set<String> stringSet = stringStream.collect(Collectors.toSet());
        System.out.println(stringSet);

        //toMap()
        Map<String, Employee> stringEmployeeMap = employeeList.stream()
                .collect(Collectors.toMap(x -> x.getName() + " " + x.getLastName(), Function.identity()));
        stringEmployeeMap.entrySet().forEach(System.out::println);

        //toCollection()
        LinkedHashSet<Employee> employeeLinkedHashSet = new LinkedHashSet<>(employeeList);
        System.out.println("//////////////////////////////");
        employeeLinkedHashSet.forEach(System.out::println);

        //toArray()
        Employee[] employees = employeeList.toArray(Employee[]::new);
        System.out.println(Arrays.toString(employees));

    }
}
