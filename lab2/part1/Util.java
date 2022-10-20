import java.util.List;

public class Util {

    public static double perimeter(Circle circle) {
        return (Math.PI * 2 * circle.getRadius());
    }

    public static double perimeter(Rectangle rectangle) {
        Point top_left = rectangle.getTopLeft();
        Point bottom_right = rectangle.getBottomRight();
        double top_left_x = top_left.getX();
        double top_left_y = top_left.getY();
        double bottom_right_x = bottom_right.getX();
        double bottom_right_y = bottom_right.getY();
        double height = Math.abs(bottom_right_x - top_left_x);
        double width = Math.abs(top_left_y - bottom_right_y);
        return ((height*2) + (width*2));
    }

    public static double perimeter(Polygon polygon) {
        double sum = 0;
        List<Point> pointList = polygon.getPoints();
        for (int i = 0; i < pointList.size(); i++) {
            int points = i+1;
            if (i == (pointList.size() - 1)) {
                points = 0;
            }
            double point_x = pointList.get(i).getX();
            double point_y = pointList.get(i).getY();
            double points_x = pointList.get(points).getX();
            double points_y = pointList.get(points).getY();
            double length = Math.sqrt(Math.pow(point_x - points_x, 2) + Math.pow(point_y - points_y, 2));
            sum += length;
        }
        return sum;
    }
}
