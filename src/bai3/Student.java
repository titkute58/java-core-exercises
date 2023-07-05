package bai3;

public class Student {

    protected String id;
    protected String fullName;
    protected String address;
    protected int priorityLevel;

    public Student(String id, String fullName, String address, int priorityLevel) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.priorityLevel = priorityLevel;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
}
