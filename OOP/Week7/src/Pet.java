//==============
//전공: 사이버보안
//학번: 1971083
//성명: 이해린
//==============

public abstract class Pet { //추상클래스
	public String species;
	public String name;
	public int age;
	public abstract void move(); //추상메서드

	Pet(String s, String n, int a){ //종, 이름, 나이를 인자로 받아 변수 초기화
		species = s; name = n; age = a;
	}
}

class Snake extends Pet{ //상속
	Snake(String n, int a) {super("Snake", n, a);} //Snake 생성자 내에서 Pet 생성자 호출
	public void move() {System.out.println("crawl");} //추상메서드
}

class Bird extends Pet{ //상속
	Bird(String n, int a){super("Bird", n, a);} //Bird 생성자 내에서 Pet 생성자 호출
	public void move() {System.out.println("fly");} //추상메서드
}

class Dog extends Pet{ //상속
	Dog(String n, int a){super("Dog", n, a);} //Dog 생성자 내에서 Pet 생성자 호출
	public void move() {System.out.println("run");} //추상메서드
}

class Cat extends Pet{ //상속
	Cat(String n, int a){super("Cat", n, a);} //Cat 생성자 내에서 Pet 생성자 호출
	public void move() {System.out.println("jump");} //추상메서드
}