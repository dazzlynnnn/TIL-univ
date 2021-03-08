import java.util.Scanner;
public class DiceGame {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	Scanner k = new Scanner(System.in);
	
	private int diceFace; //1~6
	private int userGuess; //1~6
		
	private int rollDice() { //Math 클래스의 random() 메서드를 사용하여 주사위 눈(1~6)을 반환
		diceFace = (int)(Math.random()*5)+1; //private 변수에 저장
		System.out.println("Dice is rolled!!!");
		return diceFace; //주사위 눈 반환
	}
	
	private int getUserInput() { //사용자로부터 메서드 내에서 입력을 받아 범위를 체크하여 범위 밖이면 적절한 입력이 들어올 때까지 반복해서 받음
		System.out.println("Guess the number! What do you think?");
		while (true) { //반복문
			userGuess = k.nextInt(); //userGuess에 정수 입력받음
			if (userGuess<1 || userGuess>6) //범위 밖일 때
				System.out.println("Input number between 1~6.");
			else //범위 안일 때
				return userGuess; 
		}  
	}
	
	private void checkUserGuess(int g) { //사용자 입력이 diceFace와 같은지 체크
		if (g==diceFace) //같으면 Bingo
			System.out.println("Bingo!");
		else //다르면 Wrong
			System.out.println("Wrong!\nThe face was "+diceFace);
	}
	
	public void startPlaying() { //메서드 내에서 클래스 내 다른 메서드 호출
		this.rollDice();
		this.checkUserGuess(getUserInput());
	}
}
