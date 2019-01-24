package studentPerformanceApplication;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentStatistic {
    void getParentalStatisticOnEdu(List<Student> studentsProfile) {
        System.out.println("\n\n -How many times does each parent level of education appear?");
        studentsProfile.stream()
                .collect(Collectors.groupingBy(Student::getParentalLevelOfEducation))
                .entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue().size() + " times."));
    }

    void getParentalStatisticOnEduOrdered(List<Student> studentsProfile) {
        System.out.println("\n\n -How many times does each parent level of education appear in order sorted edition?");
        studentsProfile.stream()
                .collect(Collectors.groupingBy(Student::getParentalLevelOfEducation,Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue() + " times."));
    }

    void getStudentsWithParentMasterAndLowDegree (List<Student> studentsProfile) {
        System.out.println("\n\n -How many students have parents with a master’s degree and lower grades than 60 on each topic?");
        long studentStatistic = studentsProfile.stream()
                .filter(e -> e.getParentalLevelOfEducation().equalsIgnoreCase("master's degree"))
                .filter(e -> e.getMathScore() < 60 && e.getReadingScore() < 60 && e.getWritingScore() < 60).count();
        System.out.println(studentStatistic);
    }

    void getTopThreeHighest(List<Student> studentsProfile) {
        System.out.println("\n\n -Which genders and average scores do the three students with the highest average score have?");
        studentsProfile.stream()
                .peek(e -> e.setAverage(getAveragee(e)))
                .sorted(Comparator.comparing(Student::getAverage).reversed())
//                .map(e->e.getAverage())
//                .sorted((e1,e2)->e2.compareTo(e1))
                .limit(4)
                .forEach(e -> System.out.println("A " + e.getGender() + " with average score of: " + e.getAverage()));
    }

    void getStudentWithHighScoreAndHighSchoolLevelParent(List<Student> studentsProfile) {
        System.out.println("\n\n -Is there any student with a parent education level of some high school that has at least 97 in every topic?");
        boolean anyMatchForHighScoreAndParentalEduLevel = studentsProfile.stream()
                .filter(e -> e.getParentalLevelOfEducation().equalsIgnoreCase("some high school"))
                .anyMatch(e -> e.getWritingScore() >= 97 && e.getReadingScore() >= 97 && e.getMathScore() >= 97);
        System.out.println(anyMatchForHighScoreAndParentalEduLevel);
    }

    private Double getAveragee(Student e) {
        return IntStream.of(e.getMathScore(), e.getReadingScore(), e.getWritingScore())
                .average().getAsDouble();
    }
}
