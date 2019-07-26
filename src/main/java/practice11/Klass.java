package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + getNumber();
    }

    public void assignLeader(Student student) {
        if(students.contains(student)) {
            this.leader = student;
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        students.add(student);
        student.setKlass(this);
        notifyTeacherStudentJoin(student);
    }

    public boolean isIn(Student student) {
        return this.number == student.getKlass().getNumber();
    }

    public void registerTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void notifyTeacherStudentJoin(Student student) {
        teachers.stream().forEach(teacher -> teacher.responseForStudentJoin(student));
    }
}
