package bai13;

import bai13.utility.Utilities;
import bai13.exception.BirthDayException;
import bai13.exception.EmailException;
import bai13.exception.FullNameException;
import bai13.exception.PhoneException;
import bai13.model.*;
import bai13.service.EmployeeManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmployeeManager employeeManager = new EmployeeManager();

        while (true) {
            System.out.println("Employee manager application");
            System.out.println("Enter 1: Add employee");
            System.out.println("Enter 2: Delete employee with a specific id");
            System.out.println("Enter 3: Modify employee with a specific id");
            System.out.println("Enter 4: Show all employee with a specific type");
            System.out.println("Enter 5: Exit");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Enter type of employee");
                    System.out.println("For experienced is 0");
                    System.out.println("For fresher is 1");
                    System.out.println("For intern is 2");
                    String type = scanner.nextLine();
                    Employee employeeToAdd = createEmployee(scanner, type);
                    if (!Objects.isNull(employeeToAdd)) {
                        employeeManager.addEmployee(employeeToAdd);
                        Employee.count++;
                    } else {
                        System.out.println("Invalid input");
                    }
                    break;
                case "2": {
                    System.out.println("Enter id of employee to delete: ");
                    String id = scanner.nextLine();
                    employeeManager.deleteEmployee(id);
                    Employee.count--;
                    break;
                }
                case "3": {
                    System.out.println("Enter id of employee to modify: ");
                    String id = scanner.nextLine();
                    Employee employee = employeeManager.findById(id);
                    if (Objects.isNull(employee)) {
                        System.out.println("No employee matched the given id");
                    } else {
                        employee.showMe();
                        Employee employeeUpdated = null;
                        if (employee instanceof Experienced) {
                            employeeUpdated = createEmployee(scanner, "0");
                        } else if (employee instanceof Fresher) {
                            employeeUpdated = createEmployee(scanner, "1");
                        } else if (employee instanceof Intern) {
                            employeeUpdated = createEmployee(scanner, "2");
                        }
                        if (Objects.isNull(employeeUpdated)) {
                            System.out.println("Invalid input");
                        } else {
                            employeeManager.updateEmployee(employeeUpdated);
                        }
                    }
                    break;
                }
                case "4":
                    System.out.println("0. Experienced");
                    System.out.println("1. Fresher");
                    System.out.println("2. Intern");
                    int typeOfEmployee = scanner.nextInt();
                    employeeManager.findByType(typeOfEmployee).forEach(employee -> {
                        if (employee instanceof Experienced) {
                            employee.showMe();
                        } else if (employee instanceof Fresher) {
                            employee.showMe();
                        } else if (employee instanceof Intern) {
                            employee.showMe();
                        } else {
                            System.out.println("Invalid option");
                        }
                    });
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static List<EmployeeCertificate> generateCertificates(Scanner scanner, int n) {
        List<EmployeeCertificate> list = new ArrayList<>();
        for (int i = 0;i < n;i++) {
            System.out.println("Enter Certificated id: ");
            String certId = scanner.nextLine();
            System.out.println("Enter Certificate name: ");
            String certName = scanner.nextLine();
            System.out.println("Enter Certificate rank: ");
            String certRank = scanner.nextLine();
            System.out.println("Enter Certificated date: ");
            String certDate = scanner.nextLine();
            // Can improve code with checking if the input is valid
            list.add(new EmployeeCertificate(certId,certName,Integer.parseInt(certRank),certDate));
        }
        return list;
    }

    private static Employee createEmployee(Scanner scanner, String type) {
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();
        try {
            Utilities.validateName(fullName);
            System.out.println("Name is valid");
        } catch (FullNameException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enter date of birth in format dd-MM-yyyy: ");
        String dob = scanner.nextLine();
        try {
            Utilities.validateDOB(LocalDate.parse(dob));
            System.out.println("Date of birth is valid");
        } catch (BirthDayException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        try {
            Utilities.validatePhoneNumber(phone);
            System.out.println("Phone number is valid");
        } catch (PhoneException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        try {
            Utilities.validateEmail(email);
            System.out.println("Email is valid");
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Enter number of certificates: ");
        String numberOfCert = scanner.nextLine();
        List<EmployeeCertificate> certs = new ArrayList<>();
        certs = generateCertificates(scanner, Integer.parseInt(numberOfCert));
        if ("0".equals(type)) {
            System.out.println("Enter year of experience: ");
            String yearOfExp = scanner.nextLine();
            System.out.println("Enter profession skills (in one line): ");
            String skills = scanner.nextLine();

            // Input validation
            if (Utilities.isValidName(fullName) && Utilities.isValidDOB(dob)
            && Utilities.isValidEmail(email) && Utilities.isValidPhoneNumber(phone)
            && Utilities.isInteger(numberOfCert) && Utilities.isInteger(yearOfExp)) {
                return new Experienced(id, fullName, dob, phone, email, certs, Integer.parseInt(yearOfExp), skills);
            } else {
                return null;
            }
        } else if ("1".equals(type)) {
            System.out.println("Enter graduation date: ");
            String graduationDate = scanner.nextLine();
            System.out.println("Enter graduation rank: ");
            String graduationRank = scanner.nextLine();
            System.out.println("Enter university name: ");
            String universityName = scanner.nextLine();

            // Input validation
            if (Utilities.isValidName(fullName) && Utilities.isValidDOB(dob)
                    && Utilities.isValidEmail(email) && Utilities.isValidPhoneNumber(phone)
                    && Utilities.isInteger(numberOfCert) && Utilities.isValidDOB(graduationDate)
                    && Utilities.isInteger(graduationRank)) {
                return new Fresher(id, fullName, dob, phone, email, certs, graduationDate, graduationRank, universityName);
            } else {
                return null;
            }
        } else if ("2".equals(type)) {
            System.out.println("Enter major: ");
            String major = scanner.nextLine();
            System.out.println("Enter semester: ");
            String semester = scanner.nextLine();
            System.out.println("Enter university name: ");
            String universityName = scanner.nextLine();

            // Input validation
            if (Utilities.isValidName(fullName) && Utilities.isValidDOB(dob)
                    && Utilities.isValidEmail(email) && Utilities.isValidPhoneNumber(phone)
                    && Utilities.isInteger(numberOfCert) && Utilities.isInteger(semester)) {
                return new Fresher(id, fullName, dob, phone, email, certs, major, semester, universityName);
            } else {
                return null;
            }
        }
        return null;
    }
}
