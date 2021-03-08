public class Circle {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	final double PI = 3.14159; //상수 선언
	private double radius; //private 변수 선언
	
	public void setRadius(double r) { //setter 정의
		if (r>0) radius = r;
	}
	
	public double getRadius() { //getter 정의
		return radius;
	}
	
	public double perimeter() { //원둘레 계산 메서드
		double perimeter = PI*2*radius;
		return perimeter;
	}
	
	public double area() { //원넓이 계산 메서드
		double area = PI*radius*radius;
		return area;
	}
	
	public void circleInfo() { //원둘레와 원넓이 출력 메서드
		System.out.printf("원둘레:%.2f\n",perimeter());
		System.out.printf("원넓이:%.2f",area());
	}
}
