import java.util.*;

public class HW2_2_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		
		while(true) {
			LinkedList<Character> myStack = new LinkedList<Character>(); //LinkedList를 stack으로 사용하기 위해 선언 
			char c, r='c';

			System.out.print("Input: ");
			String str = k.next();
			if (str.equals("0")) {System.out.println("Program finished"); break;} //0 입력하면 프로그램 종료
			
			char Arr[] = new char[100];
			Arr = str.toCharArray();
			//String을 문자배열로 변환

			for (int i = 0; i<str.length(); i++) {
				if (Arr[i]!='('&&Arr[i]!=')'&&Arr[i]!='{'&&Arr[i]!='}'&&Arr[i]!='['&&Arr[i]!=']') {
					System.out.println("Wrong Input\n"); r='x'; break;
				} //6개 이외의 문자 입렷기 "Wrong Input"이라고 출력하고 계속 반복
				else {
					if (Arr[i]=='('||Arr[i]=='{'||Arr[i]=='[') myStack.addLast(new Character(Arr[i]));
					//열리는 문자('(','[','{')인 경우만 push해서 stack에 넣음
					else if (Arr[i]==')') {
						if (!myStack.isEmpty()) { //stack에 문자가 있을 때
							c = myStack.removeLast();
							if(c!='(') r='i';
						} //stack이 비어 있을 
						else r='i';
					}
					else if (Arr[i]==']') {
						if (!myStack.isEmpty()) { //stack에 문자가 있을 때
							c = myStack.removeLast();
							if(c!='[') r='i';
						} //stack이 비어 있을 
						else r='i';
					}
					else if (Arr[i]=='}') {
						if (!myStack.isEmpty()) { //stack에 문자가 있을 떄
							c = myStack.removeLast();
							if(c!='{') r='i';
						} //stack이 비어 있음
						else r='i';
					}
					//닫히는 문자(')',']','}')를 만나면 stack에서 pop한 문자와 pair가 맞는지 체크
				}

			}//for문
			if (r=='c') System.out.println("Correct\n");
			else if (r=='i') System.out.println("Incorrect\n");
		}//end of while
		k.close();
	}
}
