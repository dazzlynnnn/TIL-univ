public class TestAssignment {
	public static void main (String[] args) {
		//--- Initialize two variables ---
		int a = 10, b = 20;
		
		//--- Initialize two objects ---
		Dog2 d1 = new Dog2(); d1.setName("Happy");
		Dog2 d2 = new Dog2(); d2.setName("Dona");
		
		//--- First print ---
		System.out.println("Before Change");
		System.out.println("a="+a+" b="+b);
		d1.run(); d2.run();
		
		//---Assignment---
		a = b; b = 30;
		d1 = d2; d2.setName("Dot");
		
		//---Second print---
		System.out.println("After Change");
		System.out.println("a="+a+" b="+b);
		d1.run(); d2.run();
	}
}
