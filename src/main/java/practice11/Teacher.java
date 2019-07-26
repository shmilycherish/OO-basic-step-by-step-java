package practice11;

import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    public static final String STUDENT_BECOME_LEADER = "I am %s. I know %s become Leader of %s.";
    public static final String STUDENT_JOIN = "I am %s. I know %s has joined %s.";
    private List<Klass> classes;

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        registerTeacherForEachClass();
    }

    private void registerTeacherForEachClass() {
        classes.stream().forEach(klass -> klass.registerTeacher(this));
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public List<Klass> getClasses() {
        return classes;
    }

    public boolean isTeaching(Student student) {
        return classes.stream().anyMatch(klass -> klass.isIn(student));
    }

    @Override
    public String introduce() {
        return super.introduce() + detailIntroduce();
    }

    private String detailIntroduce() {
        return getClasses() == null || getClasses().size() == 0 ? " I am a Teacher. I teach No Class." :
                String.format(" I am a Teacher. I teach Class %s.", formatClassNumber());
    }

    private String formatClassNumber() {
        return getClasses().stream().map(klass -> String.valueOf(klass.getNumber())).collect(Collectors.joining(", "));
    }

    public String introduceWith(Student student) {
        if(isTeaching(student)) {
            return super.introduce() + String.format(" I am a Teacher. I teach %s.", student.getName());
        }
        return super.introduce() + String.format(" I am a Teacher. I don't teach %s.", student.getName());
    }

    public void responseForStudentJoin(Student student, String eventName) {
        System.out.println(String.format(eventName,
                getName(), student.getName(), student.getKlass().getDisplayName()));
    }

}
