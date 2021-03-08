import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ButtonActionListener implements ActionListener{
	JTextField text;
	JLabel label;
	
	ButtonActionListener(JTextField text, JLabel label){
		this.text = text;
		this.label = label;
	}
	
	public void actionPerformed(ActionEvent e) {
		label.setText("Hello! "+ text.getText());
	}
}

public class Lab_gui1 {
	public static void main(String[] args) {
		JFrame f= new JFrame("Hello Test");
		f.setSize(250,100);
		JTextField text = new JTextField(10);
		JButton button = new JButton("Confirm");
		JLabel label = new JLabel("Hello!");
		
		JPanel panel = new JPanel();
		panel.add(text);
		panel.add(button);
		panel.add(label);
		f.add(panel);
		ActionListener listener = new ButtonActionListener(text, label);
		button.addActionListener(listener);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
