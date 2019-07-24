package practice07;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
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
        return getKlass() == null ? " I am a Teacher. I teach No Class." :
                String.format(" I am a Teacher. I teach %s.", getKlass().getDisplayName());
    }

    public String introduceWith(Student student) {
        if(student.getKlass().getNumber() == getKlass().getNumber()) {
            return super.introduce() + String.format(" I am a Teacher. I teach %s.", student.getName());
        }
        return super.introduce() + String.format(" I am a Teacher. I don't teach %s.", student.getName());
    }


}
