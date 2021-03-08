import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Cal extends JFrame implements ActionListener{ //사용자 정의 클래스 Cal이 JFrame을 상속하는 동시에 Listener를 구현하도록 함
	String operator; //연산자가 뭔지 저장할 변수
	int n1, n2; //두 정수를 저장할 변수
	double resultd; //나눗셈을 위한 결과 변수
	int resulti; //덧셈, 뺄셈, 곱셈을 위한 결과 변수
	
	JTextField field;
	JButton[] buttons;
	JButton bplus, bminus, bdivide, bmultiply, bequals, bnew;
	
	public Cal() {
		setTitle("Calculator");setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); //LayoutManager 사용

		//BorderLayout 중 NORTH 에 들어갈 panel1
		JPanel panel1 = new JPanel();field = new JTextField(24);
		field.setHorizontalAlignment(JTextField.RIGHT); //Textfield에 데이터 입력 시 오른쪽에 나타나도록 함
		panel1.add(field); //panel에 add
		add(panel1,BorderLayout.NORTH); //component를 올린 panel1을 NORTH sector에 add

		//BorderLayout 중 CENTER 에 들어갈 panel2
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4,4)); //LayoutManager 사용
		//makeButton 메서드를 정의하고 이를 호출해서 버튼 생성	
		buttons = new JButton[10];
		for(int i = 0; i<buttons.length; i++) {
			buttons[i] = new JButton(Integer.toString(i)); //숫자 button 생성
			buttons[i].addActionListener(this); //event listener를 component에 attach
		}
		//연산자 button 생성 후 event listener를 component에 attach
		bplus = new JButton("+"); bplus.addActionListener(this);
		bminus = new JButton("-"); bminus.addActionListener(this);
		bdivide = new JButton("/"); bdivide.addActionListener(this);
		bmultiply = new JButton("*"); bmultiply.addActionListener(this);
		bequals = new JButton("="); bequals.addActionListener(this);
		bnew = new JButton("New"); bnew.addActionListener(this);

		//button들 panel2에 올림
		panel2.add(buttons[7]); panel2.add(buttons[8]); panel2.add(buttons[9]); panel2.add(bdivide);
		panel2.add(buttons[4]); panel2.add(buttons[5]); panel2.add(buttons[6]); panel2.add(bmultiply);
		panel2.add(buttons[1]); panel2.add(buttons[2]); panel2.add(buttons[3]); panel2.add(bminus);
		panel2.add(bnew); panel2.add(buttons[0]); panel2.add(bequals); panel2.add(bplus);
		add(panel2,BorderLayout.CENTER); //component를 올린 panel2를 CENTER sector에 add

		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) { //event handling
		for(int i = 0; i<buttons.length; i++) {
			if(e.getSource()==buttons[i]) field.setText(Integer.toString(i)); //숫자 button을 클릭하면 textfield에 해당 수가 나타남	
		}
		
		if(e.getSource()==bplus) { // '+' button을 누르면
				n1 = Integer.parseInt(field.getText()); //textfield의 정수를 가져와 n1에 저장 후
				operator = "plus"; //연산자 종류를 "plus"라고 저장
		}
		else if(e.getSource()==bminus) { // '-' button을 누르면
			n1 = Integer.parseInt(field.getText()); //textfield의 정수를 가져와 n1에 저장 후
			operator = "minus"; //연산자 종류를 "plus"라고 저장
		}
		else if(e.getSource()==bmultiply) { // '*' button을 누르면
			n1 = Integer.parseInt(field.getText()); //textfield의 정수를 가져와 n1에 저장 후
			operator = "multiply"; //연산자 종류를 "plus"라고 저장
		}
		else if(e.getSource()==bdivide) { // '/' button을 누르면
			n1 = Integer.parseInt(field.getText()); //textfield의 정수를 가져와 n1에 저장 후
			operator = "divide"; //연산자 종류를 "plus"라고 저장
		}

		else if(e.getSource()==bequals) { // '=' button을 누르면
			n2 = Integer.parseInt(field.getText()); //textfield의 정수를 가져와 n2에 저장 후
			//각 연산자에 맞는 연산 실행 후 textfield에 결과값 나타나게 함
			if (operator.equals("plus")) {resulti = n1 + n2; field.setText(Integer.toString(resulti));}
			else if (operator.equals("minus")) {resulti = n1 - n2; field.setText(Integer.toString(resulti));}
			else if (operator.equals("multiply")) {resulti = n1 * n2; field.setText(Integer.toString(resulti));}
			else if (operator.equals("divide")) {resultd = (double)n1 / n2; field.setText(Double.toString(resultd));}

		}
		
		else if(e.getSource()==bnew){ //New button을 클릭했을 떄
			n1 = 0; n2 = 0; resulti = 0; resultd = 0; //모두 0으로 초기화
			field.setText(""); //textfield 내용 지우고 새로운 계산 시작
		}
	}
	
}//end of class Cal

public class HW2_3_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Cal c = new Cal();
	}
}
