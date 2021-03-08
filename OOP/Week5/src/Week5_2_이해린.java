import java.util.Scanner;
public class Week5_2_이해린 {
	public static void main(String[] args) {
		System.out.println("==============\n전공: 사이버보안\n학번: 1971083\n성명: 이해린\n==============\n");
		Scanner k = new Scanner(System.in);
		String yn = ""; //BoosterShot 여부 입력받기 위한 변수
		Dog[] d = new Dog[3];
		Cat[] c = new Cat[3];
		//Dog 배열과 Cat 배열을 각 3개의 element를 갖도록 선언
		
		for (int i=0; i<3; i++) {
			d[i] = new Dog(); //인스턴스화
			System.out.println("<<Dog "+(i+1)+">>");
			
			//Dog 정보 입력받음
			System.out.print("Name :");
			d[i].setName(k.nextLine());
			System.out.print("Age :");
			d[i].setAge(k.nextInt());
			k.nextLine();
			System.out.print("Weight :");
			d[i].setWeight(k.nextInt());
			k.nextLine();
			System.out.print("BoosterShot(y/n) :");
			yn=k.nextLine();
			if (yn.equalsIgnoreCase("y")) d[i].setBoosterShot(true);
			else d[i].setBoosterShot(false);
			System.out.println("");
		}
		
		for (int i=0; i<3; i++) {
			c[i] = new Cat(); //인스턴스화
			System.out.println("<<Cat "+(i+1)+">>");
				
			//Cat 정보 입력받음
			System.out.print("Name :");
			c[i].setName(k.nextLine());
			System.out.print("Age :");
			c[i].setAge(k.nextInt());
			k.nextLine();
			System.out.print("Weight :");
			c[i].setWeight(k.nextInt());
			k.nextLine();
			System.out.print("Color :");
			c[i].setColor(k.nextLine());	
			System.out.println("");
		}
		
		//Dog 배열 반복문 이용해 출력
		System.out.println("<<Dog List>>");
		for (int i=0; i<3; i++) {
			d[i].writeOutput();
			d[i].move();
			System.out.println("");
		}
		
		//Cat 배열 반복문 이용해 출력
		System.out.println("<<Cat List>>");
		for (int i=0; i<3; i++) {
			c[i].writeOutput();
			c[i].move();
			System.out.println("");
		}
		
		//두 살보다 많고 예방접종하지 않은 dog 이름 출력
		System.out.println("* Dogs older than 2 years and no boostershot are...");
		for (int i=0; i<3; i++) {
			if ( (d[i].getAge()>2) && (!(d[i].getBoosterShot())) ) System.out.print(d[i].getName()+" ");
		}
		
		//black이고 3kg 이상인 cat 이름 출력
		System.out.println("\n\n* Black cats weighs more than 3Kg are...");
		for (int i=0; i<3; i++) {
			if ( (c[i].getColor().equalsIgnoreCase("black")) && (c[i].getWeight()>3)) System.out.print(c[i].getName()+" ");
		}
	}
}