import java.io.*;
import java.net.*;
import java.util.*;

public class Week14_client_이해린 {

	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Socket socket = null;
		
		int many;
		
		try {
			socket = new Socket("10.210.0.201", 9002); //Server의 IP와 port를 사용하여 Socket을 생성하고 connection을 request
			
			Scanner in = new Scanner(socket.getInputStream()); //inputStream
			Scanner k = new Scanner(System.in); //keyboard 입력
			PrintWriter out = new PrintWriter(socket.getOutputStream()); //outputStream
			
			out.println("Hello?"); out.flush(); //인사 메시지 보냄
			
			System.out.println(in.nextLine());  //"How many numbers?" 출력
			
			many = k.nextInt();
			out.println(many); out.flush(); //숫자 개수 보냄
			
			System.out.println(in.nextLine()); //"Input n numbers" 출력
			
			for (int i=0; i<many; i++) out.println(k.nextInt()); //숫자 보
			out.flush();
			
			System.out.println(in.nextLine()); //함계 출력
			System.out.println(in.nextLine()); //평균 출력

			out.println("Service finished."); out.flush();  //서비스 종료 메시지 보냄
		}
		
		catch(Exception e) {System.out.println(e.getMessage());}
		
		finally {
			try {socket.close();} //socket 닫음
			catch(Exception e) {System.out.println(e.getMessage());}
		}
	}

}
