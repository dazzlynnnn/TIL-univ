public class Dog extends Pet { //상속
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	private boolean boosterShot; //private 변수 선언
	
	//private 변수에 따른 accessor 메서드 정의
	public void setBoosterShot(boolean b) {
		boosterShot = b;
	}
	public boolean getBoosterShot() {
		return boosterShot;
	}
	public void writeOutput() { //writeOutput() override
		super.writeOutput();
		System.out.print("BoosterShot: ");
		if (boosterShot==true) System.out.println("O"); //boosterShot 변수 boolean 값에 따른 조건문 사용
		else System.out.println("X");
	}
	public void move() { //move() override
		System.out.println(getName()+" walks and runs.");
	}
}
