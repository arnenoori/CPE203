import java.util.List;
import java.util.Objects;

class Student
{
   private final String surname;
   private final String givenName;
   private final int age;
   private final List<CourseSection> currentCourses;

   public Student(final String surname, final String givenName, final int age,
      final List<CourseSection> currentCourses)
   {
      this.surname = surname;
      this.givenName = givenName;
      this.age = age;
      this.currentCourses = currentCourses;
   }

   // Hashcode implementation (short way)
   public int hashCode() {
      return(Objects.hash(surname, givenName, age, currentCourses));
   }

   // Equals short way as a result
   public boolean equals(Object other) {
      if(other != null) {
         if (getClass() == other.getClass()) {
            boolean surnameEqual = Objects.equals(surname,((Student) other).surname);
            boolean givenNameEqual = Objects.equals(givenName,((Student) other).givenName);
            boolean ageEqual = Objects.equals(age,((Student) other).age);
            boolean currentCoursesEqual = Objects.equals(currentCourses,((Student) other).currentCourses);

            return surnameEqual && givenNameEqual && ageEqual && currentCoursesEqual;
         }
      }
      return false;
   }
}
