class MyMath2{
	long a, b;
	
	long add() { //인스턴스 메서드
		return a+b;
	}
	
	static long add(long a, long b) { //클래스 메서드(static 메서드)
		return a+b;
	}
}

public class MyMath2Test {
	public static void main(String args[]) {
		System.out.println(MyMath2.add(200L, 100L)); //클래스 메서드 호출
		MyMath2 mm = new MyMath2(); //인스턴스 생성
		mm.a = 200L;
		mm.b = 100L;
		System.out.println(mm.add()); //인스턴스 메서드 호출
	}
}
