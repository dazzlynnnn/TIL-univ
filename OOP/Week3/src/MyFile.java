public class MyFile {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	private String title;
	private int page;
	//private 변수 선언
	
	public void setTitle(String t) { //Setter 정의
		title = t;
	}
	
	public String getTitle() { //Getter 정의
		return title;
	}
	
	public void setPage(int p) { //Setter 정의
		if (p>0) page = p;
	}
	
	public int getPage() { //Getter 정의
		return page;
	}
	
	public void fileCopy(MyFile f) { //parameter로 입력받은 클래스의 변수에 메서드를 실행한 클래스의 변수 대입
		f.title = this.title;
		f.page = this.page;
	}
	
	public void fileInfo() { //파일 정보 출력 메서드 정의
		System.out.println("파일제목:"+title);
		System.out.println("페이지:"+page);
	}
}
