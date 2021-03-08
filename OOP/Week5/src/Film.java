public class Film extends Production {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	private int boxOfficeGross=0;
	
	//private 변수에 따른 getter, setter 정의
	public int getBoxOfficeGross() {
		return boxOfficeGross;
	}
	public void setBoxOfficeGross(int b) {
		boxOfficeGross = b;
	}
	public void display() { //override
		super.display(); //조상 클래스 메서드 호출
		System.out.println("boxOfficeGross:"+boxOfficeGross); //추가로 출력
	}
}
