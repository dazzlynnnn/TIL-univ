import java.util.Scanner;
public class Week5_1_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		Play p = new Play();
		Film f = new Film();
		//Play, Film 클래스 인스턴스화
		
		System.out.println("Input Title for Play");
		p.setTitle(k.nextLine());
		System.out.println("Input Director for Play");
		p.setDirector(k.nextLine());
		System.out.println("Input Writer for Play");
		p.setWriter(k.nextLine());
		//객체 p의 private 변수에 접근할 수 없으므로 setter로 변수값 저장
		
		System.out.println("Input Title for Film");
		f.setTitle(k.nextLine());
		System.out.println("Input Director for Film");
		f.setDirector(k.nextLine());
		System.out.println("Input Writer for Film");
		f.setWriter(k.nextLine());
		//객체 f의 private 변수에 접근할 수 없으므로 setter로 변수값 저장

		System.out.println("Input Performance Cost for Play");
		p.setPerformanceCost(k.nextInt());
		k.nextLine(); //carriage return
		System.out.println("Input boxOfficeGross for Film");
		f.setBoxOfficeGross(k.nextInt());
		
		p.display();
		f.display();
		//각 클래스에서 오버라이딩 한 메서드 호출
	}

}
