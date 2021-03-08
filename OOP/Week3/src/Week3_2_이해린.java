import java.util.Scanner;
public class Week3_2_이해린 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Circle c = new Circle(); //Circle 오브젝트 생성
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");

		System.out.print("반지름입력:");
		c.setRadius(k.nextDouble()); //반지름을 입력받아 인스턴스 변수에 저장
		
		System.out.println("반지름:"+c.getRadius()); //반지름 출력
		c.circleInfo(); //원둘레와 원넓이 출력 메서드 호출
	}
}
