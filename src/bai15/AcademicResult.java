package bai15;

public class AcademicResult {

    private String semester;
    private double averageScore;

    public AcademicResult(String semester, double averageScore) {
        this.semester = semester;
        this.averageScore = averageScore;
    }

    public AcademicResult() {

    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
}
