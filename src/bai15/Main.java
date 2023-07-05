package bai15;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Faculty faculty = new Faculty("Computer Science");

        while (true) {
            System.out.println("1. Add regular student");
            System.out.println("2. Add part-time student");
            System.out.println("3. Count regular students");
            System.out.println("4. Get students with average score higher than 8.0");
            System.out.println("5. Get best student in any semester");
            System.out.println("6. Sort students");
            System.out.println("7. Get student count by year");
            System.out.println("8. Get student average score by semester");
            System.out.println("9. Get part-time student by training location");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Student student = new Student();
                    student.input(scanner);
                    faculty.addStudent(student);
                    break;
                case 2:
                    PartTimeStudent partTimeStudent = new PartTimeStudent();
                    partTimeStudent.input(scanner);
                    faculty.addStudent(partTimeStudent);
                    break;
                case 3:
                    int count = faculty.countRegularStudents();
                    System.out.println("Number of regular students: " + count);
                    break;
                case 4:
                    List<Student> topStudents = faculty.getTopStudents();
                    if (topStudents.isEmpty()) {
                        System.out.println("No student found");
                    }
                    for (Student s : topStudents) {
                        s.output();
                        System.out.println();
                    }
                    break;
                case 5:
                    Student bestStudent = faculty.getBestStudent();
                    if (bestStudent != null) {
                        bestStudent.output();
                        System.out.println();
                    } else {
                        System.out.println("No students in the faculty");
                    }
                    break;
                case 6:
                    faculty.sortStudents();
                    break;
                case 7:
                    Map<Integer, Integer> countByYear = faculty.getStudentCountByYear();
                    if (countByYear.isEmpty()) {
                        System.out.println("No student found");
                    } else {
                        for (Map.Entry<Integer, Integer> entry : countByYear.entrySet()) {
                            int year = entry.getKey();
                            int c = entry.getValue();
                            System.out.println(year + ": " + c);
                        }
                    }
                    break;
                case 8:
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    Student s = faculty.getStudentById(id);
                    if (s != null) {
                        System.out.print("Enter semester: ");
                        String semester = scanner.nextLine();
                        double averageScore = s.getAverageScore(semester);
                        if (averageScore >= 0) {
                            System.out.println("Average score in " + semester + ": " + averageScore);
                        } else {
                            System.out.println("No academic results found for " + semester);
                        }
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 9:
                    System.out.println("Enter the training location: ");
                    String location = scanner.nextLine();
                    List<Student> studentByLocation = new ArrayList<>();
                    studentByLocation = faculty.getPTStudentByLocation(location);
                    if (studentByLocation.isEmpty()) {
                        System.out.println("Student not found");
                    } else {
                        faculty.getPTStudentByLocation(location).forEach(student1 -> System.out.println(student1.toString()));
                    }
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}
