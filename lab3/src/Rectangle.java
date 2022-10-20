import java.awt.Point;
import java.awt.Color;

public class Rectangle implements Shape {
    private double width;
    private double height;
    private Point topLeft;
    private Color color;

    public Rectangle(double width, double height, Point topLeft, Color color) {
        // initialize variables
        this.width = width;
        this.height = height;
        this.topLeft = topLeft;
        this.color = color;
    }

    public void setWidth(double width) {
        // sets the width width
        this.width = width;
    }

    public double getWidth() {
        // return width
        return this.width;
    }

    public void setHeight(double height) {
        // sets the height of the Rectangle
        this.height = height;
    }

    public double getHeight() {
        // return height
        return this.height;
    }

    public Point getTopLeft() {
        // returns thePoint representing the top left corner of the Rectangle
        return this.topLeft;
    }

    @Override
    public boolean equals(Object y) {
        // overrides the equals methods from Object
        if(y == null){
            return false;
        }
        if(this.getClass() != y.getClass()){
            return false;
        }
        Rectangle otherRectangle = (Rectangle)y;
        return this.width == otherRectangle.getWidth() && this.height == otherRectangle.getHeight()
                && this.topLeft.equals(otherRectangle.getTopLeft()) && this.color.equals(otherRectangle.getColor());
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        double twiceHeight = 2 * this.height;
        double twiceWidth = 2 * this.width;
        return twiceHeight + twiceWidth;
    }

    public void translate(Point p) {
        topLeft.setLocation(topLeft.getX() + p.getX(), topLeft.getY() + p.getY());
    }

}
