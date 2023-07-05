package bai3;

import java.util.ArrayList;
import java.util.List;

public class StudentEnroll {

    List<Student> studentList;

    public StudentEnroll() {
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public void printInfo() {
        this.studentList.forEach(student -> {
            if (student instanceof StudentA) {
                System.out.println(
                        "Student A {" + "\n\t" +
                                "Id: " + student.getId() + "\n\t" +
                                "Full name: " + student.getFullName() + "\n\t" +
                                "Address: " + student.getAddress() + "\n\t" +
                                "Priority level: " + student.getPriorityLevel() + "\n\t" +
                                "Subject: " + StudentA.MATH + ", " + StudentA.PHYSIC +
                                ", " + StudentA.CHEMISTRY + "\n" +
                                '}'
                );
            } else if(student instanceof StudentB) {
                System.out.println(
                        "Student A {" + "\n\t" +
                                "Id: " + student.getId() + "\n\t" +
                                "Full name: " + student.getFullName() + "\n\t" +
                                "Address: " + student.getAddress() + "\n\t" +
                                "Priority level: " + student.getPriorityLevel() + "\n\t" +
                                "Subject: " + StudentB.MATH + ", " + StudentB.CHEMISTRY +
                                ", " + StudentB.BIOMETRY + "\n" +
                                '}'
                );
            } else if(student instanceof StudentC) {
                System.out.println(
                        "Student A {" + "\n\t" +
                                "Id: " + student.getId() + "\n\t" +
                                "Full name: " + student.getFullName() + "\n\t" +
                                "Address: " + student.getAddress() + "\n\t" +
                                "Priority level: " + student.getPriorityLevel() + "\n\t" +
                                "Subject: " + StudentC.LITERATURE + ", " + StudentC.HISTORY +
                                ", " + StudentC.GEOMETRY + "\n" +
                                '}'
                );
            }
        });
    }
    public Student searchById(String id) {
        return this.studentList.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }
}
