package myPackage2;

public class BBB extends myPackage1.AAA{
	public void output() {
		System.out.println(pub_a);
		System.out.println(pro_b);
		//System.out.println(def_c); //error(다른 패키지)
		//System.out.println(pri_d); //error(그냥 프라이빗)
		System.out.println(getD());
	}
}
