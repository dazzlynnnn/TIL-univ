public class TestBornBaby {
	public static void main(String[] args) {
		Dog2 fatherDog = new Dog2();
		Dog2 motherDog = new Dog2();
		Dog2 puppy;
		
		fatherDog.setName("Happy"); fatherDog.setSize(50);
		motherDog.setName("Dona"); motherDog.setSize(30);
		fatherDog.run(); motherDog.run();
		puppy = motherDog.bornNewDog(fatherDog);
		puppy.bark(); puppy.run();
	}
}
