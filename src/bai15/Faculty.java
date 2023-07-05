package bai15;

import java.util.*;
import java.util.stream.Collectors;

public class Faculty {
    private String name;
    private List<Student> students;

    public void sortStudents() {
        Collections.sort(students, new StudentComparator());
    }

    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public Map<Integer, Integer> getStudentCountByYear() {
        Map<Integer, Integer> countByYear = new HashMap<>();
        for (Student student : students) {
            int year = student.getAdmissionYear();
            countByYear.put(year, countByYear.getOrDefault(year, 0) + 1);
        }
        return countByYear;
    }

    public Student getHighestEntranceScoreStudent() {
        double max = -1;
        int index = 0;
        for (Student student : students) {
            if (max < student.entranceScore) {
                max = student.entranceScore;
                index = students.indexOf(student);
            }
        }
        return students.get(index);
    }

    public Student getBestStudent() {
        Student bestStudent = null;
        double bestAverageScore = -1;
        for (Student student : students) {
            double averageScore = getMaxAverageScore(student);
            if (averageScore > bestAverageScore) {
                bestStudent = student;
                bestAverageScore = averageScore;
            }
        }
        return bestStudent;
    }

    private double getMaxAverageScore(Student student) {
        double maxAverageScore = -1;
        for (AcademicResult result : student.getAcademicResults()) {
            if (result.getAverageScore() > maxAverageScore) {
                maxAverageScore = result.getAverageScore();
            }
        }
        return maxAverageScore;
    }

    // Get student list with average score higher than 8.0 in the last semester
    public List<Student> getTopStudents() {
        List<Student> topStudents = new ArrayList<>();
        for (Student student : students) {
            AcademicResult latestResult = getLatestAcademicResult(student);
            if (latestResult != null && latestResult.getAverageScore() >= 8.0) {
                topStudents.add(student);
            }
        }
        return topStudents;
    }

    private AcademicResult getLatestAcademicResult(Student student) {
        List<AcademicResult> results = student.getAcademicResults();
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(results.size() - 1);
        }
    }

    public List<Student> getPTStudentByLocation(String location) {
        return students.stream().filter(student -> !student.isRegular()).collect(Collectors.toList());
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int countRegularStudents() {
        int count = 0;
        for (Student student : students) {
            if (student.isRegular()) {
                count++;
            }
        }
        return count;
    }

    public Faculty(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public Faculty(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public Faculty() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            if (s1.isRegular() && !s2.isRegular()) {
                return -1;
            } else if (!s1.isRegular() && s2.isRegular()) {
                return 1;
            } else {
                return Integer.compare(s2.getAdmissionYear(), s1.getAdmissionYear());
            }
        }
    }
}
