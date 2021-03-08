public class Emergency {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	public int i=0; //배열 인덱스를 위한 변수 선언
	public Car emgList[] = new Car[10]; //크기 10짜리 클래스 배열 선언
	public void EM_Call(Car c) { //번호 출력하고 배열에 인스턴스 추가
		if (c instanceof FireEngine) {
			System.out.println("call 119");
			emgList[i++]=new FireEngine();
		}
		else if (c instanceof Ambulance) {
			System.out.println("call 119");
			emgList[i++]=new Ambulance();
		}
		else if (c instanceof PoliceCar) {
			System.out.println("call 112");
			emgList[i++]=new PoliceCar();
		}
	}
	
	public void EM_record() { //반복문 이용하여 배열의 모든 인스턴스 출력
		System.out.println("\nEmergency       Number       Car_Type        Requird");
		for (int j=0;j<i;j++) {
				System.out.printf("%-15s %-12d %-15s %-15s\n", emgList[j].getEmgType(), emgList[j].getNumber(), emgList[j].getCarType(), emgList[j].getReqPerson());
		}
	}
}
