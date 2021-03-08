class Person{
	private String name;
	
	public Person() {
		name="No name yet";
	}
	
	public Person(String initialName) {
		name=initialName;
	}
	
	public void setName(String newName) {
		name=newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void writeOutput() {
		System.out.println("Name: "+name);
	}
	
	public boolean hasSameName(Person otherPerson) {
		return this.name.equals(otherPerson.name);
	}
}

class Student extends Person{
	private int studentNumber;
	
	public Student() {
		super();
		studentNumber=0; //Indicating no number yet
	}
	
	public Student(String initialName, int initialNumber) {
		super(initialName);
		studentNumber = initialNumber;
	}
	
	public void reset(String newName, int newStudentNumber) {
		setName(newName);
		studentNumber = newStudentNumber;
	}
	
	public int getStudentNumber() {
		return studentNumber;
	}
	
	public void setStudentNumber(int newStudentNumber) {
		studentNumber = newStudentNumber;
	}
	
	public void writeOutput() {
		System.out.println("Name: "+getName());
		System.out.println("Student Number: "+studentNumber);
	}
	
	public boolean equals(Student otherStudent) {
		return this.hasSameName(otherStudent)&&(this.studentNumber == otherStudent.studentNumber);
	}
}

public class InheritanceDemo1 {
	public static void main(String[] args) {
		Student s = new Student();

		s.setName("Warren Peace");
		s.setStudentNumber(1234);
		s.writeOutput();
	}

}
