import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Graph extends JFrame implements ActionListener{ //사용자 정의 클래스 Graph가 JFrame을 상속하는 동시에 Listener를 구현하도록 함
	Color c = Color.black; //표 색 지정
	Color gc = Color.red; //그래프 색 지정
	int kor, eng, math; //점수 저장할 변수
	int korh=380, engh=380, mathh=380; //그래프 높이 관련 변수
	JTextField ks, es, ms; //점수 입력받을 textfield
	String w="\0"; //wrong input 넣을 String
	
	public Graph(){
		Toolkit tk = getToolkit();		
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setTitle("Score Graph"); setSize(600,500); //title, size 지정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); //LayoutManager 사용
		setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2); //Frame 위치는 모니터 정중앙에 위치
		
		GraphPanel g = new GraphPanel(); //표, 그래프 Innerclass 인스턴스화
		add(g, "Center"); //Frame 가운데에 GraphPanel add
		
		JPanel p = new JPanel(); //점수 입력받을 panel
		JLabel k = new JLabel("Kor"); p.add(k);
		ks = new JTextField(3); p.add(ks);
		JLabel e = new JLabel("Eng"); p.add(e);
		es = new JTextField(3); p.add(es);
		JLabel m = new JLabel("Math"); p.add(m);
		ms = new JTextField(3); p.add(ms);
		JButton b = new JButton("Show Graph"); p.add(b); b.addActionListener(this); //event listener를 component인 button에 resister
		add(p, "South"); //Frame 아래쪽에 JPanel add
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	class GraphPanel extends JPanel{ //표, 그래프 그리는 InnerClass
		public void paint(Graphics g) { //Paint() overriding
			g.setColor(Color.white);
			g.fillRect(0,0,600,500);
			
			g.setColor(Color.black);
			g.drawString(w,270,50); //wrong input 출력
			//각 줄 간격 30으로 표 그리기
			g.drawString("100", 60, 80); g.drawString("90", 60, 110); g.drawString("80", 60, 140); g.drawString("70", 60, 170); g.drawString("60", 60, 200);
			g.drawString("50", 60, 230); g.drawString("40", 60, 260); g.drawString("30", 60, 290); g.drawString("20", 60, 320); g.drawString("10", 60, 350);
			g.drawString("KOR", 200, 400); g.drawString("ENG", 300, 400); g.drawString("MATH", 400, 400);
			g.drawLine(100,60,100,380); g.drawLine(100,380,500,380); g.drawLine(100,80,500,80); g.drawLine(100,110,500,110);
			g.drawLine(100,140,500,140); g.drawLine(100,170,500,170); g.drawLine(100,200,500,200); g.drawLine(100,230,500,230);
			g.drawLine(100,260,500,260); g.drawLine(100,290,500,290); g.drawLine(100,320,500,320); g.drawLine(100,350,500,350);
			
			g.setColor(Color.red);
			//점수를 반영하여 직사각형 그리기
			g.fillRect(210, korh, 7, 380-korh); g.fillRect(310, engh, 7, 380-engh); g.fillRect(415, mathh, 7, 380-mathh);
		}
	}//end of GraphPanel
	
	public void actionPerformed(ActionEvent e) { //event handling
		try{
			//textfield의 정수를 가져와 각 변수에 저장(문자라면 exception 발생)
			kor = Integer.parseInt(ks.getText());
			eng = Integer.parseInt(es.getText());
			math = Integer.parseInt(ms.getText());
			if (0<=kor&&100>=kor&&0<=eng&&100>=eng&&0<=math&&100>=math) { //범위 내에 있을 경우
				korh = (380-kor*3); engh = (380-eng*3); mathh = (380-math*3); //그래프 높이 설정
				w = "\0";
				repaint(); //repaint
			}
			else throw new Exception(); //범위 밖일 경우
		}catch(Exception exception){
			w = "Wrong Input"; 
			korh = 380; engh = 380; mathh = 380;
			repaint();
		}
	}//end of actionPerformed
}//end of Graph

public class HW2_4_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Graph g = new Graph();
	}
}
