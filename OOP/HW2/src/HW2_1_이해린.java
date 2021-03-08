import java.io.*;
import java.util.*;

public class HW2_1_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		
		Scanner k = new Scanner(System.in);
		String readName = "", writeName = ""; //파일명 저장할 String 변수 선언 및 초기화
		
		System.out.println("Input the filename to read."); readName = k.next(); //입력파일명
		Scanner inStream = null; //입력스트림 생성
		try {inStream = new Scanner(new File(readName));}
		catch(FileNotFoundException e) {System.out.println("FileNotFoundExcption occurs."); System.exit(1);}	
		
		System.out.println("Input the filename to write."); writeName = k.next(); //출력파일명
		PrintWriter outStream = null; //출력스트림 생성
		try {outStream = new PrintWriter(writeName);}
		catch(IOException e) {System.out.println("IOException occurs."); System.exit(1);}	
		
		while(inStream.hasNextLine()) {
			String line = inStream.nextLine(); //입력파일에서 text를 줄 단위로 읽어옴
			StringTokenizer token = new StringTokenizer(line,", \n");
			while(token.hasMoreTokens()) {
				String t = token.nextToken();
				if(t.length()>4) outStream.println(t); //길이가 4보다 큰 단어를 출력스트림을 통해 print
			}
		}
		System.out.println(writeName+" is generated.");
		k.close(); inStream.close(); outStream.close(); //각 스트림 close
	}
}
