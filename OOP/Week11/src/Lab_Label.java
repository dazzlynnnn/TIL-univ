import java.awt.*;
import javax.swing.*;

class MF2 extends JFrame{
	public MF2() {
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyFrame");
		
		JPanel panel = new JPanel(); //Generate Panel
		JLabel label = new JLabel("Hello?"); //Generate label
		JButton button = new JButton("BUTTON"); //Generate button
		
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		t2.setEditable(false);
		
		panel.add(t1);
		panel.add(t2);
		
		panel.add(label); //Add label to panel
		panel.add(button); //Add button to panel
		add(panel); //Add panel to frame
		setVisible(true);
	}
}
public class Lab_Label {
	public static void main(String[] args) {
		MF2 f = new MF2();
	}

}
