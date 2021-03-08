import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Car extends JFrame implements ActionListener{	
	Color carcolor = Color.red; //차 초기색 설정
	Color eyecolor = Color.black; //눈 색 설정
	Color wheelcolor = Color.lightGray; //바퀴 색 설정
	JRadioButton RB1, RB2, RB3;
	
	public Car() { //생성자
		Toolkit tk = getToolkit();		
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setTitle("MyCar - 이해린"); //Frame Title 지정
		setSize(500,350); //Frame Size 지정
		setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2); //Frame 위치는 모니터 정중앙에 위치
		
		CarPanel c = new CarPanel(); //차 색칠하는 InnerClass 인스턴스화
		add(c,"Center"); //Frame에 CarPanel add
		
		JPanel p = new JPanel(); //RadioButton, Button 있는 Panel
		RB1 = new JRadioButton("RED",true); //초기 선택된 RadioButton
		RB2 = new JRadioButton("GREEN");
		RB3 = new JRadioButton("BLUE");
		ButtonGroup bg = new ButtonGroup(); //한 RadioButton만 선택할 수 있게 ButtonGroup 생성
		bg.add(RB1); bg.add(RB2); bg.add(RB3);
		JButton b = new JButton("Paint"); //Button 생성
		b.addActionListener(this); //event listener를 component인 button에 resister
		p.add(RB1); p.add(RB2); p.add(RB3); p.add(b); //JPanel에 각 RadioButton, Button add
		add(p,"South"); //Frame에 JPanel add
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	class CarPanel extends JPanel{ //차 색칠하는 InnerClass
		public void paint(Graphics g) { //Paint() overriding
			g.setColor(carcolor); //carcolor로 색 설정
			g.fillRect(180, 50, 140, 60);
			g.fillRect(110, 110, 280, 100);

			g.setColor(eyecolor); //eyecolor로 색 설정
			g.drawArc(270, 70, 50, 100, 30, 120);
			
			g.setColor(wheelcolor); //wheelcolor로 색 설정
			g.fillOval(150, 180, 80, 80);
			g.fillOval(270, 180, 80, 80);
		}
	}
	
	public void actionPerformed(ActionEvent e) { //event handling
		if(RB1.isSelected()) carcolor = Color.red; //RB1이 선택되었을 때 carcolor red으로 설정
		else if (RB2.isSelected()) carcolor = Color.green; //RB2가 선택되었을 때 carcolor green으로 설정
	    else if (RB3.isSelected()) carcolor = Color.blue; //RB3이 선택되었을 때 carcolor blue로 설정
		repaint(); //repaint
	}
}
public class Week12_2_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Car myCar = new Car();
	}
}
