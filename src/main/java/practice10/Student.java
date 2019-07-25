package practice10;

public class Student extends Person {
    private final Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        return super.introduce() + detailIntroduce();
    }

    private String detailIntroduce() {
        return this.equals(klass.getLeader()) ? String.format(" I am a Student. I am Leader of %s.", getKlass().getDisplayName()) :
                String.format(" I am a Student. I am at %s.", getKlass().getDisplayName());
    }
}
