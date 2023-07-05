package bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QLCB {

    private List<CanBo> canBoList;

    public QLCB() {
        canBoList = new ArrayList<>();
    }

    public void addCanBo(CanBo canBo) {
        canBoList.add(canBo);
    }

    public List<CanBo> searchCanBo(String name) {
        return canBoList.stream().filter(c -> c.getFullName().contains(name)).collect(Collectors.toList());
    }

    public void printAll() {
        canBoList.forEach(c -> {
            if (c instanceof CongNhan) {
                System.out.println("Cong nhan:\n\t"
                + "Full name: " + c.getFullName() + "\n\t"
                + "Age: " + c.getAge() + "\n\t"
                + "Address: " + c.getAddress() + "\n\t"
                + "Gender: " + c.getGender() + "\n\t"
                + "Level: " + ((CongNhan) c).getLevel() + "\n");
            } else if (c instanceof NhanVien) {
                System.out.println("Nhan vien:\n\t"
                        + "Full name: " + c.getFullName() + "\n\t"
                        + "Age: " + c.getAge() + "\n\t"
                        + "Address: " + c.getAddress() + "\n\t"
                        + "Gender: " + c.getGender() + "\n\t"
                        + "Role: " + ((NhanVien) c).getRole() + "\n");
            } else if (c instanceof KySu) {
                System.out.println("Ky su:\n\t"
                        + "Full name: " + c.getFullName() + "\n\t"
                        + "Age: " + c.getAge() + "\n\t"
                        + "Address: " + c.getAddress() + "\n\t"
                        + "Gender: " + c.getGender() + "\n\t"
                        + "Major: " + ((KySu) c).getMajor() + "\n");
            }
        });
    }
}
