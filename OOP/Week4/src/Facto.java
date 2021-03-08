public class Facto {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	public static int result; //static 변수 선언
	
	public static int factoVal(int x) { //static 메서드 정의
		int result = 1;
		for (int i=x; i>0; i--) result *= i; //factorial 계산
		return result; //결과값 리턴
	}
}
