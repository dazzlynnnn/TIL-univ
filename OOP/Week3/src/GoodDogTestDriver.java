public class GoodDogTestDriver {
	public static void main (String[] args) {
		
		GoodDog one = new GoodDog();
		one.setSize(30);
		one.setSize(0); //Does this make changes? - no
		one.bark(3);
			//Try
			//one.size = 10; - error
		
		System.out.println("Dog one: "+one.getSize());
	}
}
