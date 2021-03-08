public class TestParameter {
	public static void main (String[] args) {
		
		int intSize = 50;
		Dog2 d1 = new Dog2(); Dog2 d2 = new Dog2();
		d1.setName("Happy"); d1.setSize(25);
		
		d1.tryToChange(intSize);
		System.out.println("\n     === Result in main ===");
		System.out.println("     intSize = "+intSize);
		
	
		System.out.println("\n******** Call methods tryToReplace() ********");
		d1.tryToReplace(d2);
		
		System.out.println("\n     === Result in main ===");
		System.out.print("     d1.run() =>");
		d1.run();
		System.out.print("     d2.run() =>");
		d2.run(); //default value
		
		System.out.println("\n******** Call methods change() ********");
		d1.change(d2);
		
		System.out.println("\n     === Result in main ===");
		System.out.print("     d1.run() =>");
		d1.run();
		System.out.print("     d2.run() =>");
		d2.run();
	}
}
