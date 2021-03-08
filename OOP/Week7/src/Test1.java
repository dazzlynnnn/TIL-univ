public class Test1 {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		
		if (f instanceof Unit1) {
			System.out.println("f는 Unit 클래스의 자식");
		}
		
		if (f instanceof Fightable) {
			System.out.println("f는 Fightable 인터페이스를 구현");
		}
		
		if (f instanceof Movable) {
			System.out.println("f는 Mavable 인터페이스를 구현");
		}
		
		if (f instanceof Attackable) {
			System.out.println("f는 Attackable 인터페이스를 구현");
		}
		
		if (f instanceof Object) {
			System.out.println("f는 Object 클래스의 자식");
		}
		
		f.move(100, 200);
		f.attack(new Unit1());
		
	}

}

class Fighter extends Unit1 implements Fightable{
	public void move(int x, int y) {
		System.out.println("위치("+x+","+y+")로 이동하랏!");
	}
	public void attack(Unit1 u) {
		System.out.println(u+" 공격!!!"); //그냥 인스턴스 이름 => toString() 호출 (자바 기본 기능)
	}
}

class Unit1{
	int currentHP; //부대의 체력
	int x;		   //부대의 위치(x좌표)
	int y; 		   //부대의 위치(y좌표)
	public String toString() {return "부대!";} //
}

interface Fightable extends Movable, Attackable{}
interface Movable {void move(int x, int y);}
interface Attackable{ void attack(Unit1 u);}