import java.util.Scanner;
public class Week1_2_이해린 {
	public static void main(String[] args) {
		int a, b, c; //평균값을 구할 정수들을 입력 받을 정수형 변수 선언
		float avg; //평균값을 계산하여 저장할 실수형 변수 선언
		
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("정수 세 개 입력");
		a = keyboard.nextInt();
		b = keyboard.nextInt();
		c = keyboard.nextInt(); //정수 세 개를 각각 변수 a, b, c에 입력 받음
		
		avg = (float)(a+b+c) / 3; //정수 세 개를 모두 더해 float형으로 형변환 시킨 후 3으로 나눈 float형 최종 연산값을 avg에 대입 
		System.out.printf("평균: %.2f",avg); //소수점 아래 두 자리까지만 출력
		}

}
