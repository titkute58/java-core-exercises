package bai15;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PartTimeStudent extends  Student{

    private String trainingLocation;

    @Override
    public void input(Scanner scanner) {
        System.out.print("Enter student ID: ");
        studentId = scanner.nextLine();
        System.out.print("Enter student name: ");
        fullName = scanner.nextLine();
        System.out.print("Enter student date of birth (yyyy-MM-dd): ");
        try {
            dob = LocalDate.parse(scanner.nextLine());
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter date in the format yyyy-MM-dd");
            return;
        }
        System.out.print("Enter year of admission: ");
        try {
            admissionYear = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year of admission. Please enter a valid integer");
            return;
        }
        System.out.print("Enter entrance score: ");
        try {
            entranceScore = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid entrance score. Please enter a valid number");
            return;
        }
        System.out.println("Enter number of semesters: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0;i < n;i++) {
            System.out.println("Enter semester: ");
            String semesterName = scanner.nextLine();
            System.out.println("Enter average score: ");
            double score = scanner.nextDouble();
            scanner.nextLine();
            academicResults.add(new AcademicResult(semesterName, score));
        }
        System.out.println("Enter training location: ");
        trainingLocation = scanner.nextLine();
    }

    @Override
    public boolean isRegular() {
        return false;
    }

    public PartTimeStudent() {
        super();
    }

    public PartTimeStudent(String id, String name, LocalDate dob, int yearOfAdmission, double entranceScore, String trainingLocation) {
        super(id, name, dob, yearOfAdmission, entranceScore);
        this.trainingLocation = trainingLocation;
    }

    public PartTimeStudent(PartTimeStudent other) {
        super(other);
        this.trainingLocation = other.trainingLocation;
    }

    public String getTrainingLocation() {
        return trainingLocation;
    }

    public void setTrainingLocation(String trainingLocation) {
        this.trainingLocation = trainingLocation;
    }

    @Override
    public String toString() {
        return "PartTimeStudent{" +
                "id='" + studentId + '\'' +
                ", name='" + fullName + '\'' +
                ", dob=" + dob +
                ", yearOfAdmission=" + admissionYear +
                ", entranceScore=" + entranceScore +
                ", trainingLocation='" + trainingLocation + '\'' +
                '}';
    }
}
