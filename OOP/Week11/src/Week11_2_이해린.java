import java.awt.*;
import javax.swing.*;

class Stu extends JFrame{
	public Stu() {
		setTitle("Student Information");
		setSize(350,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); //LayoutManager 사용
		
		//RadioButton 올릴 panel_R
		JPanel panel_R = new JPanel();
		JRadioButton RB1 = new JRadioButton("Male");
		JRadioButton RB2 = new JRadioButton("Female",true); //초기상태로 선택
		panel_R.add(RB1); panel_R.add(RB2); //panel에 add
		ButtonGroup bg = new ButtonGroup();	//buttonGroup을 만들어 둘 중 하나만 선택가능하도록 설정
		bg.add(RB1); bg.add(RB2);
		
		//BorderLayout 중 NORTH 에 들어갈 panel1
		JPanel panel1 = new JPanel();
		makeLabel("STUDENT INFORMATION",panel1); //makeLabel 메서드를 정의하고 이를 호출해서 label 생성
		add(panel1,BorderLayout.NORTH); //component를 올린 panel1을 NORTH sector에 add

		//BorderLayout 중 CENTER 에 들어갈 panel2
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4,2)); //LayoutManager 사용
		//makeTextField 메서드를 정의하고 이를 호출해서 TextField 생성
		makeLabel("NAME",panel2); makeTextField(panel2);
		makeLabel("GENDER",panel2); panel2.add(panel_R);
		makeLabel("ID",panel2); makeTextField(panel2);
		makeLabel("DEPARTMENT",panel2); makeTextField(panel2); 
		add(panel2,BorderLayout.CENTER); //component를 올린 panel2를 CENTER sector에 add
		
		//BorderLayout 중 SOUTH 에 들어갈 panel3
		JPanel panel3 = new JPanel();
		//makeButton 메서드를 정의하고 이를 호출해서 Button 생성
		makeButton("Save",panel3); makeButton("Cancel",panel3); 
		add(panel3,BorderLayout.SOUTH);	//component를 올린 panel3을 SOUTH sector에 add
		
		setVisible(true);
	}
	
	//Button을 만들어 인자로 받은 panel에 올림
	public void makeButton(String text, JPanel panel) {
		JButton button = new JButton(text);
		panel.add(button);
	}
	
	//Label을 만들어 인자로 받은 panel에 올림
	public void makeLabel(String text, JPanel panel) {
		JLabel label = new JLabel(text);
		panel.add(label);
	}
	
	//TextField를 만들어 인자로 받은 panel에 올림
	public void makeTextField(JPanel panel) {
		JTextField field = new JTextField(15);
		panel.add(field);
	}
}

public class Week11_2_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Stu s = new Stu();
	}
}
