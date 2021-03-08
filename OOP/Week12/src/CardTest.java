import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame2 extends JFrame implements ActionListener{
	JPanel panel;
	Cards cards;
	
	public MyFrame2() {
		setTitle("CardLayoutTest");
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel(new GridLayout(0,5,10,0));
		addButton("<<",panel);
		addButton("<",panel);
		addButton(">",panel);
		addButton(">>",panel);
		addButton("END",panel);
		add(panel, "North");
		
		cards = new Cards();
		add(cards, "Center");
		setVisible(true);
	}
	
	void addButton(String str, Container target) {
		JButton button = new JButton(str);
		button.addActionListener(this);
		target.add(button);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().contentEquals("END")) {
			System.exit(0);;
		}
		else if(e.getActionCommand().contentEquals("<<")) {
			cards.layout.first(cards);
		}
		else if(e.getActionCommand().contentEquals("<")) {
			cards.layout.previous(cards);
		}
		else if(e.getActionCommand().contentEquals(">")) {
			cards.layout.next(cards);
		}
		else if(e.getActionCommand().contentEquals(">>")) {
			cards.layout.last(cards);
		}
	}
	
	private class Cards extends JPanel{
		CardLayout layout;
		public Cards() {
			layout = new CardLayout();
			setLayout(layout);
			for(int i=1;i<=10;i++) {
				add(new JButton("Current card number is " +i+"."),"Center");
			}
		}
	}
}
public class CardTest {
	public static void main(String[] args) {
		MyFrame2 f = new MyFrame2();
	}
}
