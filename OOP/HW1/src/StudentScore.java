import java.util.Scanner;

public class StudentScore extends StudentInformation { //상속
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============

	Scanner k = new Scanner(System.in);

	private int korean;
	private int math;
	private int english;
	
	public void setKorean() { //korean 입력 받아서 private 변수에 저장
		System.out.print("Korean:");
		korean = k.nextInt();
	}
	public void setMath() { //math 입력 받아서 private 변수에 저장
		System.out.print("Math:");
		math = k.nextInt();
	}
	public void setEnglish() { //english 입력 받아서 private 변수에 저장
		System.out.print("English:");
		english = k.nextInt();
	}
	
	//private 변수에 따른 getter 정의
	public int getKorean() { 
		return korean;
	}
	public int getMath() {
		return math;
	}
	public int getEnglish() {
		return english;
	}
	
	public int getSum() {
		return (korean+math+english); //모든 과목 총점 리턴
	}
	public double getAvg() {
		return (double)(this.getSum())/3; //getSum() 메서드 이용해 과목 평균 리턴 
	}
	
	public void display() { //오버라이딩
		super.display(); //StudentInformation 클래스의 메서드 호출
		System.out.printf("%-10d%-10d%-10d",korean,math,english); //korean, math, english 추가 출력
	}
}