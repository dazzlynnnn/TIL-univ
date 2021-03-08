import java.util.*;

class Student{
	String name, ID; int age;
	Student(){}
	Student(String n, String i, int a){name=n; ID=i; age=a;} //생성자를 이용해 초기화
	public String toString() {return name+"\t"+ID+"\t"+age;}
}

public class Week10_1_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		List <Student> s = new ArrayList<Student>(); //ArrayList 생성
		String name="", ID=""; int age=0;

		System.out.println("Input Student Name, ID, and age. 0 for name to quit.");
		while(true) {
			name = k.next(); if(name.equals("0")) break; //0을 입력하면 루프 종료
			ID = k.next(); age = k.nextInt();
			s.add(new Student(name,ID,age)); //ArrayList에 저장
		}
		System.out.println("NUMBER\tNAME\tID\tAGE"); printResult(s); //저장한 학생정보 출력
		
		for(;;) {
			System.out.println("\nChoose the operation you want.");
			System.out.println("1.add information 2.delete information 3.show list 4.Finish program");
			int n = k.nextInt(); //원하는 작업 입력 받음
			switch(n) {
			case 1 : addStudent(s); printResult(s); break; //추가 후 전체 리스트 출력
			case 2 : deleteStudent(s); printResult(s); break; //삭제 후 전체 리스트 출력
			case 3 : printResult(s); break; //전체 리스트 출력
			case 4 : System.exit(0); //시스템 종료
			default : System.out.println("Wrong input."); //범위 밖 입력
			}
		}
	}
	public static void printResult(List<Student> student) { //리스트 출력 메서드 정의
		for (int i=0; i<student.size(); i++) //for loop 이용하여 모든 학생정보 출력
			System.out.println((i+1)+"\t"+student.get(i)); //get() 메서드로 학생정보 불러옴
	}
	public static void deleteStudent(List<Student> Stu) {
		Scanner k = new Scanner(System.in);
		System.out.println("Input Student Number to delete.");
		Stu.remove(k.nextInt()-1); //특정 위치의 학생정보를 삭제
	}
	public static void addStudent(List<Student> Stu) {
		Scanner k = new Scanner(System.in);
		System.out.println("Input new Student Name, ID, and age, and the location");
		String name=k.next(); String ID=k.next(); int age=k.nextInt();
		Stu.add(k.nextInt()-1,new Student(name,ID,age)); //학생정보를 입력받아 특정 위치에 추가
	}
}
