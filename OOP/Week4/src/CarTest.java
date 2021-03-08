class Car {
	String color;     //색상
	String gearType;  //변속기 종류 - auto(자동), manual(수동)
	int door;         //문의 개수
	
	Car(){
		this("white", "auto", 4);
	}
	
	Car(Car c){ //인스턴스의 복사를 위한 생성자
		color = c.color;
		gearType = c.gearType;
		door = c.door;
	}
	
	Car(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

public class CarTest {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car(c1); //c1의 복사본 c2를 생성한다
		Car c3 = new Car();
		c3 = c1;
		
		System.out.println("c1의 color="+c1.color+", gearType="+c1.gearType+", door="+c1.door);
		System.out.println("c2의 color="+c2.color+", gearType="+c2.gearType+", door="+c2.door);
		System.out.println("c3의 color="+c3.color+", gearType="+c3.gearType+", door="+c3.door);

		c1.door=100; //c1의 인스턴스 변수 door의 값을 변경한다
		System.out.println("\nc1.door=100; 수행 후");
		System.out.println("c1의 color="+c1.color+", gearType="+c1.gearType+", door="+c1.door);
		System.out.println("c2의 color="+c2.color+", gearType="+c2.gearType+", door="+c2.door); //이미 초기값을 복사해서 c2 변수들에 저장했으므로 전과 같은 결과 출력
		System.out.println("c3의 color="+c3.color+", gearType="+c3.gearType+", door="+c3.door);
	}
}
