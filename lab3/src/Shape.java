import java.awt.Point;
import java.awt.Color;

// Lab Instructions:
// http://users.csc.calpoly.edu/~klmork/203/labs/lab3.html

public interface Shape {
    Color getColor();
    void setColor(Color c);
    double getArea();
    double getPerimeter();
    void translate(Point p);
}


