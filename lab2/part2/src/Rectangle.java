public class Rectangle {
    private final Point top_left;
    private final Point bottom_right;

    public Rectangle(Point top_left, Point bottom_right) {
        this.top_left = top_left;
        this.bottom_right = bottom_right;
    }

    public Point getTopLeft() {
        return this.top_left;
    }

    public Point getBottomRight() {
        return this.bottom_right;
    }

    public double perimeter() {
        Point top_left = this.top_left;
        Point bottom_right = this.bottom_right;
        double top_left_x = top_left.getX();
        double top_left_y = top_left.getY();
        double bottom_right_x = bottom_right.getX();
        double bottom_right_y = bottom_right.getY();
        double height = Math.abs(bottom_right_x - top_left_x);
        double width = Math.abs(top_left_y - bottom_right_y);
        return ((height*2) + (width*2));
    }
}
