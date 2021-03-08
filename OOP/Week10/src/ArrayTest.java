class Fruit{
	int price;
	Fruit(int price){this.price=price;}
}
class Strawberry extends Fruit{
	Strawberry(){super(1000);}
	public String toString() {return "Strawberry";}
}
class Apple extends Fruit{
	Apple(){super(2000);}
	public String toString() {return "Apple";}
}
class Pear extends Fruit{
	Pear(){super(4000);}
	public String toString() {return "Pear";}
}
class Grape extends Fruit{
	Grape(){super(3500);}
	public String toString() {return "Grape";}
}
class Buyer{
	int money = 10000;
	void buy(Fruit f) {
		money=money-f.price;
	}
}
public class ArrayTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		Fruit[] f = new Fruit[10];
		f[0]=new Apple();
		f[1]=new Grape();
		f[2]=new Pear();
		f[3]=new Pear();
		
		System.out.println("You have "+b.money+" won.");
		for(int i = 0; i<4; i++){
			b.buy(f[i]);
		}
		System.out.println("\n<my Fruit Basket>");
		for(int i=0; i<4; i++)
			System.out.print(f[i]+"("+f[i].price+")\t");
		if(b.money<0)
			System.out.println("\nYou need to pay "+-b.money+"won more.");
		else
			System.out.println("\nYou have"+b.money+"won left.");
	}

}
