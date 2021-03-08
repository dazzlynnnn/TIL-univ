public class Cat extends Pet { //상속
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	private String color; //private 변수 선언
	
	//private 변수에 따른 accessor 메서드 정의
	public void setColor(String c) {
		color = c;
	}
	public String getColor() {
		return color;
	}
	public void writeOutput() { //writeOutput() override
		super.writeOutput();
		System.out.print("Color: "+color+"\n");
	}
	public void move() { //move() override
		System.out.println(getName()+" creeps and jumps.");
	}
}
