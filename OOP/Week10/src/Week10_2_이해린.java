import java.util.*;

public class Week10_2_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		Map<String, String> stu = new HashMap<String, String>(); //HashMap을 사용하여 학생 ID(String)와 이름(String)을 저장
		String ID, name, str;
		System.out.println("학생의 ID와 이름을 차례로 입력하세요.(종료시 0 0 입력)");
		while(true) {
			ID = k.next(); name = k.next(); //ID, 이름 입력받음
			if (ID.equals("0")&&name.equals("0")) break; //0 0 입식하면 정보입력 종료
			stu.put(ID,name); //HashMap에 저장
		}
		Set s = stu.keySet(); //keySet 생성
		Iterator<String> it1 = s.iterator(); //Iterator it1 생성
		str = it1.next(); 
		int maxLength = stu.get(str).length();
		int minLength = stu.get(str).length();
		String maxID = str, minID = str;
		//Map 중에 이름을 하나 읽어서 초기값으로 저장
		
		Iterator<String> it2 = s.iterator(); //Iterator it2 생성
		System.out.println("<학생명단>\n[ID]\t\t[NAME]");
		while(it2.hasNext()) {
			str=it2.next();
			//각 이름의 길이와 매번 비교해서 더 길거나 더 짧은 이름이 나오면 길이 및 ID를 update
			if (maxLength<stu.get(str).length()) {maxLength=stu.get(str).length(); maxID=str;} 
			if (minLength>stu.get(str).length()) {minLength=stu.get(str).length(); minID=str;}
			System.out.println(str+"\t\t"+stu.get(str)); //전체 학생 명단 출력
		}
		System.out.println("\n전체 학생수:"+stu.size());
		System.out.println("<가장 긴 이름을 가진 학생>");
		System.out.println("ID:"+maxID+" Name:"+stu.get(maxID)+" 길이:"+maxLength);
		System.out.println("<가장 짧은 이름을 가진 학생>");
		System.out.println("ID:"+minID+" Name:"+stu.get(minID)+" 길이:"+minLength);

	}
}
