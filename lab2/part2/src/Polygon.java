import java.util.List;

public class Polygon {
    private final List<Point> points;

    public Polygon(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public double perimeter() {
        double sum = 0;
        for (int i = 0; i < this.points.size(); i++) {
            int next = i+1;
            if (i == this.points.size() - 1) {
                next = 0;
            }
            double point_x = this.points.get(i).getX();
            double point_y = this.points.get(i).getY();
            double points_x = this.points.get(next).getX();
            double points_y = this.points.get(next).getY();
            double length = Math.sqrt(Math.pow(point_x - points_x, 2) + Math.pow(point_y - points_y, 2));
            sum += length;
        }
        return sum;
    }
}
