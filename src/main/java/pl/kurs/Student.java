package pl.kurs;

import java.util.Random;

public class Student {
    private String firstName;
    private String lastName;
    private BehaviourGrade behaviourGrade;
    private int year;

    public Student(String firstName, String lastName, BehaviourGrade behaviourGrade, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.behaviourGrade = behaviourGrade;
        this.year = year;
    }

    public void setBehaviourGrade(BehaviourGrade behaviourGrade) {
        this.behaviourGrade = behaviourGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BehaviourGrade getBehaviourGrade() {
        return behaviourGrade;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", behaviourGrade=" + behaviourGrade +
                ", year=" + year +
                '}';
    }

    public static class Generator {
        private static String[] firstNames = {"Adam", "Marcin", "Robert", "Szymon", "Mariusz"};
        private static String[] lastNames = {"Nowak", "Kowalski", "Malinowski", "Kwiatkowski", "Szymański"};
        private static int[] years = {1998, 1999, 2000, 2001};
        private static BehaviourGrade[] grades = BehaviourGrade.values();
        private static Random random = new Random();

        public static Student generate(){
            String generatedFirstName = firstNames[random.nextInt(firstNames.length)];
            String generatedLastName = lastNames[random.nextInt(lastNames.length)];
            int generatedYear = years[random.nextInt(years.length)];
            BehaviourGrade behaviourGrade1 = grades[random.nextInt(grades.length)];
            return new Student(generatedFirstName, generatedLastName, behaviourGrade1, generatedYear);
        }
        //todo - policz jakiego rocznika jest najwięcej uczniów, a jakiego najmniej.
        //todo - sprawdź ile uczniów posiada dane zachowanie.
        //todo -sprawdź ilu jest uczniów o tym samym imieniu i nazwisku.

    }

    public enum BehaviourGrade{
        NAGANNA,
        DOSTATECZNA,
        DOBRA,
        BARDZO_DOBRA,
        WZOROWA
    }
}

