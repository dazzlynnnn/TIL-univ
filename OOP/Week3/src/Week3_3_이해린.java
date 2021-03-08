import java.util.Scanner;
public class Week3_3_이해린 {
	public static void main(String[] args) {
		
		Scanner k = new Scanner(System.in);
		MyFile fOld = new MyFile(); //원래 file
		MyFile fNew = new MyFile(); //새로 만드는 file
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");

		System.out.println("--File정보입력(제목,페이지수)--");
		fOld.setTitle(k.nextLine()); //파일 제목을 입력받음
		fOld.setPage(k.nextInt()); //페이지 수를 입력받음
		fOld.fileCopy(fNew); //fileCopy 메서드로 fOld 정보를 fNew에 대입

		System.out.println("<원래 File>");
		fOld.fileInfo(); //원래 file 정보 출력
		System.out.println("<복사된 File>");
		fNew.fileInfo(); //새로 만든 file 정보 출력
	}
}
