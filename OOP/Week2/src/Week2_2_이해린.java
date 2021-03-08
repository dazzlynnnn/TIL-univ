import java.util.Scanner;
public class Week2_2_이해린 {
	public static void main(String[] args) {
		String degree = "c", input = "y"; //온도의 종류를 입력받을 문자열 변수 degree와 계속 실행할지에 대한 값을 입력받을 문자열 변수 input 선언 및 초기화
		double Degree_C = 0; //섭씨온도를 저장할 실수형 변수 선언 및 초기화
		int Degree_F = 0; //화씨온도를 저장할 정수형 변수 선언 및 초기화
		
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============");
		
		Scanner keyboard = new Scanner(System.in);
		
		while (input.equalsIgnoreCase("y")) {
			System.out.println("\n입력할 온도의 종류? C(섭씨) 또는 F(화씨) : "); 
			degree = keyboard.nextLine(); //온도의 종류를 입력받음
			
			if (degree.equalsIgnoreCase("c")) { //섭씨온도를 입력받는 경우
				System.out.println("섭씨온도(실수) 입력");
				Degree_C = keyboard.nextDouble();
				Degree_F = (int)(9*Degree_C/5) + 32; //double형 섭씨온도를 int형으로 형변환 후 변수에 대입
				System.out.println("섭씨 "+Degree_C+"도/화씨 "+Degree_F+"도");
				keyboard.nextLine(); //get carriage return
			}
			
			else if (degree.equalsIgnoreCase("f")) { //화씨온도를 입력받는 경우
				System.out.println("화씨온도(정수) 입력");
				Degree_F = keyboard.nextInt();
				Degree_C = 5*(double)(Degree_F-32)/9; //int형 화씨온도를 double형으로 형변환 후 연산, 대입
				System.out.printf("화씨 %d도/섭씨 %.1f도\n", Degree_F, Degree_C);
				keyboard.nextLine(); //get carriage return
			}
			
			else System.out.println("잘못된 입력\n"); //degree가 c나 f이 아닌 경우 
			
			System.out.println("계속하시겠습니까?(Y)");
			input = keyboard.nextLine();
		} //the end of while (input.equalsIgnoreCase("y"))
		
		System.out.println("프로그램 종료");
	}

}
