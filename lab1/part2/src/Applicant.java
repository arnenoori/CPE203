import java.util.List;
import java.util.Map;

public class Applicant {
    private final int yearsOfExperience;
    private final int numberOfKnownLanguages;
    private final boolean previousWork;
    private final List<CourseGrade> grades;
    private final String name;

    public Applicant(String name, List<CourseGrade> grades) {
        this.yearsOfExperience = 0;
        this.numberOfKnownLanguages = 0;
        this.previousWork = false;
        this.name = name;
        this.grades = grades;

    } // — Constructor.

    public Applicant(String name, List<CourseGrade> grades, int yearsOfExperience, int numberOfKnownLanguages, boolean previousWork) {
        this.yearsOfExperience = yearsOfExperience;
        this.numberOfKnownLanguages = numberOfKnownLanguages;
        this.previousWork = previousWork;
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return this.name;
    }// — Returns the applicant’s name.


    public List<CourseGrade> getGrades() {
        return this.grades;
    }// — Returns the applicant’s list of scores.

    public int getYearsOfExperience() {
        return this.yearsOfExperience;
    } // Returns number of years of programming experience a person has.

    public int getNumberOfKnownLanguages() {
        return this.numberOfKnownLanguages;
    } // Returns number of languages a person knows

    public boolean getPreviousWork() {
        return this.previousWork;
    } // Returns if person has had previous internships


    public CourseGrade getGradeFor(String course) {
        for(CourseGrade courseName: grades) {
            if(courseName.getCourseName().equals(course))
                return courseName;
        }
        return null;
    }
    //  — Returns the CourseGrade that was asked for. The course parameter can be one of the courses as defined here.
    //  That is, getGradeFor("Intro to CS") will return the CourseGrade at index 0, getGradeFor("DataStructures") will return the CourseGrade at index 1, and so on.




}
