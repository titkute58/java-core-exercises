package bai6;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentClass studentClass = new StudentClass();

        while (true) {
            System.out.println("Enter 1: Add student");
            System.out.println("Enter 2: Print information of 20-year-old students: ");
            System.out.println("Enter 3: Number of 23-year-old students originate from DN: ");
            System.out.println("Enter 4: Exit:");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Enter student information");
                    System.out.println("Full name: ");
                    String fullName = scanner.nextLine();
                    System.out.println("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Hometown: ");
                    String hometown = scanner.nextLine();
                    studentClass.addStudent(new Student(fullName, age, hometown));
                    System.out.println("Successfully added the student");
                    break;
                case "2":
                    if (studentClass.students.isEmpty()) {
                        System.out.println("None of the student matches desired filter");
                    } else {
                        studentClass.printStudentOf20();
                    }
                    break;
                case "3":
                    System.out.println(studentClass.numberOfStudent23InDN());
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }


    }
}
