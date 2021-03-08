public class Production {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	private String title;
	private String director;
	private String writer;
	
	//private 변수에 따른 getter, setter 정의
	public String getTitle() {
		return title;
	}
	public String getDirector() {
		return director;
	}
	public String getWriter() {
		return writer;
	}
	public void setTitle(String t) {
		title = t;
	}
	public void setDirector(String d) {
		director = d;
	}
	public void setWriter(String w) {
		writer = w;
	}
	public void display() { //title, director, writer 출력
		System.out.println("\nTitle:"+title);
		System.out.println("Director:"+director);
		System.out.println("Writer:"+writer);
	}
}
