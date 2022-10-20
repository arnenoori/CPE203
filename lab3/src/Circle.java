import java.awt.Point;
import java.awt.Color;

public class Circle implements Shape {
    private double radius;
    private Point center;
    private Color color;

    public Circle(double radius, Point center, Color color) {
        this.radius = radius;
        this.center = center;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return this.center;
    }

    @Override
    public boolean equals(Object z) {
        if(z == null){
            return false;
        }
        if(this.getClass() != z.getClass()){
            return false;
        }
        Circle otherCircle = (Circle)z;
        return this.radius == otherCircle.getRadius() && this.center.equals(otherCircle.getCenter())
                && this.color.equals(otherCircle.getColor());
    }


    public Color getColor() {
        return this.color;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public double getArea() {
        return (Math.PI * Math.pow(this.radius, 2));
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    public void translate(Point p) {
        center.setLocation(center.getX() + p.getX(), center.getY() + p.getY());
    }



}
