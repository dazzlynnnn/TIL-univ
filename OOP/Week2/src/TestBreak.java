
public class TestBreak {

	public static void main(String[] args) {
		AA:
		for (int i=0 ; i<3 ; i++) {
			for (int j=0 ; j<5 ; j++) {
				if (j==3) break AA;
				
				System.out.println("Value of i is "+i+", value of j is "+j);
			}
		}

	}

}
