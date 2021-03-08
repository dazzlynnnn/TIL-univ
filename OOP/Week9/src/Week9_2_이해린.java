import java.io.Serializable;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;

class Pet implements Serializable{ //child class에서 Serializable을 implements하려면 parent class도 implements해야 함
	//변수 선언
	private String name; private int age; private double weight;

	//생성자로 변수 초기화
	public Pet() {}
	public Pet(String n, int a, double w) {this.setPet(n, a, w);}
	
	//setter 메서드
	public void setPet(String newName, int newAge, double newWeight) {name=newName; age=newAge; weight=newWeight;}
	public void setName(String newName) {name = newName;}
	public void setAge(int newAge) {age = newAge;}
	public void setWeight(double newWeight) {weight = newWeight;}
	
	//getter 메서드
	public String getName() {return name;}
	public int getAge() {return age;}
	public double getWeight() {return weight;}
}

class Dog extends Pet implements Serializable{
	//변수 선언
	private String breed; private boolean boosterShot;
	
	//생성자로 변수 초기화
	public Dog() {}
	public Dog(String n, int a, double w, String b, boolean s) {super(n,a,w); setBreed(b); setBoosterShot(s);}
	
	//setter 메서드
	public void setBreed(String breed) {this.breed = breed;}
	public void setBoosterShot(boolean boosterShot) {this.boosterShot = boosterShot;}
		
	//getter 메서드
	public String getBreed() {return breed;}
	public boolean getBoosterShot() {return boosterShot;}
	
	//toString 오버라이딩
	public String toString() {return getName()+getAge()+getWeight()+getBreed()+getBoosterShot();}
}

public class Week9_2_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		String fileName="";
		
		//클래스 배열 후 초기화
		Dog[] myDog = new Dog[10]; 
		myDog[0] = new Dog("Merry", 3, 2.5, "Bulldog", false);
		myDog[1] = new Dog("JJong", 5, 5.5, "Mix", false);
		myDog[2] = new Dog("Kong", 4, 3, "Poodle", true);
		myDog[3] = new Dog("Apple", 2, 2.5, "Collie", true);
		myDog[4] = new Dog("Candy", 5, 5.5, "Coca", false);
		myDog[5] = new Dog("Cutie", 7, 2.5, "Chiwawa", true);
		myDog[6] = new Dog("Peace", 3, 2.5, "Huskey", false);
		myDog[7] = new Dog("Lion", 9, 1.5, "Shepard", true);
		myDog[8] = new Dog("Windy", 2, 9, "Jindo", true);
		myDog[9] = new Dog("Sweetie", 1, 2.5, "Maltiz", false);
		
		Scanner k = new Scanner(System.in);
		System.out.println("Input File name to write Dog data");
		fileName = k.next(); //파일명 입력 받음
		
		//파일에 Object를 쓰고 파일 완성
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileName)); //출력 스트림 생성
			o.writeObject(myDog); //Object형 자체를 write (Serializable 구현했기 때문에 오브젝트 자체로 읽고 쓰기 가능)
			o.close(); //스트림 close
		}
		catch(IOException e) {System.out.println("IO Exception"); System.exit(1);}//예외 처리
		
		//다시 열어서 전체 출력
		Dog[] arr = null; //파일에 있는 내용 입력할 새로운 배열 선언
		try {
			ObjectInputStream i = new ObjectInputStream(new FileInputStream(fileName)); //입력 스트림 생성
			arr = (Dog[])i.readObject(); //Object형 자체를 read해서 Dog 배열로 down casting
			System.out.println("Name\tAge\tWeight\tBreed\t\tBoosterShot");
			for (int j=0; j<10; j++) { //전체 출력
				System.out.print(arr[j].getName()+"\t"+arr[j].getAge()+"\t"+arr[j].getWeight()+"\t"+arr[j].getBreed()+"\t\t");
				if (arr[j].getBoosterShot()==true) System.out.println("O");
				else System.out.println("X");
			}
			System.out.println("\nDogs older than 2 years and did not get the boosterShot."); 
			for (int j=0; j<10; j++) { //2세 초과 & 예방접종 안 한 강아지 이름과 종을 출력
				if (arr[j].getAge()>2&&arr[j].getBoosterShot()==false) {
					System.out.println(arr[j].getName()+"\t"+arr[j].getBreed());
				}
			}
			i.close(); //스트림 close
			System.out.println("\nProgram finished");
		}
		
		//예외 처리
		catch(EOFException e) {System.out.println("End of File Exception"); System.exit(1);}
		catch(FileNotFoundException e) {System.out.println("File not found Exception"); System.exit(1);}
		catch(IOException e) {System.out.println("IO Exception"); System.exit(1);}
		catch(Exception e) {System.out.println("Exception"); System.exit(1);}
	}
}
