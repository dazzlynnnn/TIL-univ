import java.awt.*;
import javax.swing.*;

class MF3 extends JFrame{
	public MF3() {
		setTitle("BorderLayoutTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//For frame, default layout is BorderLayout anyway.
		setLayout(new BorderLayout());
		
		//Buttons are added.
		add(new JButton("Center"),BorderLayout.CENTER);
		add(new JButton("Line Start"),BorderLayout.LINE_START);
		add(new JButton("Line End"),BorderLayout.LINE_END);
		add(new JButton("Page Start"),BorderLayout.PAGE_START);
		add(new JButton("Page End"),BorderLayout.PAGE_END);
		
		pack();
		setVisible(true);
	}
}
public class BorderLayoutTest {
	public static void main(String[] args) {
		MF3 f = new MF3();
	}

}
