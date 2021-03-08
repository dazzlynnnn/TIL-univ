public class Pet {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	private String name;
	private int age;
	private double weight;
	//private 변수 선언
	
	public void writeOutput() { //name, age, weight 출력
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Weight: "+weight);
	}
	
	//private 변수에 따른 accessor 메서드 정의
	public void setPet(String n, int a, double w) {
		name = n; age=a; weight=w;
	}
	public void setName(String n) {
		name = n;
	}
	public void setAge(int a) {
		age = a;
	}
	public void setWeight(double w) {
		weight = w;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getWeight() {
		return weight;
	}
	public void move() { 
		System.out.println(name+" moves.");
	}
}
