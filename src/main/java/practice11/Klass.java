package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static practice11.Teacher.STUDENT_BECOME_LEADER;

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
            notifyTeacherWithEvent(student, STUDENT_BECOME_LEADER);
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
        notifyTeacherWithEvent(student, Teacher.STUDENT_JOIN);
    }

    public boolean isIn(Student student) {
        return this.number == student.getKlass().getNumber();
    }

    public void registerTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void notifyTeacherWithEvent(Student student, String eventName) {
        teachers.stream().forEach(teacher -> teacher.responseForStudentJoin(student, eventName));
    }
}
