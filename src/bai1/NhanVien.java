package bai1;

public class NhanVien extends CanBo {

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public NhanVien(String fullName, int age, String gender, String address, String role) {
        super(fullName, age, gender, address);
        this.role = role;
    }
}
