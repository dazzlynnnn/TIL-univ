import java.util.Scanner;
class Product{ //전자제품들의 조상 클래스
	int price;
	int bonusPoint;
	Product(int price){ //변수 초기화 생성자
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}
	
class Tv extends Product{ //상속
	Tv(){super(100);} //조상 클래스의 생성자로 변수 초기화
	public String toString() {return "TV";} //오버라이딩
	}

class Computer extends Product{ //상속
	Computer(){super(200);} //조상 클래스의 생성자로 변수 초기화
	public String toString() {return "Computer";} //오버라이딩
}

class Video extends Product{ //상속
	Video(){super(110);} //조상 클래스의 생성자로 변수 초기화
	public String toString() {return "Video";} //오버라이딩
}

class Audio extends Product{ //상속
	Audio(){super(50);} //조상 클래스의 생성자로 변수 초기화
	public String toString() {return "Audio";} //오버라이딩
}

class NoteBook extends Product{ //상속
	NoteBook(){super(300);} //조상 클래스의 생성자로 변수 초기화
	public String toString() {return "NoteBook";} //오버라이딩
}

class Buyer{ //구매자 클래스
	int money = 0, i = 0;
	int bonusPoint = 0;
	Product item[] = new Product[10]; //Product 클래스를 item 배열로 선언
	
	void buy(Product pd) { //구매 메서드
		if (pd.price>money) { //잔액 부족
			System.out.println("\nMoney is not enough.\n");
			this.summary(); //summary 메서드 호출로 쇼핑리스트 출력
			System.exit(0); //종료
		}
		System.out.println("You bought "+pd+"("+pd.price+")"); //구매한 제품 출력
		money = money - pd.price; //잔액 계산
		bonusPoint = bonusPoint + pd.bonusPoint; //포인트 계산
		item[i++] = pd; //item 배열에 구매한 Product 대입
	}
	
	void summary() { //쇼핑리스트 출력 메서드
		System.out.print("\nShopping list : ");
		for(int j=0;j<i;j++) System.out.print(item[j]+" "); //구매한 Product들 item 배열에 있음
		System.out.println("\nMoney left: "+money);
		System.out.println("Current bonus point: "+bonusPoint);
	}
}

public class Week6_1_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);

		//각 인스턴스를 생성
		Buyer b = new Buyer(); 
		Tv t = new Tv();
		Computer c = new Computer();
		Video v = new Video();
		Audio a = new Audio();
		NoteBook n = new NoteBook();
		
		System.out.println("How much money do you have?");
		b.money = k.nextInt(); //돈 입력받기
		
		while (true) { //0 입력할 때까지 반복
			System.out.println("\nWhat do you want to buy? Input 0 to quit.");
			System.out.println("1. TV(100)     2. Computer(200)     3. Video(110)     4. Audio(50)     5. NoteBook(300)");
			switch(k.nextInt()) {
				case 0: b.summary(); System.exit(0); //종료
				case 1: b.buy(t); break; //Buyer 클래스의 buy 메서드 인자로 Tv형 참조변수 t를 넣어 실행
				case 2: b.buy(c); break; //Buyer 클래스의 buy 메서드 인자로 Computer형 참조변수 c를 넣어 실행
				case 3: b.buy(v); break; //Buyer 클래스의 buy 메서드 인자로 Video형 참조변수 v를 넣어 실행
				case 4: b.buy(a); break; //Buyer 클래스의 buy 메서드 인자로 Audio형 참조변수 a를 넣어 실행
				case 5: b.buy(n); break; //Buyer 클래스의 buy 메서드 인자로 NoteBook형 참조변수 n을 넣어 실행
				default : System.out.println("No such item."); break; //잘못된 입력
			}
		}

	}
}
