class Parent{
	int x = 100;
	
	void methodtest() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent{
	int x = 200;
	
	void methodtest() {
		System.out.println("Child Method");
	}
}

public class PolyTest {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		
		System.out.println("p.x="+p.x);
		p.methodtest();
		System.out.println("c.x="+c.x);
		c.methodtest();

	}

}
