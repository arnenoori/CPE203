import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WorkSpace {
    private List<Shape> shapes;

    public WorkSpace() {
        // The constructor should not take any parameters.
        this.shapes = new ArrayList<>();
    }

    public void add(Shape shape) {
        // Adds an object which implements the Shape interface to the end of the List in the WorkSpace.
        shapes.add(shape);
    }

    public Shape get(int index) {
        // Returns the specified Shape from the WorkSpace.
        return shapes.get(index);
    }

    public int size() {
        // Returns the number of Shapes contained by the WorkSpace.
        return shapes.size();
    }

    public List<Circle> getCircles() {
        // Returns a List of all the Circle objects contained by the WorkSpace.
        List<Circle> circles = new ArrayList<>();
        for (Shape shape: shapes) {
            if (shape instanceof Circle) {
                circles.add((Circle) shape);
            }
        }
        return circles;
    }

    public List<Rectangle> getRectangles() {
        // Returns a List of all the Rectangle objects contained by the WorkSpace.
        List<Rectangle> rectangles = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape instanceof Rectangle) {
                rectangles.add((Rectangle) shape);
            }
        }
        return rectangles;
    }

    public List<Triangle> getTriangles() {
        // Returns a List of all the Triangle objects contained by the WorkSpace.
        List<Triangle> triangles = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape instanceof Triangle) {
                triangles.add((Triangle) shape);
            }
        }
        return triangles;
    }

    public List<Shape> getShapesByColor(Color color) {
        // Returns a List of all the Shape objects contained by the WorkSpace that match the specified Color.
        List <Shape> shapeList = new ArrayList<>();
        for (Shape shape: shapes) {
            if (shape.getColor().equals(color)) {
                shapeList.add(shape);
            }
        }
        return shapeList;
    }


    public double getAreaOfAllShapes() {
        // Returns the sum of the areas of all the Shapes contained by the WorkSpace.
        double area = 0;
        for (Shape shape: shapes) {
            area += shape.getArea();
        }
        return area;
    }


    public double getPerimeterOfAllShapes() {
        // Returns the sum of the perimeters of all the Shapes contained by the WorkSpace.
        double perimeter = 0;
        for (Shape shape: shapes) {
            perimeter += shape.getPerimeter();
        }
        return perimeter;
    }

}
