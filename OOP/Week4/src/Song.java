public class Song {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	public String title;
	public String singer;
	public int price, t;
	
	public Song() {} //default 생성자
	
	public Song(String title, int price) { //title, price 있는 생성자
		this(title,"모름",price); //가수정보가 없는 경우 내부적으로 "모름"을 인자로 다른 생성자 호출
	}
	
	public Song(String title, String singer, int price) { //title, singer, price 있는 생성자
		this.title = title; 
		this.singer = singer;
		this.price = price;
		//멤버변수에 인자로 입력받은 값 저장
	}
	
	public void play() { //제목 및 가수 출력
		for (int i=0; i<t; i++) { //t번 반복
			System.out.println(title+" by "+singer);
		}
		System.out.println("총 "+(t*price)+"원입니다.");
	}
}
