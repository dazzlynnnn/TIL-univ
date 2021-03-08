public class Play extends Production { //상속
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	private int performanceCost=0;
	
	//private 변수에 따른 getter, setter 정의
	public int getPerformanceCost() {
		return performanceCost;
	}
	public void setPerformanceCost(int p) {
		performanceCost = p;
	}
	public void display() { //override
		super.display(); //조상 클래스 메서드 호출
		System.out.println("performance cost:"+performanceCost); //추가로 출력
	}
}
