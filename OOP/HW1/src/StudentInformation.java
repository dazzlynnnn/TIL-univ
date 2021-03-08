import java.util.Scanner;

public class StudentInformation {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	Scanner k = new Scanner(System.in);

	private String name;
	private String id;
	
	public void setName() {
		System.out.print("Name:");
		name = k.nextLine(); //name 입력 받아서 private 변수에 저장
	}
	public void setId() {
		System.out.print("ID:");
		id = k.nextLine(); //id 입력 받아서 private 변수에 저장
	}
	
	//private 변수에 따른 getter 정의
	public String getName() {
		return name; 
	}
	public String getId() {
		return id;
	}
	
	public void display() { //name, id 출력
		System.out.printf("%-15s%-10s",name,id);
	}
}