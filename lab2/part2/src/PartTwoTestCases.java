import org.junit.jupiter.api.Test;

import java.awt.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// import static org.junit.jupiter.api.AssertTrue.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartTwoTestCases
{
   public static final double DELTA = 0.00001;

   @Test
   public void testCircleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getCenter", "getRadius", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, double.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0], new Class[0]);

      /*verifyImplSpecifics(Circle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);*/
   }

   // added perimeter test for circle

   @Test
   public void testCirclePerimeter() {
      Circle circle = new Circle(new Point(0,1), 5);
      assertEquals(31.4159265359, circle.perimeter(), DELTA);
   }

   @Test
   public void testRectangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getTopLeft", "getBottomRight", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, Point.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0], new Class[0]);

      /*verifyImplSpecifics(Rectangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);*/
   }

   // added perimeter test for rectangle

   @Test
   public void testRectanglePerimeter(){
      Rectangle rectangle = new Rectangle(new Point(5,5), new Point(1,1));
      assertEquals(16, rectangle.perimeter(), DELTA);
   }

   @Test
   public void testPolygonImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getPoints", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         List.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0]);

//      verifyImplSpecifics(Polygon.class, expectedMethodNames,
//         expectedMethodReturns, expectedMethodParameters);
   }

   // added perimeter test for polygon

   @Test
   public void testPolygonPerimeter(){
      List<Point> polygon = new ArrayList<Point>();
      Point point1 = new Point(0,0);
      polygon.add(point1);
      Point point2 = new Point(10,0);
      polygon.add(point2);
      Point point3 = new Point(10,10);
      polygon.add(point3);
      Point point4 = new Point(0,10);
      polygon.add(point4);
      Polygon calpoly = new Polygon(polygon);
      assertEquals(40, calpoly.perimeter(), DELTA);
   }

   // which is bigger

   @Test
   public void testBigger(){
      // create circle
      Circle circle1 = new Circle(new Point(0,1), 2);

      // create rectangle
      Rectangle rectangle1 = new Rectangle(new Point(5,5), new Point(1,1));

      // create polygon
      List<Point> polygon1 = new ArrayList<Point>();
      Point p1 = new Point(0,0);
      polygon1.add(p1);
      Point p2 = new Point(10,0);
      polygon1.add(p2);
      Point p3 = new Point(10,10);
      polygon1.add(p3);
      Point p4 = new Point(0,10);
      polygon1.add(p4);
      Polygon polycal = new Polygon(polygon1);

      // which is bigger
      assertEquals(40, Bigger.whichIsBigger(circle1, rectangle1, polycal), DELTA);
   }


   // remain untouched
/*
   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {

      assertEquals("Unexpected number of public fields",
         0, clazz.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertEquals("Unexpected number of public methods",
         expectedMethodNames.size(), publicMethods.size());

      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }

 */
}
