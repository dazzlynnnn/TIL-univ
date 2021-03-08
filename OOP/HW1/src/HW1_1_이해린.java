import java.util.Scanner;
public class HW1_1_이해린 {

	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		
		Time t = new Time(); //Time 인스턴스 생성
		int h = 0, m = 0; //시와 분을 입력받을 int형 변수 선언
		
		System.out.println("Hour:");
		h = k.nextInt(); //시 입력받음
		System.out.println("Minute:");
		m = k.nextInt(); //분 입력받음
		t.setTime(h,m); //setTime() 메서드 호출해 Time 인스턴스의 private 변수에 저장
		
		System.out.println(t.getTime('h')+":"+t.getTime('m')); //getTime() 메서드 호출해 시와 분을 다시 불러와 출력
	}

}
