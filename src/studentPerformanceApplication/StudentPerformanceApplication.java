package studentPerformanceApplication;

import com.sun.org.glassfish.external.statistics.Statistic;

import java.util.List;

public class StudentPerformanceApplication {
    public static void main(String[] args) {
        StudentData studentData = new StudentData();
        List<Student> students = studentData.getStudentsData();
        StudentStatistic studentStatistic = new StudentStatistic();
        //----Students Statistic:------------
//        How many times does each parent level of education appear?
        studentStatistic.getParentalStatisticOnEdu(students);
//        Which are the different parent level of educations sorted from most appearing to least appearing?
        studentStatistic.getParentalStatisticOnEduOrdered(students);
//        How many students have parents with a master’s degree and lower grades than 60 on each topic?
        studentStatistic.getStudentsWithParentMasterAndLowDegree(students);
//        Which genders and average scores do the three students with the highest average score have?
        studentStatistic.getTopThreeHighest(students);
//        Is there any student with a parent education level of some high school that has at least 95 in every topic?
        studentStatistic.getStudentWithHighScoreAndHighSchoolLevelParent(students);
    }
}
