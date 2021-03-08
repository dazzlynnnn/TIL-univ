import java.util.*;

public class TimeArrayList {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("How many times do you want to generate?");
		int n = k.nextInt();
		ArrayList <Time> t = new ArrayList<Time>();
		for(int i=0; i<n; i++) 
			t.add(new Time(randNum(24),randNum(60),randNum(60)));
		for(int i=0; i<t.size(); i++) {
			System.out.print("<Time "+(i+1)+"> ");
			System.out.println(t.get(i));
		}

	}
	public static int randNum(int n) {
		return (int)(Math.random()*n);
	}
}


