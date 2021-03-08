import java.util.Scanner;
public class Week1_3_이해린 {
	public static void main(String[] args) {
		int f; //화씨온도를 입력받을 정수형 변수 선언
		float c; //섭씨온도를 계산하여 저장할 실수형 변수 선언 

		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("화씨온도 입력:"); 
		f = keyboard.nextInt(); //화씨온도를 입력받음 
		
		c = (float)5/9 * (f - 32); //5를 float형으로 형변환 시켜 5/9의 결과값이 float형이 되게 만든 후 f-32와 곱해서 나온 float형 최종 연산값을 c에 대입 
		System.out.printf("\n화씨온도:%d\n", f);
		System.out.printf("섭씨온도:%.1f", c); //소수점 아래 한 자리까지만 출력
		}

}
