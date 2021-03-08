import java.util.*;
class Pet{
	String name;
	public String toString() {return name;}
}
class Dog extends Pet{
	Dog(){}
	Dog(String str){name=str;}
}
class Cat extends Pet{
	Cat(){}
	Cat(String str){name=str;}
}
class Bird extends Pet{
	Bird(){}
	Bird(String str){name=str;}
}
class Hamster extends Pet{
	Hamster(){}
	Hamster(String str){name=str;}
}
public class PetList {
	public static void main(String[] args) {
		List<Pet> petList = new LinkedList<Pet>();
		petList.add(new Dog("Doggy1"));
		petList.add(new Dog("Doggy2"));
		petList.add(new Cat("Kitty"));
		output(petList);
		Bird b = new Bird();
		petList.add(b);
		output(petList);
		petList.add(2, new Cat("Kitty2"));
		petList.add(new Bird("Birdy"));
		output(petList);
		petList.remove(1);
		output(petList);

	}
	public static void output(List<Pet> p) {
		System.out.println("\n<OUTPUT>");
		int i = 1;
		Iterator<Pet> it = p.iterator();
		while(it.hasNext())
			System.out.println("Pet "+(i++)+":"+it.next());
	}
}


