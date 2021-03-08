import java.util.*;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> mySet = new HashSet<String>();
		Scanner k = new Scanner(System.in);
		System.out.println("Input 5 Names");
		for(int i=0;i<5;i++)
			mySet.add(k.next());
		System.out.println("HashSet size : "+mySet.size());
		Iterator<String> it = mySet.iterator();
		String name;
		while(it.hasNext()) {
			name=it.next();
			System.out.println(name);
		}
			
	}
}
