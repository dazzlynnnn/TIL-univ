import java.util.*;

public class QueueTest {
	public static void main(String[] args) {
		LinkedList<String> myQueue = new LinkedList<String>();
		Scanner k = new Scanner(System.in);
		String name;
		while(true) {
			System.out.print("Input a name to queue in('O' to quit):");
			name = k.next();
			if(name.equalsIgnoreCase("O")) break;
			myQueue.offer(name);
		}
		System.out.println("<Result>");
		while(!myQueue.isEmpty()) {
			System.out.println(myQueue.poll());
			
		}
	}

}
