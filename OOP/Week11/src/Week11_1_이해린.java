import java.awt.*;
import javax.swing.*;

class Cal extends JFrame{
	public Cal() {
		setTitle("Calculator");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); //LayoutManager 사용

		//BorderLayout 중 NORTH 에 들어갈 panel1
		JPanel panel1 = new JPanel();
		JTextField field = new JTextField(24);
		field.setHorizontalAlignment(JTextField.RIGHT); //Textfield에 데이터 입력 시 오른쪽에 나타나도록 함
		panel1.add(field); //panel에 add
		add(panel1,BorderLayout.NORTH); //component를 올린 panel1을 NORTH sector에 add

		//BorderLayout 중 CENTER 에 들어갈 panel2
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(5,4)); //LayoutManager 사용
		//makeButton 메서드를 정의하고 이를 호출해서 버튼 생성
		makeButton("ON",panel2); makeButton("AC",panel2); makeButton("C",panel2); makeButton("OFF",panel2);
		makeButton("7",panel2); makeButton("8",panel2); makeButton("9",panel2); makeButton("/",panel2);
		makeButton("4",panel2); makeButton("5",panel2); makeButton("6",panel2); makeButton("X",panel2);
		makeButton("1",panel2); makeButton("2",panel2); makeButton("3",panel2); makeButton("-",panel2);
		makeButton("0",panel2); makeButton(".",panel2); makeButton("=",panel2); makeButton("+",panel2);
		add(panel2,BorderLayout.CENTER); //component를 올린 panel2를 CENTER sector에 add
		
		setVisible(true);
	}
	
	//Button을 만들어 인자로 받은 panel에 올림
	public void makeButton(String text, JPanel panel) {
		JButton button = new JButton(text);
		panel.add(button);
	}
	
}//end of class Cal

public class Week11_1_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Cal c = new Cal();
	}
}
