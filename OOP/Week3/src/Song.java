public class Song {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	public String title, singer;
	public int price;
	// 멤버변수 선언
	
	public void play() { //노래 재생 메서드 선언
		System.out.println("노래들어요: \""+title+"\" by "+singer);
	}
	
	public void price() { //가격 출력 메서드 선언
		System.out.println(price+"원입니다.");
	}
}
