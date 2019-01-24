package studentPerformanceApplication;

import java.util.List;
import java.util.stream.Collectors;

public class StudentData {
    FileReader fileReader = new FileReader();
    private List<String> file = fileReader.asList("studentPerformanceApplication/students-performance.csv");

    public List<Student> getStudentsData() {
        List<Student> students =  file.stream()
                .skip(1)
                .map(e -> e.split(";"))
                .map(e -> new Student(e[0],e[1],Integer.valueOf(e[2]),Integer.valueOf(e[3]),Integer.valueOf(e[4])))
                .collect(Collectors.toList());
        return students;
    }
}