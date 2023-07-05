package bai13.model;

import java.util.List;

public class Intern extends  Employee{

    private String major;
    private int semester;
    private String universityName;

    @Override
    public void showMe() {
        System.out.println("Fresher {" + "\n\t" +
                "Id: " + id + "\n\t" +
                "Full Name: " + fullName + "\n\t" +
                "Birthday: " + birthDay + "\n\t" +
                "Phone: " + phone + "\n\t" +
                "Email: " + email + "\n\t" +
                "Graduation Date: " + major + "\n\t" +
                "Semester: " + semester + "\n\t" +
                "University Name: " + universityName + "\n" +
                '}');
    }

    public Intern(String id, String fullName, String birthDay, String phone, String email,
                  List<EmployeeCertificate> certificates,
                  String major, int semester, String universityName) {
        super(id, fullName, birthDay, phone, email, certificates);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
        this.type = 2;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
