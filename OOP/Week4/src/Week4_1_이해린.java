import java.util.Scanner;
public class Week4_1_이해린 {
	public static void main(String[] args) {
		
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		String title="", singer="";
		int price=0;
		Song s;
		
		System.out.println("*Song 정보*");
		System.out.print("곡명: "); //곡명 입력 받음
		title = k.nextLine();

		while(title.equals("")) { //곡명이 입력될 때까지 반복
			System.out.println("곡명은 반드시 필요합니다.");
			System.out.print("곡명: "); //곡명 다시 입력 받음
			title = k.nextLine();
		}

		System.out.print("가수명: ");
		singer = k.nextLine(); //가수명 입력 받음
		
		System.out.print("가격: ");
		price = k.nextInt(); //가격 입력 받음
		k.nextLine(); //carriage return
	
		if (singer.equals("")) s = new Song(title, price); //가수명이 없는 경우 생성자 호출
		else s = new Song(title, singer, price);           //가수명이 있는 경우 생성자 호출
			
		System.out.println("몇 번 들으시겠습니까?");
		s.t = k.nextInt(); //재생 횟수 입력받아 s.t에 저장
		
		s.play(); //제목 및 가수 출력 함수 호출
		
	}
}
