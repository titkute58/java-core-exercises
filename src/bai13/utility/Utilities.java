package bai13.utility;

import bai13.exception.BirthDayException;
import bai13.exception.EmailException;
import bai13.exception.FullNameException;
import bai13.exception.PhoneException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Utilities {

    public static void validateName(String name) throws FullNameException {
        if (name == null || name.isEmpty()) {
            throw new FullNameException("Name cannot be null or empty");
        }
        String regex = "^[\\p{L} .'-]+$";
        if (!name.matches(regex)) {
            throw new FullNameException("Name contains invalid characters");
        }
    }

    public static void validateEmail(String email) throws EmailException {
        if (email == null || email.isEmpty()) {
            throw new EmailException("Email cannot be null or empty");
        }
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.matches(regex)) {
            throw new EmailException("Email is not in a valid format");
        }
    }

    public static void validatePhoneNumber(String phoneNumber) throws PhoneException {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new PhoneException("Phone number cannot be null or empty");
        }
        String regex = "^\\d{10}$";
        if (!phoneNumber.matches(regex)) {
            throw new PhoneException("Phone number is not in a valid format");
        }
    }

    public static void validateDOB(LocalDate dob) throws BirthDayException {
        if (dob == null) {
            throw new BirthDayException("Date of birth cannot be null");
        }
        LocalDate today = LocalDate.now();
        if (dob.isAfter(today)) {
            throw new BirthDayException("Date of birth cannot be in the future");
        }
    }


    public static boolean isValidName(String name) {
        String regex = "^[\\p{L} .'-]+$";
        return Pattern.matches(regex, name);
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, email);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\d{10}$";
        return Pattern.matches(regex, phoneNumber);
    }

    public static boolean isValidDOB(String dobString) {
        LocalDate dob = parseDOB(dobString);
        if (dob == null) {
            return false;
        }
        LocalDate today = LocalDate.now();
        return dob.isBefore(today);
    }

    private static LocalDate parseDOB(String dobString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate dob = LocalDate.parse(dobString, formatter);
            return dob;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter date in the format dd-MM-yyyy");
            return null;
        }
    }

    public static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
