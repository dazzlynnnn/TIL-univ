public class Car {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	private String emgType; //Fire, Patient, Thief
	private int number; //112(Thief), 119(Fire, Patient)
	private String carType; //FireEngine, Ambulance, PoliceCar
	private String reqPerson; //FireFighter, PoliceOfficer, Doctor
	
	//getter 메서드 정의
	public String getEmgType() {return emgType;} 
	public int getNumber() {return number;}
	public String getCarType() {return carType;}
	public String getReqPerson() {return reqPerson;}
	public String getStr() {return getEmgType()+getNumber()+getCarType()+getReqPerson();}
	Car(String emg, int num, String car, String req){ //private 변수 네 개를 인자로 받아서 변수 초기화
		emgType=emg; number=num; carType=car; reqPerson=req;
	}
}

class FireEngine extends Car{ //상속
	FireEngine(){super("Fire", 119, "FireEngine", "FireFighter");} //super 호출해 변수 초기화
	public String toString() {return getStr();} //오버라이딩
}

class Ambulance extends Car{ //상속
	Ambulance(){super("Patient", 119, "Ambulance", "Doctor");} //super 호출해 변수 초기화
	public String toString() {return getStr();} //오버라이딩
}

class PoliceCar extends Car{ //상속
	PoliceCar(){super("Thief", 112, "PoliceCar", "PoliceOfficer");} //super 호출해 변수 초기화
	public String toString() {return getStr();} //오버라이딩
}