class Point{
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Pixel extends Point{
	String color;
	public Pixel(int x, int y, String color) {
		super(x,y);
		this.color = color;
	}
}

public class PixelTest {
	public static void main(String[] args) {
		Pixel myPixel = new Pixel(2,3,"yellow");
		System.out.println("location: ("+myPixel.x+","+myPixel.y+")");
		System.out.println("Color: "+myPixel.color);

	}
}
