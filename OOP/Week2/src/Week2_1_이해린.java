import java.util.Scanner;
public class Week2_1_이해린 {
	public static void main(String[] args) {
	
		int cash = 0, fifty_t = 0, ten_t = 0, five_t = 0, one_t = 0, five_h = 0, one_h = 0, fifty = 0, ten = 0;
		//금액을 입력받을 변수를 cash로 선언하고 지폐 단위 변수들을 각각 선언한 후 모두 0으로 초기화
		
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Input the amount of money(0~100000):"); 
		cash = keyboard.nextInt(); //변수 cash에 금액을 입력받음
		
		if ( cash>=0 && cash<=100000 ) { //입력 범위(0~100000)내에 금액이 있을 때
			fifty_t = cash / 50000; cash = cash % 50000;
			ten_t = cash / 10000; cash = cash % 10000;
			five_t = cash / 5000; cash = cash % 5000;
			one_t = cash / 1000; cash = cash % 1000;
			five_h = cash / 500; cash = cash % 500;
			one_h = cash / 100; cash = cash % 100;
			fifty = cash / 50; cash = cash % 50;
			ten = cash / 10; cash = cash % 10;	
			//입력받은 cash를 지폐 단위로 나눈 몫을 각 지폐 단위 변수에 대입하고, 나눈 나머지를 cash에 다시 넣어서 다음 지폐 단위를 순차적으로 계산함
			
			System.out.println("The output will be");
			System.out.println("50000 won: "+fifty_t);
			System.out.println("10000 won: "+ten_t);
			System.out.println("5000 won: "+five_t);	
			System.out.println("1000 won: "+one_t);
			System.out.println("500 won: "+five_h);
			System.out.println("100 won: "+one_h);
			System.out.println("50 won: "+fifty);
			System.out.println("10 won: "+ten);
			System.out.println("Remainder: "+cash);
			//지폐 단위별로 수량을 출력하고 나머지는 Remainder로 출력함
		}
		else System.out.println("잘못된 입력"); //입력 범위(0~100000)내에 금액이 없을 때

	}

}
