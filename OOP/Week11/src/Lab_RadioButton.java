import java.awt.*;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class RadioButtonFrame extends JFrame{
	private JTextField textField;
	private JRadioButton RB1;
	private JRadioButton RB2;
	private JRadioButton RB3;
	private JRadioButton RB4;
	
	public RadioButtonFrame() {
		super ("RadioButton Test");
		
		setLayout(new FlowLayout());
		textField = new JTextField("Radio Button Example",25);
		add(textField);
		RB1 = new JRadioButton("RB1");
		RB2 = new JRadioButton("RB2");
		RB3 = new JRadioButton("RB3");
		RB4 = new JRadioButton("RB4");
		add(RB1); add(RB2); add(RB3); add(RB4);
		
		//buttonGroup을 만들어야 하나만 고르게 됨
		ButtonGroup bg = new ButtonGroup();
		bg.add(RB1); bg.add(RB2); bg.add(RB3); bg.add(RB4);
	}
}
public class Lab_RadioButton {
	public static void main(String[] args) {
		RadioButtonFrame r = new RadioButtonFrame();
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		r.setSize(300,100);
		r.setVisible(true);
	}

}
