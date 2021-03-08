import java.util.Scanner;
public class InheritanceDemo2 {
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		Student stu1 = new Student();
		Student stu2 = new Student();
		
		System.out.println("<STUDENT 1>");
		System.out.print("Number:");
		stu1.setStudentNumber(kbd.nextInt());
		System.out.print("Name:");
		stu1.setName(kbd.next());
		System.out.println("<STUDENT 2>");
		System.out.print("Number:");
		stu2.setStudentNumber(kbd.nextInt());
		System.out.print("Name:");
		stu2.setName(kbd.next());
		
		stu1.writeOutput();
		stu2.writeOutput();
		
		if(stu1.hasSameName(stu2))
			System.out.println("Student1("+stu1.getStudentNumber()+") has same name as student2("+stu2.getStudentNumber()+").");
		else
			System.out.println("Student1("+stu1.getStudentNumber()+") has different name as student2("+stu2.getStudentNumber()+").");
		
		if(stu1.equals(stu2))
			System.out.println("Student1("+stu1.getStudentNumber()+") is the same student as student2("+stu2.getStudentNumber()+").");
		else
			System.out.println("Student1("+stu1.getStudentNumber()+") is not the same student as student2("+stu2.getStudentNumber()+").");

	}

}
