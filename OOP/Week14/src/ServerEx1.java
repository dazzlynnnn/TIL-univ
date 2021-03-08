import java.io.*;
import java.net.*;
import java.util.*;

public class ServerEx1 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();
			
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			String strIn = in.nextLine();
			System.out.println(strIn);
			
			out.println("Hello, Client!!!");
			out.flush();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				serverSocket.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
