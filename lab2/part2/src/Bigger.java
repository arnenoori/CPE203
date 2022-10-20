public class Bigger {
    public static double whichIsBigger(Circle circle, Rectangle rectangle, Polygon polygon) {
        double perimeterCircle = circle.perimeter();
        double perimeterRectangle = rectangle.perimeter();
        double perimeterPolygon = polygon.perimeter();

        if (perimeterCircle > perimeterRectangle && perimeterCircle > perimeterPolygon) {
            return perimeterCircle;
        }
        else if (perimeterRectangle > perimeterPolygon && perimeterRectangle > perimeterCircle) {
            return perimeterRectangle;
        }
        return perimeterPolygon;
    }
}
