//==============
//전공: 사이버보안
//학번: 1971083
//성명: 이해린
//==============
import java.util.Scanner;
public class Game {
	int youwin = 0, comwin = 0; //이긴 횟수 저장 변수
	int you = 0, com = 0; //가위 바위 보 저장 변수
	
	public void play() { //게임시작 및 반복적으로 가위바위보 하다가 최종 결과 출력
		System.out.println("가위바위보 게임을 시작합니다.");
		while (youwin<3&&comwin<3)  //이긴 횟수가 3이 되면 while문 종료
			this.input(); //같은 클래스의 input()메서드 호출
		System.out.printf("\nYou(%d)\tCom(%d)\n",youwin,comwin); //최종 게임 결과 출력
		if (youwin<comwin) //컴퓨터가 이겼을 때
			System.out.print("컴퓨터가 이겼습니다.\n게임을 종료합니다.");
		else //당신이 이겼을 때
			System.out.print("당신이 이겼습니다.\n게임을 종료합니다.");
	}
	
	public void input() {
		Scanner k = new Scanner(System.in);
		System.out.printf("\n당신의 선택은?(You(%d) - Com(%d))\n",youwin,comwin);
		System.out.println("가위(1) 바위(2) 보(3)");
		try{
			you = k.nextInt(); //사용자로부터 키보드 입력 받기
			com = (int)(Math.random()*2)+1; //컴퓨터 선택값 설정하기
			
			if (you<1||com<1||you>3||com>3) //범위 내에 없을 때
				throw new Exception("범위가 잘못되었습니다.");	 //exception 발생
			
			System.out.printf("<You>\t<Com>\n");
			switch(you) {
				case 1 : System.out.print("가위"); break;
				case 2 : System.out.print("바위"); break;
				case 3 : System.out.print("보"); break; }
			switch(com) {
				case 1 : System.out.print("\t가위\n"); break;
				case 2 : System.out.print("\t바위\n"); break;
				case 3 : System.out.print("\t보\n"); break; }
			
			this.writeOutput();
		}
		catch(Exception e) { //exception catch
			System.out.println(e.getMessage()); //Exeption() 인자 출력
		}
	}
	
	public void writeOutput() { //사용자입력과 컴퓨터입력 비교 후 매번 누가 이겼는지 결과 출력
		if (you==com) 
			System.out.println("비김");
		else if((you+1)%3==com%3) {
			System.out.println("컴퓨터 승");
			comwin++;
		}
		else {
			System.out.println("당신 승");
			youwin++;
		}
	}
}
