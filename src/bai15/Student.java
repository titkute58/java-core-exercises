package bai15;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

    protected String studentId;
    protected String fullName;
    protected LocalDate dob;
    protected int admissionYear;
    protected double entranceScore;
    protected List<AcademicResult> academicResults;

    public void addAcademicResult(AcademicResult result) {
        academicResults.add(result);
    }

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
    }

    public void output() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student name: " + fullName);
        System.out.println("Student date of birth: " + dob);
        System.out.println("Year of admission: " + admissionYear);
        System.out.println("Entrance score: " + entranceScore);
    }

    public double getAverageScore(String semester) {
        for (AcademicResult result : academicResults) {
            if (result.getSemester().equals(semester)) {
                return result.getAverageScore();
            }
        }
        return -1;
    }

    public boolean isRegular() {
        return true;
    }

    public Student() {
        academicResults = new ArrayList<>();
    }

    public Student(String studentId, String fullName, LocalDate dob, int admissionYear, double entranceScore) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dob = dob;
        this.admissionYear = admissionYear;
        this.entranceScore = entranceScore;
        this.academicResults = new ArrayList<>();
    }

    public Student(String studentId, String fullName, LocalDate dob, int admissionYear, double entranceScore, List<AcademicResult> academicResults) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dob = dob;
        this.admissionYear = admissionYear;
        this.entranceScore = entranceScore;
        this.academicResults = academicResults;
    }

    public Student(Student other) {
        this.studentId = other.studentId;
        this.fullName = other.fullName;
        this.dob = other.dob;
        this.admissionYear = other.admissionYear;
        this.entranceScore = other.entranceScore;
        this.academicResults = new ArrayList<>(other.academicResults);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public double getEntranceScore() {
        return entranceScore;
    }

    public void setEntranceScore(double entranceScore) {
        this.entranceScore = entranceScore;
    }

    public List<AcademicResult> getAcademicResults() {
        return academicResults;
    }

    public void setAcademicResults(List<AcademicResult> academicResults) {
        this.academicResults = academicResults;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + studentId + '\'' +
                ", name='" + fullName + '\'' +
                ", dob=" + dob +
                ", yearOfAdmission=" + admissionYear +
                ", entranceScore=" + entranceScore +
                '}';
    }
}
