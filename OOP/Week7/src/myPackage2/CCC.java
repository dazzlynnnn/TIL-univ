package myPackage2;

public class CCC {
	public static void main(String[] args) {
		BBB b = new BBB();
		System.out.println(b.pub_a);
//		System.out.println(b.pro_b); //error(자손클래스 아님)
//		System.out.println(b.def_c); //error
//		System.out.println(b.pri_d); //error
		System.out.println(b.getD());
	}
}
