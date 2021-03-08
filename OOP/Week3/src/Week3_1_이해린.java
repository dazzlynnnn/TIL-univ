import java.util.Scanner;
public class Week3_1_이해린 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Song s1 = new Song(); //Song 1 오브젝트 생성
		Song s2 = new Song(); //Song 2 오브젝트 생성
		int select = 0; //선택한 노래 번호
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
	
		System.out.println("*Song 1*");
		System.out.print("곡명입력:");
		s1.title = k.nextLine(); //곡명 입력받아 오브젝트 s1의 title에 저장
		System.out.print("가수명입력:");
		s1.singer = k.nextLine(); //가수명 입력받아 오브젝트 s1의 title에 저장
		System.out.print("가격입력:");
		s1.price = k.nextInt(); //가격 입력받아 오브젝트 s1의 price에 저장

		System.out.println("\n*Song 2*");
		System.out.print("곡명입력:");
		k.nextLine();  //get carriage return
		s2.title = k.nextLine(); //곡명 입력받아 오브젝트 s2의 title에 저장
		System.out.print("가수명입력:");
		s2.singer = k.nextLine(); //가수명 입력받아 오브젝트 s2의 title에 저장
		System.out.print("가격입력:");
		s2.price = k.nextInt(); //가격 입력받아 오브젝트 s2의 price에 저장
		
		System.out.println("\n노래를 고르세요");
		System.out.println("1:"+s1.title+" 2:"+s2.title); //노래 목록 출력
		select = k.nextInt();
		
		switch (select) {
			case 1 : s1.play(); s1.price(); break; 
			case 2 : s2.play(); s2.price(); break;
			//case에 따라 Song 클래스에서 선언한 메서드 실행
		}
		
		System.out.println("감사합니다.");
		
	}
}
