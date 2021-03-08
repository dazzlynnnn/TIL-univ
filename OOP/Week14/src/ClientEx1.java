import java.io.*;
import java.net.*;
import java.util.*;

public class ClientEx1 {
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket("10.210.3.213", 9000);
			
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("Hello, Server!!!");
			out.flush();
			
			String strIn = in.nextLine();
			System.out.println(strIn);
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
		}

	}

}
