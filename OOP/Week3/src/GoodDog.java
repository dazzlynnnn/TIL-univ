public class GoodDog {
	
	private int size;
	private String name;
	
	public void setSize(int sz) {
		if (sz>10) size = sz; 
	}
	
	public int getSize() {
		return size;
	}
	
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
	
}
