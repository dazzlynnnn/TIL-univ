import java.util.Scanner;
public class Week7_2_이해린 {

	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		double x=0, y=0, z=0; //삼각형 변 길이 입력 받을 변수
		
		System.out.println("Input radius for a circle");
		Circle c = new Circle(k.nextDouble()); //Circle 인스턴스 생성
		
		System.out.println("Input length for a square");
		Square s = new Square(k.nextDouble()); //Square 인스턴스 생성
		
		System.out.println("Input a for a triangle"); x = k.nextDouble();
		System.out.println("Input b for a triangle"); y = k.nextDouble();
		System.out.println("Input c for a triangle"); z = k.nextDouble();
		Triangle t = new Triangle(x,y,z); //Triangle 인스턴스 생성
		
		//각 도형의 넓이, 둘레
		System.out.println("<Circle>\nArea: "+c.area()+"\nCircumference: "+c.perimeter());
		System.out.println("<Square>\nArea: "+s.area()+"\nCircumference: "+s.perimeter());
		System.out.println("<Square>\nArea: "+t.area()+"\nCircumference: "+t.perimeter());
	}
}
