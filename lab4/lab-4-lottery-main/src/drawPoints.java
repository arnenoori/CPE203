import processing.core.*;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class drawPoints extends PApplet {

	public void settings() {
    size(500, 500);
	}
  
	public void setup() {
    	background(180);
    	noLoop();
  	}

  	public void draw() {

   	double x, y;
   
   	String[] lines = loadStrings("drawMe.txt");
   	println("there are " + lines.length);
  		for (int i=0; i < lines.length; i++){
      	if (lines[i].length() > 0 ) {
        		String[] words= lines[i].split(",");
        		x = Double.parseDouble(words[0]);
        		y = Double.parseDouble(words[1]);
        		println("xy: " + x + " " + y);
        		ellipse((int)x, (int)y, 1, 1);
      	}
  		}
  	}

  	public static void main(String args[]) {
		List<Point> list = new ArrayList<>();
		read(list);
		write(list);
		PApplet.main("drawPoints");
   }
	public static void read(List<Point> list) {
		try {
			File input = new File("lab-4-lottery-main/inputs.txt");
			Scanner sc = new Scanner(input);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] split = line.split(",");
				list.add(new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2])));
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void write(List<Point> list) {
		try {

			list = list.stream().filter(p -> p.getZ() <= 2.0)
					.map(p -> new Point(p.getX()/2 -157,p.getY()/2 -37, p.getZ()/2))
					.collect(Collectors.toList());

			PrintStream output = new PrintStream("drawMe.txt");
			for (Point p : list) {
				output.println(p.getX() + ", " + p.getY() + ", " + p.getZ());
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

