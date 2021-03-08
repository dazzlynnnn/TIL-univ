import java.util.Scanner;
public class HW1_4_이해린 {

	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		
		int korsum=0, mthsum=0, engsum=0; //과목별 총점 저장할 int형 변수 선언
		double koravg, mthavg, engavg; //과목별 평균 저장할 double형 변수 선언
		
		System.out.println("How many students are there?");
		StudentScore[] s = new StudentScore[k.nextInt()]; //학생수를 입력받아 StudentScore 객체배열 생성
		System.out.println("Input the information.");
		
		for (int i=0; i<s.length; i++) { //학생 수만큼 반복
			System.out.println();
			s[i] = new StudentScore(); //인스턴스화
			s[i].setId(); s[i].setName(); s[i].setKorean(); s[i].setMath(); s[i].setEnglish(); //인스턴스 메서드로 변수 초기화
			korsum += s[i].getKorean(); //korean 점수 추가
			mthsum += s[i].getMath(); //math 점수 추가
			engsum += s[i].getEnglish(); //english 점수 추가
		}
		
		//각 과목 평균 계산
		koravg = (double)korsum/s.length;
		mthavg = (double)mthsum/s.length;
		engavg = (double)engsum/s.length;
		
		System.out.println("\nNAME           ID        KOREAN    MATH      ENGLISH   SUM       AVG");
		for (int i=0; i<s.length; i++) { //학생별로 정보 출력
			s[i].display();
			System.out.printf("%-10d%-10.2f\n",s[i].getSum(),s[i].getAvg()); //각 학생별 총점 평균 출력
		}
		System.out.printf("Subject Avg              %-10.2f%-10.2f%-10.2f",koravg,mthavg,engavg); //각 과목의 평균 출력

		System.out.println("\n\n<Students over the average>"); //각 과목별 평균점수 이상인 학생의 이름 출력
		System.out.println("\nKorean:");
		for (int i=0; i<s.length; i++) {
			if (koravg<=s[i].getKorean()) {
				System.out.printf("%-15s", s[i].getName());
			}
		}
		System.out.println("\nMath:");
		for (int i=0; i<s.length; i++) {
			if (mthavg<=s[i].getMath()) {
				System.out.printf("%-15s", s[i].getName());
			}
		}
		System.out.println("\nEnglish:");
		for (int i=0; i<s.length; i++) {
			if (engavg<=s[i].getEnglish()) {
				System.out.printf("%-15s", s[i].getName());
			}
		}
	}

}
