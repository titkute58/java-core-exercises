package bai6;

public class Student {

    private String fullName;
    private int age;
    private String homeTown;

    public Student(String fullName, int age, String homeTown) {
        this.fullName = fullName;
        this.age = age;
        this.homeTown = homeTown;
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

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }
}
