import java.util.Scanner;
public class TestSwitch {

	public static void main(String[] args) {
		int month;
		String season;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input your favorite month ");
		month = keyboard.nextInt();
		
		switch(month)
		{
			case 12 :
			case 1 :
			case 2 :
				season = "Winter";
				break;
			case 3 : 
			case 4 :
			case 5 :
				season = "Spring";
				break;
			case 6 : 
			case 7 :
			case 8 : 
				season = "Summer";
				break;
			case 9 :
			case 10 : 
			case 11 :
				season = "Fall";
				break;
			default :
				season = "strange season";
				break;
		}
		System.out.println("You like "+season);
	}

}
