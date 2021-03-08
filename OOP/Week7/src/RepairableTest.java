public class RepairableTest {

	public static void main(String[] args) {
		Tank1 tank = new Tank1();
		Marine1 marine = new Marine1();
		SCV scv = new SCV();
		SCV scv2 = new SCV();
		scv.repair(tank);
		//scv.repair(marine);
		scv.repair(scv2);
	}

}

interface Repairable{}
class Unit2{
	int hitPoint; //means power
	final int MAX_HP;
	Unit2(int hp){
		MAX_HP = hp;

	}
}

class GroundUnit extends Unit2{
	GroundUnit(int hp){
		super(hp);
	}
}
class AirUnit extends Unit2{
	AirUnit(int hp){
		super(hp);
	}
}

class Tank1 extends GroundUnit implements Repairable{
	Tank1(){
		super(150);
		hitPoint = MAX_HP;
	}
	public String toString() {
		return "Tank";
	}
}
class Marine1 extends GroundUnit{
	Marine1(){
		super(40);
		hitPoint = MAX_HP;
	}
	public String toString() {
		return "Marine";
	}
}

class SCV extends GroundUnit implements Repairable{
	SCV(){
		super(60);
		hitPoint = MAX_HP;
	}
	void repair(Repairable r) {
		if (r instanceof Unit2) {
			Unit2 u = (Unit2)r;
			while(u.hitPoint != u.MAX_HP) {
				u.hitPoint++; //hit point is increased
			}
		}
		System.out.println(r+"is repaired.");
	}//end of method repair(Repairable r)
}