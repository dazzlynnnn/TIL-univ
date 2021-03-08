class A2{
	public void aaa() {
		System.out.println("aaa");
	}
	public void bbb() {
		System.out.println("bbb");
	}
}

class B2 extends A2{
	public void bbb() {
		System.out.println("bbb1");
	}
	public void ccc() {
		System.out.println("ccc");
	}
}

public class ClassTest2 {
	public static void main(String[] args) {
		
		A2 ap = new B2();
		ap.aaa();
		ap.bbb();   // 자식타입에서 오버라이딩한 메서드는 가능
		//ap.ccc(); // 부모타입이 자식타입에서 정의된 메서드 접근 x

	}

}
