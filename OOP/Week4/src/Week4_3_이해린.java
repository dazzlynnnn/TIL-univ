public class Week4_3_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");

		int a = 5, b = 10;
		double da = 3.4, db = 5.2;
		char ca = 'a', cb = 'b';
		int iarr[] = {1,2,3};
		double darr[] = {1.1,2.2,3.3};
		char carr[] = {'a','p','p','l','e'};
		
		System.out.println("a+b="+sum(a,b));
		System.out.println("da+b="+sum(da,b));
		System.out.println("a+db="+sum(a,db));
		System.out.println("da+db="+sum(da,db));
		System.out.println("ca+cb="+sum(ca,cb));
		System.out.println("sum of Int_Arr="+sum(iarr));
		System.out.println("sum of Double_Arr="+sum(darr));
		System.out.println("sum of Char_Arr="+sum(carr));
		} //End of main
	
	//sum() 메서드 정의(오버로딩) - main 함수에서 호출하는 것이기 때문에 모두 static 함수
	public static int sum(int a, int b) {
		return a+b; //a 와 b 더한 int값 리턴
	}
	
	public static double sum(double da, int b) {
		return da+b; //da 와 b 더한 double값 리턴
	}
	
	public static double sum(int a, double db) {
		return a+db; //a 와 db 더한 double값 리턴
	}
	
	public static double sum(double da, double db) {
		return da+db; //da 와 db 더한 double값 리턴
	}
	
	public static String sum(char ca, char cb) {
		return ""+ca+cb; //String 형태로 바꾸기 위에 앞에 String 공백을 더해 char 두 개 연결한 String값 리턴
	}
	
	public static int sum(int[] iarr) {
		int result = 0;
		for(int i=0; i<iarr.length; i++) result += iarr[i]; //모든 원소의 합
		return result;
	}
	
	public static double sum(double[] darr) {
		double result = 0;
		for(int i=0; i<darr.length; i++) result += darr[i]; //모든 원소의 합
		return result;
	}
	
	public static String sum(char[] carr) {
		String result = ""; //String 변수 선언 및 초기화
		for(int i=0; i<carr.length; i++) result += carr[i]; //모든 문자 연결
		return result;
	}
	
}//End of class Week4_3_이해린
