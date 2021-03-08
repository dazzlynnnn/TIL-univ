import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;

public class EOFExceptionDemo {
	public static void main(String[] args) {
		String fileName = "numbers.dat";
		try {
			ObjectInputStream i = new ObjectInputStream(new FileInputStream(fileName));
			System.out.println("Reading ALL the integers");
			System.out.println("in the file " +fileName);
			
			try {
				while(true) {
					int anInteger = i.readInt();
					System.out.println(anInteger);
				}
			}
			catch(EOFException e) {
				System.out.println("End of reading from file.");
				i.close();
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Cannot find file "+fileName);
		}
		catch(IOException e) {
			System.out.println("Problem with input from file "+fileName);
		}
	}
}
