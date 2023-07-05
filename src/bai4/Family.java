package bai4;

import java.util.List;

public class Family {

    private List<Person> familyMembers;
    private String address;

    public Family(List<Person> familyMembers, String address) {
        this.familyMembers = familyMembers;
        this.address = address;
    }

    public List<Person> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<Person> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
