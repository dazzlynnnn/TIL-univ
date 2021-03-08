import java.util.*;

class SharedArea1{ //데이터 교환하기 위한 SharedArea 정의
	double ratio;
	boolean isReady;
}

class SimulThread extends Thread{ //동전을 던져서 비율을 구하는 Thread
	int num; //동전 던지는 횟수
	double count; //앞면 나온 횟수
	SharedArea1 sharedArea;
	SimulThread(int n, SharedArea1 area){num = n; sharedArea = area;} //생성자를 이용해 동전 던지는 횟수와 SharedArea 입력 받음
	public void run() { //run 메서드 오버라이딩
		for (int i=0; i<num; i++) {if (Math.round(Math.random()) == 0) count++;} //동전 던지는 횟수만큼 반복문 실행해서 random한 수가 0(앞면)이면 앞면 나온 횟수 1 증가
		sharedArea.ratio = (count/num)*100; //앞면 비율 계산
		sharedArea.isReady = true; //sharedArea의 Boolean 변수 true로 바꿈
		synchronized(sharedArea) {sharedArea.notify();} //PrintThread에 신호 전달
	}
}

class PrintThread extends Thread{ //시뮬레이션 결과 출력 Thread
	SharedArea1 sharedArea;
	PrintThread(SharedArea1 area){sharedArea = area;} //생성자를 이용해 SharedArea 입력 받음
	public void run() { //run 메서드 오버라이딩
		if(sharedArea.isReady != true) { //아직 계산이 되지 않은 상태
			try {synchronized(sharedArea) {sharedArea.wait();}} //SimulThread로부터 신호를 기다림
			catch(InterruptedException e) {System.out.println(e.getMessage());} //error handling
		}
		System.out.printf("Front Ratio : %.2f",sharedArea.ratio); //sharedArea.isReady가 true가 되면 실행
		System.out.print("%");
	}
}

public class Week13_1_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		
		System.out.println("Input the number of coin toss : ");
		int num = k.nextInt(); //동전 던지는 횟수 입력 받음
		
		SharedArea1 area = new SharedArea1();
		SimulThread th1 = new SimulThread(num, area);
		PrintThread th2 = new PrintThread(area);
		
		th1.start(); th2.start(); //Thread 시작시키기
		k.close();
	}
}
