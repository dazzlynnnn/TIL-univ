import java.util.Scanner;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;

public class Week9_1_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");

		Scanner k = new Scanner(System.in);
		String fileName1 = "", fileName2 = ""; //파일명 저장할 String 변수 선언 및 초기화
		System.out.println("File name for input:"); fileName1 = k.next(); //입력파일명
		System.out.println("File name for input:"); fileName2 = k.next(); //출력파일명
		
		//file1 input, file2 output
		try {
			ObjectInputStream i = new ObjectInputStream(new FileInputStream(fileName1)); //입력 스트림 생성
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileName2)); //출력 스트림 생성
			System.out.println("The numbers in File, "+fileName1);
			try {
				while(true) { //file이 끝날 때까지 루프
					int integer = i.readInt(); //입력스트림을 통해 정수를 읽어옴
					o.writeInt(integer*2); //2를 곱한 결과를 출력스트림을 통해 출력파일에 씀
					System.out.println(integer); //콘솔창에 읽어들인 정수 출력
				}
			}
			catch(EOFException e) { //End of File 예외 처리
				System.out.println("End of reading from file, "+fileName1);
				System.out.println(fileName2+" is generated\n");
				i.close(); o.close(); //두 스트림 close
			}
		}
		//예외 처리
		catch(FileNotFoundException e) {System.out.println("Cannot find file "+fileName1);System.exit(1);}
		catch(IOException e) {System.out.println("Problem with input from file "+fileName1);System.exit(1);}
	
		//새로 생성된 file2를 읽기 목적으로 다시 열기 (file1과 동일)
		try {
			ObjectInputStream i = new ObjectInputStream(new FileInputStream(fileName2)); //입력 스트림 생성
			System.out.println("The numbers in File, "+fileName2);
			try {
				while(true) { //file이 끝날 때까지 루프
					int integer = i.readInt(); //입력스트림을 통해 정수를 읽어옴
					System.out.println(integer); //콘솔창에 읽어들인 정수 출력
				}
			}
			catch(EOFException e) { //End of File 예외 처리
				System.out.println("End of reading from 2nd File, "+fileName2);
				i.close(); //입력 스트림 close
			}
		}
		//예외 처리
		catch(FileNotFoundException e) {System.out.println("Cannot find file "+fileName2);System.exit(1);}
		catch(IOException e) {System.out.println("Problem with input from file "+fileName2);System.exit(1);}
	}
}

