import java.util.Scanner;
class Time{
	int hour, minute, second;
	Time(int h, int m, int s){
		hour = h; minute = m; second = s;
	}
	public String toString() {
		return "Hour: "+hour+"\tMinute: "+minute+"\tSecond: "+second;
	}
}
public class TimeTest {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("How many times do you want to generate?");
		int n = k.nextInt();
		Time[] t = new Time[n];
		for(int i=0; i<t.length; i++) 
			t[i] = new Time(randNum(24),randNum(60),randNum(60));
		for(int i=0; i<n; i++) {
			System.out.print("<Time "+(i+1)+"> ");
			System.out.println(t[i]);
		}

	}
	public static int randNum(int n) {
		return (int)(Math.random()*n);
	}

}
