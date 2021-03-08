import java.util.*;

public class StackTest {
	public static void main(String[] args) {
		LinkedList<Integer> myStack = new LinkedList<Integer>();
		Scanner k = new Scanner(System.in);
		int num1;
		while (true) {
			System.out.print("Push numbers(0 to quit):");
			num1 = k.nextInt();
			if(num1==0)break;
			myStack.addLast(new Integer(num1));
		}
		System.out.println("<Popped Result>");
		while(!myStack.isEmpty()) {
			int num2 = myStack.removeLast();
			System.out.println(num2);
		}
	}

}
