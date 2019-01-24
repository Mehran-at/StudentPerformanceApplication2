package studentPerformanceApplication;

public class Student {
    private String gender;
    private String parentalLevelOfEducation;
    private Integer mathScore;
    private Integer readingScore;
    private Integer writingScore;
    private Double average;

    public Student(String gender, String parentalLevelOfEducation, Integer mathScore, Integer readingScore, Integer writingScore) {
        this.gender = gender;
        this.parentalLevelOfEducation = parentalLevelOfEducation;
        this.mathScore = mathScore;
        this.readingScore = readingScore;
        this.writingScore = writingScore;
        this.average = average;
    }

    public String getGender() {
        return gender;
    }

    public String getParentalLevelOfEducation() {
        return parentalLevelOfEducation;
    }

    public Integer getMathScore() {
        return mathScore;
    }

    public Integer getReadingScore() {
        return readingScore;
    }

    public Double getAverage() {
        return average;
    }

    public Integer getWritingScore() {
        return writingScore;
    }

    public void setAverage(Double average) {
        this.average = average;
    }
}
