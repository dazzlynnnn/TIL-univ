import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MouseTest extends JFrame{
	JPanel p = new JPanel();
	JLabel myLabel;
	public MouseTest() {
		setTitle("Mouse Adapter Test");
		p.addMouseListener(new myMouseEvent());
		myLabel = new JLabel("Location of the mouse");
		myLabel.setSize(50,20);
		myLabel.setLocation(30,30);
		p.add(myLabel);
		add(p);
		setSize(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	class myMouseEvent extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x=e.getX();
			int y=e.getY();
			myLabel.setText("x="+x+", y="+y);
		}
	}
	public static void main(String[] args) {
		new MouseTest();
	}
}

