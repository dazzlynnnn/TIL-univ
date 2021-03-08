import java.util.Scanner;
public class HW1_3_이해린 {

	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		String yn = "y"; //입력을 계속할지 입력받는 문자열 선언
		
		while(yn.equalsIgnoreCase("y")) { //y를 입력한 동안 반복
			char Arr[] = new char[100]; //char형 배열 Arr 선언
			
			System.out.println("\nInput a word");
			String str = k.next(); //문자열로 입력을 받음
			k.nextLine(); //carriage return 
			
			Arr = str.toCharArray(); //문자열을 문자 배열로 변환
			if (check(Arr)) //check()메서드를 호출해 대칭 여부 리턴받음
				System.out.println("Symmetry");
			else
				System.out.println("Asymmetry");
			
			System.out.print("\nTry again?(y/n)");
			yn = k.nextLine();
		}
	}
	
	public static boolean check(char[] Arr) { //main에서 호출할 static 메서드 check 선언
		for (int i=0; i<Arr.length; i++) { //입력받은 문자 배열 길이만큼 반복
			if (Arr[i]!=Arr[Arr.length-1-i]) //대칭이 아닌 경우
				return false; //false 리턴하고 함수 종료
		}
		return true; //대칭인 경우 true 리턴하고 함수 종료
	}

}
