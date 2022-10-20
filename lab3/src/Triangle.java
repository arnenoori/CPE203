import java.awt.Point;
import java.awt.Color;
import java.awt.List;

public class Triangle implements Shape {

    private Point a;
    private Point b;
    private Point c;
    private Color color;

    // use Heron's Formula to calculate the area of a triangle
    Triangle(Point a, Point b, Point c, Color color) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = color;
    }

    public Point getVertexA() {
        // returns point A
        return this.a;
    }

    public Point getVertexB() {
        // returns point B
        return this.b;
    }

    public Point getVertexC() {
        // returns point C
        return this.c;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public double getArea() {
        // Heron's formula
        // Area = Square root of√s(s - a)(s - b)(s - c) where s is half the perimeter, or (a + b + c)/2.
        return Math.abs((a.getX() * (b.getY() - c.getY()) +
                b.getX() * (c.getY() - a.getY()) +
                c.getX() * (a.getY() - b.getY())) / 2);
    }

    public double getPerimeter() {
        double ab = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        double ac = Math.sqrt(Math.pow(a.getX() - c.getX(), 2) + Math.pow(a.getY() - c.getY(), 2));
        double cb = Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY()- b.getY(), 2));
        return ab + ac + cb;
    }

    public void translate(Point p) {
        a.setLocation(a.getX() + p.getX(), a.getY() + p.getY());
        b.setLocation(b.getX() + p.getX(), b.getY() + p.getY());
        c.setLocation(c.getX() + p.getX(), c.getY() + p.getY());
    }

    @Override
    public boolean equals(Object x) {
        // overrides equals method inherited from Objec
        if(x == null){
            return false;
        }
        if(this.getClass() != x.getClass()){
            return false;
        }
        Triangle otherTriangle = (Triangle)x;
        return this.a.equals(otherTriangle.getVertexA()) && this.b.equals(otherTriangle.getVertexB())
                && this.c.equals((otherTriangle.getVertexC()));
    }

}
