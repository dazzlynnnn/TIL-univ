import java.util.Scanner;
public class Week6_2_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);

		//각 인스턴스를 생성
		Emergency emg = new Emergency(); 
		FireEngine f = new FireEngine();
		Ambulance a = new Ambulance();
		PoliceCar p = new PoliceCar();
		
		while (true) { //5 입력할 때까지 반복
			System.out.println("\nWhat kind of Emergency?\n1.Fire   2.Patient   3.Thief   4.Record   5.End");			
			switch(k.nextInt()){ //사용자 입력을 받음
				case 1: emg.EM_Call(f); break;
				case 2: emg.EM_Call(a); break;
				case 3: emg.EM_Call(p); break;
				//전화번호 출력 및 정보저장을 위해 각 선택 번호에 따라 EM_Call 호출
				case 4: emg.EM_record(); break;
				//현재까지의 모든 데이터 출력
				case 5: System.out.println("Finished"); System.exit(0); //종료
				default: System.out.println("Wrong Input"); break; //잘못된 입력
			}
		}
	}

}
