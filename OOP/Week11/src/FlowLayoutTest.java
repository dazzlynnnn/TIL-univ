import java.awt.*;
import javax.swing.*;

class MF5 extends JFrame{
	public MF5() {
		setTitle("FlowLayoutTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(); //panel is generated and FlowLayout is set as default
		panel.setLayout(new FlowLayout(FlowLayout.CENTER)); //not necessary
		panel.add(new JButton("Button1"));
		panel.add(new JButton("Button2"));
		panel.add(new JButton("Button3"));
		panel.add(new JButton("B4"));
		panel.add(new JButton("Long Button5"));
		add(panel);
		pack(); setVisible(true);
	}
}
public class FlowLayoutTest {
	public static void main(String[] args) {
		MF5 f = new MF5();
	}

}
