import java.util.Scanner;
public class Week1_1_이해린 {
	public static void main(String[] args) {
		int base, height; //밑변의 길이와 높이를 입력 받을 정수형 변수 선언
		float area; //넓이를 계산하여 저장할 실수형 변수 선언 
		
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input base : "); 
		base = keyboard.nextInt(); //밑변의 길이를 입력 받음
		System.out.println("Input height : ");
		height = keyboard.nextInt(); //높이를 입력 받음
		
		area = (float)(base * height) / 2; //base와 height가 곱해진 정수를 float로 형변환 시킨 다음 2로 나누어 최종 연산값이 float형이 되게 하여 float형 변수 area에 대입
		System.out.println("The area : "+area); 
		}

}
