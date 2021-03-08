import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;

class Species implements Serializable{
	private String name;
	private int population;
	private double growthRate;
	
	public Species() {
		name=null; population=0; growthRate=0;
	}
	
	public Species(String initialName, int initialPopulation, double initialGrowthRate) {
		name = initialName;
		if(initialPopulation>=0) population = initialPopulation;
		else {
			System.out.println("ERROR: Negative population.");
			System.exit(0);
		}
		growthRate = initialGrowthRate;
	}
	
	public String toString() {
		return ("Name="+name+"\nPopulation="+population+"\ngrowth rate="+growthRate+"%");
	}
}

public class Lab{
	public static void main(String[] args) {
		Species[] oneArray = new Species[2]; //class Species 배
		oneArray[0] = new Species("Calif Condor", 27, 0.02);
		oneArray[1] = new Species("Black Rhino", 100, 1.0);
		String fileName = "array.dat";
		
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileName));
			o.writeObject(oneArray); //Object형 자체를 write (Serializable 구현했기 때문에 오브젝트 자체로 읽고 쓰기 가능)
			o.close();
		}
		catch(IOException e) {
			System.out.println("ERROR writing to file "+fileName);
			System.exit(0);
		}
		System.out.println("Array written to file "+fileName+" and file is closed.");
		
		Species[] anotherArray = null;
		
		try {
			ObjectInputStream i = new ObjectInputStream(new FileInputStream(fileName));
			anotherArray = (Species[])i.readObject(); //Object형 자체를 read해서 Species배열로 down casting
			System.out.println(anotherArray[0]);
			System.out.println(anotherArray[1]);
			i.close();
		}
		catch(EOFException e) {
			System.out.println("End of File Exception");
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found Exception");
		}
		catch(IOException e) {
			System.out.println("IO Exception");
		}
		catch(Exception e) {
			System.out.println("Exception");
		}
		System.out.println("End of program");
	}
}