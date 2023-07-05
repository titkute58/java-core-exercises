package bai3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentEnroll studentEnroll = new StudentEnroll();
        while (true) {
            System.out.println("Student enrolling app");
            System.out.println("Enter 1: To add student");
            System.out.println("Enter 2: To show information of student: ");
            System.out.println("Enter 3: To search student by id");
            System.out.println("Enter 4: To exit:");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.println("Enter a: to add Student A");
                    System.out.println("Enter b: to add Student B");
                    System.out.println("Enter c: to add Student C");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a": {
                            studentEnroll.addStudent(generateStudent(scanner, "a"));
                            break;
                        }
                        case "b": {
                            studentEnroll.addStudent(generateStudent(scanner, "b"));
                            break;
                        }
                        case "c": {
                            studentEnroll.addStudent(generateStudent(scanner, "c"));
                            break;
                        }
                        default:
                            System.out.println("Invalid");
                            break;
                    }
                    break;
                }
                case "2": {
                    studentEnroll.printInfo();
                    break;
                }
                case "3": {
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    Student student = studentEnroll.searchById(id);
                    if (student == null) {
                        System.out.println("Not found");
                    } else {
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
                    }
                    break;
                }
                case "4": {
                    return;
                }
                default:
                    System.out.println("Invalid");
                    continue;
            }
        }
    }


    private static Student generateStudent(Scanner scanner, String type) {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Priotity: ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        if (type.equals("a")) {
            return new StudentA(id, name,address,priority);
        } else if (type.equals("b")) {
            return new StudentB(id, name,address,priority);
        } else {
            return new StudentC(id, name,address,priority);
        }
    }
}
