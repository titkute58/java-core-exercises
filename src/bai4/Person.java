package bai4;

public class Person {

    private String fullName;
    private int age;
    private String occupation;
    private String idNumber;

    public Person(String fullName, int age, String occupation, String idNumber) {
        this.fullName = fullName;
        this.age = age;
        this.occupation = occupation;
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
