package bai1;

public class CongNhan extends CanBo {

    private int level;

    public CongNhan(String fullName, int age, String gender, String address, int level) {
        super(fullName, age, gender, address);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
