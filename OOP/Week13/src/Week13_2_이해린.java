import javax.swing.JOptionPane;

class SharedArea{ //데이터 교환하기 위한 SharedArea 정의
	//문자열 저장 배열을 사용하여 3글자 이상의 단어를 초기화(최소 15개 이상)
	String[] word = new String[] {"love","happy","cake","spring","cat","dog","giant","apple","juice","coffee","plum","peach","banana","bed","door"};
	String random; //문자열 배열 중 하나를 랜덤하게 골라서 넣을 변수
}

class MyThread extends Thread{
	boolean stop; //Thread 중지시킬 때 필요한 boolean 변수
	int i; //시간 변수
	SharedArea sharedArea;
	MyThread(SharedArea area){sharedArea = area;}
	public void setStop(boolean stop) {this.stop = stop;} //Thread 내에 stop시키는 메서드를 정의
	public void run() { //run 메서드 오버라이딩
		for(i=20; i>0; i--) { //20초 설정
			if(stop==true) {System.out.println("Timer is stopped."); System.exit(0);} //성공했을 때 Thread 종료
			sharedArea.random = sharedArea.word[(int)(Math.random()*(sharedArea.word.length))]; //문자열 배열 중 하나를 랜덤하게 골라서 변수에 넣음
			System.out.println(sharedArea.random); //콘솔창에 랜덤 단어 출력
			try {sleep(1000);} //출력하고 1초 sleep
			catch(InterruptedException e){System.out.println(e.getMessage());} //error handling
		}
		if(i==0) System.out.println("실패!"); //20초 내로 성공하지 못하면
		System.exit(0);
	}
}

public class Week13_2_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		SharedArea area = new SharedArea();
		MyThread th = new MyThread(area);
		th.start(); //Thread 시작
		while(true) {
			String st = JOptionPane.showInputDialog("문자열 입력");
			System.out.println("<"+st+">을 입력하셨습니다."); //입력한 단어 콘솔창에 출력
			if (area.random.equals(st)) { //출력된 단어랑 입력한 단어가 같으면
				System.out.println("성공!");
				th.setStop(true); //Thread 내의 Stop시키는 메서드 호출
			}
		}
	}
}
