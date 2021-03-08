import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Catch extends JFrame{
	JPanel p = new JPanel();
	JButton b;
	
	public Catch() { //Catch 생성자
		setTitle("나 잡아봐~라! - 이해린"); //Frame Title
		setSize(300,300); //Frame Size
		setResizable(false); //Size 고정
		b = new JButton("Click!"); //button 생성
		b.addMouseListener(new myMouseEvent()); //event listener를 component인 button에 resister
		p.add(b); //panel에 button을 add
		add(p); //frame에 panel을 add
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	class myMouseEvent extends MouseAdapter{ //inner class에 event handling 포함(Adapter Class 상속)
		public void mouseEntered(MouseEvent e) { //button 영역 내에 마우스가 들어가면
			//frame 내에서 random setLocation
			int x = (int)(Math.random()*230); 
			int y = (int)(Math.random()*250);
			b.setLocation(x,y);
			System.out.println("x="+x+",\ty="+y); //x, y 위치 콘솔에 표시
		}
		public void mouseClicked(MouseEvent e) { //button이 클릭되면
			System.out.println("윽,,,잡혔다ㅠㅠ"); //출력하고 계속 진행
		}
	}
}

public class Week12_1_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Catch c = new Catch();
	}
}
