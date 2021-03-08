import java.util.*;
import java.net.*;
import java.io.*;

public class ReceiverThread extends Thread{
	Socket socket = null;
	ReceiverThread(Socket socket){
		this.socket = socket;
	}
	public void run() {
		try {
			Scanner in = new Scanner(socket.getInputStream());
			
			while(true) {
				String str = in.nextLine();
				if(str==null) break;
				System.out.println("REC>"+str);
			}
		}
		catch(NoSuchElementException e) {
			System.out.println("Chatting finished");
			System.exit(0);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
