package bai6;

import java.util.ArrayList;
import java.util.List;

public class StudentClass {

    List<Student> students;

    public StudentClass() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void printAll() {
        this.students.forEach(student -> {
            printStudentInfo(student);
        });
    }

    public void printStudentOf20() {
        this.students.stream().filter(student -> student.getAge() == 20).forEach(
                student -> printStudentInfo(student)
        );
    }

    public long numberOfStudent23InDN() {
        return this.students.stream().filter(
                student -> (student.getAge() == 23) && (student.getHomeTown().equals("DN"))
        ).count();
    }

    private void printStudentInfo(Student student) {
        System.out.println("Student name: " + student.getFullName() + "\n"
                + "Age: " + student.getAge() + "\n"
                + "Hometown: " + student.getHomeTown());
    }
}
