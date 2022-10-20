import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestCases
{
   /*
    * This test is just to get you started.
    */
   @Test
   public void testGetName()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 75),
         new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades);
      assertEquals("Aakash", testApplicant.getName());
   }

   /* Added tests */


   // This student is very qualified, and should pass our tests
   @Test
   public void testQualifiedStudent()
   {
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Bob", grades, 3, 3, true);
      assertTrue(SimpleIf.analyzeApplicant2(testApplicant));
   }

   // Unqualified student
   @Test
   public void testUnqualifiedStudent()
   {
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Bob", grades, 0, 0, true);
      assertFalse(SimpleIf.analyzeApplicant2(testApplicant));
   }

   // Average student
   @Test
   public void testAverageStudent()
   {
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Bob", grades, 1, 1, true);
      assertTrue(SimpleIf.analyzeApplicant2(testApplicant));
   }


   /*
    * The tests below here are to verify the basic requirements regarding
    * the "design" of your class.  These are to remain unchanged.
    */
   @Test
   public void testImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getName",
         "getGrades",
         "getGradeFor"
      );

      final List<Class> expectedMethodReturns = Arrays.asList(
         String.class,
         List.class,
         CourseGrade.class
      );

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0],
         new Class[0],
         new Class[] { String.class }
         );

      verifyImplSpecifics(Applicant.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals(0, Applicant.class.getFields().length,
              "Unexpected number of public fields");

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());


      assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
              "Invalid test configuration");
      assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
              "Invalid test configuration");

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }
}
