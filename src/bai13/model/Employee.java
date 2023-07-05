package bai13.model;

import java.util.List;

public abstract class Employee {

    public static long count = 0;
    protected String id;
    protected String fullName;
    protected String birthDay;
    protected String phone;
    protected String email;
    protected int type;
    protected List<EmployeeCertificate> certificates;

    public abstract void showMe();

    public Employee(String id, String fullName, String birthDay, String phone, String email, List<EmployeeCertificate> certificates) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.certificates = certificates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EmployeeCertificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<EmployeeCertificate> certificates) {
        this.certificates = certificates;
    }
}
