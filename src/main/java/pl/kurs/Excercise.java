package pl.kurs;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Excercise {
    public static void main(String[] args) {
        List<Double> doubleList = DoubleStream.iterate(1, x -> x + 1)
                .filter(x -> x != 0 && x % 2 == 0)
                .map(x -> x / 2)
                .filter(x -> x != 0 && x % 2 == 0)
                .skip(50)
                .limit(100)
                .boxed()
                .collect(Collectors.toList());
//        for (Double aDouble : doubleList) {
//            System.out.println(aDouble);
//        }
        List<Employee> employees = generateList(100, () -> Employee.Generator.generate());
        int size = employees.stream()
                .filter(x -> x.getSalary() <= 10_000)
                .peek(x -> x.setSalary(x.getSalary() * 1.2))
                .distinct() //wyszarzyło ponieważ bo LinkedHashSet zwracany przez collecta nie posiada sam z siebie duplikatów.
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed().thenComparing(Employee::getLastName).thenComparing(Employee::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .size();
//        System.out.println(size);


        List<Student> students = generateList(30, () -> Student.Generator.generate());

        //oceny uczniow
        Map<Student.BehaviourGrade, Long> studentGrades = students.stream()
                .collect(Collectors.groupingBy(x -> x.getBehaviourGrade(), Collectors.counting()));
        System.out.println(studentGrades);

        //ilu uczniow o tym samym imieniu i nazwisku
        students.stream()
                .collect(Collectors.groupingBy(x -> x.getFirstName() + " " + x.getLastName(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)))
                .forEach(System.out::println);


        //najwiecej rocznika i najmniej
        Map<Integer, Long> countStudentsByYear = students.stream()
                .collect(Collectors.groupingBy(x -> x.getYear(), Collectors.counting()));
        System.out.println(countStudentsByYear);

        Map.Entry<Integer, Long> maxYear = countStudentsByYear.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow(RuntimeException::new);
        System.out.println(maxYear);


        Optional<Map.Entry<Integer, Long>> min = countStudentsByYear.entrySet()
                .stream()
                .min(Comparator.comparing(Map.Entry::getValue));
        Map.Entry<Integer, Long> minYear = min.orElseThrow(() -> new RuntimeException());
        System.out.println(minYear);

        students.forEach(System.out::println);
        List<Student> updatedStudents = students.stream()
                .peek(x -> {
                    Student.BehaviourGrade[] grades = Student.BehaviourGrade.values();
                    if (x.getBehaviourGrade() != grades[grades.length-1]) {
                        x.setBehaviourGrade(grades[x.getBehaviourGrade().ordinal() + 1]);
                    }
                })
                .collect(Collectors.toList());;
        System.out.println();
        System.out.println();
        updatedStudents.forEach(System.out::println);
    }

    public static <T> List<T> generateList(int size, Supplier<T> supplier) {
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i, supplier.get());
        }
        return list;
    }

    @Override
    public String toString() {
        return "Excercise{}";
    }
}
