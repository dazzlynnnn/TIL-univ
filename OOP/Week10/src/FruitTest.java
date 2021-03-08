import java.util.*;
class Buyer1{
	public Buyer1(int money) {this.money=money;}
	ArrayList<Fruit> mf = new ArrayList<Fruit>();
	int money;
	void buy(Fruit f) {
		mf.add(f);
		money = money - f.price;
	}
	void pay() {
		System.out.println("\n<My Fruit Basket>");
		for(int i=0; i<mf.size();i++) 
			System.out.println(mf.get(i)+"("+mf.get(i).price+")\t");
		if(money<0)
			System.out.println("\nYou need to pay "+-money+"won more.");
		else
			System.out.println("\nYou have "+money+" won left.");
	}
}
public class FruitTest {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("How much money do you have?");
		int money = k.nextInt();
		System.out.println("You have "+money+" won.");
		Buyer1 b = new Buyer1(money);
		Apple a = new Apple();
		Grape g = new Grape();
		Pear p = new Pear();
		Strawberry s = new Strawberry();
		b.buy(a); b.buy(s); b.buy(p); b.buy(p);b.pay();

	}

}
