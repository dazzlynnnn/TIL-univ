import java.io.*;
import java.net.*;
import java.util.*;

public class Week14_server_이해린 {

	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		int sum = 0, many;
		double avg;
		
		try {
			serverSocket = new ServerSocket(9002); //ServerSocket을 만들어 포트번호 9002에서 open하고 connection request를 기다림
			socket = serverSocket.accept(); //request를 받아들여 Socket을 생성하고 Client와 연결
			
			Scanner in = new Scanner(socket.getInputStream()); //inputStream
			PrintWriter out = new PrintWriter(socket.getOutputStream()); //outputStream
			
			System.out.println(in.nextLine()); //"Hello?" 출력
			
			out.println("How many numbers?"); out.flush(); //숫자 개수 입력 요청 메시지 보냄
			
			String strIn = in.nextLine(); //숫자 개수 전송받음
			System.out.println(strIn); //숫자 개수 출력
			many = Integer.parseInt(strIn); //개수를 int형 변수에 저장
			
			out.println("Input "+many+" numbers"); out.flush(); //숫자 입력 요청 메시지 보냄
			
			for (int i=0; i<many; i++) sum += Integer.parseInt(in.nextLine()); //입력받는 숫자로 sum 계산
			avg = (double)sum/many; //avg 계산
			
			out.println("Sum: "+sum); out.println("Avg: "+avg); out.flush(); //sum, avg 보냄
			
			System.out.println(in.nextLine()); //"Service finished." 출력
		}
		
		catch(Exception e) {System.out.println(e.getMessage());}
		
		finally {
			try {socket.close();} //socket 닫음
			catch(Exception e) {System.out.println(e.getMessage());}
			
			try {serverSocket.close();} //serverSocket 닫음
			catch(Exception e) {System.out.println(e.getMessage());}
		}
	}

}
