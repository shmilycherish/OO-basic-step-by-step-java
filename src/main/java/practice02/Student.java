package practice02;

public class Student {
    private final String name;
    private final int age;
    private final int klass;

    public Student(String name, int age, int klass) {

        this.name = name;
        this.age = age;
        this.klass = klass;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getKlass() {
        return klass;
    }
}
