package bai13.model;

import java.util.List;

public class Fresher extends Employee {

    private String graduationDate;
    private String graduationRank;
    private String universityName;

    @Override
    public void showMe() {
        System.out.println("Fresher {" + "\n\t" +
                "Id: " + id + "\n\t" +
                "Full Name: " + fullName + "\n\t" +
                "Birthday: " + birthDay + "\n\t" +
                "Phone: " + phone + "\n\t" +
                "Email: " + email + "\n\t" +
                "Graduation date: " + graduationDate + "\n\t" +
                "Graduation rank: " + graduationRank + "\n\t" +
                "University Name: " + universityName + "\n" +
                '}');
    }

    public Fresher(String id, String fullName, String birthDay, String phone, String email,
                   List<EmployeeCertificate> certificates,
                   String graduationDate, String graduationRank, String universityName) {
        super(id, fullName, birthDay, phone, email, certificates);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.universityName = universityName;
        this.type = 1;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
