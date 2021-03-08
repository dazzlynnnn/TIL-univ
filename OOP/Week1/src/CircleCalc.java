import java.util.Scanner;
public class CircleCalc {

	public static void main(String[] args) {
		final double PI = 3.14159;
		double radius;
		double area;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("반지름 : ");
		radius = keyboard.nextDouble();
		area = PI * radius * radius;
		System.out.println("원의 넓이 : "+area);
	}

}
