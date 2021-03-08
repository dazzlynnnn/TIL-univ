import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Chart extends JFrame implements ActionListener{ //사용자 정의 클래스 Chart가 JFrame을 상속하는 동시에 Listener를 구현하도록 함
	String message="\0"; //오류 메시지 저장 변수
	int kimnum, leenum, parknum, etcnum; //사람 수 저장할 변수
	JTextField ks, ls, ps, es; //학생수 입력받을 textfield

	public Chart(){
		Toolkit tk = getToolkit();		
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setTitle("Pie Chart of Student names - 이해린"); setSize(600,500); //title, size 지정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); //LayoutManager 사용
		setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2); //Frame 위치는 모니터 정중앙에 위치
		
		ChartPanel c = new ChartPanel(); //차트 그리는 Innerclass 인스턴스화
		add(c, "Center"); //Frame 가운데에 ChartPanel add
		
		JPanel p = new JPanel(); //사람 수 입력받을 panel
		JLabel kim = new JLabel("Kim"); p.add(kim);
		ks = new JTextField(5); p.add(ks);
		JLabel lee = new JLabel("Lee"); p.add(lee);
		ls = new JTextField(5); p.add(ls);
		JLabel park = new JLabel("Park"); p.add(park);
		ps = new JTextField(5); p.add(ps);
		JLabel etc = new JLabel("Etc"); p.add(etc);
		es = new JTextField(5); p.add(es);
		JButton b = new JButton("Graph"); p.add(b); b.addActionListener(this); //event listener를 component인 button에 resister
		add(p, "South"); //Frame 아래쪽에 JPanel add
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	class ChartPanel extends JPanel{ //차트 그리는 InnerClass
		public void paint(Graphics g) { //Paint() overriding
			int kimsize = (int)Math.round(kimnum*3.6);
			int leesize = (int)Math.round(leenum*3.6);
			int parksize = (int)Math.round(parknum*3.6);
			int etcsize = (int)Math.round(etcnum*3.6);
			boolean s = false;
			
			g.setColor(Color.white);
			g.fillRect(0,0,600,500);
			
			try {
				if(etcnum<0) {message = "Number of Students is 100"; throw new BoundaryException();} //(김씨+이씨+박씨>100)인 경우 (etc<0인 경우) BoundaryException throw
				else if ((kimnum+leenum+parknum+etcnum)==100) s  = true;
				if(message.equals("Input numbers of student names")) throw new Exception(); //입력값이 숫자형태가 아니거나 음수면 Exception throw
				g.setColor(Color.yellow); //김씨 색으로 설정
				g.fillArc(120, 120, 200, 200, 0, kimsize); //호 그리기
				if (s==true) g.drawString("YELLOW: KIMs", 350, 200);
			
				g.setColor(Color.red); //이씨 색으로 설정
				g.fillArc(120, 120, 200, 200, kimsize, leesize); //호 그리기
				if (s==true) g.drawString("RED: LEEs", 350, 220);

				g.setColor(Color.blue); //박씨 색으로 설정
				g.fillArc(120, 120, 200, 200, kimsize+leesize, parksize); //호 그리기
				if (s==true) g.drawString("BLUE: PARKs", 350, 240);

				g.setColor(Color.green); //기타 색으로 설정
				g.fillArc(120, 120, 200, 200, kimsize+leesize+parksize, etcsize); //호 그리기
				if (s==true) g.drawString("GREEN: Etc.", 350, 260);
			
			}catch(BoundaryException boundE) {
				ks.setText("0");ls.setText("0");ps.setText("0");es.setText("0");
				g.setColor(Color.black);
				g.drawString(message,200,400);
				message = "\0";

			}catch(Exception nonnumberE) {
				ks.setText("0");ls.setText("0");ps.setText("0");es.setText("0");
				g.setColor(Color.black);
				g.drawString(message,200,400);
				message = "\0";
			}
		}
	}//end of ChartPanel
	
	public void actionPerformed(ActionEvent e) { //event handling
		try{		
			//각 사람 수 textfield에서 가져옴
			kimnum = Integer.parseInt(ks.getText());
			leenum = Integer.parseInt(ls.getText());
			parknum = Integer.parseInt(ps.getText());
			
			if(kimnum<0||leenum<0||parknum<0) throw new BoundaryException(); //사람 수가 음수일 경우 BoundaryException throw
			etcnum = 100-kimnum-leenum-parknum; //Etc 사람 수 계산 후 저장
			es.setText(String.valueOf(etcnum)); //textfield에 출력
			repaint();
		}
		catch(BoundaryException boundE2) { //음수일 때 throw 한 Exception catch
			ks.setText("0"); ls.setText("0"); ps.setText("0"); es.setText("0"); //textfield 모두 0으로 설정하고
            message = "Input numbers of student names"; //오류 메시지
            repaint();
		}
		catch(Exception nonnumberE2) { //textfield에서 int를 가져올 수 없는 경우
			kimnum = 0; leenum = 0; parknum = 0; etcnum = 0;
			ks.setText("0"); ls.setText("0"); ps.setText("0"); es.setText("0"); //textfield 모두 0으로 설정하고
            message = "Input numbers of student names"; //오류 메시지
            repaint();
		}
	}//end of actionPerformed
}//end of Graph

class BoundaryException extends Exception{ //사용자 지정 예외 정의
	BoundaryException(){}
	BoundaryException(String msg){
		super(msg);
	}
}

public class HW2_5_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Chart chart = new Chart();
	}
}
