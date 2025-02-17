package practice04;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String basicIntroduce() {
        return String.format("My name is %s. I am %s years old.", getName(), getAge());
    }

    public String introduce() {
        return basicIntroduce();
    }
}
