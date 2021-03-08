import java.util.Scanner;
public class Week3_4_이해린 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		MenuOrder m = new MenuOrder(); //MenuOrder 오브젝트 생성
		String y_or_n = "y"; //계속하시겠습니까 입력받을 변수 선언
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		
		System.out.println("--- 음료가격 설정 ---");
		System.out.print("Coke가격:");
		m.setPrice("coke", k.nextInt()); //setPrice 메서드로 가격 입력
		k.nextLine(); //get carriage return
		System.out.print("Lemonade가격:");
		m.setPrice("lemonade", k.nextInt()); //setPrice 메서드로 가격 입력
		k.nextLine(); //get carriage return
		System.out.print("Coffee가격:");
		m.setPrice("coffee", k.nextInt()); //setPrice 메서드로 가격 입력
		k.nextLine(); //get carriage return
		
		while (y_or_n.equalsIgnoreCase("y")) {
			System.out.println("\n--- 돈을 넣으세요 ---");
			m.setMoney(k.nextInt()); //금액 입력
			k.nextLine(); //get carriage return
			
			System.out.println("--- 음료를 선택하세요 ---");
			m.showMenu(); //음료와 가격정보 출력
			m.showResult(k.nextInt()); //선택할 음료를 인자로 받고 결과 출력
			k.nextLine(); //get carriage return
			
			System.out.println("계속하시겠습니까?(y/n)");
			y_or_n = k.nextLine();
		} //the end of while (y_or_n.equalsIgnoreCase("y"))

	}
}
