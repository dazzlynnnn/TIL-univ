public class TestEquals {
	public static void main(String[] args) {
		int[] a = new int[3];
		int[] b = new int[3];
		setArray(a);
		setArray(b);
		if (b == a) System.out.println("주소 동일");
		else System.out.println("주소 동일하지 않음");
		if(equals(b,a)) System.out.println("배열요소 동일");
		else System.out.println("배열요소 동일하지 않음");
	} //end of main method
	
	public static boolean equals(int[] a, int[] b) {
		boolean elementsMatch = true; //true로 초기화 & true인 동안 반복
		if (a.length != b.length) elementsMatch=false;
		else {
			int i=0;
			while (elementsMatch&&(i<a.length)) {
				if (a[i]!=b[i]) elementsMatch=false;
				i++;
			} //end of while
		} //end of else
			return elementsMatch;
	} //end of equals method
	
	public static void setArray(int[] array) {
		for(int i=0;i<array.length;i++) array[i]=i;
	} //end of setArray method
	
} //end of TestEquals class
