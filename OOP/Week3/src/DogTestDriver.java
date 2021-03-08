public class DogTestDriver {
	public static void main (String[] args) {
		
		Dog d1 = new Dog();
		d1.size = 30;
		d1.name = "Happy";
		d1.bark(1);
		d1.run();
		
		Dog d2 = new Dog();
		d2.size = 50;
		d2.name = "Dona";
		d2.bark(2);
		d2.run();
		
		Dog d3 = new Dog();
		d3.bark(3); d3.run();
	}
}
