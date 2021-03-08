import java.util.Scanner;
public class HW1_2_이해린 {

	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		
		String yn = "y"; //게임을 계속할지 입력받는 문자열 선언
		DiceGame d = new DiceGame(); //DiceGame 인스턴스 생성
		
		while (!(yn.equalsIgnoreCase("n"))) { //n이 나올 때까지 반복
			System.out.println("\n<< GAME START >>");
			d.startPlaying(); //startPlaying() 호출
			System.out.println("Try again?(y/n)");
			yn = k.nextLine();
		}
		
		System.out.println("Game finished.");
	}
}
