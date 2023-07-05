package bai1;

public class KySu extends CanBo {

    private String major;

    public KySu(String fullName, int age, String gender, String address, String major) {
        super(fullName, age, gender, address);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
