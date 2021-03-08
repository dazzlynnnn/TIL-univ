import java.util.*;
import java.net.*;
import java.io.*;

public class ClientEx2 {
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket("10.210.3.213", 9001);
			
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
