import java.util.Scanner;
public class Week4_2_이해린 {
	public static void main(String[] args) {
		
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		int a=0, b=0, result1, result2;
		
		System.out.print("첫번째 원소 입력:");
		a = k.nextInt(); //첫번째 원소 입력 받아서
		k.nextLine(); //carriage return
		result1 = Facto.factoVal(a); //Facto 클래스의 클래스 메서드를 호출한 후 리턴값을 result1에 저장
		
		System.out.print("두번째 원소 입력:");
		b = k.nextInt(); //두번째 원소 입력 받아서
		result2 = Facto.factoVal(b); //Facto 클래스의 클래스 메서드를 호출한 후 리턴값을 result2에 저장
		
		Facto.result = result1-result2; //두 개의 factorial값의 차이를 클래스 변수 result에 저장
		
		System.out.println("Factorial("+a+") - Factorial("+b+") = "+Facto.result); //클래스 변수 result 출력
	}
}
