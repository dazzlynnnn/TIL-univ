import java.util.*;
public class MapTest {
	public static void main(String[] args) {
		Map<String, String> myMap = new HashMap<String, String>();
		Scanner k = new Scanner(System.in);
		String ID, name, str;
		System.out.println("Input 5 IDs and Names");
		for(int i = 0; i<5; i++) {
			ID = k.next();
			name = k.next();
			myMap.put(ID,name);
		}
		System.out.println("HashMap size : "+myMap.size());
		System.out.println("Input ID to search:");
		ID = k.next();
		System.out.println(myMap.get(ID));
		System.out.println(myMap);
		
		Set s = myMap.keySet();
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			str=it.next();
			System.out.println("<"+str+","+myMap.get(str)+">");
		}

	}

}
