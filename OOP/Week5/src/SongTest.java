import java.util.Scanner;

class Song{
	String title;
	String singer;
	
	public void playIt() {
		System.out.println(title+" by "+singer);
	}
}

public class SongTest {
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("곡은 몇 개입니까?");
		int num = kbd.nextInt();
		kbd.nextLine();
		String title, singer;
		Song[] s = new Song[num];
		
		System.out.println("<<곡정보 입력>>");
		for (int i=0;i<s.length;i++) {
			s[i] = new Song();
			System.out.print("곡명");
			s[i].title = kbd.nextLine();
			System.out.print("가수명");
			s[i].singer = kbd.nextLine();	
			System.out.println("");
		}
		
		System.out.println("<<Song 정보>>");
		for (int i=0;i<s.length;i++) s[i].playIt();
	}

}
