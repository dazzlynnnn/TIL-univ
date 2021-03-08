import java.awt.*;
import javax.swing.*;

class MyComponent extends JComponent{
	public static final int x = 30;
	public static final int y = 80;
	
	public void paint(Graphics g) {
		g.drawString("Hello everyone!",x,y);
		g.drawLine(x, y+10, x+100, y+10);
	}
}
public class GraphicTest extends JFrame{
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	
	public GraphicTest() {
		setTitle("MyFrame");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		MyComponent c = new MyComponent();
		add(c);
	}

	public static void main(String[] args) {
		GraphicTest f = new GraphicTest();
	}

}
