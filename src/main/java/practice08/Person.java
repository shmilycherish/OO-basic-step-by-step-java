package practice08;

public class Person {
    private final int id;
    private final String name;
    private final int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Person) {
            Person person = (Person) obj;
            return person.id == this.id;
        }
        return false;
    }

    public String introduce() {
        return String.format("My name is %s. I am %s years old.", getName(), getAge());
    }
}
