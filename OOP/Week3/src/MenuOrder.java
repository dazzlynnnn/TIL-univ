public class MenuOrder {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	
	private int cokePrice, lemonadePrice, coffeePrice, inputMoney, changeMoney;
	private String drinkSelected;
	//private 변수 선언
	
	public void setPrice(String d, int price) { //음료 가격 setter
		if (d.equals("coke")) cokePrice = price;
		else if (d.equals("lemonade")) lemonadePrice = price;
		else coffeePrice = price;
	}
	
	public int getPrice(String d) { //음료 가격 getter
		if (d.equals("coke")) return cokePrice;
		else if (d.equals("lemonade")) return lemonadePrice;
		else return coffeePrice;
	}
	
	public void showMenu() { //메뉴 출력 메서드
		System.out.println("1. Coke: "+cokePrice);
		System.out.println("2. Lemonade: "+lemonadePrice);
		System.out.println("3. Coffee: "+coffeePrice);
	}
	
	public void setMoney(int m) { //넣은 돈 inputMoney에 넣는 setter
		inputMoney = m;
	}
	
	public int getMoney() { //inputMoney getter
		return inputMoney;
	}
	
	public void showResult(int num) { //결과 출력 메서드
			if (num==1||num==2||num==3) { //메뉴에 있는 음료일 때
				switch (num) {
					case 1 : drinkSelected = "Coke"; changeMoney = inputMoney - cokePrice; break;
					case 2 : drinkSelected = "Lemonade"; changeMoney = inputMoney - lemonadePrice; break;
					case 3 : drinkSelected = "Coffee"; changeMoney = inputMoney - coffeePrice; break;
				}
				
				System.out.println(drinkSelected+"를 선택하셨습니다.");
				if (changeMoney>0) System.out.println("잔돈은 "+changeMoney+"원입니다."); //잔돈 출력
				else if (changeMoney<0) System.out.println((-changeMoney)+"원 더 넣어주세요."); //changeMoney가 음수이면 부족한 돈으로 출력
			}
			else System.out.println("없는 메뉴를 선택하셨습니다."); //메뉴에 없는 음료일 때
	}
	
}

