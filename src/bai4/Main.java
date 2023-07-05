package bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SubQuarter subQuarter = new SubQuarter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {

            System.out.println("Enter address: ");
            scanner.nextLine(); //Pass the new line from the nextInt - similar to cin.ignore()
            String address = scanner.nextLine();

            List<Person> people = new ArrayList<>();
            System.out.println("Enter number person");
            int numberOfPeople = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < numberOfPeople; j++) {
                System.out.println("Enter full name: ");
                String fullName = scanner.nextLine();
                System.out.println("Enter age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter occupation: ");
                String occupation = scanner.nextLine();
                System.out.println("Enter id number: ");
                String idNumber = scanner.nextLine();
                people.add(new Person(fullName, age, occupation, idNumber));
            }

            subQuarter.addFamily(new Family(people, address));

        }

        subQuarter.subQuarter.forEach(family -> {
            System.out.println("Family address: " + family.getAddress());
            family.getFamilyMembers().forEach(person -> {
                System.out.println(
                        "Full name: " + person.getFullName() + "\n"
                        + "Age: " + person.getAge() + "\n"
                        + "Occupation: " + person.getOccupation() + "\n"
                        + "Identity number: " + person.getIdNumber()
                        );
            });
        });

    }
}
