import java.util.Scanner;
public class Week7_1_이해린 {

	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============");
		Scanner k = new Scanner(System.in);
		
		Pet[] p = new Pet[10]; //참조변수배열 생성
		int i = 0, input = 0, a = 0;
		String n = "";
		
		while (true) {
			System.out.println("\n원하는 작업은 무엇입니까?");
			System.out.println("1. New input  2. Output  3. Exit");
			switch(k.nextInt()) { //원하는 작업 입력받음
				case 1: //New input
					AA:while(true) {
						System.out.println("\n종은 무엇입니까?\n1. Dog  2. Cat  3. Snake  4. Bird");
						input = k.nextInt(); k.nextLine(); //종 입력받고 carriage return
						if (input>0&&input<5) { //범위 안에 있을 경우
							System.out.print("\nName:"); n = k.nextLine(); //이름 입력 받음
							System.out.print("Age:"); a = k.nextInt(); //나이 입력 받음
							
							switch(input){
								case 1: p[i++] = new Dog(n, a); break AA;
								case 2: p[i++] = new Cat(n, a); break AA;
								case 3: p[i++] = new Snake(n, a); break AA;
								case 4: p[i++] = new Bird(n, a); break AA;
							} //이름, 나이 인자로 배열마다 인스턴스 생성하고 while문 종료
						}
						else System.out.println("잘못된 입력");
					}
					break; //case1 break
					
				case 2: //Output
					System.out.println("\nSpecies\tName\tAge\tMovement");
					for (int j=0;j<i;j++) { //배열 출력
						System.out.printf(p[j].species+"\t"+p[j].name+"\t"+p[j].age+"\t");
						p[j].move();
					}
					break;
					
				case 3: System.out.println("종료"); System.exit(0); //Exit
				default: System.out.println("잘못된 입력"); break; //범위 밖의 값
			}
		}
	}
}
