//==============
//����: ���̹�����
//�й�: 1971083
//����: ���ظ�
//==============
import java.util.Scanner;
public class Game {
	int youwin = 0, comwin = 0; //�̱� Ƚ�� ���� ����
	int you = 0, com = 0; //���� ���� �� ���� ����
	
	public void play() { //���ӽ��� �� �ݺ������� ���������� �ϴٰ� ���� ��� ���
		System.out.println("���������� ������ �����մϴ�.");
		while (youwin<3&&comwin<3)  //�̱� Ƚ���� 3�� �Ǹ� while�� ����
			this.input(); //���� Ŭ������ input()�޼��� ȣ��
		System.out.printf("\nYou(%d)\tCom(%d)\n",youwin,comwin); //���� ���� ��� ���
		if (youwin<comwin) //��ǻ�Ͱ� �̰��� ��
			System.out.print("��ǻ�Ͱ� �̰���ϴ�.\n������ �����մϴ�.");
		else //����� �̰��� ��
			System.out.print("����� �̰���ϴ�.\n������ �����մϴ�.");
	}
	
	public void input() {
		Scanner k = new Scanner(System.in);
		System.out.printf("\n����� ������?(You(%d) - Com(%d))\n",youwin,comwin);
		System.out.println("����(1) ����(2) ��(3)");
		try{
			you = k.nextInt(); //����ڷκ��� Ű���� �Է� �ޱ�
			com = (int)(Math.random()*2)+1; //��ǻ�� ���ð� �����ϱ�
			
			if (you<1||com<1||you>3||com>3) //���� ���� ���� ��
				throw new Exception("������ �߸��Ǿ����ϴ�.");	 //exception �߻�
			
			System.out.printf("<You>\t<Com>\n");
			switch(you) {
				case 1 : System.out.print("����"); break;
				case 2 : System.out.print("����"); break;
				case 3 : System.out.print("��"); break; }
			switch(com) {
				case 1 : System.out.print("\t����\n"); break;
				case 2 : System.out.print("\t����\n"); break;
				case 3 : System.out.print("\t��\n"); break; }
			
			this.writeOutput();
		}
		catch(Exception e) { //exception catch
			System.out.println(e.getMessage()); //Exeption() ���� ���
		}
	}
	
	public void writeOutput() { //������Է°� ��ǻ���Է� �� �� �Ź� ���� �̰���� ��� ���
		if (you==com) 
			System.out.println("���");
		else if((you+1)%3==com%3) {
			System.out.println("��ǻ�� ��");
			comwin++;
		}
		else {
			System.out.println("��� ��");
			youwin++;
		}
	}
}
