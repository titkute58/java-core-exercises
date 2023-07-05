package bai13.model;

import java.util.List;

public class Experienced extends Employee{

    private int yearOfExperience;
    private String proSkill;

    @Override
    public void showMe() {
        System.out.println("Fresher {" + "\n\t" +
                "Id: " + id + "\n\t" +
                "Full Name: " + fullName + "\n\t" +
                "Birthday: " + birthDay + "\n\t" +
                "Phone: " + phone + "\n\t" +
                "Email: " + email + "\n\t" +
                "Year of Experience: " + yearOfExperience + "\n\t" +
                "Profession skills: " + proSkill + "\n" +
                '}');
    }

    public Experienced(String id, String fullName, String birthDay, String phone, String email,
                       List<EmployeeCertificate> certificates, int yearOfExperience, String proSkill) {
        super(id, fullName, birthDay, phone, email, certificates);
        this.yearOfExperience = yearOfExperience;
        this.proSkill = proSkill;
        this.type = 0;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
