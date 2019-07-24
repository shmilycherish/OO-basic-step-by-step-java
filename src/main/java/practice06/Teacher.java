package practice06;

public class Teacher extends Person {
    private Integer klass;

    public Teacher(String name, int age, Integer klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Integer getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        return super.introduce() + detailIntroduce();
    }

    private String detailIntroduce() {
        return getKlass() == null ? " I am a Teacher. I teach No Class." :
                String.format(" I am a Teacher. I teach Class %s.", getKlass());
    }
}
