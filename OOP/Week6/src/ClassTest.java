class A{
	int x = 100;
}

class B extends A{
	int y = 200;
}
public class ClassTest {
	public static void main(String[] args) {
		A ap = new B();
		System.out.println("x="+ap.x);
		//System.out.println("y="+ap.y);
	}
}
