public class Dog {
	
	public int size;
	public String name;
	
	void bark(int numOfBarks) {
		while (numOfBarks>0) {
			if (size>40)
				System.out.println("Woof! Woof!");
			else if (size>20)
				System.out.println("Ruff! Ruff!");
			else
				System.out.println("Yip! Yip!");
			numOfBarks--;
		}//while
	}//numOfBarks
	
	void run() {
		System.out.println(name+" is running");
	}
}//End of class Dog
