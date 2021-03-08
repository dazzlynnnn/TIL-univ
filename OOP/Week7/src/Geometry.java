//==============
//전공: 사이버보안
//학번: 1971083
//성명: 이해린
//==============

public interface Geometry { //인터페이스 정의
	double PI = 3.14159; //상수 정의
	double area();
	double perimeter();
}

class Circle implements Geometry{ //인터페이스 구현
	public double r;
	public Circle(){}
	public Circle(double radius){r = radius;} //변수 초기화할 생성자
	public double area() {return r*r*PI;} //면적 구하는 메서드
	public double perimeter() {return 2*r*PI;} //둘레 구하는 메서드
}

class Square implements Geometry{ //인터페이스 구현
	public double s;
	public Square() {}
	public Square(double side) {s = side;} //변수 초기화할 생성자
	public double area() {return s*s;} //면적 구하는 메서드
	public double perimeter() {return 4*s;} //둘레 구하는 메서드
}

class Triangle implements Geometry{ //인터페이스 구현
	public double a, b, c, s;
	public Triangle() {}
	public Triangle(double a, double b, double c){ //변수 초기화할 생성자
		this.a=a; this.b=b; this.c=c; s=(a+b+c)/2;
	}
	public double area() {return Math.sqrt(s*(s-a)*(s-b)*(s-c));} //면적 구하는 메서드
	public double perimeter() {return s*2;} //둘레 구하는 메서드
}