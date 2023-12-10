package pl.kurs.zadanie;


public class Animal {
    private String name;
    private int age;
    private boolean sterilized;

    public Animal(String name, int age, boolean sterilized) {
        this.name = name;
        this.age = age;
        this.sterilized = sterilized;
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
        return "name='" + name + '\'' +
                ", age=" + age +
                ", sterilized=" + sterilized +
                '}';
    }


}
