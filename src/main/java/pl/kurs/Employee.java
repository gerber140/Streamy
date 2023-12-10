package pl.kurs;

import java.util.Random;

public class Employee{
    private String name;
    private String lastName;
    private double salary;

    public Employee(String name, String lastName, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }


    public static class Generator {
        private static String[] firstNames = {"Adam", "Marcin", "Robert", "Szymon", "Mariusz"};
        private static String[] lastNames = {"Nowak", "Kowalski", "Malinowski", "Kwiatkowski", "Szymański"};
        private static double[] salaries = {8_000, 10_000, 12_000, 14_000, 16_000, 18_000, 20_000};
        private static Random random = new Random();

        public static Employee generate(){
            String generatedFirstName = firstNames[random.nextInt(firstNames.length)];
            String generatedLastName = lastNames[random.nextInt(lastNames.length)];
            double generatedSalary = salaries[random.nextInt(salaries.length)];
            return new Employee(generatedFirstName, generatedLastName, generatedSalary);
        }

    }
}
