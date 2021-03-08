import java.util.*;
import java.net.*;
import java.io.*;

public class SenderThread extends Thread{
	Socket socket;
	SenderThread(Socket socket){
		this.socket = socket;
	}
	public void run() {
		try {
			Scanner in = new Scanner(System.in);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			String strIn;
			while(true) {
				strIn = in.nextLine();
				if(strIn.equalsIgnoreCase("bye")) break;
				out.println(strIn);
				out.flush();
			}
		}
		catch(Exception e) {
			System.out.println("End of Chatting");
		}
		try {
			socket.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
